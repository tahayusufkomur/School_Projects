    #include <stdio.h>
    #include <string.h>
    #define CONSTANT_MACRO 6
    #include <ctype.h>


int customerNumber = 000;
char forbiddenItems[CONSTANT_MACRO][50];
int customers[500][1];
double transactions[730][1];
int customerSearcher();
int customerNumberIncrementer = -1;
char tempContents[500];
char contents[500];

double *money;
int checkFinish();

int stringToConstruct[500], start, end;
int searchWord(char  string1[], char string2[]);
void reconstruct();
int startIndex;
int endIndex;
int mother();
int main(){
    for(int i= 0; i<500;i++){
        tempContents[i] = '\0';
    }
//FOr infinitive menu loop
    for(;;){

puts("Hello Admin Please the Forbidden Items");
for(int i= 0; i<CONSTANT_MACRO; i++){

    gets(forbiddenItems[i]);

}
int inputSystem = 0;
puts("Do you want to start the system? 1--> Yes, 0 --> No:");

scanf("%d",  &inputSystem);

if(inputSystem == 0)

      return 0;


      printf("Welcome the the Cargo Tracking System \n");
      printf("Please enter the customer number:\n");

      scanf("%d", &customerNumber);

      if(customerSearcher(customerNumber) != -1){
        printf("New Customer Added;\n");
        customerNumberIncrementer += 1;
        customers[customerNumberIncrementer][0] = customerNumber; }
        else if(customerSearcher(customerNumber)!= 1){
            printf("Already exists"); }


            //To have exact sized array of contents;
            puts("Please enter the contents of cargo");
            fflush(stdin);
            gets(tempContents);
            int i;
            int j;
            for(i= 0,j=0; i<500 ;i++){
                if(tempContents[i]== '\0'){
                        break;
                     }
                    else if(tempContents[i] == ' ')

                    i=i;
                    else  {

                            contents[j] = tempContents[i];
                            j++;
                            }
                }






            }



}






//its checks if the user is already exists or not
int customerSearcher(){
      for(int i = 0; i<500;i++){
        if((customerNumber != customers[i][0])){

            return customerNumber; }

            else
                return -1;

        }
        }

   //it checks if the contents full of empties or nulls
int checkFinish(char stringToCheck[]){

    for(int i = 0; i<500; i++){

        if(stringToCheck[i] != '\0'||stringToCheck[i] != ' '){
            return 1;
        }
        else return 0;
    }
}

    //this is my custom function to get start and end index of choosen item. it also seek for forbidden items.
    int mother(char string1[], char  string2[]) {


    int i=0, j=0;
    int tempIndex = i;
    int lengthOfString1 = strlen(string1);
    int lengthOfString2 = strlen(string2);


    for(i=0; i<lengthOfString1-lengthOfString2; i++)
    {
        tempIndex = i;
        startIndex = i;
        endIndex = startIndex+ lengthOfString2;


                for(j=0; j<lengthOfString2; j++)
        {
            if(string1[tempIndex]==string2[j])
            {
                if(j==lengthOfString2-1)

                return 1;
                tempIndex++;
            }
            else break;
        }

    }

return 0;
}

//This function is to composite mother and reconstruct functions..
int searchWord(char string1[], char string2[])
{
    if(mother(string1, string2)) {
        reconstruct(string1, startIndex, endIndex);
        return 1;
    }
    else return  0;




}


//This function for extracting an item from contents array. Its also rebuild it.
void reconstruct(char contents[],int startIndex,int endIndex){

char tempContents1[startIndex];
char tempContents2[strlen(contents)-endIndex];

for(int i= 0;i<startIndex;i++){
   tempContents1[i] = contents[i];
}
for(int i= 0; endIndex<strlen(contents); i++, endIndex++){
   tempContents2[i] = contents[endIndex];
}

for(int i= 0;i<strlen(tempContents1); i++){
    contents[i] = tempContents1[i];
}
for(int i = 0; i<strlen(tempContents2); i++, startIndex++){
    contents[startIndex]=tempContents2[i];
}
contents[strlen(tempContents1)+strlen(tempContents2)] = '\0';

}











