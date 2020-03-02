public class Go implements Square {

    private int goPrice;
    private int pos;
    private String name;
    private String typeName = "Go Square";

    public Go(String name, int price, int pos){
        this.name= name;
        this.goPrice = price;
        this.pos = pos;
    }

    public Go() {

    }

    public int getPrice() {
        return goPrice;
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
        this.goPrice = price;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getSquareName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public void setOwner(Player player) { }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public boolean action(Player player, int dice, int index) {//if player pass through go square give it go price

    	player.setMoney(goPrice);//increment money of player
    	GameCreation.bank.setBankAmount(goPrice*(-1));//decrement bank amount

        return false;
    }
}
