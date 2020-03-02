import java.io.*;
//This program operates 6 functions for String, all rights reserved to Taha Yusuf Kömür, his student number is 150114064
import java.util.Scanner;
public class Pro_4_150114064 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {   //This loop is infinite, but at last i made exit
            //i had to implement 2 nextLine method to keep my structure fixed instead of 1 nextLine method.
            //Because, i used println in the menu, and it causes one line used by the nextline method.
            System.out.println();
            System.out.println();
            System.out.println("Welcome to our String Analyzer Program.");
            System.out.println("    1. Count number of chars");
            System.out.println("    2. Print the words in a sentence");
            System.out.println("    3. Delete substring");
            System.out.println("    4. Replace substring");
            System.out.println("    5. Sort characters");
            System.out.println("    6. Hash code of a string");
            System.out.println();
            System.out.println("Please enter your choice: ");
            int x = input.nextInt();	

        switch (x) {
            case 1:
                System.out.println("Enter an input string:");
                String inputStr = input.nextLine();
                String inputStr2 = input.nextLine();

                System.out.println("Enter an input char: ");
                Character s = input.next().charAt(0);
                System.out.println("The number of " + s + " in " + inputStr2 + " is " + numOfChars(inputStr2, s)+".");
            break;
            case 2:  System.out.println("Enter an input string:");
            String case2St = input.nextLine();
            String case2Str = input.nextLine();
            System.out.println("The output is :");
            printWords(case2Str);
            break;
            case 3:  System.out.println("Enter an input string:");
                String case3St = input.nextLine();
                String case3Str = input.nextLine();
                System.out.println("Enter a substring: ");
                String case3Sub = input.nextLine();
                System.out.println("Enter a type: ");
                int type = input.nextInt();

            System.out.println(delete(case3Str,case3Sub, type));
            break;
            case 4: System.out.println("Enter an input string:");
                String case34t = input.nextLine();
                String case4Str = input.nextLine();
                System.out.println("Enter the first substring: ");
                String case4Sub = input.nextLine();
                System.out.println("Enter the second substring: ");
                String case4Sub2 = input.nextLine();

                System.out.println(replaceAll(case4Str, case4Sub, case4Sub2));
            break;
            case 5: System.out.println("Enter an input string:");
                String case5t = input.nextLine();
                String case5Str = input.nextLine();
                System.out.println("Enter a type: ");
                int type5 = input.nextInt();
                System.out.println(sortChars(case5Str, type5));
                break;
            case 6:
                System.out.println("Enter an input string:");
                String case6t = input.nextLine();
                String case6Str = input.nextLine();
                System.out.println("Enter a value for b: ");
                int b = input.nextInt();
            System.out.println("The hashcode for " +case6Str+" is " + hashCode(case6Str, b) +".");
                break;
        }

        //I wanted to locate my exit method here, coz it is more visuable here.
            System.out.println("Text exit&quit to quit, enter to contiune..");
            String lala = input.nextLine();
            String exit = input.nextLine();
            if(exit.equals("exit") || exit.equals("quit")){
                System.out.println("Program ends, Bye :)");
                System.exit(0);
            }

    }


    }
        // Methods

    public static int numOfChars(String str, char ch) {
        int count = 0;
        //comparing the character ch by characters which string contains, by index
        //every occurance, count ++
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char strChar = str.charAt(i);
            if (strChar == ch) {
                count++;
            }
        }
        return count;
    }
    public static void printWords(String str) {
        int length = str.length();
        for (int i = 0; i < length - 2; i++) { //Checking if letter or digit or else
            if (i == 0){if ((Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i)))) { System.out.print(str.charAt(i)); }}
            if (!Character.isLetter(str.charAt(i)) || !Character.isDigit(str.charAt(i))) {
                //Checking the punctitations and adding line for any of them
                //If when i is a letter, and i+1 is not letter, and i+2 is letter too, this means, i+1 should be new line.
                if (Character.isLetter(str.charAt(i + 1)) || Character.isDigit(str.charAt(i + 1))) { System.out.print(str.charAt(i + 1)); }
                if ((str.charAt(i + 1) == '_') && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == ',' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == '('&& (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == ')' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == ' ' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == '-' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == '.' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == '!' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
                if (str.charAt(i + 1) == '?' && (Character.isLetter(str.charAt(i + 2)) || Character.isDigit(str.charAt(i + 2)))){ System.out.println(); }
            }
        }System.out.println(); }
    public static String delete(String str, String subStr, int type) {

            if(type == 0) {
                int sublength = subStr.length();
                int startIndex = str.indexOf(subStr);    //i ll create new string not contains the substring
                int endIndex = startIndex + sublength;

                String updatedStr =str.substring(0, startIndex); //im creating it
                updatedStr += str.substring(endIndex);
              return updatedStr;
            }
                while(!((str.indexOf(subStr))==-1)) {  //iterating the same method above
                 int sublength = subStr.length();      //The difference is i m holding the tempEndIndex here, and iterating till indexOf method return -1 (no existing)
                 int startIndex = str.indexOf(subStr);
                 int  endIndex = startIndex + sublength;
                    String tempEndindex = str.substring(endIndex);

                    str = "" + str.substring(0, startIndex);
                    str += tempEndindex;
                }
            return str;

        }
    public static String replaceAll(String s, String sub, String rep ){

     while(!((s.indexOf(sub))==-1)) {   //Using the same method with delete
        int strlength = s.length();     //But the difference is, im holding the rep which is replacer, and adding it to the string each loop time
        int  sublength = sub.length();
        int startIndex = s.indexOf(sub);
        int endIndex = startIndex + sublength;
         String tempEndindex = s.substring(endIndex);

         s = "" + s.substring(0, startIndex);
         s += rep;
         s += tempEndindex;
     }
     return s;

 }
    public static String sortChars(String str, int type) {

        if (type == 0) {
            int length = str.length();     //Creating an int array to hold ascii values of characters
            int[] arr = new int[length];   //Using get ascii method for it (I wrote that :P)
            for (int i = 0; i < length; i++) {  // And im implementing my sorting method (O(n^2)) time complexity
                arr[i] = getAscii(str.charAt(i));
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            //Now, im adding all characters from the sorted ascii values of them to my new String.
            String sorted = "";

            for (int i = 0; i < length; i++) {

              sorted += getChar(arr[i]);
            }

            return sorted;
        }
            //here, im using the same method. But first, im sorting all string, then grouping them.
            String type1sorted = "";
        String lowerCaseLetters ="";
        String upperCaseLetters ="";
        String digits = "";
        String others = "";

        int length = str.length();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getAscii(str.charAt(i));
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < length; i++) {

            if(Character.isLowerCase(getChar(arr[i]))){
                lowerCaseLetters += getChar(arr[i]);
            }
            else if(Character.isUpperCase(getChar(arr[i]))){
                upperCaseLetters += getChar(arr[i]);
            }
            else if(Character.isDigit(getChar(arr[i]))){
                digits += getChar(arr[i]);
            }
            else {
                others += getChar(arr[i]);
            }
        }
//Grouped and sorted
        type1sorted =lowerCaseLetters+upperCaseLetters+digits+others;

        return type1sorted;
    }
    public static int getAscii (Character s){
//getting ascii
            int ascii = s;
            return s;

        }
    public static Character getChar(int i){
        char b= (char) i;
return b;
    }
    public static int hashCode(String str, int b) {

        int total = 0;
        int length = str.length();
        //iterating the formula at document, and holding the data in total value.
        for(int i= 0; i<length; i++){
           int s= getAscii(str.charAt(i));
          total += s*(int)Math.pow(b, length-i-1);
        }
        return total;
    }
    }















