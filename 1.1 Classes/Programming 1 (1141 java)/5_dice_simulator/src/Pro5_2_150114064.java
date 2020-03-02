import  java.util.Scanner;



public class Pro5_2_150114064 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
 System.out.println("Welcome to our program.");
 boolean checker = false;
        int temp = 0;
        int columns = 0;
 outer:
 while(!checker) {
     System.out.print("Enter a string: ");
     String string = input.nextLine();
     string += '-';
     checker = formatChecker(string);
     if (!checker) { continue outer; } ;
     int[] arr = tokenizeAndParse(string);
     System.out.print("Enter number of steps: "); int steps = inputInt.nextInt(); System.out.println();


    int lengthArr = arr.length;
     for(int i= 0; i<lengthArr; i++){
         if(arr[i]>temp){ temp= arr[i]; }
     }
     String tempS = Integer.toBinaryString(temp);
     columns = tempS.length();
     int rows = lengthArr;

      int converted[][] = convertBinaryArray(arr);

      printFormattedArray(converted, rows, columns);

    int[][] updatedArray =  updateTheArray(converted, rows, columns);

     printFormattedArray(updatedArray, rows, columns);
 }
 }

/* This method takes the string as input, and checks its format for( number - number - number - ..... )*/
public static boolean  formatChecker(String x){
        int length = x.length();
        for(int i= 0; i<length; i++){
            char t = x.charAt(i);
            if((t<48 && t>57)) { return true; }
            if(t == '-') { return true;}
        }
    System.out.println("Wrong format!! The format should be x-x-x"); return false;
    }
/* This method takes the Formatted String as input, and tokenize it, and parse integers from it. And returns an integer Array which holds the values*/
public static int[]tokenizeAndParse(String x) {
    int length = x.length();

    //Determining the size of the array of integers
    int size = countAnyChar(x,'-');
    int [] y = new int[size];
    int startındex = 0;
    int endIndex = 0;
    int k = 0;
    char t = '-';
    int lelength = 0;
    for(int i = 0; i<length; i++){
        if(x.charAt(i) == t) {
            endIndex = i;
         String temp = x.substring(startındex, endIndex);
         int tempInt = Integer.parseInt(temp);

            startındex = endIndex+1;
         y[k] = tempInt;

            k++;
        }
    }
    return y;
}
/* This method, count any Char inside any String returns an integer.*/
public static int countAnyChar(String x, char c){
    int count = 0;
    int length = x.length();
    for(int i = 0; i<length; i++){
     if(x.charAt(i) == c){count ++;}
    }
    return count;
}



/* This method takes an integer array and converts its to 2D binary array.
Its uses Integer.toBinaryString submethod to convert integer to its binary string represent
And its parses every each character of binary represent, to integer, then store them into the new array.
The max columns determining by, the maximum integer value of integer array, length of its binary represents becomes our column
*/

public static int[][] convertBinaryArray (int[] x) {
    int rows = x.length;
    int columns = 0;
    int temp = 0;

    for(int i= 0; i<rows; i++){
        if(x[i]>temp){ temp= x[i]; }
    }
String tempS = Integer.toBinaryString(temp);
    columns = tempS.length();
    int[][] converted = new int[rows][columns];

    for(int i=0; i<rows; i++) {
        int z = 0;
        String tempSS = Integer.toBinaryString(x[i]);
        int lengthDec = tempSS.length();
        int difference = columns-lengthDec;
        for(int k= difference; k<columns; k++) {
            char c = tempSS.charAt(z);
            int p = c -'0';
            converted[i][k] = p;
z++;
        }
    }
    return converted;
}
/* This method takes array input, rows and columns and printing its value formatted as table */
public static void printFormattedArray(int[][]arr, int rows, int columns) {
    for(int z =0; z<columns; z++) {System.out.print("---"); }
    System.out.print("-");
        for(int i = 0; i<rows; i++) { System.out.println();
            System.out.print("| ");
            for(int k = 0; k<columns; k++) {
            System.out.print(arr[i][k] +" |");
            }
        }
    System.out.println();
    for(int z =0; z<columns; z++) {System.out.print("---"); }
    System.out.print("-");

    }
 public static int checkLeft(int[][] arr, int i, int k){
    return arr[i][k-1];
 }
    public static int checkRight(int[][] arr, int i, int k){
        return arr[i][k+1];
    }
    public static int checkUp(int[][] arr, int i, int k){
        return arr[i-1][k];
    }
    public static int checkDown(int[][] arr, int i, int k){
    int y =  arr[i+1][k];
        return y;
    }
    public static int checkLeftTopDia(int[][] arr, int i, int k){
        return arr[i-1][k-1];
    }
    public static int checkLeftDownDia(int[][] arr, int i, int k){
        return arr[i+1][k-1];
    }
    public static int checkRightTopDia(int[][] arr, int i, int k){
        return arr[i-1][k+1];
    }
    public static int checkRightDownDia(int[][] arr, int i, int k){
        return arr[i+1][k+1];
    }
    public static int[][] updateTheArray(int x[][], int rows, int columns) {
        int[][] updated = x;


        for(int i = 0; i<rows; i++) {
            for(int k= 0; k<columns; k++) {
               int total = 0;
                if(i>=0 && i<rows-1){
                  total += checkDown(x,rows,columns);
                }
                if(i>0 && i<rows){
                    total  +=  checkUp(x, rows,columns);
                }
                if(k>=0 && k<columns-1){
                    total  +=  checkRight(x, rows,columns);
                }
                if(k>0 && k<columns){
                    total  +=  checkLeft(x, rows,columns);
                }

                if(i>=0 && i<rows-1){
                    if(k>0 && k<columns){
                    total  +=  checkLeftDownDia(x, rows,columns);
                }}
                if(i>=0 && i<rows-1){
                    if(k>=0 && k<columns-1){
                        total  +=  checkRightDownDia(x, rows,columns);
                    }}
                if(i>0 && i<rows){
                    if(k>=0 && k<columns-1){
                        total  +=  checkRightTopDia(x, rows,columns);
                    }}
                if(i>0 && i<rows){
                    if(k>0 && k<columns){
                        total  +=  checkLeftTopDia(x, rows,columns);
                    }}



                    if(x[i][k] == 1 && total<2) { x[i][k] = 0; }
                    if(x[i][k] == 1 && total>3) { x[i][k] = 0; }
                    if(x[i][k] == 1 && total== 3) { x[i][k] = 1; }
                    if(x[i][k] == 0 && total== 3) { x[i][k] = 1; }




                    }


            }


            return updated;
        }
}
