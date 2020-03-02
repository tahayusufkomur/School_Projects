	import java.util.Scanner;
	public class Pro2_150114064 {
	
		public static void main(String args[]) {
			Scanner input = new Scanner(System.in); //Creating Scanner Operator
			
			//Taking the inputs as variable of float.
			System.out.println("Enter your monthly salary, for example 3500: ");
			float salary = input.nextFloat();
			System.out.println("Enter the percent of your salary to save, for example 10%:");
			float savePercent = input.nextFloat();
			System.out.println("Enter the monthly interest rate, for example 8.25%");
			float interestRate = input.nextFloat();
			System.out.println("Enter the monthly government support rate, for example 25%:");
			float supportRate = input.nextFloat();
			
			//The equations for calculating each months value
			double amountOfSave = (double)((int)((salary*savePercent/100)*100)/100.0);
		
			double amountOfAccountFirstMonth =  amountOfSave*(1+supportRate/100)*((1+interestRate/100));
			double amountOfAccountSecondMonth = ((amountOfAccountFirstMonth + (amountOfSave*(1+(supportRate/100))))*(1+interestRate/100));
			double amountOfAccountThirthMonth = ((amountOfAccountSecondMonth + (amountOfSave*(1+(supportRate/100))))*(1+interestRate/100));
			double amountOfAccountFourthMonth = ((amountOfAccountThirthMonth + (amountOfSave*(1+(supportRate/100))))*(1+interestRate/100));
			double amountOfAccountFifthMonth = ((amountOfAccountFourthMonth + (amountOfSave*(1+(supportRate/100))))*(1+interestRate/100));
			double amountOfAccountSixthMonth = ((amountOfAccountFifthMonth + (amountOfSave*(1+(supportRate/100))))*(1+interestRate/100));
			
			//Rounding operations to have 2 decimal after the value.
			
			amountOfAccountFirstMonth = (double)Math.round(amountOfAccountFirstMonth * 100d) / 100d;
			amountOfAccountSecondMonth = (double)Math.round(amountOfAccountSecondMonth * 100d) / 100d;
			amountOfAccountThirthMonth = (double)Math.round(amountOfAccountThirthMonth * 100d) / 100d;
			amountOfAccountFourthMonth = (double)Math.round(amountOfAccountFourthMonth * 100d) / 100d;
			amountOfAccountFifthMonth = (double)Math.round(amountOfAccountFifthMonth * 100d) / 100d;
			amountOfAccountSixthMonth = (double)Math.round(amountOfAccountSixthMonth * 100d) / 100d;
			
			//printings
			System.out.println("After the first month, the account value is " + amountOfAccountFirstMonth + " TLs");
			System.out.println("After the second month, the account value is " + amountOfAccountSecondMonth+" TLs");
			System.out.println("After the thirth month, the account value is " + amountOfAccountThirthMonth+" TLs");
			System.out.println("After the fourth month, the account value is " + amountOfAccountFourthMonth+" TLs");
			System.out.println("After the fifth month, the account value is " + amountOfAccountFifthMonth+" TLs");
			System.out.println("After the sixth month, the account value is " + amountOfAccountSixthMonth+" TLs");
			
			// The six month Amount and Total Profit
			
			double sixMonthSaveAmount = amountOfSave*6;
			double totalProfit = (double)Math.round((amountOfAccountSixthMonth-sixMonthSaveAmount)*100d)/100d;
			
			
			System.out.println("In total you saved " + sixMonthSaveAmount + "TLs and your total profit is " + (totalProfit) +" TLs");
		
			
			
			
		}
	}
