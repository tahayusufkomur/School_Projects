import java.io.IOException;
import java.util.ArrayList;

public class CommunityChestCard extends AbstractPlayer implements Square, Card{

    private String name = "Community Chest Card Square";
    private String typeName = "Card";
    private int currentCardIndex = 0;
    private int pos;
    public static Player getOutOfJailCardIsAvailable = null;

    public CommunityChestCard(int pos) throws IOException {
        super();
        this.pos= pos;
    }

    public CommunityChestCard() throws IOException {
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
        System.out.println(player.getName() + " came to the Community Chance Card Square and drawed card:");
        switch(currentCardIndex){
            case 0: payCardAction("Bank error in your favor - collect $200", 200, player); currentCardIndex++; break;
            case 1: payCardAction("Doctor's fee - pay $50", -50, player); currentCardIndex++; break;
            case 2: payCardAction("Income Tax Refund - collect $20",20, player); currentCardIndex++; break;
            case 3: payCardAction("Life Insurance matures - collect $100", 100, player); currentCardIndex++; break;
            case 4: payCardAction("Pay Hospital fees - pay $100", -100, player); currentCardIndex++; break;
            case 5: payCardAction("Pay School tax - pay $150", -150, player); currentCardIndex++; break;
            case 6: payCardAction("Receive for 'Services' ;) - collect $25", 25, player); currentCardIndex++; break;
            case 7: payCardAction("You win 2nd place in a fat contest - collect $10", 10, player); currentCardIndex++; break;
            case 8: payCardAction("Your parents die, you inherit $100", 100, player); currentCardIndex++; break;
            case 9: payCardAction("From sale of stock you earn 45$", 45, player); currentCardIndex++; break;
            case 10: payCardAction("Xmas fund matures - collect 100$", 100, player); currentCardIndex++; break;
            case 11: payPerBuildingCardAction ("You are assessed for street repairs – $40 per house, $115 per hotel", 45,115, player); currentCardIndex++; break;
            case 12: payPerPlayerCardAction("Grand Opera Night - pay 50$ to each player", 50, player); currentCardIndex++; break;
            case 13: getOutOfJailCardAction("Get out of jail free – this card may be kept until needed, or sold", player); currentCardIndex++; break;
            case 14: goToJailCardAction("Go to jail – go directly to jail – Do not pass Go, do not collect $200 ", player); currentCardIndex++; break;
            case 15: goToCardAction("Advance to Go, Collect 200$", "", player); currentCardIndex = 0; break;
            default: return false;
        }
        return false;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getIndex(String name) {
        for (int i = 0; i < 40; i++){
            if(GameCreation.squares.get(i).getName().equals(name))
                return i;
        }
        return 0;
    }

    public void payCardAction(String text, int amount, Player player){
        System.out.println(text);
        player.setMoney(amount); //increment or decrement current player's amount of money
    }

    public void payPerPlayerCardAction(String text, int amount, Player player){
        System.out.println(text);

        ArrayList<Player> tempPlayers = getPlayersAbstract();
        for (int i = 0; i < tempPlayers.size(); i++){
            tempPlayers.get(i).setMoney(amount);    //increment amount of per player's money
        }

        player.setMoney(-(amount*tempPlayers.size())); //decrement amount of current player's money
    }

    public void getOutOfJailCardAction(String text, Player player){
        if(this.getOutOfJailCardIsAvailable == null) {//if card is available
            System.out.println(text);
            this.getOutOfJailCardIsAvailable = player;  //player will keep this card
        }
        else{ //if card is not available player will get and play next card(go to jail card) action
            goToJailCardAction("Go to jail – go directly to jail – Do not pass Go, do not collect $200 ", player);
        }
    }

    public void goToJailCardAction(String text, Player player){
        System.out.println(text);
        player.setPosition(Board.jailIndex);
    }

    public void goToCardAction(String text, String propertyName, Player player){
        System.out.println(text);
        player.setPosition(0);
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
}
