package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Some Comparison Characters

        char compact = 'C';
        char luxury = 'L';
        char midsize = 'M';
        char pickup = 'P';
        char SUV = 'S';
        //Tax Values
        double otv1 = 135/100;
        double otv2 = 140/100;
        double kdv = 118/100;
        double totalSalePrice = 0;

while(true){
  //Menu
        Scanner input = new Scanner(System.in);
        System.out.println("WELCOME TO MARMARA MOTOR CARS");
        System.out.println("-----------------------------");
        System.out.println("Compact (C) ");
        System.out.println("Luxury (L) ");
        System.out.println("Midsize (M) ");
        System.out.println("Pickup (P) ");
        System.out.println("SUV (S) ");
        System.out.println("What model of car do you want? (C, L, M, P, S):");
        char carChar = input.next().charAt(0);
        if(carChar == 'C' || carChar == 'c'){

            double basePrice = 16000;
            double underCoating =125;
            double securityPackage = 800;




            System.out.println("Do you want protective undercoating for 125.0$? (Y/N)? ");
            char coatingChar = input.next().charAt(0);
            System.out.println("Do you want the security package for $800.0 (Y/N)? ");
            char securityChar = input.next().charAt(0);
            if(coatingChar == 'Y' || coatingChar == 'y') {
                if (securityChar == 'Y' || securityChar == 'y')
                {
                    double totalPrice = ((basePrice + underCoating + securityPackage) * 1.35) * 1.18;
                    double tax = (totalPrice-underCoating-securityPackage - 16000);
                    System.out.println("You ordered a Compact car with a base price of $16000.0");
                    System.out.println("Your additional cost is " + (underCoating + securityPackage));
                    System.out.println("Sales Tax: " + tax);
                    System.out.println("Total cost of car & options :" + totalPrice);
                    System.out.println("Program ends...");
                }
                else {

                    double totalPrice = (((basePrice+underCoating) * 1.35) * 1.18);
                    double tax = (totalPrice-underCoating-16000);
                    System.out.println("You ordered a Compact car with a base price of $16000.0");
                    System.out.println("Your additional cost is " + (underCoating));
                    System.out.println("Sales Tax: " + tax);
                    System.out.println("Total cost of car & options :" + totalPrice);
                    System.out.println("Program ends...");
                }

            } else if (securityChar == 'Y' || securityChar == 'y')
            {
                double totalPrice = ((basePrice + securityPackage) * 1.35) * 1.18;
                double tax = (totalPrice-securityPackage-16000);
                System.out.println("You ordered a Compact car with a base price of $16000.0");
                System.out.println("Your additional cost is " + ( securityPackage));
                System.out.println("Sales Tax: " + tax);
                System.out.println("Total cost of car & options :" + totalPrice);
                System.out.println("Program ends...");
            }
            else {
                double totalPrice = ((basePrice) * 1.35) * 1.18;
                double tax = (totalPrice-16000);
                System.out.println("You ordered a Compact car with a base price of $16000.0");
                System.out.println("Your additional cost is " + ( 0));
                System.out.println("Sales Tax: " + tax);
                System.out.println("Total cost of car & options :" + totalPrice);
                System.out.println("Program ends...");


            }
            System.out.println("Press 0 to exit number else to return menu");
        }

        if(carChar == 'L' || carChar == 'l') {
            double underCoating = 125;
            double multimediaPackage = 1250;




            System.out.println("Do you want protective undercoating for 125.0$? (Y/N)? ");
            char coatingChar = input.next().charAt(0);
            System.out.println("Do you want the multimedia package for $1250.0 (Y/N)? ");
            char multimediaChar = input.next().charAt(0);




            if (coatingChar == 'Y' || coatingChar == 'y') {

                if(multimediaChar == 'Y' || multimediaChar =='y'){

                    double discountedPackage = (multimediaPackage+underCoating)*0.95;
                    double basePrice = 39000;
                    double totalPrice = ((basePrice+discountedPackage)*1.40)*1.18;
                    double tax = (totalPrice-discountedPackage-39000.00);
                    System.out.println("You ordered a Luxury car with a base price of $39000.0");
                    System.out.println("Your additional cost is "+discountedPackage);
                    System.out.println("Sales Tax: "+ tax);
                    System.out.println("Total cost of car & options :" + totalPrice );
                    System.out.println("Program ends...");
                }

                else {

                    double basePrice = 39000;
                    double totalPrice = ((basePrice+underCoating)*1.40)*1.18;
                    double tax = (totalPrice-underCoating-39000.00);
                    System.out.println("You ordered a Luxury car with a base price of $39000.0");
                    System.out.println("Your additional cost is "+underCoating);
                    System.out.println("Sales Tax: "+ tax);
                    System.out.println("Total cost of car & options :" + totalPrice );
                    System.out.println("Program ends...");

                }

            }
        else if(multimediaChar == 'Y' || multimediaChar == 'y'){

                double basePrice = 39000;
                double totalPrice = ((basePrice+multimediaPackage)*1.40)*1.18;
                double tax = (totalPrice-multimediaPackage-39000.00);
                System.out.println("You ordered a Luxury car with a base price of $39000.0");
                System.out.println("Your additional cost is "+multimediaPackage);
                System.out.println("Sales Tax: "+ tax);
                System.out.println("Total cost of car & options :" + totalPrice );
                System.out.println("Program ends...");


            }

            else {   double basePrice = 39000;
                double totalPrice = ((basePrice)*1.40)*1.18;
                double tax = (totalPrice-39000.00);
                System.out.println("Your additional cost is $0.00");
                System.out.println("Sales Tax: "+ tax);
                System.out.println("Total cost of car & options :" + totalPrice );
                System.out.println("Program ends...");



            }
            System.out.println("Press 0 to exit number else to return menu");
        }
            if(carChar == 'M' || carChar == 'm') {
                double basePrice = 26000;
                double sportsPackage = basePrice*0.05;
                double sunroof = 1500;
                double automaticTransmission = 2000;
                double multimediaPackage = 750;
                double securityPackage = 1000;
                double underCoating= 125;



            System.out.println("Do you want protective undercoating for 125.0$? (Y/N)? ");
            char coatingChar = input.next().charAt(0);
            System.out.println("Do you want the Automatic Transmission for $2000.0 (Y/N)? ");
            char automaticTranmissionChar = input.next().charAt(0);
            System.out.println("Do you want the Sunroof for $1500.0 (Y/N)? ");
            char sunroofChar = input.next().charAt(0);
            System.out.println("Do you want the Multimedia Package for $750.0 (Y/N)? ");
            char multimediaChar = input.next().charAt(0);
            System.out.println("Do you want the Security Package for $1000.0 (Y/N)? ");
            char securityPackageChar = input.next().charAt(0);
            System.out.println("Do you want the sports package for an increased 5.0% This will increase your cost by " + sportsPackage +"(Y/N)? ");
            char sportPackageChar = input.next().charAt(0);
/*if (multimediaChar == 'y' || multimediaChar == 'Y'){
 if (sunroofChar == 'y' || sunroofChar == 'Y'){
   if (securityPackageChar == 'y' || securityPackageChar == 'Y')[
   if (automaticTranmissionChar == 'y' || automaticTranmissionChar == 'Y'){


   }
   }

 }
}


 */

        if (sunroofChar == 'y' || sunroofChar == 'Y'){
            if (multimediaChar == 'y' || multimediaChar == 'Y') {
                multimediaPackage = 500;
                if (securityPackageChar == 'y' || securityPackageChar == 'Y'){
                    if (automaticTranmissionChar == 'y' || automaticTranmissionChar == 'Y'){

                        automaticTransmission *= 0.9;
                        securityPackage *= 0.9;

                        double OptionedPrice = basePrice + automaticTransmission + securityPackage + multimediaPackage + sunroof;
                        if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                        if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}

                        //Y Y Y Y Y Y
                        double totalPrice = OptionedPrice*1.35*1.18;
                        double tax = totalPrice - basePrice;
                        double additionalCost = OptionedPrice-basePrice;
                        System.out.println("You ordered a Midsize car with a base price of $26000.0");
                        System.out.println("Your additional cost is $" + additionalCost);
                        System.out.println("Sales Tax: "+ tax);
                        System.out.println("Total cost of car & options :" + totalPrice );
                        System.out.println("Program ends...");

                    }
                    else {  // security without discount, sunroof and multi with discount, and others normally if he needs.
                        double OptionedPrice = basePrice + securityPackage + multimediaPackage + sunroof;


                        if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                        if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                        double totalPrice = OptionedPrice*1.35*1.18;
                        double tax = totalPrice - basePrice;
                        double additionalCost = OptionedPrice-basePrice;
                        System.out.println("You ordered a Midsize car with a base price of $26000.0");
                        System.out.println("Your additional cost is $" + additionalCost);
                        System.out.println("Sales Tax: "+ tax);
                        System.out.println("Total cost of car & options :" + totalPrice );
                        System.out.println("Program ends...");

                    }
                }
                else {
                    // automatic (without discount, multimedia, sunroof with discount,  and if buyer wants, coating + sportspackage
                    double OptionedPrice = 0;
                    OptionedPrice += (basePrice + multimediaPackage + sunroof);
                    if(automaticTranmissionChar == 'y' || automaticTranmissionChar == 'Y') { OptionedPrice += 2000; }
                    if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                    if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                    double totalPrice = OptionedPrice*1.35*1.18;
                    double tax = totalPrice - basePrice;
                    double additionalCost = OptionedPrice-basePrice;
                    System.out.println("You ordered a Midsize car with a base price of $26000.0");
                    System.out.println("Your additional cost is $" + additionalCost);
                    System.out.println("Sales Tax: "+ tax);
                    System.out.println("Total cost of car & options :" + totalPrice );
                    System.out.println("Program ends...");

                }


            } else {     if (securityPackageChar == 'y' || securityPackageChar == 'Y'){
                if (automaticTranmissionChar == 'y' || automaticTranmissionChar == 'Y'){

                    automaticTransmission *= 0.9;
                    securityPackage *= 0.9;
System.out.print(" ");
                    double OptionedPrice = basePrice + automaticTransmission + securityPackage + sunroof;

                    if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                    if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                    double totalPrice = OptionedPrice*1.35*1.18;
                    double tax = totalPrice - basePrice;
                    double additionalCost = OptionedPrice-basePrice;
                    if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                    System.out.println("You ordered a Midsize car with a base price of $26000.0");
                    System.out.println("Your additional cost is $" + additionalCost);
                    System.out.println("Sales Tax: "+ tax);
                    System.out.println("Total cost of car & options :" + totalPrice );
                    System.out.println("Program ends...");

                }
                else {  // security without discount, sunroof and multi with discount, and others normally if he needs.
                    double OptionedPrice = basePrice + securityPackage + sunroof;

System.out.print(" ");
                    if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                    if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                    double totalPrice = OptionedPrice*1.35*1.18;
                    double tax = totalPrice - basePrice;
                    double additionalCost = OptionedPrice-basePrice;
                    if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                    System.out.println("You ordered a Midsize car with a base price of $26000.0");
                    System.out.println("Your additional cost is $" + additionalCost);
                    System.out.println("Sales Tax: "+ tax);
                    System.out.println("Total cost of car & options :" + totalPrice );
                    System.out.println("Program ends...");
                    break;
                }
            }
            else {
                // automatic (without discount, multimedia, sunroof with discount,  and if buyer wants, coating + sportspackage
                double OptionedPrice = 0; System.out.print(" ");
                OptionedPrice += (basePrice  + sunroof);
                if(automaticTranmissionChar == 'y' || automaticTranmissionChar == 'Y') { OptionedPrice += 2000; }
                if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                double totalPrice = OptionedPrice*1.35*1.18;
                double tax = totalPrice - basePrice;
                double additionalCost = OptionedPrice-basePrice;
                if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                System.out.println("You ordered a Midsize car with a base price of $26000.0");
                System.out.println("Your additional cost is $" + additionalCost);
                System.out.println("Sales Tax: "+ tax);
                System.out.println("Total cost of car & options :" + totalPrice );
                System.out.println("Program ends...");
                break;
            }

            }





            }

            else {

               if(automaticTranmissionChar == 'Y' || automaticTranmissionChar == 'y'){
                   if(securityPackageChar =='y' || securityPackageChar =='Y'){
                       double OptionedPrice = basePrice+2700;
                       if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                       if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                       if(multimediaChar =='y' || multimediaChar == 'Y') {OptionedPrice += multimediaPackage;}
                       if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                           double totalPrice = OptionedPrice*1.35*1.18;
                           double tax = totalPrice - basePrice;
                           double additionalCost = OptionedPrice-basePrice;
                       System.out.println("You ordered a Midsize car with a base price of $26000.0");
                       System.out.println("Your additional cost is $" + additionalCost);
                           System.out.println("Sales Tax: "+ tax);
                           System.out.println("Total cost of car & options :" + totalPrice );
                           System.out.println("Program ends...");
                           break;
                }
                else {
                    double OptionedPrice = basePrice + 2000;
                       if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                       if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                       if(multimediaChar =='y' || multimediaChar == 'Y') {OptionedPrice += multimediaPackage;}
                       if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                       double totalPrice = OptionedPrice*1.35*1.18;
                       double tax = totalPrice - basePrice;
                       double additionalCost = OptionedPrice-basePrice;
                       System.out.println("You ordered a Midsize car with a base price of $26000.0");
                       System.out.println("Your additional cost is $" + additionalCost);
                       System.out.println("Sales Tax: "+ tax);
                       System.out.println("Total cost of car & options :" + totalPrice );
                       System.out.println("Program ends...");
                       break;

                   }
            }

            else {

                double OptionedPrice = basePrice;
                       if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
                       if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                       if(multimediaChar =='y' || multimediaChar == 'Y') {OptionedPrice += multimediaPackage;}
                           double totalPrice = OptionedPrice*1.35*1.18;
                           double tax = totalPrice - basePrice;                                       System.out.print(" ");
                           double additionalCost = OptionedPrice-basePrice;
                   System.out.println("You ordered a Midsize car with a base price of $26000.0");
                   System.out.println("Your additional cost is $" + additionalCost);
                           System.out.println("Sales Tax: "+ tax);
                           System.out.println("Total cost of car & options :" + totalPrice );
                           System.out.println("Program ends...");

                   }

        }







        }





        if(carChar == 'P' || carChar == 'p'){
            double underCoating =150;
            double multimediaPackage = 750;
            double basePrice = 19500;
            double OptionedPrice = basePrice;



            System.out.println("Do you want protective undercoating for $150.0? (Y/N)? ");
            char coatingChar = input.next().charAt(0);
            System.out.println("Do you want the multimedia package for $750.0 (Y/N)? ");
            char multimediaChar = input.next().charAt(0);
            System.out.println("Press 0 to exit number else to return menu");

            if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
            if(multimediaChar =='y' || multimediaChar == 'Y') {OptionedPrice += multimediaPackage;}
            double totalPrice = OptionedPrice*1.35*1.18;
            double tax = totalPrice - basePrice;                                       System.out.print(" ");
            double additionalCost = OptionedPrice-basePrice;
            System.out.println("You ordered a Pickup car with a base price of $19000.0");
            System.out.println("Your additional cost is $" + additionalCost);
            System.out.println("Sales Tax: "+ tax);
            System.out.println("Total cost of car & options :" + totalPrice );
            System.out.println("Program ends...");



        }

        if(carChar == 'S' || carChar == 's'){
            double automaticTransmission = 2500;
            double underCoating =200;
            double securityPackage = 1350;
            double multimediaPackage = 1000;
            double sunroof = 2300;
            double basePrice = 29000;
            double sportsPackage = basePrice/100*5;
            double OptionedPrice = basePrice;

            System.out.println("Do you want protective undercoating for 200$? (Y/N)? ");
            char coatingChar = input.next().charAt(0);
            System.out.println("Do you like to replace the normal transmission by an automatic transmission for $2500.0 (Y/N)? ");
            char automaticTransmissonChar = input.next().charAt(0);
            System.out.println("Do you want sunroof for $2300.0 (Y/N)? ");
            char sunroofChar = input.next().charAt(0);
            System.out.println("Do you want the multimedia package for $1000.0 (Y/N)? ");
            char multimediaChar = input.next().charAt(0);
            System.out.println("Do you want the security package for $1350.0 (Y/N)?");
            char securityPackageChar = input.next().charAt(0);
            System.out.println("Do you want the sports package for an increased 5.0% This will increase your cost by " + sportsPackage +"(Y/N)? ");
            char sportPackageChar = input.next().charAt(0);


            if (multimediaChar == 'y' || multimediaChar == 'Y'){
                if (sunroofChar == 'y' || sunroofChar == 'Y'){
                    if (securityPackageChar == 'y' || securityPackageChar == 'Y'){
                    if (automaticTransmissonChar == 'y' || automaticTransmissonChar == 'Y'){
                        if(sportPackageChar == 'y' || sportPackageChar == 'Y'){ OptionedPrice += sportsPackage;}
                        OptionedPrice += (2500+1350+1000+2300);
                        if(OptionedPrice<35000){
                            double totalPrice = (OptionedPrice*1.35)*1.18;
                            double tax = totalPrice - OptionedPrice;                                       System.out.print(" ");
                            double additionalCost = OptionedPrice-basePrice;

                            System.out.println("You won protective undercoating for free! ");
                            System.out.println("You ordered a Pickup car with a base price of $19000.0");
                            System.out.println("Your additional cost is $" + additionalCost);
                            System.out.println("Sales Tax: "+ tax);
                            System.out.println("Total cost of car & options :" + totalPrice );
                            System.out.println("Program ends...");
                            break;
                        } else {

                        double totalPrice = (OptionedPrice*1.40)*1.18;
                            double tax = totalPrice - OptionedPrice;                                       System.out.print(" ");
                            double additionalCost = OptionedPrice-basePrice;

                            System.out.println("You won protective undercoating for free! ");
                            System.out.println("You ordered a Pickup car with a base price of $19000.0");
                            System.out.println("Your additional cost is $" + additionalCost);
                            System.out.println("Sales Tax: "+ tax);
                            System.out.println("Total cost of car & options :" + totalPrice );
                            System.out.println("Program ends...");
                            break;

                        }



                    }
                }

            }



        }
            if (multimediaChar == 'y' || multimediaChar == 'Y'){OptionedPrice += multimediaPackage;}
            if (automaticTransmissonChar == 'y' || automaticTransmissonChar == 'Y'){OptionedPrice += automaticTransmission;}
            if(sportPackageChar == 'y' || sportPackageChar == 'Y'){OptionedPrice += sportsPackage;}
            if(coatingChar == 'y' || coatingChar == 'Y') { OptionedPrice += underCoating; }
            if(multimediaChar =='y' || multimediaChar == 'Y') {OptionedPrice += multimediaPackage;}
            if(securityPackageChar == 'y' || securityPackageChar == 'Y'){OptionedPrice += securityPackage;}
            if(sunroofChar =='y' || sunroofChar == 'Y') {OptionedPrice += sunroof;}
            if(OptionedPrice<35000){
                double totalPrice = (OptionedPrice*1.35)*1.18;
                double tax = totalPrice - OptionedPrice;                                       System.out.print(" ");
                double additionalCost = OptionedPrice-basePrice;

                System.out.println("You won protective undercoating for free! ");
                System.out.println("You ordered a Pickup car with a base price of $19000.0");
                System.out.println("Your additional cost is $" + additionalCost);
                System.out.println("Sales Tax: "+ tax);
                System.out.println("Total cost of car & options :" + totalPrice );
                System.out.println("Program ends...");
                break;
            } else {

                double totalPrice = (OptionedPrice*1.40)*1.18;
                double tax = totalPrice - OptionedPrice;                                       System.out.print(" ");
                double additionalCost = OptionedPrice-basePrice;

                System.out.println("You won protective undercoating for free! ");
                System.out.println("You ordered a Pickup car with a base price of $19000.0");
                System.out.println("Your additional cost is $" + additionalCost);
                System.out.println("Sales Tax: "+ tax);
                System.out.println("Total cost of car & options :" + totalPrice );
                System.out.println("Program ends...");
                break;

            }



        }

        w

        }}}


