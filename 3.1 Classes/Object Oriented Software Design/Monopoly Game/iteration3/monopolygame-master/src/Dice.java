
public class Dice {

    private int num;

    public Dice(int num){
        this.num = num;
    }

    public static int rollDices(Dice diceOne, Dice diceTwo){
        double random = Math.random();
        double random2 = Math.random();
        diceOne.num = (int) (random * 6 + 1);
        diceTwo.num = (int) (random2 * 6 + 1);
        return diceOne.num + diceTwo.num;
    }

    public static void printDices(Dice diceOne, Dice diceTwo){  //Method for print dices after each cycle
        System.out.println("\nFirst dice: " + diceOne.num);
        System.out.println("Second dice: " + diceTwo.num);
        int totalFaceValue = diceOne.num + diceTwo.num;
        System.out.println("Total face value: " + totalFaceValue + "\n");
    }

    public static boolean getDicesAreEven(Dice diceOne, Dice diceTwo){  //Check whether player rolled even or not
        if(diceOne.num == diceTwo.num)
            return true;
        return false;
    }

}