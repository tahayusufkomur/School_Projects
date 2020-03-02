import java.util.ArrayList;

public class Station implements Square {

    private int purchasePrice = 0;
    private int rentPrice = 25;
    private int pos;
    private String name;
    private Player owner;
    private int numberOfStationSquares;
    private String typeName = "Station Square";


    static ArrayList<Player> owners = new ArrayList<Player>();

    public static String[] stationName_Arr = { "Haydarpaşa Train Station" , "Kadıköy Gangboard", "Kabataş Gangboard", "Sirkeci Train Station"};

    public Station(int nameId, int pos, int purchasePrice, int numberOfStationSquares) {
        this.name = stationName_Arr[nameId%(stationName_Arr.length+1)];
        this.pos = pos;
        this.purchasePrice = purchasePrice;
        this.numberOfStationSquares= numberOfStationSquares;
    }

    public Station() {

    }


    public int getRentPrice() {
        return this.rentPrice;
    }

    public void setRentPrice(int rentPrice){
        this.rentPrice = rentPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int pos) {
        this.pos = pos;
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
        return this.owner;
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
    public int getPrice() {
        return this.purchasePrice;
    }

    @Override
    public int getIndex(String name) {
        for (int i = 0; i < 40; i++){
            if(GameCreation.squares.get(i).getName().equals(name))
                return i;
        }
        return 0;
    }

    public boolean action(Player player, int dice, int index) {//player will decide to whether to buy utility

    	 if(owner!= null) {//if station has owner set the rent amount according to number of player
    			if(player != this.owner) {
    	    		int commonOwnerNumber = controlOwners();
    	    		if(commonOwnerNumber == 1)
    	    		    setRentPrice(this.rentPrice);
    	    		else if(commonOwnerNumber == 2)
    	    		    setRentPrice(50);
    	    		else if(commonOwnerNumber == 3)
    	    		    setRentPrice(100);
    	    		else
    	    		    setRentPrice(200);
    	    			
    	    		player.setMoney(getRentPrice() * (-1));

                    if (player.getMoney() >=0)
	    				this.owner.setMoney(getRentPrice());
                    else
                        return true;
    			}
    	 }

    	 else { //player will buy station if its money is enough
    		 if((player.getMoney()-purchasePrice) >=0  &&  dice >=8 ) {  //can player buy
                 player.setOwnedPlaces(this);
    			 setOwner(player); 
    			 owners.add(player);
    			 player.setMoney(purchasePrice*(-1));
                 GameCreation.bank.setBankAmount(purchasePrice);
    		 }
    	 }
    	 return false;
    }
    
    public int controlOwners() {//check the number of player that have this station
    	int common=0;
    	for(int i=0; i < this.owners.size(); i++) {
    		if(this.owner == this.owners.get(i))
    			common++;
    	}
    	return common;
    }
    
}