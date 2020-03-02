//TAHA YUSUF KÖMÜR
//150114064


import java.lang.Math;
import java.util.Scanner;



/* This Programme, takes 2 input from user as: "Number of dices" , "Times to roll the dices" */
/* This programme, creates an array with flexible size and fill it with information of dices*/
/* It prints histogram to show the statistics. */

public class Pro5_1_150114064 {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("Welcome to dice rolling programme");
System.out.println("Enter how many dice you want to roll ");
int diceNum = input.nextInt();
System.out.println("Enter how many times you want to roll the dice");
int rollNum = input.nextInt();



int diceArr[] = createAnArraySized(6*diceNum);


for(int i= 0; i<rollNum; i++){

    int temp = rollNDice(diceNum);
    diceArr[temp] += 1;
}


printHistogram(diceArr);
    }
    //This method rolls a single dice n times and sum their values, and return it.
    public static int rollNDice(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
              total += (int)(Math.random()*6)+1; }
            return total;
        }
    //This method creates array with size which needed, it returns to an integer array
    public static int[] createAnArraySized(int n){
        int[] x = new int[n];
        //initilaize 0

        for(int i = 0; i<n; i++){x[i]= 0; }
        return x;
    }
   //This method takes integer array as input, and prints its values as stars.
    public static void printHistogram(int x[]){
        int length = x.length;
        for(int i=0; i<length; i++){
            if(x[i]!= 0){System.out.println(); System.out.print(i+": "); for(int k= 0; k<x[i]; k++){ System.out.print("*"); } }
        }
    }
    }
