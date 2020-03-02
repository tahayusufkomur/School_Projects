/*THIS PROGRAMME, MAKES A GRAPH OF CHAR ARRAYS AND CALCULATE THOSE ARRAYS CENTRALITY, CLOSENESS, BETWENNES DEGREES
ALSO THIS PROGRAMME, PRINTS THE GRAPH, DOESNT MATTER HOW MANY MEMBER THE GRAPH HAS */

//TAHA YUSUF KOMUR 150114064    

#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>
#include <assert.h>
#define INFINITY 9999
#define MAX 10
 
struct AdjListNode 
{ 
    char *dest; 
    struct AdjListNode* next;   
    int numberOfedges;
}; 

struct AdjList 
{ 
    struct AdjListNode *head;  
}; 
void printDegreeCentrality(double vertex, double edges){

double standardizedScore = (edges/(vertex-1));

printf("%lf ", standardizedScore);
}


struct Graph 
{ 
    int V; 
    struct AdjList* array; 
}; 

void printClosenessCentrality(int v, struct Graph *graph, int G[MAX][MAX], int startnode){
int t = closenessCalc(G, v,startnode,graph);
printf("%d/",(v-1)); printf("%d", t);
}
//Thıs function prints centrality of the char arrays in graph as formatted..

void printGraphCentrality(struct Graph *graph, int G[MAX][MAX], int B[] ){
int v = graph->V; 
printf("  Source      Degree Centrality   Closeness Centrality    Betwennes Centrality\n\n");
for(int i = 0; i<v; i++) {
int passtime = B[i];
double standardized = (double)2*passtime/((graph->V-1)*(graph->V-2));

int tempEdgeNo = graph->array[i].head->numberOfedges;
char *t = graph->array[i].head->dest;

int difference = 7-strlen(t);
printf("No %d:", (i+1));
if(i<9){printf(" ");}
printf("%s ", t);
for(int k = 0; k<difference; k++){printf(" ");}
printDegreeCentrality(v, tempEdgeNo); printf("              "); printClosenessCentrality(v, graph, G, i); printf("\t\t\t%lf", standardized);


printf("\n");
}


}
//This function allocate a memory for a new char array node, and create a node and initialize its values.
struct AdjListNode* newAdjListNode(char *dest) 
{ 
    struct AdjListNode* newNode =  (struct AdjListNode*) malloc(sizeof(struct AdjListNode)); 
    newNode->dest = dest; 
    newNode->next = NULL; 
    newNode->numberOfedges = 1;
    return newNode; 

} 
//this function creates a graph, whichs form of structure is, array of char arrayed linked lists.. 

struct Graph* createGraph(int V) 
{ 
    struct Graph* graph =  (struct Graph*) malloc(sizeof(struct Graph)); 
    graph->V = V; 
    graph->array =  (struct AdjList*) malloc(V * sizeof(struct AdjList)); 
    int i; 
    for (i = 0; i < V; ++i) 
        graph->array[i].head = NULL; 
return graph; 
} 


//This function searching for spesific member inside char arrayed linked list, if it finds, its returns to 1, else it returns to 0

int hasIt(struct AdjListNode *node, char * str){
int count = 0;
char *temp;
while(node->next){
node = node->next;
temp = node->dest;  
if(node->next== NULL) {strtok(temp, "\n"); }
if(strcmp(temp, str) == 0){ count = 1; }
}
    return count;
}
int countChar(char str[], char c){
int count = 0;
int length = strlen(str);
for(int i= 0; i<length; i++){
    if((str[i])==c){count++;}  
}
return count;
}

//This function insert Vertexes to char array (Graph)
void insert(struct Graph *graph, char *name, int v) {

 for (int i = 0; i < v; i++){

     if(graph->array[v-1].head != NULL){ printf("The graph is full, cant insert anymore.. \n"); break; }
        if(graph->array[i].head == NULL) {
        graph->array[i].head = newAdjListNode(name); 
        break;} }

} 
//This functions, insert spesific char* arr to vertexes linked list, those means they have connection.
void addEdge(struct Graph* graph, char *src, char *dest, int V) 
{   
    int source;
    int destination;
    
    for(int i= 0; i<V; i++){
        if(graph->array[i].head != NULL) { 
         if(strcmp(src, (graph->array[i].head->dest))==0) {source = i;}
         }
    }
     struct AdjListNode* iterator =  graph->array[source].head;

     while(iterator->next){
         iterator->numberOfedges += 1;
         iterator = iterator->next;
     }
     struct AdjListNode* newNode = newAdjListNode(dest); 
     iterator->next = newNode; /**/
} 

//This function prints graph as formatted. 
void printGraph(struct Graph* graph) 
{ 
    int v; 
    printf("  ");
    for (v = 0; v < graph->V; ++v) 
    { 
        int len = strlen(graph->array[v].head->dest);
        for(int z=len; z<7; z++){printf(" ");}
    printf("%s", graph->array[v].head->dest);
}
printf("\n");
for(int i= 0; i<graph->V; i++) {
   int len = strlen(graph->array[i].head->dest);
   
    printf("%s", graph->array[i].head->dest);
     for(int z=len; z<7; z++){printf(" ");} 
    for(int k =0; k<graph->V; k++) { 
        int t = hasIt(graph->array[i].head, graph->array[k].head->dest);
      printf("%d      ", t);  
    }
    printf("\n");
}


 }

// I used this to update input to easy using way. 
char *substring(char *string, int position, int length)
{
   char *pointer;
   int c;
 
   pointer = malloc(length+1);
   
   if (pointer == NULL)  {  printf("Unable to allocate memory.\n");  exit(1); }
 
   for (c = 0 ; c < length ; c++)
   {
      *(pointer+c) = *(string+position-1);      
      string++;  
   }
 
   *(pointer+c) = '\0';
   return pointer;
}
//This function is helper for adjusting the input to insert the graph.
void remchar(char *s, char chr)
{
   int i, j = 0;
   for ( i = 0; s[i] != '\0'; i++ ) /* 'i' moves through all of original 's' */
   {  if ( s[i] != chr ) {        s[j++] = s[i]; /* 'j' only moves after we write a non-'chr' */ } }
       s[j] = '\0'; /* re-null-terminate */
}
//This function is helper for adjusting the input to insert the graph.
char** str_split(char* a_str, const char a_delim)
{
    char** result    = 0;
    size_t count     = 0;
    char* tmp        = a_str;
    char* last_comma = 0;
    char delim[2];
    delim[0] = a_delim;
    delim[1] = 0;

    while (*tmp)
    {
        if (a_delim == *tmp)
        {
            count++;
            last_comma = tmp;
        }
        tmp++;
    }
    count += last_comma < (a_str + strlen(a_str) - 1);
    count++;

    result = malloc(sizeof(char*) * count);

    if (result)
    {
        size_t idx  = 0;
        char* token = strtok(a_str, delim);

        while (token)
        {
            assert(idx < count);
            *(result + idx++) = strdup(token);
            token = strtok(0, delim);
        }
        assert(idx == count - 1);
        *(result + idx) = 0;
    }

    return result;
}

int closenessCalc(int G[MAX][MAX],int n,int startnode, struct Graph *graph)
{ 
    int cost[MAX][MAX],distance[MAX],pred[MAX];
    int visited[MAX],count,mindistance,nextnode,i,j;
    int total = 0; 
    //pred[] stores the predecessor of each node
    //count gives the number of nodes seen so far
    //create the cost matrix
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            if(G[i][j]==0)
                cost[i][j]=INFINITY;
            else
                cost[i][j]=G[i][j];
    
    //initialize pred[],distance[] and visited[]
    for(i=0;i<n;i++)
    {
        distance[i]=cost[startnode][i];
        pred[i]=startnode;
        visited[i]=0;
    }
    
    distance[startnode]=0;
    visited[startnode]=1;
    count=1;
    
    while(count<n-1)
    {
        mindistance=INFINITY;
        
        //nextnode gives the node at minimum distance
        for(i=0;i<n;i++)
            if(distance[i]<mindistance&&!visited[i])
            {
                mindistance=distance[i];
                nextnode=i;
            }
            //check if a better path exists through nextnode            
            visited[nextnode]=1;
            for(i=0;i<n;i++)
                if(!visited[i])
                    if(mindistance+cost[nextnode][i]<distance[i])
                    {
                        distance[i]=mindistance+cost[nextnode][i];
                        pred[i]=nextnode;
                   }
        count++;
    }
    //print the path and distance of each node
    for(i=0;i<n;i++)
        if(i!=startnode)
        {
          
            j=i;
            total += distance[i];
            do
            {
                j=pred[j];
              
            }while(j!=startnode);
    }
    return total;
}
char *strCopy(const char *header, const char **words, size_t num_words)
{
    size_t message_len = strlen(header) + 1; /* + 1 for terminating NULL */
    char *message = (char*) malloc(message_len);
    strncat(message, header, message_len);

    for(int i = 0; i < num_words; ++i)
    {
       message_len += 1 + strlen(words[i]); /* 1 + for separator ';' */
       message = (char*) realloc(message, message_len);
       strncat(strncat(message, ";", message_len), words[i], message_len);
    }

  return message;
}
#include <stdlib.h>
#include <string.h>

char* concat(char *s1, char *s2)
{
    char *result = malloc(strlen(s1) + strlen(s2) + 1); // +1 for the null-terminator
    // in real code you would check for errors in malloc here
    strcpy(result, s1);
    strcat(result, s2);
    return result;
}
void betwennes(struct Graph *graph, int G[MAX][MAX],int startnode, int type, int B[])
{
 if(type == 1) {printf(" \n  Source      Target        Intermediate Nodes          Path \n" ); }
 while(startnode < graph->V) {
    int cost[MAX][MAX],distance[MAX],pred[MAX];
    int visited[MAX],count,mindistance,nextnode,i,j;
    
    //pred[] stores the predecessor of each node
    //count gives the number of nodes seen so far
    //create the cost matrix
    for(i=0;i<graph->V;i++)
        for(j=0;j<graph->V;j++)
            if(G[i][j]==0)
                cost[i][j]=INFINITY;
            else
                cost[i][j]=G[i][j];
    
    //initialize pred[],distance[] and visited[]
    for(i=0;i<graph->V;i++)
    {
        distance[i]=cost[startnode][i];
        pred[i]=startnode;
        visited[i]=0;
    }
    
    distance[startnode]=0;
    visited[startnode]=1;
    count=1;
    
    while(count<graph->V-1)
    {
        mindistance=INFINITY;
        
        //nextnode gives the node at minimum distance
        for(i=0;i<graph->V;i++)
            if(distance[i]<mindistance&&!visited[i])
            {
                mindistance=distance[i];
                nextnode=i;
            }
            
            //check if a better path exists through nextnode            
            visited[nextnode]=1;
            for(i=0;i<graph->V;i++)
                if(!visited[i])
                    if(mindistance+cost[nextnode][i]<distance[i])
                    {
                        distance[i]=mindistance+cost[nextnode][i];
                        pred[i]=nextnode;
                    }
        count++;
    }

    
     char * source = graph->array[startnode].head->dest;
      if(type == 1) { printf("\n"); }
      int kiff;
    for(i=0;i<graph->V;i++)
        if(i!=startnode)
        {   
            char *intermediate = "";
            char *destination =  graph->array[i].head->dest;
            if(type == 1) {
            int sourcedif = 10-strlen(source);
           printf("\n    %s",source);  for(int y= 0; y<sourcedif; y++){printf(" ");} printf("%s", destination); 
            int destdif = 15-strlen(destination);
            for(int y= 0; y<destdif; y++){printf(" ");}
            }
            j=i;
            do
            {
                j=pred[j];
               if(strcmp(graph->array[j].head->dest,source) != 0 && j!=startnode){ B[j] += 1; 
               char *temp = graph->array[j].head->dest;
                 if(type == 1) { intermediate = concat(intermediate,temp); intermediate =concat(intermediate, ",");}  } 
                int lentt = strlen(intermediate);
                 kiff = (25)-lentt;
               
            }while(j!=startnode);
             if(type == 1) {printf("%s", intermediate);}
            for(int p = 0;p<kiff; p++) if(type == 1) {{printf(" ");}}
            j=i;
           if(type == 1) {  printf("%s",graph->array[i].head->dest); }
            do
            {
                j=pred[j];
                 if(type == 1) { printf("<-%s",graph->array[j].head->dest);}   
                
            }while(j!=startnode);
    }

startnode ++; }
}

//This function finds the last of the char arrayed lineked list. I created this for representation, but i'm not using it inside main.
struct AdjListNode *findLastt(struct AdjListNode *node){
struct AdjListNode *temp = node;
while(temp->next!= NULL){ 
    temp = temp->next;
}
return temp;
}
//This is add spesific member to all vertexes linked listes.. But im not using this
void graphUpdater(struct Graph *graph, int lineCount){
for(int i =0; i<lineCount; i++){
struct AdjListNode *temp = findLastt(graph->array[i].head);
char *t = temp->dest;
int n = graph->array[i].head->numberOfedges;
struct AdjListNode * iterator = graph->array[i].head;
for(int k = 0; k<n; k++){iterator = iterator->next;}
iterator->next = newAdjListNode(t);
}}
int main(int argc, char const *argv[])
{
int c;
int lineCount = 0;
char forLine[50];
FILE * fp;
FILE * fp2;



fp2 = fopen("input.txt", "r");
while (fgets(forLine, 256, fp2)) { lineCount++; }
fclose(fp2);
    fp = fopen("input.txt", "r");
  if (fp == NULL) {
        perror("Error: Failed to open file.");
        return -1;
    }
//LINE COUNTİNG it gives us the number of Vertexes.
struct Graph *graph = createGraph(lineCount);
char line[256];
int length;
char *token;
char edges[256];
while (fgets(line, sizeof(line), fp)) {

for(int i = 0; i<256; i++) { if(line[i] == ';') length = i; }
for(int k = 0; k<256; k++) {edges[k] = line[k+length+2]; }         
char *vertex = substring(line, 1, length);
insert(graph, vertex, lineCount);
remchar(edges, ' ');
int tt= countChar(edges, ',')+1;
//Adding edges.
char **tokens = str_split(edges, ',');
if(tokens) {
 for (int i = 0; *(tokens + i); i++)  { addEdge(graph, vertex,  *(tokens + i), lineCount);  }    
}
}
fclose(fp);

//Creating an adjency matrix to calculate the distance between vertexes.
int G[lineCount][lineCount];
for(int i = 0; i< lineCount; i++){ 
    for(int k =0; k<graph->V; k++) { 
        int t = hasIt(graph->array[i].head, graph->array[k].head->dest);
      G[i][k] = t;
    } }
int B[lineCount];  //Betwennes values
for(int i= 0; i<lineCount; i++) {
    B[i] = 0;
}

//Adjency Matrix
printGraph(graph);
printf("\n ");
betwennes(graph, G, 0, 0, B); //Type 0 to update betwennes values.
printGraphCentrality(graph, G, B);

betwennes(graph, G, 0, 1, B);// Type 1 to print the Source   Target    Intermediate Nodes           Path     table.


    return 0;

}

