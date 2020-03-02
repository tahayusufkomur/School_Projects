import java.util.Scanner;

    public class Pro3_1_150114064{


    public static void main(String args[]){

    Scanner input = new Scanner(System.in);

        System.out.println("Welcome to image printer program.");
        System.out.println("Please enter your sequence:");
 //taking sequence as string
        String sequence = input.nextLine();
 //taking length of sequence
        int seqLength = sequence.length();
    //defined loop for scope
        int loop = 1;

        //the printer loop
        for (int i= 0; i<seqLength; i++){
        //taking sequence character by character
            char CurrentChar = sequence.charAt(i);


            if(CurrentChar == 'b'){
               for(int j= 0; j<loop; j++){
                   System.out.print(" ");
               }
            }
            if(CurrentChar == 's'){

                for(int j= 0; j<loop; j++){
                    System.out.print("*");
                }

            }
            if(CurrentChar == 'n'){

                for(int j= 0; j<loop; j++){
                    System.out.println("");
                }

            }

            loop = 1;
            if(Character.isDigit(CurrentChar)){

                loop = CurrentChar - '0';

            }

        }



    }


    }