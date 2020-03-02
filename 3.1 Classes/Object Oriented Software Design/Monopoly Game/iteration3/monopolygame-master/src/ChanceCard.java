import java.io.IOException;
import java.util.ArrayList;

public class ChanceCard extends AbstractPlayer implements Square, Card {
    private String name = "Chance Square";
    private String typeName = "Card";
    private int pos;
    private int currentCardIndex = 0;
    public static Player getOutOfJailCardIsAvailableChance = null;

    public ChanceCard( int pos) throws IOException {
        super();
        this.pos= pos;
    }

    public ChanceCard() throws IOException {
        super();
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public void setOwner(Player player) {

    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTypeName() {
        return this.typeName;
    }

    @Override
    public boolean action(Player player, int dice, int index) {
        System.out.println(player.getName() + " came to the Chance Card Square and drawed card:");
        switch(currentCardIndex) {
            case 0: getOutOfJailCardAction("Get out of jail free – this card may be kept until needed, or sold", player); currentCardIndex++; break;
            case 1: goToCardAction("Advance to Go, Collect 200$", "", player); currentCardIndex++; break;
            case 2: goToCardAction("Advance to Caddebostan", "Caddebostan", player); currentCardIndex++; break;
            case 3: goToCardAction("Advance to Beyoğlu","Beyoğlu", player); currentCardIndex++; break;
            case 4: payCardAction("Bank pays you dividend of $50 ", 50, player); currentCardIndex++; break;
            case 5: moveBackCardAction("Go back 3 spaces", 3, player); currentCardIndex++; break;
            case 6: goToJailCardAction("Go to jail – go directly to jail – Do not pass Go, do not collect $200", player); currentCardIndex++; break;
            case 7: payPerBuildingCardAction ("Make general repairs on all your property – $25 per house, $100 per hotel", 25, 100, player); currentCardIndex++; break;
            case 8: payCardAction("Pay poor tax of $15 ", -15, player); currentCardIndex++; break;
            case 9: goToStationCardAction("Take a ride on the Haydarpaşa Train Station","Haydarpaşa Train Station", player); currentCardIndex++; break;
            case 10: goToCardAction("Advance to Yeniköy", "Yeniköy", player); currentCardIndex++; break;
            case 11: payPerPlayerCardAction("You have been elected chairman of the board - pay 50$ to each player", 50, player); currentCardIndex++; break;
            case 12: payCardAction("Your building loan matures - collect $150", 150, player); currentCardIndex++; break;
            case 13: goToNearestUtilityAction("Advance token to nearest Utility", player); currentCardIndex++; break;
            case 14: goToNearestStationAction("Advance token to the nearest Station", player); currentCardIndex++; break;
            case 15: payCardAction("You have won a crossword competition. Collect $100", 100, player); currentCardIndex = 0; break;
            default: return false;
        }
        return false;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void payCardAction(String text, int amount, Player player) {
        System.out.println(text);
        player.setMoney(amount); //increment or decrement current player's amount of money
        GameCreation.bank.setBankAmount(-amount);
    }

    @Override
    public void payPerPlayerCardAction(String text, int amount, Player player) {
        System.out.println(text);

        ArrayList<Player> tempPlayers = getPlayersAbstract();
        for (int i = 0; i < tempPlayers.size(); i++){
            tempPlayers.get(i).setMoney(amount);    //increment amount of per player's money
        }

        player.setMoney(-(amount*tempPlayers.size())); //decrement amount of current player's money
    }

    public void getOutOfJailCardAction(String text, Player player){

        if(this.getOutOfJailCardIsAvailableChance == null){//if card is available
            System.out.println(text);
            this.getOutOfJailCardIsAvailableChance = player;  //player will keep this card
        }
        else{ //if card is not available player will get and play next card(go to jail card) action
            goToCardAction("Advance to Go, Collect 200$", "", player);
        }
    }

    public void goToJailCardAction(String text, Player player) {
        System.out.println(text);
        player.setPosition(Board.jailIndex);
    }

    public void goToCardAction(String text, String propertyName, Player player){
        System.out.println(text);
        player.setPosition(getIndex(propertyName));
    }

    public void goToStationCardAction(String text, String stationName, Player player){
        System.out.println(text);
        player.setPosition(getIndex(stationName));
    }

    @Override
    public int getIndex(String name) {
        for (int i = 0; i < 40; i++){
            if(GameCreation.squares.get(i).getName().equals(name))
                return i;
        }
        return 0;
    }

    @Override
    public void payPerBuildingCardAction(String text, int houseRepairAmount, int hotelRepairAmount, Player player) {
        for (int i = 0; i < player.getNumberOfHouse(); i++) {
            player.setMoney(-(houseRepairAmount));
            GameCreation.bank.setBankAmount(houseRepairAmount);
        }
        for (int i = 0; i < player.getNumberOfHotel(); i++) {
            player.setMoney(-(hotelRepairAmount));
            GameCreation.bank.setBankAmount(hotelRepairAmount);
        }
    }

    public void moveBackCardAction(String text, int step, Player player){
        System.out.println(text);
        player.setPosition(((player.getPosition() - step) % 40));
    }

    public void goToNearestUtilityAction(String text, Player player){

        System.out.println(text);

        Utilities utility = new Utilities();
        while(true){
            player.setPosition((player.getPosition() + 1) % 40);
            Square squareTypeName = GameCreation.squares.get(player.getPosition());
            if(squareTypeName.getTypeName() == utility.getTypeName()){
                break;
            }
        }
    }

    public void goToNearestStationAction(String text, Player player){
        System.out.println(text);

        Station station = new Station();
        while(true){
            player.setPosition((player.getPosition() + 1) % 40);
            Square squareTypeName = GameCreation.squares.get(player.getPosition());
            if(squareTypeName.getTypeName() == station.getTypeName()){
                break;
            }
        }
    }
}
