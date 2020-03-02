#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <stdbool.h>
#include <signal.h>
#include <stdbool.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/resource.h>
#include <libgen.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

#define MAX_LINE 128 /* 80 chars per line, per command, should be enough. */
#define MAX_ARGS 32
#define HIST_SIZE 10
/* The setup function below will not return any value, but it will just: read
in the next command line; separate it into distinct arguments (using blanks as
delimiters), and set the args array entries to point to the beginning of what
will become null-terminated, C-style strings. */



char* my_local_path;

char* concat(const char *s1, const char *s2)
{
    char *result = malloc(strlen(s1) + strlen(s2) + 1); // +1 for the null-terminator
    // in real code you would check for errors in malloc here
    strcpy(result, s1);
    strcat(result, s2);
    return result;
}

void add_path(char* path)
{
    char* new_path = concat(":", path);
    my_local_path = concat(my_local_path, new_path);
}

/* This struct, to manipulate PATH value by linked list utilities */
typedef struct PATH
{
  char* path_name;
  char* orig_path_arg;
  int number_of_paths;
  struct PATH* next;
}PATH;
/* This is for the BG processes queque, its again to manipulate processes */
typedef struct BG
{
  pid_t pid;
  pid_t p_pid;
  char* command;
  struct BG* next;
}BG;

BG* background_processes;

int main_pid;  /* main processes pid */
int number_of_arguments; /* number of expected arguments to have fixed array */
int redirect_out;  /* this function is to write out to a file what command prints */
int redirect_in;  /* this function is to get input to a command from a file */
static char buffer[MAX_LINE];  /* to get whole line as input */
char history[HIST_SIZE][MAX_LINE]; /* to keep history record, 2 dimensional character array, first dimension is record count, second commands max length */
int count = 0;
int rCheck = 0;
char historyFileLoc[] = "./historyLog.txt";  /* holding our records at -> ./historyLog.txt it might be needed you to change it to your own file name */

/* to handle redirection in*/
void redirectIn(char *fileName)
{
    int in = open(fileName, O_RDONLY);
    dup2(in, 0);
    close(in);
}

/* to handle redirection in*/
void redirectOut(char *fileName)
{
    int out = open(fileName, O_WRONLY | O_TRUNC | O_CREAT, 0600);
    dup2(out, 1);
    close(out);
}
/* a utility function to find path of command */
int findpathof(char *pth, const char *exe)
{
  char *searchpath;
  char *beg, *end;
  int stop, found;
  int len;

  if (strchr(exe, '/') != NULL)
  {
    if (realpath(exe, pth) == NULL) return 0;
      return  check_executable(pth);
  }
  searchpath = my_local_path;
  if (searchpath == NULL) return 0;
  if (strlen(searchpath) <= 0) return 0;

  beg = searchpath;
  stop = 0; found = 0;

  do {
    end = strchr(beg, ':');
    if (end == NULL)
    {
      stop = 1;
      strncpy(pth, beg, MAX_ARGS);
      len = strlen(pth);
    } else {
      strncpy(pth, beg, end - beg);
      pth[end - beg] = '\0';
      len = end - beg;
    }
    if (pth[len - 1] != '/') strncat(pth, "/", 1);
    strncat(pth, exe, MAX_ARGS - len);
    found = check_executable(pth);
    if (!stop) beg = end + 1;
  } while (!stop && !found);

  return found;
}

/* a utility function to use findpath function, its return the file when its valid  */
int check_executable(const char *filename)
{
  int result;
  struct stat statinfo;
  
  result = stat(filename, &statinfo);
  if (result < 0) return 0;
  if (!S_ISREG(statinfo.st_mode)) return 0;

  if (statinfo.st_uid == geteuid()) return statinfo.st_mode & S_IXUSR;
  if (statinfo.st_gid == getegid()) return statinfo.st_mode & S_IXGRP;
  return statinfo.st_mode & S_IXOTH;
}

/*
 saving history to file
 */
void saveH() {
    int i;
    
    FILE *hisFile = fopen(historyFileLoc, "w");

/* writes the history to hisFile */
    for(i=0; i < HIST_SIZE; i++){
            strcpy(buffer, history[i]);
            if(strcmp(buffer,"\0") != 0) {
                fprintf(hisFile,"%s", buffer);
            }
    }
    if(fclose(hisFile) != 0) {
        perror("History File could'nt closed properly");
    }
}
/* loads the commands from file to our array back */
void lHistory() {
    int i;
    char histCommand[MAX_LINE];
    
    i = 0;
    FILE *hisFile = fopen(historyFileLoc, "r");
    
    if( hisFile ) {
        /* not depends to all records, only ten record will be shown */
        while(!feof(hisFile)) {
            strcpy(histCommand, "\0");
            fgets(histCommand, MAX_LINE, hisFile);
            if (strcmp(histCommand, "\0") != 0) {
                strcpy(history[i], histCommand);
            }
            i++;
            count++;
        }
    }
    
    if(hisFile != NULL){
        if(fclose(hisFile) != 0) {
            perror("History file (r) was not closed correctly");
        }
    }
}
/* utility function to print history array */
void printHistory() {
    int i;
    int j = 0;
    int histcount = count;
    
    printf("\n");
    for (i=0; i < HIST_SIZE; i++) {
        printf("%d.   ", i+1); /* Used to print the correct history number */
        while (history[i][j] != '\n' && history[i][j] != '\0') {
            printf("%c",history[i][j]);
            j++;
        }
        printf("\n");
        j=0;
        
        histcount--;
        if(histcount == 0) {
            break;
        }
    }
    printf("\n");
}

void setup(char inputBuffer[], char *args[],int *background)
{
  int length, /* # of characters in the command line */
    i,      /* loop index for accessing inputBuffer array */
    start,  /* index where beginning of next command parameter is */
    ct,    /* index of where to place the next parameter into args[] */
    nt;    /* nested loop counter */
    ct = 0;

    /* read what the user enters on the command line */
  length = read(STDIN_FILENO,inputBuffer,MAX_LINE);

    if(rCheck == 1) {
        length = read(STDIN_FILENO, inputBuffer, MAX_LINE);
        rCheck = 0;
    }
  /* checks to see if the command is a history retrieval command. If it isn't then add it to the history */
  if((strcmp(inputBuffer, "r\n\0") != 0) && (strncmp(inputBuffer, "r x", 2) != 0) ) {
      for(i= (HIST_SIZE - 1); i>0; i--) {
          strcpy(history[i], history[i-1]);
      }
      strcpy(history[0], inputBuffer);
      count++;
  }
  start = -1;
  if (length == 0) {
      saveH();
      exit(0); /* ^d was entered, end of user command stream */
  }
  else if ( (length < 0) && (errno != EINTR) )
  {
    perror("error reading the command");
      saveH();
    exit(-1); /* terminate with error code of -1 */
  }
  /* Checks to see if r was entered. If so, it copies the command most recently in the input buffer */
  if(strcmp(inputBuffer, "r\n\0") == 0) {
      strcpy(inputBuffer,history[0]);
      /* Checks to see if r x was entered. If so then it searches for the most recent command that begins with x */
  } else if(strncmp(inputBuffer, "r x", 2) == 0) {
      for(nt=0; nt<10; nt++){
          if(inputBuffer[2] == history[nt][0]) {
              strcpy(inputBuffer,history[nt]);
              break;
          }
      }
  }
    /* to retrieve indexed history line  usage is : history -i num*/
    if (strstr(inputBuffer, "history -i 0") != NULL) {
   strcpy(inputBuffer,history[0]);
    }
    if (strstr(inputBuffer, "history -i 1") != NULL) {
     strcpy(inputBuffer,history[1]);
    }
    if (strstr(inputBuffer, "history -i 2") != NULL) {
       strcpy(inputBuffer,history[2]);
    }
    if (strstr(inputBuffer, "history -i 3") != NULL) {
       strcpy(inputBuffer,history[3]);
    }
    if (strstr(inputBuffer, "history -i 4") != NULL) {
       strcpy(inputBuffer,history[4]);
    }
    if (strstr(inputBuffer, "history -i 5") != NULL) {
       strcpy(inputBuffer,history[5]);
    }
    if (strstr(inputBuffer, "history -i 6") != NULL) {
       strcpy(inputBuffer,history[6]);
    }
    if (strstr(inputBuffer, "history -i 7") != NULL) {
       strcpy(inputBuffer,history[7]);
    }
    if (strstr(inputBuffer, "history -i 8") != NULL) {
       strcpy(inputBuffer,history[8]);
    }
    if (strstr(inputBuffer, "history -i 9") != NULL) {
       strcpy(inputBuffer,history[9]);
    }

    if(strstr(inputBuffer, "path +") != NULL)
    {
        add_path(args[2]);
    }
    
    
    
    
length = strlen(inputBuffer);
  for (i=0;i<length;i++)
  { /* examine every character in the inputBuffer */
    switch (inputBuffer[i])
    {
      case ' ':
      case '\t' : /* argument separators */
          if(start != -1)
        {
          args[ct] = &inputBuffer[start];    /* set up pointer */
            ct++;
          }
        inputBuffer[i] = '\0'; /* add a null char; make a C string */
          start = -1;
        break;
      case '\n':                 /* should be the final char examined */
          if (start != -1)
        {
          args[ct] = &inputBuffer[start];
            ct++;
          }
        inputBuffer[i] = '\0';
        args[ct] = NULL; /* no more arguments to this command */
          break;
      default :             /* some other character */
          if (start == -1)
              start = i;
        if (inputBuffer[i] == '&')
        {
             *background  = 1;
           inputBuffer[i-1] = '\0';
          }
    } /* end of switch */
  }    /* end of for */
  args[ct] = NULL; /* just in case the input line was > 80 */

    
} /* end of setup routine */



int main(void)
{
  pid_t pid;
  main_pid = getpid();
  char inputBuffer[MAX_LINE]; /*buffer to hold command entered */
  int background, status; /* equals 1 if a command is followed by '&' */
  char *args[MAX_LINE/2 + 1]; /*command line arguments */
 
    my_local_path = getenv("PATH");
 

  while (1)
  {
    background = 0;
    printf("\n myshell: ");
    fflush(stdout);
    
    /*setup() calls exit() when Control-D is entered */
    setup(inputBuffer, args, &background);
    fflush(stdout);
    pid_t child_pid = fork();

    if(child_pid == -1)
    {
      char msg[] = "Can't create child!";
        saveH();
      write(STDOUT_FILENO, msg, sizeof(msg) - 1);
    }
    else if(child_pid == 0)
    {
        if(!(strcmp(args[0], "history")) && args[1] == NULL ){
            printHistory();
            exit(1);
        }
    
      char* mypath;
      findpathof(mypath, args[0]);
      execv(mypath, args);
      if (status < 0) {
          fprintf(stderr, "ERROR: Could not execute %s", args[0]);
          saveH();
          exit(1);
      }
        exit(1);
    }
     else if (background == 0) { /* if the fork is run in the foreground */
        wait(NULL);
    }
    
  }
    return -1;
}
