//Taha Yusuf Kömür 150114064

import java.util.Scanner; //importing the Scanner


public class Pro1_150114064 {
	//main
	public static void main(String args[]){
		//taking inputs from the user and the variables
		System.out.println("Enter value of x1: ");
		Scanner input = new Scanner(System.in);
		double inputx1 = input.nextDouble();
		System.out.println("Enter value of y1: ");
		double inputy1 = input.nextDouble();
		System.out.println("Enter value of x2: ");
		double inputx2 = input.nextDouble();
		System.out.println("Enter value of y2: ");
		double inputy2 = input.nextDouble();
		//having new variables using the inputs
		double slope = (inputy2-inputy1)/(inputx2-inputx1);
		double midpointX = (inputx2+inputx1)/2;
		double midpointY = (inputy2+inputy1)/2;
		double perpendicularSlope = -1/(slope); //having perpendicular slope
		double b = (-(perpendicularSlope*midpointX)+ midpointY); //having the constant double of the equation here.
		
		
		//printing
		System.out.print("The equation of the perpendicular bisector of the line segment between ");
		System.out.print("("+ inputx1 +","+ inputy1 + ")" + " and ("+ inputx2 + "," + inputy2 + ") is y ="+ perpendicularSlope+"x + "+ b );
		
		
	}

}
