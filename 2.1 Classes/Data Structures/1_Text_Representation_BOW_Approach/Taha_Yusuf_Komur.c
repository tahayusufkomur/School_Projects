/* Developer -> Taha Yusuf Kömür
   Marmara University 3. semester project
   2018 Fall
 
   to compile -> gcc <program_name.c> -o <program_name>
   to run ->     ./program_name
 */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <locale.h>

// SUB-LINKEDLIST
struct doc{
	int docId;  //Document Id
	int repeat; //count
	int len; 	
	char* cName; //Category
	struct doc* next; //next pointer
};	

// MASTER LINKEDLIST
struct mml{
	char* termName;  //Word
	int repeat; 	 //count
	struct mml* next;	//next node pointer
	struct doc* list;   //to sublist pointer
};

//Defining the structs
typedef struct mml mml;
typedef struct doc doc;

// Finding the stop words.
void findGeneral(mml* den){
	// Using flag values as detectors. To detect the categories. 
	// Temp is to end function when total word count become 5
	int flag1=0,flag2=0,flag3=0,temp3=0;
	
	doc* son;
	// son is the bottom node list 
	// den is the Master Node list
	while(den){// Checking all words here.
		son=den->list;
		while(son){// Checking the bottom node list, flag keeps the value to detect existing on category
			if(strcmp(son->cName,"econ")==0){
				flag1=1;
			}
			else if(strcmp(son->cName,"magazin")==0){
				flag2=1;
			}
			else if(strcmp(son->cName,"health")==0){
				flag3=1;
			}
			son=son->next;
		}
		if((flag1)&&(flag2)&&(flag3)){     //Prints if all the flag values are 1
			printf("%s\n",den->termName);
			temp3+=1;
		}
		flag1=0;
		flag2=0;
		flag3=0;
		den=den->next;
		if(temp3==5){// To print 5 common value, function get iterated 5 times by the temp value.
			break;
		}
	}
}


void findDiscriminate(mml* head){
	mml* den=head;
	int flag1=0,flag2=1,flag3=1,temp3=0;
	/* This time, im using the flags to detect word if exists in only 1 category. 
	To find econ, we start with 0, 1, 1 value for flags, 

	*/
	
	doc* son;
	printf("    ECON      \n");
	while(den){
		son=den->list;
		while(son){
			if(strcmp(son->cName,"econ")==0){
				flag1=1;
			}
			else if(strcmp(son->cName,"magazin")==0){
				flag2=0;
			}
			else if(strcmp(son->cName,"health")==0){
				flag3=0;
			}
			son=son->next;
		}
		if((flag1)&&((flag2))&&((flag3))){
			printf("%s\n",den->termName);
			temp3+=1;
		}
		flag1=0;
		flag2=1;
		flag3=1;
		den=den->next;
		if(temp3==5){
			break;
		}
	}
	flag1=1,flag2=0,flag3=1,temp3=0;
	printf("    MAGAZIN     \n");
	den=head;
	while(den){
		son=den->list;
		while(son){
			if(strcmp(son->cName,"econ")==0){
				flag1=0;
			}
			else if(strcmp(son->cName,"magazin")==0){
				flag2=1;
			}
			else if(strcmp(son->cName,"health")==0){
				flag3=0;
			}
			son=son->next;
		}
		if(((flag1))&&((flag2))&&((flag3))){
			printf("%s\n",den->termName);
			temp3+=1;
		}
		flag1=1;
		flag2=0;
		flag3=1;
		den=den->next;
		if(temp3==5){
			break;
		}
	}
	flag1=1,flag2=1,flag3=0,temp3=0;
	printf("    HEALTH      \n");
	den=head;
	while(den){
		son=den->list;
		while(son){
			if(strcmp(son->cName,"econ")==0){
				flag1=0;
			}
			else if(strcmp(son->cName,"magazin")==0){
				flag2=0;
			}
			else if(strcmp(son->cName,"health")==0){
				flag3=1;
			}
			son=son->next;
		}
		if(((flag1))&&((flag2))&&((flag3))){
			printf("%s\n",den->termName);
			temp3+=1;
		}
		flag1=1;
		flag2=1;
		flag3=0;
		den=den->next;
		if(temp3==5){
			break;
		}
	}
}

void insert(mml** head,char* term,int did, char* cn,int dlen){
	
	mml* iter,*n;
	doc* iter2;
	if(*head==NULL){ // When the list is empty
		(*head)=(mml*)malloc(sizeof(mml));
		(*head)->termName=(char*)malloc(sizeof(char)*strlen(term));
		strcpy(((*head)->termName),term);
		(*head)->repeat=1;
		(*head)->next=NULL;
		(*head)->list=(doc*)malloc(sizeof(doc));
		(*head)->list->docId=did;
		(*head)->list->repeat=1;
		(*head)->list->len=dlen;
		(*head)->list->cName=cn;
		(*head)->list->next=NULL;
		return;
	}
	iter=*head;
	if(strcmp(term,iter->termName) < 0){  //If the new word should come before the head.
		n=(mml*)malloc(sizeof(mml));
		n->termName=(char*)malloc(sizeof(char)*strlen(term));
		strcpy((n->termName),term);
		n->repeat=1;
		n->next=iter;
		n->list=(doc*)malloc(sizeof(doc));
		n->list->docId=did;
		n->repeat=1;
		n->list->len=dlen;
		n->list->cName=cn;
		n->list->next=NULL;
		*head=n;
		return;
	}
	while((iter->next!=NULL)&&(strcmp(term,iter->next->termName) > 0)){
		iter=iter->next;
	}
	if(iter->next==NULL){// When need to at the term to the end
		iter->next=(mml*)malloc(sizeof(mml));
		iter->next->termName=(char*)malloc(sizeof(char)*strlen(term));
		strcpy((iter->next->termName),term);
		iter->next->repeat=1;
		iter->next->next=NULL;
		iter->next->list=(doc*)malloc(sizeof(doc));
		iter->next->list->docId=did;
		iter->next->repeat=1;
		iter->next->list->len=dlen; //to be changed
		iter->next->list->cName=cn;
		iter->next->list->next=NULL;
		return;
	}
	if((strcmp(term,iter->next->termName) == 0)){//When find same word
		iter2=iter->next->list;
		while((iter2->docId!=did)&&(iter2->next!=NULL)){
			iter2=iter2->next;
		}
		if(iter2->docId==did){// when it finds in the same doc, repeat ++; 
			iter2->repeat+=1;
			return;
		}
		iter2->next=(doc*)malloc(sizeof(doc));//when it can't find same document, creates one.
		iter2->next->docId=did;
		iter2->next->repeat=1;
		iter2->next->len=dlen;
		iter2->next->cName=cn;
		iter2->next->next=NULL;
		return;
	}
	
	if(strcmp(term,iter->next->termName) < 0){// when the word should be ordered between to already existing words.
		n=(mml*)malloc(sizeof(mml));
		n->termName=(char*)malloc(sizeof(char)*strlen(term));
		strcpy((n->termName),term);
		n->repeat=1;
		n->next=iter->next;
		n->list=(doc*)malloc(sizeof(doc));
		n->list->docId=did;
		n->repeat=1;
		n->list->len=dlen;
		n->list->cName=cn;
		n->list->next=NULL;
		iter->next=n;
		return;
	}
}
int main(){
	setlocale(LC_CTYPE,"TURKİSH");
	int x=0,temp2=0;// xx holding the doc index, temp2 holding the array index
	mml* head=NULL;// Master List
	mml* den; // To trace the master list
	doc* son; //To trace the sub list
	char* q=(char*)malloc(sizeof(char)*50); // Pointer to hold the string when getting input
	char* d=(char*)malloc(sizeof(char)*50); // Pointer to send the strings to insertion.
	int* leng=(int*)malloc(sizeof(int)); // Array to hold doc sizes.
	DIR *FD; // Directory pointer
	struct dirent* in_file; // File Pointer
	FILE *ptr; // Document Holder
	FILE *ptr2; // Holding the last doc (we created)
	ptr2=fopen("./econ/qq.txt","w"); // Opening the first category
	FD=opendir("./econ");
	chdir("./econ");
	leng[0]=0;
	while (in_file=readdir(FD)){
		if (!(strcmp (in_file->d_name, "."))) //To enter the files inside directories ./1.txt
            continue;
        if (!(strcmp (in_file->d_name, "..")))   // ../1.txt
            continue;
        ptr=fopen(in_file->d_name,"r");
		while(fscanf(ptr,"%s",q)==1){ // Sending the file words the the document
			fprintf(ptr2,"%s ",q);	
			leng[temp2]+=1;
		}
		temp2+=1;
		leng=(int*)realloc(leng,sizeof(int)*(temp2+1)); //we increasing the size of document array holder
		leng[temp2]=0; //to not get error, new index of array = 0;
		fprintf(ptr2," uuu "); //to understand if files finished.
		fclose(ptr);
	}
	fprintf(ptr2," uuus "); // Category finished.
	fclose(ptr2);
	ptr2=fopen("qq.txt","r"); 
	while(1){
		fscanf(ptr2,"%s",d);
		if(!(strcmp(d,"uuus"))){
			break;
		}
		if(!(strcmp(d,"uuu"))){ // we changing x to document id when its finished.
			x+=1;
			continue;
		}
		insert(&head,d,x,"econ",leng[x]);
	}
	fclose(ptr2);
	closedir(FD);
	
	//
	
	FD=opendir("../magazin");
	chdir("../magazin");
	ptr2=fopen("./qq.txt","w");
	while (in_file=readdir(FD)){
		if (!(strcmp (in_file->d_name, ".")))
            continue;
        if (!(strcmp (in_file->d_name, "..")))  
            continue;
        ptr=fopen(in_file->d_name,"r");
		while(fscanf(ptr,"%s",q)==1){
			fprintf(ptr2,"%s ",q);
			leng[temp2]+=1;
		}
		temp2+=1;
		leng=(int*)realloc(leng,sizeof(int)*(temp2+1));
		leng[temp2]=0;
		fprintf(ptr2," uuu ");
	}
	fprintf(ptr2," uuus ");
	fclose(ptr2);
	ptr2=fopen("qq.txt","r");
	while(1){
		fscanf(ptr2,"%s",d);
		if(!(strcmp(d,"uuus"))){
			break;
		}
		if(!(strcmp(d,"uuu"))){
			x+=1;
			continue;
		}
		insert(&head,d,x,"magazin",leng[x]);
	}
	fclose(ptr2);
	closedir(FD);
	
	FD=opendir("../health");
	chdir("../health");
	ptr2=fopen("./qq.txt","w");
	while (in_file=readdir(FD)){
		if (!(strcmp (in_file->d_name, ".")))
            continue;
        if (!(strcmp (in_file->d_name, "..")))  
            continue;
        ptr=fopen(in_file->d_name,"r");
		while(fscanf(ptr,"%s",q)==1){
			fprintf(ptr2,"%s ",q);
			leng[temp2]+=1;
		}
		temp2+=1;
		leng=(int*)realloc(leng,sizeof(int)*(temp2+1));
		leng[temp2]=0;
		fprintf(ptr2," uuu ");
	}
	fprintf(ptr2," uuus ");
	fclose(ptr2);
	ptr2=fopen("qq.txt","r");
	while(1){
		fscanf(ptr2,"%s",d);
		if(!(strcmp(d,"uuus"))){
			break;
		}
		if(!(strcmp(d,"uuu"))){
			x+=1;
			continue;
		}
		insert(&head,d,x,"health",leng[x]);
	}
	fclose(ptr2);
	closedir(FD);
	
	//Outputs
	
	printf("The Common Words\n");
	
	den=head;
	findGeneral(den);
	
	printf("The Discriminated Words\n");
	
	den=head;
	findDiscriminate(den);
	
	return 0;
}


