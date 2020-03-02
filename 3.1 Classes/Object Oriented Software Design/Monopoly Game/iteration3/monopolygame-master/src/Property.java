import java.util.Collections;

public class Property implements Square {

    private int purchasePrice = 0;
    private int rentPrice = 0;
    private int pos;
    private String name;
    private Player owner;
    private int groupId;
    private int numberOfPropertySquares;
    private String typeName = "Property Square";
    private int indexOfPropertyarr = 0;
    private int housePrice=0;
    private int hotelPrice=0;


    int []numberofHouse ;
    int []numberofHotel;
    //  Integer[] numberofHotel = Collections.nCopies(numberOfPropertySquares, 0).toArray(new Integer[0]);


    Player[][] owners = new Player[8][5];  //row number represents group id

    static String[] name_Arr= { "Kasımpaşa", "Dolapdere", "Sultanahmet", "Karaköy" , "Sirkeci", "Beyoğlu" , "Beşiktaş", "Taksim", "Harbiye", "Şişli", "Mecidiyeköy", "Bostancı" , "Erenköy", "Caddebostan" , "Nişantaşı",  "Teşvikiye",  "Maçka" , "Levent", "Etiler", "Bebek" , "Tarabya", "Yeniköy"};
    private Integer[] groupId_arr= {-1,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7 };

    public Property(int pos, int purchasePrice, int rentPrice, int numberOfPropertySquares, int i) {

        this.name = name_Arr[i%(name_Arr.length+1)];
        this.pos = pos;
        this.purchasePrice = purchasePrice;
        this.rentPrice = rentPrice;
        this.groupId = groupId_arr[i%(groupId_arr.length+1) +1];
        this.numberOfPropertySquares= numberOfPropertySquares;
        this.indexOfPropertyarr = i;
        this.housePrice = this.rentPrice*8;
        this.hotelPrice = this.rentPrice*8;

        numberofHouse = new int [numberOfPropertySquares];
        numberofHotel = new int [numberOfPropertySquares];

    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getRentPrice() {
        return this.rentPrice;
    }

    public void setRentPrice(int rentPrice) {
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

    public boolean action(Player player, int dice, int index) {//player will decide to whether to buy property or don't

        if(owner!= null) {//if property has owner player will pay the rent amount
            if(player != this.owner) {
                if ((player.getMoney()- this.rentPrice) >=0){
                    player.setMoney(this.rentPrice * (-1));//decrement money of player who came to the square
                    this.owner.setMoney(this.rentPrice);//increment money of player who has property
                }
                else{
                    return true;
                }
            }
            else {//sahibi player //ev kurmaya başlıyorum

                int [] returnArr = controlOwners();
                int common = returnArr[0];
                int numberOfSquareHasSameId = returnArr[2];

                int loc= this.groupId*3;


                if(common == numberOfSquareHasSameId) { // aynÄ± id'e sahip olan bÃ¼tÃ¼n yerler playerÄ±n

                    for (int i =loc; i < loc+common; i++) {
                        if(i != this.indexOfPropertyarr ){ // control ettiÄŸim square ben deÄŸilsem //ev sayÄ±sÄ± kontrolÃ¼
                            if(numberofHouse[i] >= numberofHouse[this.indexOfPropertyarr]) {		//ilgili karelerin ev sayÄ±sÄ± benimkine bÃ¼yÃ¼k eÅŸit mi?

                                if(numberofHouse[this.indexOfPropertyarr] == 4) {		//otel kur

                                    numberofHotel[this.indexOfPropertyarr]++;
                                    player.setNumberOfHotel(1);
                                    player.setNumberOfHouse(-4);
                                    numberofHouse[this.indexOfPropertyarr] = 0;
                                    this.rentPrice *= 1.2;

                                    player.setMoney(this.hotelPrice * (-1));
                                    GameCreation.bank.setBankAmount(this.hotelPrice);

                                }
                                else {		//ev kur
                                    if(this.numberofHotel[this.indexOfPropertyarr] == 1 )
                                        break;

                                    numberofHouse[this.indexOfPropertyarr]++;
                                    player.setNumberOfHouse(1);
                                    this.rentPrice *= 2.5;

                                    player.setMoney(this.housePrice * (-1));
                                    GameCreation.bank.setBankAmount(this.housePrice);
                                }
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        }
        else { //player will buy property if its money is enough and rolled dice greater than 8
            boolean noAnotherOwner = true;
            int [] returnArr = controlOwners();
            int numberOfSquareHasSameId = returnArr[2];

            Player[] groupOwners = owners[this.groupId];

            //aynÄ± idye sahip diÄŸer squareler baÅŸkasÄ±na aitse orayÄ± almasÄ±n
            for (int i = 0; i <numberOfSquareHasSameId; i++) {

                if( groupOwners[i] != null && groupOwners[i] != player ) {
                    noAnotherOwner=false;
                    break;
                }
            }

            boolean x =noAnotherOwner && player.getMoney()-purchasePrice >=0  &&  dice >=8 ;
            if( noAnotherOwner && player.getMoney()-purchasePrice >=0  &&  dice >=8 ) {  //can player buy

                setOwner(player);
                owners[this.groupId][returnArr[1]]= player;

                player.setOwnedPlaces(this);
                player.setMoney(purchasePrice*(-1));
                GameCreation.bank.setBankAmount(purchasePrice);
                System.out.println("Player bought " + this.name + " Square" );

                if(returnArr[0] == returnArr[2]) { //all squares which has same id owned by player
                    this.rentPrice*=2;
                }
            }
        }
        return false;
    }

    public int [] controlOwners() {//check the number of player which has the property that has the same groupId

        int common=0;		//common is a number of bought properties which have same group id by relational square's owner.
        //oyuncunun ÅŸuan geldiÄŸi karenin sahibininin, gelinen kareyle eaynÄ± idlere sahip olan kareler arasÄ±ndan
        //kaÃ§ tanesine sahip olduÄŸunun sayÄ±sÄ±

        int loc;
        if(this.groupId == 0)
            loc = 1;
        else
            loc= this.groupId*3;


        int numberOfOwner_currentGroup = 0;		//numberOfOwner_currentGroup is a number of owners of squares which have the same group id with relational square.
        int numberofsquarehassameid = 0;
        while(loc+1 < groupId_arr.length && groupId_arr[loc] == groupId_arr[loc+1]) {
            common=0;
            numberOfOwner_currentGroup = 0;
            Player[] groupOwners = owners[groupId];
            for(int i=0; i<5; i++) {
                if(groupOwners[i] == null)
                    break;
                numberOfOwner_currentGroup++;
            }

            for(int i=0; i < numberOfOwner_currentGroup; i++) {
                if(owner == groupOwners[i])
                    common++;
            }
            loc++;
            numberofsquarehassameid++;
        }
        int [] returnarr = {common, numberOfOwner_currentGroup,numberofsquarehassameid+1};
        return returnarr;
    }

}
