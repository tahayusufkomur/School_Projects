import java.util.ArrayList;

public class Player {

    private String name;
    private int position;
    private int money;
    ArrayList<Square> ownedPlaces;
    private int numberOfRolledDiceWhenPlayerInJail;
    private int numberOfEvenDices;
    private int turnCycle= 1;
    private boolean onGame = true;
    private String [] printArr = new String[2];
    private boolean justCameJail = false;
    private boolean justLeftFromJail = false;
    private int numberOfHouse = 0;
    private int numberOfHotel = 0;

    public Player(String name){
        this.name = name;
        this.money = 200;
        this.position = 0;
        this.ownedPlaces = new ArrayList<Square>();
        printArr[0]= "";
        printArr[1]= "";
    }

    public String getName() {
        return name;
    }

    public String getPrintArr(int i){
        return printArr[i];
    }

    public int getMoney(){
        return this.money;
    }
    /**
     * Used to update Player's money
     * @param money current amount of money
     */

    public void setMoney(int money){
        this.money += money;
    }

    /**
     * Used to update Player's position
     */
    public int getPosition(){
        return this.position;
    }

    public void setPosition(int dice){
        this.position=dice;
    }

    public boolean getJustCameJail(){
        return this.justCameJail;
    }

    public void setJustCameJail(boolean TF){
        this.justCameJail= TF;
    }

    public boolean getJustLeftFromJail(){
        return this.justLeftFromJail;
    }

    public void setJustLeftFromJail(boolean TF){

        this.justLeftFromJail = TF;
    }

    /**
     * Used to update Player's owned places
     */
    public void setOwnedPlaces(Square ownedPlace){
        ownedPlaces.add(ownedPlace);
    }

    public ArrayList<Square> getOwnedPlaces(){
        return this.ownedPlaces;
    }

    public int incrementNumberOfRolledDiceWhenPlayerInJail(){//increment number of this variable when player roll dice
        //while it is in jail.
        return numberOfRolledDiceWhenPlayerInJail++;
    }

    public void setNumberOfRolledDiceZeroWhenPlayerGetOutOfJail(){
        numberOfRolledDiceWhenPlayerInJail = 0;
    }

    public int getNumberOfRolledDiceWhenPlayerInJail(){
        return numberOfRolledDiceWhenPlayerInJail;
    }

    public int getNumberOfEvenDices(){
        return numberOfEvenDices;
    }

    public void setNumberOfEvenDices(int num){
        if(num == 0){
            numberOfEvenDices = 0;
        }
        else{
            numberOfEvenDices++;
        }
    }

    public int getTurnCycle(){
        return this.turnCycle;
    }

    public void setTurnCycle(){
        this.turnCycle++;
    }

    public boolean getOnGame(){
        return this.onGame;
    }

    public void setFalseOnGame(){
        onGame = false;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int num) {
        this.numberOfHouse += num;
    }

    public int getNumberOfHotel() {
        return numberOfHotel;
    }

    public void setNumberOfHotel(int num) {
        this.numberOfHotel += num;
    }
}
