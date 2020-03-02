#include <stdlib.h>
#include <stdio.h>
//TAHA YUSUF KÖMÜR, 150114064


static int count = 0;
struct node {
int data;
int isLeaf;
int childSign;   //1 = Lchild, 2= Mchild, 3= Rchild;  
struct node * lChild, *mChild, *rChild, *parent;


} ;
typedef struct node node;


//This is for balancing function, but nevermind, i didnt used.

int isOnlyChild(node *tree){

    if(tree->childSign == 1){ if(tree->parent->mChild == NULL && tree->parent->rChild == NULL){  return 1;  }}
    if(tree->childSign == 2){ if(tree->parent->lChild == NULL && tree->parent->rChild == NULL){  return 1;  }}
    if(tree->childSign == 3){ if(tree->parent->lChild == NULL && tree->parent->mChild == NULL){  return 1;  }}
return 0;
}

//To compare 2 integer
int maxOf(int a, int b){

if(a>b){ return a;}
if(b>a){ return b;}
return a;
}


//This is for remove funtion, to swap the deleted node with max child
int findMax(node *tree){
if(!tree){ return 0;}
if(tree->rChild != NULL){int max = findMax(tree->rChild); return max;}
else if(tree->mChild != NULL){int max = findMax(tree->mChild); return max;}
else return tree->data;

}

//This was for balancing tree too
int depthOf(node *ptr){
int count= 0;
    while(ptr->parent != NULL){
        ptr = ptr->parent;
       count++;
    }
return count;
    }
//Insert funtion, similar to the binary tree insertion... 
void insert(node ** tree, int val)
{
    node *temp = NULL;
    if(!(*tree))
    {
        temp = (node *)malloc(sizeof(node));
        temp->lChild = temp->mChild = temp->rChild = NULL;
        temp->data = val;
        temp->isLeaf = 0;
        temp->parent = NULL;
        *tree = temp;
        return;
    }
   else if(val< ((*tree)->data)){
        
        insert(&(*tree)->lChild, val); 
        ((*tree)->lChild)->parent = *tree;
        ((*tree)->lChild)->childSign= 1;
     
          return;
    }
   else if(val>((*tree)->data) && (((*tree)->data*(*tree)->data))>= val){
     
        insert(&(*tree)->mChild, val);
          ((*tree)->mChild)->parent = *tree;
          ((*tree)->mChild)->childSign=2;
          return;
    }
    else if (val>((*tree)->data*(*tree)->data))
    
     {   
         
         insert(&(*tree)->rChild,val); 
         ((*tree)->rChild)->parent = *tree; 
         ((*tree)->rChild)->childSign= 3;
         return;
       
         }
    else { return;}
}

//Search function, similar to binary search function.
node* search(node ** tree, int val) {
 if(!(*tree)) {
   return NULL;
  }
 if(val == (*tree)->data) {
     printf("Found\n");
   return *tree;
} else if(val < (*tree)->data) {
    search(&((*tree)->lChild), val);}
 else if(val>((*tree)->data) && (((*tree)->data*(*tree)->data))>= val){
     search(&(*tree)->mChild, val);
 }
else if(val > (*tree)->data){
    search(&((*tree)->rChild), val);
}

else{ printf("not found"); }
}

//Displaying the tree in order of previous.
void preOrderDisp(node *tree){
if(tree){
printf("%d \n", tree->data);
preOrderDisp(tree->lChild);
preOrderDisp(tree->mChild);
preOrderDisp(tree->rChild);

}}

//This is marking leaves, so we can always access them with search function..
void leafMark(node *tree){

if(tree->lChild == NULL)
if(tree->mChild == NULL) 
{if(tree->rChild == NULL)

    tree->isLeaf = 1;

}
if((tree->lChild)){leafMark(tree->lChild);}
if((tree->mChild)){leafMark(tree->mChild);}
if((tree->rChild)){leafMark(tree->rChild);}
} 
//I holded leaves inside a file, this is to printing leaves to file.
void printLeafToFile(node *tree,FILE *fp){
fp = fopen("leaves.txt", "w");
if(tree->isLeaf == 1){fprintf( fp, "%d  \n", tree->data);   }
if(tree){ 
if((tree->lChild)){printLeafToFile(tree->lChild, fp);}
if((tree->mChild)){printLeafToFile(tree->mChild,fp);}
if((tree->rChild)){printLeafToFile(tree->rChild, fp);}
}   
}

//Displaying the leaves.. Using isLeaf for it.
void leafDisplay(node *tree){
if(tree->isLeaf == 1){ printf("%d  \n",tree->data);   }
if(tree){ 
if((tree->lChild)){leafDisplay(tree->lChild);}
if((tree->mChild)){leafDisplay(tree->mChild);}
if((tree->rChild)){leafDisplay(tree->rChild);}
}   
}

//Some kind of search funtion, which gives us the leaf.
int getLeaf(node *tree){
if(tree->isLeaf == 1){tree->isLeaf = 0; return tree->data;   }
if(tree){ 
if((tree->lChild)){getLeaf(tree->lChild);}
if((tree->mChild)){getLeaf(tree->mChild);}
if((tree->rChild)){getLeaf(tree->rChild);}
}   

}



int leafCount(node *tree){
    
if(tree->isLeaf == 1){count ++;  }
if(tree){
if((tree->lChild)){leafCount(tree->lChild);}
if((tree->mChild)){leafCount(tree->mChild);}
if((tree->rChild)){leafCount(tree->rChild);}
}   
return count;
}


//When its find the value inside tree, it checks the conditions below.
void deleteNode(node **tree, int val){
leafMark(*tree);
 if(!(*tree)) {
   return;
  }
 if(val == (*tree)->data) {
    if((*tree)->isLeaf == 1){   /* ***********DELETE LEAF*************** */

if((*tree)->childSign == 1) {  (*tree)->parent->lChild = NULL;return ; }  
if((*tree)->childSign == 2) {  (*tree)->parent->mChild = NULL;  return; }  
if((*tree)->childSign == 3) { (*tree)->parent->rChild = NULL ;  return ; }  
     } /* ***********DELETE LEAF*************** */
      /*  ******************DELETE 1 CHILD PARENT**************  (1 */
  if((*tree)->isLeaf == 0) {


if((*tree)->lChild == NULL && (*tree)->rChild == NULL){
     if((*tree)->childSign == 1){(*tree)->mChild->parent = (*tree)->parent; (*tree)->parent->lChild = (*tree)->mChild; return;} 
else if((*tree)->childSign == 2){(*tree)->mChild->parent = (*tree)->parent;(*tree)->parent->mChild = (*tree)->mChild; return;}
else if((*tree)->childSign == 3){(*tree)->mChild->parent = (*tree)->parent; (*tree)->parent->rChild = (*tree)->mChild;return;} }
;
if((*tree)->mChild == NULL && (*tree)->rChild == NULL){
 if((*tree)->childSign == 1) {(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->lChild = (*tree)->lChild;return;}
else if((*tree)->childSign == 2) {(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->mChild = (*tree)->lChild;return;}
else if((*tree)->childSign == 3)  {(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->rChild = (*tree)->lChild; return;}    }


   /*  if((*tree)->parent->mChild->data == (*tree)->data){(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->mChild = (*tree)->lChild;return;}
else if((*tree)->parent->lChild->data == (*tree)->data){(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->lChild = (*tree)->lChild;return;}
else if((*tree)->parent->rChild->data == (*tree)->data){(*tree)->lChild->parent = (*tree)->parent; (*tree)->parent->rChild = (*tree)->lChild; return;}    }

*/

if((*tree)->lChild == NULL && (*tree)->mChild == NULL){
    if((*tree)->childSign == 1){(*tree)->parent->lChild = (*tree)->rChild; (*tree)->rChild->parent = (*tree)->parent;return;}
else if((*tree)->childSign == 2){(*tree)->parent->mChild = (*tree)->rChild; (*tree)->rChild->parent = (*tree)->parent;return;}
else if((*tree)->childSign == 3){(*tree)->parent->rChild = (*tree)->rChild; (*tree)->rChild->parent = (*tree)->parent;return;}    }
  }

    /*  ******************DELETE 1 CHILD PARENT************* */
    /*    **************DELETE 3 CHILD PARENT *********** */
if((*tree)->isLeaf == 0) {
 if((*tree)->lChild != NULL && (*tree)->mChild != NULL&& (*tree)->rChild != NULL) {

    int i = findMax((*tree)->lChild);   
    int y = (*tree)->mChild->data;
    int z = findMax((*tree)->mChild);
    node *temp =search((tree), z);
    printf("%d\n", i);
     if((i*i)>(*tree)->mChild->data){ deleteNode(tree, z);  deleteNode(tree, i); (*tree)->data = i; insert(tree, z); return; }
     if((i*i)<(*tree)->mChild->data){if(y*y< (*tree)->rChild->data){ deleteNode(tree, y); (*tree)->data = y; return; }}
     if(i*i<(*tree)->mChild->data){if(y*y>(*tree)->rChild->data) { deleteNode(tree,i); (*tree)->data = i;  temp->mChild = (*tree)->rChild; (*tree)->rChild = (*tree)->mChild; (*tree)->mChild = NULL; return;}}

/*  deleteNode(tree, i); (*tree)->data = i; search(tree, z)->mChild = (*tree)->rChild; (*tree)->rChild = (*tree)->mChild; /*

 }  /*    **************DELETE 3 CHILD PARENT *********** */}
 /*    **************DELETE 2 CHILD PARENT *********** */
  }
   
  if((*tree)->isLeaf ==0) {
   
    
   
      if((*tree)->lChild == NULL && (*tree)->mChild != NULL&& (*tree)->rChild != NULL) {
    int rData = (*tree)->rChild->data;
    int mData = (*tree)->mChild->data;
     node *x = (*tree)->mChild;
      while((x)->lChild!=NULL){ (x) = (x)->lChild;}
    int lowest = x->data;  
      
    if(mData*mData<(rData)&& (*tree)->mChild->isLeaf == 1){(*tree)->data = mData; (*tree)->mChild = NULL;}
          else if(lowest*lowest<rData && x->isLeaf == 1) { (*tree)->data = lowest; (x->parent->lChild == NULL); }
          else {deleteNode(tree, rData); (*tree)->data =rData; (*tree)->lChild = (*tree)->mChild; (*tree)->mChild = NULL; return; }       //****************************************************
      }
      else if((*tree)->lChild != NULL && (*tree)->mChild == NULL&& (*tree)->rChild != NULL) {
         int i = findMax((*tree)->lChild);
         deleteNode(tree, i);
        (*tree)->data = i;

      }
       else if((*tree)->lChild != NULL && (*tree)->mChild != NULL&& (*tree)->rChild == NULL) {
        (*tree)->data = (*tree)->mChild->data; 
        
        (*tree)->mChild = NULL; 
      }
  }
  /*    **************DELETE 2 CHILD PARENT *********** */
     }
      else if(val < (*tree)->data) {
    deleteNode(&((*tree)->lChild), val);}
 else if(val>((*tree)->data) && (((*tree)->data*(*tree)->data))>= val){
     deleteNode(&(*tree)->mChild, val);
 }
else if(val > (*tree)->data){
    deleteNode(&((*tree)->rChild), val);
}
else{ printf("not found"); }
}



void main(){
int linecount = 0;
node *root;
FILE * fp;
FILE * fp2;

root = NULL;
int c;
int i = 0;



 fp2 = fopen("input.txt","r");
    // if opening file fails, print error message and exit 1
    if (fp2 == NULL) {
        perror("Error: Failed to open file.");
        return;
    }
   do{
        fscanf(fp2,"%11111d",&i); //Storing the number into the tree.
      insert(&root, i);
    linecount++;
    } while(c=getc(fp2)!=EOF);
    fclose(fp2); 
    leafMark(root);
    leafDisplay(root);
    printLeafToFile(root, fp);
    //printLeafToFile(&root, fp);

/* IMPORTANT NOTE: Please use leafMark method after deleted or inserted something. This keeps the Tree fixed. thanks.. */

}
