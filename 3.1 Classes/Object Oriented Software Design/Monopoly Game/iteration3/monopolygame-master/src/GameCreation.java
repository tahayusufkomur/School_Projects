import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GameCreation extends AbstractPlayer {

    private ArrayList<Player> players;  //Players list that will play the game.
    private int goPrice;    //Amount of money if the player pass from Go Square
    private Player winner;
    private int countCycle = 1; //Cycle counter
    private boolean gameOver;   //Control variable for game is over or not
    public static String[] inputs;  //Inputs that taken from user
    private int numberOfPlayer;
    static ArrayList<Square> squares;  //Squares list for create squares
    public static Bank bank;
    public int bankAmount;

    static Dice diceOne = new Dice(0);
    static Dice diceTwo = new Dice(0);

    public GameCreation() throws IOException {

        bank = new Bank();
        bankAmount = bank.getBankAmount();  //initialize bank amount
        inputs = takeInputs();  //take inputs from user
        this.numberOfPlayer = Integer.parseInt(inputs[0]);  //set number of player from user input
        this.goPrice = Integer.parseInt(inputs[4]); //set go price from user input
        this.gameOver = false;
    }

    public String[] takeInputs() throws IOException {   //Function for reading input file
        inputs = new String[17];

        File file = new File("inputs.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String string;  //each line from input
        int i = 0;
        while ((string = br.readLine()) != null) {
            String[] tokens = string.split(":");
            inputs[i] = tokens[1];
            i++;
        }
        return inputs;
    }

    public void play() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        createPlayers();//Create players

        players = determineOrder(); //Determine the game order of players
        Board.createBoard(inputs); //Create game board
        progress(); //players will play after board is generated
    }

    public void createPlayers() {
        players = getPlayersAbstract(); //array list to hold players

    }

    public void progress() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException { //Game will continue cycle in this method
        Player failedPlayer = null;  //who is failed
        squares = Board.getSquares();  //Squares that produced already

        while (bankAmount >= 0) {   //While there is money in the bank game will be continue
            boolean playerFailed = false;  //if action method of related square returns true, that's mean player failed.(situation of fail)
            int failedPlayerNum = 0;   //number of players that is failed

            for (int i = 0; i < players.size(); i++) {//loop for each cycle
                Player currentPlayer = players.get(i);  //hold player who has turn
                failedPlayer = currentPlayer;   //temporarily initialize current user as a failed
                int currPos = 0;

                int diceNum = Dice.rollDices(diceOne, diceTwo); //Roll dices
                if (Dice.getDicesAreEven(diceOne, diceTwo)) {//control if player rolled dices even
                    if (currentPlayer.getNumberOfEvenDices() == 2) {//If player rolled dices even at three times, it will go to the Jail.
                        currentPlayer.setPosition(Board.jailIndex);
                        currentPlayer.setNumberOfEvenDices(0); //Set number of even dices zero
                    } else {
                        currentPlayer.setNumberOfEvenDices(1); //If player did not roll dices even at three times yet, it will play its turn
                        playerFailed = noProblemForAction(currPos, currentPlayer, diceNum); //Player plays its turn and control whether it failed or not.
                    }
                } else {//If player did not roll dices even, it will play its turn
                    currentPlayer.setNumberOfEvenDices(0);
                    playerFailed = noProblemForAction(currPos, currentPlayer, diceNum);//Player plays its turn and control whether it failed or not.
                }
                currentPlayer.setTurnCycle(); //increment turn cycle for each player's per roll

                if (bankAmount <= 0) {//check whether bank amount is over or not
                    System.out.println("\nThe money in the bank is over!");
                    gameOver(null);//if money in the bank is over game will over
                    break;
                }

                if (playerFailed) {  //fail control
                    System.out.println(currentPlayer.getName() + " bursted up!" );
                    players.remove(currentPlayer);  //if player failed remove it from array list of players
                    System.out.println(currentPlayer.getName() + " bursted up!" );
                    currentPlayer.setFalseOnGame();  //set player's current situation of it is on game or not
                    if (controlGameOver(currentPlayer)) {//check if the number of players remaining is one or not
                        gameOver = true;
                        break;  //when remained 1 player on the game, game will over and loop will be terminated.
                    }
                    failedPlayerNum++;  //increment number of failed player
                }
            }
            if (gameOver)
                break;  //when remained 1 player on the game, game will over and loop will be terminated.

            if (bankAmount > 0)
                printCycleSituation();  //print each cycle's situation in game

            countCycle++;//increment count cycle at each cycle
            numberOfPlayer -= failedPlayerNum; //calculate remained player number

            if (numberOfPlayer == 1) {//if remained number of player is 1 finish the game
                gameOver(failedPlayer);
                break;
            }
        }
    }

    public boolean noProblemForAction(int currPos, Player currentPlayer, int diceNum) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Class currentSquare;
        Method action = null;

        boolean playerFailed = false;  //if action method of related square returns false, that's mean player is failed.
        currPos = currentPlayer.getPosition();

        if (currPos == Board.jailIndex) {   //if player came to the jail square it won't move, it will try to get out of jail
            Square sqr = squares.get(currPos);
            printCurrentSituation(currentPlayer); //print situation of player when it came to the Jail

                System.out.println(currentPlayer.getPrintArr(0));
                currPos = currentPlayer.getPosition();
                currentSquare = squares.get(currPos).getClass();
                action = currentSquare.getMethod("action", Player.class, int.class, int.class); //Get method for jail square
                printAfterRollDiceSituation(currentPlayer); //Print situation of player after it rolled dices

                playerFailed = (boolean) action.invoke(sqr, currentPlayer, diceNum, currPos); //invoke jail square's action method
                if(currentPlayer.getJustLeftFromJail()){ //If player just left from the jail square it will invoke the action method of destination square
                    Square currSq = squares.get(currentPlayer.getPosition());
                    Class sqrClass = currSq.getClass();
                    Method leavingActionFromJail = sqrClass.getMethod("action", Player.class, int.class, int.class);
                    playerFailed  = (boolean) leavingActionFromJail.invoke(currSq,currentPlayer, diceNum, currPos); //invoke current position action
                    printAfterRollDiceSituation(currentPlayer); //Print situation of player after it left from jail
                    currentPlayer.setJustLeftFromJail(false);
                }

        } else {    //If player did not come to the Jail Square set its position according to the rolled dice
            int previousPos = currentPlayer.getPosition();
            printCurrentSituation(currentPlayer);

            currentPlayer.setPosition((previousPos + diceNum) % 40);//set current player's position according to face number

            currPos = currentPlayer.getPosition();

            if(currPos == Board.jailIndex)  //If player came to the jail square set its situation as justCameJail
                currentPlayer.setJustCameJail(true);

            Square sqr = squares.get(currPos);
            currentSquare = sqr.getClass();

            action = currentSquare.getMethod("action", Player.class, int.class, int.class);

            if ((previousPos - currPos > 0) && bankAmount - goPrice >= 0  ) {  //control condition for came to Go square after roll or passed Go square
                currentPlayer.setMoney(goPrice);//give current player to the go price
                bankAmount -= goPrice; //reduce bank amount
                if(currPos != 0)
                    System.out.println("Player just passed from Go Square.");
            }

            if(sqr.getTypeName() == "Go To Jail Square"){   //If player came to the Go To Jail Square sent player to the Jail Square
                printAfterRollDiceSituation(currentPlayer);
                playerFailed = (boolean) action.invoke(sqr, currentPlayer, diceNum, currPos); //invoke current position action
                System.out.println(currentPlayer.getName() + " went to Jail Square from Go to Jail Square.");
            }
            else{//If player did not come to the Go To Jail Square invoke current square's action method
                playerFailed = (boolean) action.invoke(sqr, currentPlayer, diceNum, currPos); //invoke current position action
                printAfterRollDiceSituation(currentPlayer);
            }
        }
        return playerFailed;
    }

    public ArrayList<Player> determineOrder() {//Determine order of game according to the player's rolled dice

        ArrayList<Player> order = new ArrayList<>();    //array list for holding order of players
        int size = players.size();
        int[] rowPlayers = new int[size];   //order of players

        for (int i = 0; i < size; i++) {    //first roll dices for determine order
            rowPlayers[i] = Dice.rollDices(diceOne, diceTwo);
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {//determine order of players
            for (int j = 0; j < size; j++) {
                if (rowPlayers[j] >= max) {
                    max = rowPlayers[j];
                    maxIndex = j;
                }

            }
            order.add(players.get(maxIndex));
            rowPlayers[maxIndex] = 0;
            max = 0;
        }
        return order;
    }

    public boolean gameOver(Player lastFailedPlayer) {
        //Game will over when bank amount is 0 or number of player on game is 1
        winner = players.get(0);    //Remained player is the winner one

        if (lastFailedPlayer == null)
            System.out.println("The remain amount of bank is " + bankAmount);
        else
            System.out.println("\nRemained player is " + winner.getName());

        System.out.println("\nGAME OVER");

        System.out.println("The winner is: " + winner.getName());

        this.gameOver = true;

        return true;
    }

    public boolean controlGameOver(Player failedPlayer) {//If remained only one player game will be over

        if (players.size() == 1) {
            return gameOver(failedPlayer);
        }
        return false;
    }

    public void printCurrentSituation(Player currentPlayer) {   //this method will be called after each player played

        System.out.println("\nCurrent player is " + currentPlayer.getName());
        System.out.println("Money amount of current user: " + currentPlayer.getMoney());

        System.out.println("Count Cycle: " + countCycle);

        System.out.println("Turn Cycle of "+ currentPlayer.getName() + ": " + currentPlayer.getTurnCycle());
        System.out.println("User is currently in Square " + currentPlayer.getPosition()+ ", " + squares.get(currentPlayer.getPosition()).getName() +
                ", "+  squares.get(currentPlayer.getPosition()).getTypeName());

        Dice.printDices(diceOne, diceTwo);

    }

    public void printAfterRollDiceSituation(Player currentPlayer) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Print situation of game after dice rolled
        String sqrName = squares.get(currentPlayer.getPosition()).getTypeName();
        System.out.println("Current position " + (currentPlayer.getPosition() ) + " and it is " + squares.get(currentPlayer.getPosition()).getName() + ", " + sqrName);

        if(squares.get(currentPlayer.getPosition()).getOwner() == null)
            System.out.println("Owner : None");
        else
            System.out.println("Owner: " + squares.get(currentPlayer.getPosition()).getOwner().getName());

        if(sqrName == "Property Square" || sqrName == "Station Square" || sqrName == "Utilities Square"){
            Square currPos = squares.get(currentPlayer.getPosition());
            Class sqrClass = currPos.getClass();
            Method getRentPrice = sqrClass.getMethod("getRentPrice");
            int returnRentPrice = (int) getRentPrice.invoke(currPos); //invoke current position action
            System.out.println("The amount of rent: " + returnRentPrice);
        }

        System.out.println("Money amount of current user: " + currentPlayer.getMoney());

        if (!currentPlayer.getOnGame()) {
            System.out.println("The player is failed.");
        }
    }

    public void printCycleSituation() { //Print situation of cycles after each cycle

        System.out.println("\nNew Cycle Balance");
        System.out.println(GameCreation.bank.getBankAmount());
        int size = players.size();
        int[] moneyArr = new int[size];
        int[] moneyRow = new int[size];

        for (int j = 0; j < size; j++) {
            moneyArr[j] = players.get(j).getMoney();
        }

        //To print current situations of players according to money amounts after each cycle
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (moneyArr[j] >= max) {
                    max = moneyArr[j];
                    maxIndex = j;
                }
            }
            moneyRow[i] = maxIndex;
            moneyArr[maxIndex] = 0;
            max = 0;

        }

        for (int k = 0; k < size; k++) {
            Player currPlayer = players.get(k);
            int totalValue = 0;
            for(int j=0; j<currPlayer.getOwnedPlaces().size(); j++){

                Square sq= currPlayer.getOwnedPlaces().get(j);
                totalValue += sq.getPrice();
            }

            System.out.println(k + 1 + ". player is " + currPlayer.getName() + " with " + currPlayer.getMoney() + " $." +
                     " Location is " + currPlayer.getPosition() + " ,number of owned places "+ currPlayer.getOwnedPlaces().size() +
                    ", value of owned places "+ totalValue + ", number of house " + currPlayer.getNumberOfHouse() + ", number of hotel " + currPlayer.getNumberOfHotel());
        }
    }
}
