
public class Tax implements Square {

    private int price;
    private int pos;
    private String name;
    private Player player;
    private String typeName = "Tax Square";

    private String[] taxName_arr = {"Income Tax", "Super Tax"};

    public Tax(int nameId, int price, int pos) {
        this.name = taxName_arr[nameId%(taxName_arr.length+1)];
        this.price = price;
        this.pos = pos;
    }

    public Tax() {

    }

    public int getPrice(){
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
    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public void setOwner(Player player) {
        this.player = player;
    }

    @Override
    public Player getOwner() {
        return player;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    public boolean action(Player player, int dice, int index) {//When player came to the tax square it will pay tax amount to the bank
        if(player.getMoney() - price >= 0)
            player.setMoney(this.price* (-1));//decrement amount of player's money
        else
            return true;

    	GameCreation.bank.setBankAmount(price);//increment amount of bank
    	return false;
    }
    
    
}