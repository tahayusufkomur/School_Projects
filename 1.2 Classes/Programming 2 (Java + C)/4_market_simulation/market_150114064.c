//Taha Yusuf Kömür
//150114064

//Hocam neredeyse %90 tamamladım, yalnızca son stockout'ta hata üstüne hata aldım, vaktinde yetiştiremedim. 
//Kalan bütün fonksiyonlarım her case e uygun çalışıyor. 



#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>


typedef struct firm firm;
typedef struct food food;
typedef struct foodStock foodStock;

struct firm{
int firmId;
char firmName[100];
struct firm *nextFirmPtr;

};

struct food{
char prod_name[400]; //Name of the food.
int exp_day;
int exp_month;
int exp_year;
};

struct foodStock{
struct food ffood;
struct foodStock *nextFood;

};




char* concat(const char s1[], const char s2[])
{
    char *result = malloc(strlen(s1)+strlen(s2)+1);//+1 for the null-terminator
    strcpy(result, s1);
char stringForEmpty[2]=  " ";
    strcat(result,stringForEmpty);
    strcat(result, s2);
    return result;
}
void printList(firm *head){

struct firm *current = head;
while(current != NULL){

    printf("%d %s\n" , current->firmId, current->firmName);

    current = current-> nextFirmPtr;


}}

void printProducts(foodStock *head2, char fileName[]){
foodStock *current = head2;
FILE *productsFilePtr = fopen(fileName, "w");
while (current -> nextFood != NULL) {
    printf("%s\n",current->ffood.prod_name );
    fprintf(productsFilePtr, "%s%s%d/%d/%d\n", current->ffood.prod_name, " EXP : ",  current->ffood.exp_day, current->ffood.exp_month, current->ffood.exp_year);
    current = current -> nextFood;
}


}



void insert(firm** headPtr, int firmId, char firmName[]) {
    firm* newPtr = malloc(sizeof(firm));

    if (newPtr != NULL) {
        newPtr -> firmId = firmId;
        strcpy(newPtr->firmName, firmName);
        newPtr -> nextFirmPtr = NULL;
        firm* previousPtr = NULL;
        firm* currentPtr = *headPtr;
        while(currentPtr != NULL && firmId < currentPtr -> firmId) {
            previousPtr = currentPtr;
            currentPtr = currentPtr -> nextFirmPtr;
        }
        if(previousPtr == NULL) {
            newPtr -> nextFirmPtr = *headPtr;
            *headPtr = newPtr;
        }
        else {
            previousPtr -> nextFirmPtr = newPtr;
            newPtr -> nextFirmPtr = currentPtr;
        }
    }
    else {
        printf("%d not inserted. No memory available.\n", firmId);
    }

}

void InsertEnd(foodStock **headPointer, char prod_name[] )
{
    foodStock *newNode = malloc(sizeof(foodStock));

    //randoms

    int exp_day =(rand() % (14 + 1 - 1)) + 1;
   int exp_month =(rand() % (4 + 1 - 1)) + 1;
  int   exp_year =(rand() % 2 + 2018);


    strcpy(newNode->ffood.prod_name, prod_name);
    newNode->ffood.exp_day = exp_day;
    newNode->ffood.exp_month = exp_month;
    newNode->ffood.exp_year = exp_year;
    if(*headPointer == NULL){
        newNode->nextFood = *headPointer;
        *headPointer = newNode;
    }
    else {
        foodStock *currentPtr = *headPointer;
        while (currentPtr -> nextFood != NULL) {
            currentPtr = currentPtr -> nextFood;
        }
        currentPtr -> nextFood = newNode;
        newNode -> nextFood = NULL;

    }
   
}
int stockChecker(int day, int month, int year, foodStock node){
//exp : 5/2/2019
// date : 7/ 7/ 2018
if (node.ffood.exp_year < year) {
     puts("gate 1");
    return 1;
   
}
else if (node.ffood.exp_month < month && node.ffood.exp_year == year) {
     puts("gate 2");
    return 1;
   
}
else if (node.ffood.exp_day < day && node.ffood.exp_year == year && node.ffood.exp_month == month) {
      puts("gate 3");
    return 1;
  
}

else  
    puts("gate 4");
    return 0;
}


foodStock *stockOut(foodStock *foodPtr, int day, int month, int year){
    /*
    while (1) {
    if(stockChecker(day, month, year, *foodPtr) && foodPtr != NULL) {
       foodPtr = foodPtr -> nextFood;
    }
    else {
        foodStock *previousPtr = NULL;
        foodStock *currentPtr = foodPtr;
        if (stockChecker(day, month, year, *currentPtr) && currentPtr -> nextFood != NULL) {
            previousPtr = currentPtr ;
            currentPtr = currentPtr -> nextFood;
        }
        previousPtr -> nextFood = currentPtr ->nextFood;
        free(currentPtr);
      
    }
}
return foodPtr;*/

}


firm *readFirm(char filename[]){
firm *head = NULL;
 FILE *filePtr = fopen(filename, "r");

 for(;;){



int firmId;
char firmName[100];
fscanf(filePtr, "%d%s", &firmId, firmName);
if(feof(filePtr))

break;
insert(&head, firmId, firmName);


 }

return head;
}

int detectPoint() {
    int count = 0;
     FILE *filePtr = fopen("products.txt", "r");
     char s[400];
    for(;;) {
        count++;
        fgets(s, 399, filePtr);
        if(feof(filePtr)) break;
    }
    return count;
}

foodStock *readFoods(char fileName[]){
    
int count = 0;
FILE *fileProducts = fopen(fileName, "r");
foodStock *head2 = NULL;
char s1[40];
char s2[40];
char s3[40];
int quantity;
char *tempString;

for(;;){

fscanf(fileProducts, "%s%s%s%d", s1,s2,s3, &quantity);
tempString= concat(s1, s2);
tempString= concat(tempString,s3);

for(int i= 0; i<quantity; i++){
InsertEnd(&head2, tempString );
if ( i == quantity - 1) {
count++;
}
if(count == detectPoint()) {
    i--;
}



    

}
if(feof(fileProducts)){break;}



}

return head2;

}


int main(){
 
srand(time(NULL));

foodStock *newPtr = malloc(sizeof(foodStock));

printList(readFirm("firms.txt"));
foodStock *stablePtr = readFoods("products.txt");
puts("Please enter the day, month and year to be checked:");

printProducts(stockOut(stablePtr, 7, 7, 2018), "final_stock.txt");
}
