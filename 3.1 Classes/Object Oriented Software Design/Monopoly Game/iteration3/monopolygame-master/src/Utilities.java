import java.util.ArrayList;

public class Utilities implements Square {

    private int price = 0;
    private int pos;
    private int rentPrice = 0;
    private String name;
    private Player owner= null;
    private int numberOfUtilitySquares;
    private String typeName = "Utilities Square";


    private String[] utilityName_arr = {"Electric Community", "Water Works"};
    ArrayList<Player> owners = new ArrayList<Player>();

    public Utilities(int nameId, int pos, int price, int numberOfUtilitySquares) {
        this.name = utilityName_arr[nameId%(utilityName_arr.length+1)];
        this.pos = pos;
        this.price = price;
        this.numberOfUtilitySquares= numberOfUtilitySquares;
    }

    public Utilities() {

    }


    @Override
    public int getPosition() {
        return this.pos;
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTypeName() {
        return this.typeName;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getIndex(String name) {
        for (int i = 0; i < 40; i++){
            if(GameCreation.squares.get(i).getName().equals(name))
                return i;
        }
        return 0;
    }

    public void setRentPrice(int rentPrice){
        this.rentPrice = rentPrice;
    }

    public int getRentPrice(){
        return this.rentPrice;
    }

    public boolean action(Player player, int dice, int index) {//player will decide to whether to buy utility
    	int rent=0;
    	 if(owner!= null) {		//if utility has owner set the rent amount according to number of player
    			if(player != this.owner) {
    	    		int commonOwnerNumber= controlOwners();
    	    		if(commonOwnerNumber== 1) {
    	    		    rent = dice*4;
    	    		    setRentPrice(rent);
    	    		}
    	    		else {
    	    		    rent = dice*10;
    	    		    setRentPrice(rent);
    	    		}
    	    		player.setMoney(getRentPrice() * (-1));
    	    		if (player.getMoney() >=0)
    	    		    this.owner.setMoney(getRentPrice());
    	    		else
    	    		    return true;
                }
    	 }
    	 else {		//player will buy utility if its money is enough
    		 if(player.getMoney()-price >=0  &&  dice >=8 ) {  //can player buy
    			 setOwner(player); 
    			 owners.add(player);
    			 player.setMoney(price*(-1));
                 player.setOwnedPlaces(this);
             }
    	 }
    	 return false;
    }
    
    public int controlOwners() {	//check the number of player that have this utility
    	int common=0;
    	for(int i=0; i < owners.size(); i++) {
    		if(owner == owners.get(i))
    			common++;
    	}
    	return common;
    }
    
}
