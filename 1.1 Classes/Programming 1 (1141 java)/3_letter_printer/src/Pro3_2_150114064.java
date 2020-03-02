import java.util.Scanner;

public class Pro3_2_150114064 {


    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);



        System.out.println("Welcome to the letter printer program.");
        boolean yesOrnoController = true;


        while(yesOrnoController) {
            System.out.println("Enter the size: ");

            int size = input.nextInt();
            boolean sizeController = false;
            boolean letterController = false;

            if (size > 4 && size % 2 == 1) {
                sizeController = true;
            }
            if (!sizeController) {
                while (!sizeController) {
                    System.out.println("Invalid size. Enter the size again:  ");
                    size = input.nextInt();
                    if (size > 4 && size % 2 == 1) {
                        sizeController = true;
                    }
                }
            }
            System.out.println("Enter the letter");
            char letter = input.next().charAt(0);

            if (letter == 'Y' || letter == 'y') {
                letterController = true;
                //*************************Y PRINTER *************************\\
                int midPoint = (size - 1) / 2;
                for (int i = 0; i <= midPoint - 1; i++) {
                    for (int k = 0; k <= i; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 2; j < size - (2 * i); j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    System.out.println();
                }
                for (int z = 0; z <= midPoint; z++) {
                    for (int p = 0; p <= midPoint; p++) {
                        System.out.print(" ");
                    }
                    System.out.println("*");
                }
            }
            //*************************Y PRINTER *************************\\
            if (letter == 'X' || letter == 'x') {
                letterController = true;

            //*************************X PRINTER *************************\\
                //***TOP PART****\\
            int midPoint = (size - 1) / 2;
            for (int k = 0; k < midPoint; k++) {
                for(int j= 0; j<k;j++){ System.out.print(" "); }
                System.out.print("*");
                for (int i = 0; i < (size -2- 2*k); i++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println("");
            }
                //***TOP PART****\\

                //***MIDDLE PART***\\
            for (int m = 0; m< midPoint; m++) {
                System.out.print(" ");
            }
                System.out.println("*");
                //***MIDDLE PART***\\

                //***BOTTOM PART***\\
                //size 7 mid point 3

                for(int i= 0; i<midPoint; i++){
                    for(int b= 0; b<midPoint-1*i-1; b++){ System.out.print(" ");}
                    System.out.print("*");
                    for(int b= 0; b< 2*i+1 ; b++ ) { System.out.print(" "); }
                    System.out.print("*");

                    System.out.println("");
                }


                //***BOTTOM PART***\\
                //*************************X PRINTER *************************\\



        }



            if (letter == 'W' || letter == 'w') {
                letterController = true;

                //***** W PRINTER********\\
                //*****First Line********\\
                System.out.print("*");
                for (int i= 0; i< size*2-1; i++)
                {System.out.print(" ");}
                System.out.print("*");
                for (int i= 0; i< size*2-1; i++)
                {System.out.print(" ");}
                System.out.print("*");
                System.out.println();
                //*****First Line********\\

                //*****Middle Part*******\\
                for(int i= 0; i<size-2; i++){
                    for(int k= 0; k<=i; k++){ System.out.print(" "); }
                    System.out.print("*");
                    for (int k= 0; k< 2*size-4-2*i; k++) { System.out.print(" "); }
                    System.out.print("*");
                    for(int k= 0; k<=2*i+2; k++){ System.out.print(" "); }
                    System.out.print("*");
                    for (int k= 0; k< 2*size-4-2*i; k++) { System.out.print(" "); }
                    System.out.print("*");
                    System.out.println();
                    //*****Middle Part*******\\
                }

            //*******Bottom Part*******\\
                for(int i= 0; i< size-1; i++){ System.out.print(" "); }
                System.out.print("*");
                for(int i= 0; i< 2*(size); i++){ System.out.print(" "); }
                System.out.print("*");
           //*******Bottom Part*******\\

            }
            System.out.println();

            //***** W PRINTER********\\
            if (letter == 'Z' || letter == 'z') {

                //********Z PRINTER************\\
                //First Line
                for (int i= 0; i< size; i++) {
                    System.out.print("*");

                }
                System.out.println();
                //First Line

                //Middle Part}}\\
                for (int i= 0; i<size-2; i++){
                    for (int k= 0; k<size-2-i; k++){ System.out.print(" "); }
                    System.out.println("*");
                }
                //Middle Part}}\\

                //Last Line\\
                for (int i= 0; i< size; i++) {
                    System.out.print("*");

                }
                System.out.println();
                //Last Line\\
                //********Z PRINTER************\\

                letterController = true;
            }
            if (!letterController) {

                while (!letterController) {

                    System.out.println("Invalid letter: Enter the letter again: ");
                    letter = input.next().charAt(0);

                    if (letter == 'Y' || letter == 'y') {
                        letterController = true;
                        //*************************Y PRINTER *************************\\
                        int midPoint = (size - 1) / 2;
                        for (int i = 0; i <= midPoint - 1; i++) {
                            for (int k = 0; k <= i; k++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int j = 2; j < size - (2 * i); j++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            System.out.println();
                        }
                        for (int z = 0; z <= midPoint; z++) {
                            for (int p = 0; p <= midPoint; p++) {
                                System.out.print(" ");
                            }
                            System.out.println("*");
                        }
                    }
                    //*************************Y PRINTER *************************\\
                    if (letter == 'X' || letter == 'x') {
                        letterController = true;
                        //*************************X PRINTER *************************\\
                        //***TOP PART****\\
                        int midPoint = (size - 1) / 2;
                        for (int k = 0; k < midPoint; k++) {
                            for (int j = 0; j < k; j++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int i = 0; i < (size - 2 - 2 * k); i++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            System.out.println("");
                        }
                        //***TOP PART****\\

                        //***MIDDLE PART***\\
                        for (int m = 0; m < midPoint; m++) {
                            System.out.print(" ");
                        }
                        System.out.println("*");
                        //***MIDDLE PART***\\

                        //***BOTTOM PART***\\
                        //size 7 mid point 3

                        for (int i = 0; i < midPoint; i++) {
                            for (int b = 0; b < midPoint - 1 * i - 1; b++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int b = 0; b < 2 * i + 1; b++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");

                            System.out.println("");
                        }


                        //***BOTTOM PART***\\
                        //*************************X PRINTER *************************\\

                    }
                    if (letter == 'W' || letter == 'w') {
                        letterController = true;

                        //***** W PRINTER********\\
                        //*****First Line********\\
                        System.out.print("*");
                        for (int i = 0; i < size * 2 - 1; i++) {
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        for (int i = 0; i < size * 2 - 1; i++) {
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        System.out.println();
                        //*****First Line********\\

                        //*****Middle Part*******\\
                        for (int i = 0; i < size - 2; i++) {
                            for (int k = 0; k <= i; k++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int k = 0; k < 2 * size - 4 - 2 * i; k++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int k = 0; k <= 2 * i + 2; k++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            for (int k = 0; k < 2 * size - 4 - 2 * i; k++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                            System.out.println();
                            //*****Middle Part*******\\
                        }

                        //*******Bottom Part*******\\
                        for (int i = 0; i < size - 1; i++) {
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        for (int i = 0; i < 2 * (size); i++) {
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        //*******Bottom Part*******\\

                    }
                    System.out.println();

                    //***** W PRINTER********\\


                    if (letter == 'Z' || letter == 'z') {

                        //********Z PRINTER************\\
                        //First Line
                        for (int i= 0; i< size; i++) {
                            System.out.print("*");

                        }
                        System.out.println();
                        //First Line

                        //Middle Part}}\\
                        for (int i= 0; i<size-2; i++){
                            for (int k= 0; k<size-2-i; k++){ System.out.print(" "); }
                            System.out.println("*");
                        }
                        //Middle Part}}\\
                        //Last Line\\
                        for (int i= 0; i< size; i++) {
                            System.out.print("*");
                        }
                        System.out.println();
                        //Last Line\\
                        //********Z PRINTER************\\
                        letterController = true;
                    }

                }
            }
            System.out.println("Would you want to contiune? (Y or N) :");
            char yesOrno = input.next().charAt(0);
            if (yesOrno == 'N' || yesOrno == 'n'){ yesOrnoController = false;}
        }}
}



