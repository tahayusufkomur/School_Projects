public class FreeParking implements Square {

    private int pos;
    private String name;
    private String typeName = "Free Parking Square";

    public FreeParking(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    @Override
    public int getPosition() {
        return pos;
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
        return typeName;
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

    @Override
	public boolean action(Player player, int dice, int index) { //Player will do nothing when it came to the Free Parking
        return false;
	}
    
}
