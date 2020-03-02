import java.lang.reflect.InvocationTargetException;

public class Jail implements Square {

    private int pos;
    private String name;
    private String typeName = "Jail Square";

    public Jail(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public void setOwner(Player player) {    }

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
        return typeName;
    }

    @Override
    public int getPrice() {
        return -1;
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
    public boolean action(Player player, int dice, int index) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        /**if the player has the exit from the jail card, the player continues playing
         * by placing the card at the bottom of the community chest cards.
         */

        //If player has get out of jail card from Community Chest cards and did not just come to the jail it can use this card
        if(CommunityChestCard.getOutOfJailCardIsAvailable == player && player.getJustCameJail() == false){
            player.setPosition((index + dice) % 40);    //Update player's location
            player.setJustLeftFromJail(true);
            System.out.println(player.getName() + " left from Jail with Get Out Of Jail Card.");
            CommunityChestCard.getOutOfJailCardIsAvailable = null;
            return false;
        }
        //If player has get out of jail card from Chance cards and did not just come to the jail it can use this card
        if(ChanceCard.getOutOfJailCardIsAvailableChance == player && player.getJustCameJail() == false){
            player.setPosition((index + dice) % 40);    //Update player's location
            player.setJustLeftFromJail(true);
            System.out.println(player.getName() + " left from Jail with Get Out Of Jail Card.");
            ChanceCard.getOutOfJailCardIsAvailableChance = null;
            return false;
        }

        if(!player.getJustCameJail())    {
            //If player came to the jail first try to roll even to get away
            if(player.getNumberOfRolledDiceWhenPlayerInJail() < 3 && Dice.getDicesAreEven(GameCreation.diceOne, GameCreation.diceTwo)){//If player rolled even, it can move.
                System.out.println(player.getName() + " rolled even.");
                player.setNumberOfRolledDiceZeroWhenPlayerGetOutOfJail();
                player.setPosition((index + dice) % 40);    //Update player's location
                System.out.println(player.getName() + " left from Jail.");
                player.setJustLeftFromJail(true);
                return false;
            }
            else{   //If player is already in jail
                player.incrementNumberOfRolledDiceWhenPlayerInJail();
                if(player.getNumberOfRolledDiceWhenPlayerInJail() == 3){//if player rolled dices 3 times and could not roll even
                                                                              //player will pay 50 to the bank and move
                    if((player.getMoney() - 50) > 0){   //control does player have enough money to pay amount
                        player.setMoney(50 * (-1));     //if player have enough money it can move
                        GameCreation.bank.setBankAmount(50);
                        player.setPosition((index + dice) % 40);    //Update player's location
                        player.setNumberOfRolledDiceZeroWhenPlayerGetOutOfJail();
                        System.out.println(player.getName() + " paid 50 to the bank and left from the Jail.\n");
                        player.setJustLeftFromJail(true);
                    }
                    else{   //if player doesn't have enough money to get away from Jail, it will fail.
                        return true;
                    }
                }
                else    //if player rolled dice and they did not face even player will stay in jail
                    System.out.println(player.getName() + " will stay in Jail.\n");
            }
        }
        player.setJustCameJail(false);
        return false;
    }
}
