import java.io.IOException;
import java.util.ArrayList;

public class Board {

    private static ArrayList<Square> squares = new ArrayList<Square>();
    private int boardSize;
    public static int goPrice;
    private static String[] inputs ;
    static Square[] squaresBackup= new Square[40];
    public static int jailIndex;
    private static ArrayList<Integer> positions = new ArrayList<>();
    private static boolean[] currentPositions = new boolean[40];

    public Board(int boardSize, String[] inputs){
        this.boardSize = boardSize;
        this.inputs = inputs;
    }

    public static ArrayList<Integer> generatePositions(){  //Generate 40 number of position index for place squares
        for(int i = 0; i <= 40; i++){
            positions.add(i);
        }
        return positions;
    }

    public static ArrayList<Square> getSquares(){

        for(int i=0; i<40; i++){
            squares.add(squaresBackup[i]);
        }

        return squares;
    }

     public void getPrice() {}

    public static void createBoard(String inputs[]) throws IOException {   //Generate each type of square on board
        generatePositions();

        generateTaxSquare(squaresBackup, inputs);
        generateGoSquare(squaresBackup, inputs);
        generatePropertySquare(squaresBackup, inputs);
        generateStationSquare(squaresBackup, inputs);
        generateUtilitySquare(squaresBackup, inputs);
        generateJailSquare(squaresBackup, inputs);
        generateGoToJailSquare(squaresBackup, inputs);
        generateFreeParkingSquare(squaresBackup, inputs);
        generateChanceCardSquare(squaresBackup, inputs);
        generateCommunityCardSquare(squaresBackup, inputs);

    }

    private static void generateStationSquare(Square[] squaresBackup, String inputs[]) {
        //Generate Station Square according to the given inputs

        int numberOfStationSquares = Integer.parseInt(inputs[8]);//number of station squares that taken from user
        int purchasePrice = Integer.parseInt(inputs[9]);//amount of station that taken from user

        for (int i = 0; i < numberOfStationSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true) {
                if (pos < 40 && squaresBackup[pos] == null) {  //square object is generated with unique position number
                    Square stationSquare = new Station(i, pos, purchasePrice, numberOfStationSquares);
                    squaresBackup[pos] = stationSquare;
                    currentPositions[pos] = true;
                    break;
                } else {    //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generateGoSquare(Square[] squaress, String inputs[]) {
        //Generate Go Square according to the given inputs

        goPrice = Integer.parseInt(inputs[4]);//price of go square that taken from user
        Square goSquare = new Go("Go", goPrice, 0);
        squaress[0] =  goSquare;    //Place go square on first position
        currentPositions[0] = true;
    }

    private static void generateTaxSquare(Square[] squaress, String inputs[]) {
        //Generate Tax Square according to the given inputs

        int numberOfTaxSquares = Integer.parseInt(inputs[2]);//number of tax squares that taken from user
        int taxAmount = Integer.parseInt(inputs[3]);//amount of tax that taken from user

        for (int i = 0; i < numberOfTaxSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square taxSquare = new Tax(i, taxAmount, pos);
                    squaress[pos] =  taxSquare;
                    currentPositions[pos] = true;
                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generatePropertySquare(Square[] squaress, String inputs[]) {
        //Generate Property Square according to the given inputs

        int numberOfPropertySquares = Integer.parseInt(inputs[5]);//number of property squares that taken from user
        int purchasePrice = Integer.parseInt(inputs[6]);//amount of property that taken from user
        int rentPrice = Integer.parseInt(inputs[7]);//amount of property that taken from user

        for (int i = 0; i < numberOfPropertySquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square propertySquare = new Property(pos, purchasePrice,rentPrice, numberOfPropertySquares, i);
                    squaress[pos] =  propertySquare;
                    currentPositions[pos] = true;

                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generateUtilitySquare(Square[] squaresBackup, String inputs[]) {
        //Generate Utility Square according to the given inputs

        int numberOfUtilitySquares = Integer.parseInt(inputs[13]);//number of utility squares that taken from user
        int purchasePrice = Integer.parseInt(inputs[14]);//amount of utility that taken from user

        for (int i = 0; i < numberOfUtilitySquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square utilitySquare = new Utilities(i, pos, purchasePrice, numberOfUtilitySquares);
                    squaresBackup[pos] =  utilitySquare;
                    currentPositions[pos] = true;
                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generateJailSquare(Square[] squaresBackup, String inputs[]) {
        //Generate Jail Square according to the given inputs

        int numberOfJailSquares = Integer.parseInt(inputs[15]);//number of jail squares that taken from user
        int pos = 0;
        for (int i = 0; i < numberOfJailSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square jailSquare = new Jail("Jail", pos);
                    squaresBackup[pos] =  jailSquare;
                    currentPositions[pos] = true;
                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);

                }
            }
        }
        jailIndex = pos;
    }

    private static void generateGoToJailSquare(Square[] squaresBackup, String inputs[]) {
        //Generate Go To Jail Square according to the given inputs

        int numberOfGoToJailSquares = Integer.parseInt(inputs[16]);//number of jail squares that taken from user

        for (int i = 0; i < numberOfGoToJailSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square goToJailSquare = new GoToJail("Go To Jail", pos, jailIndex);
                    squaresBackup[pos] =  goToJailSquare;
                    currentPositions[pos] = true;
                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generateFreeParkingSquare(Square[] squaresBackup, String inputs[]) {
        //Generate Free Parking Square according to the given inputs

        int numberOfFreeParkingSquares = Integer.parseInt(inputs[16]);//number of free parking squares that taken from user

        for (int i = 0; i < numberOfFreeParkingSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            int pos = (int) (random * 40 + 1);
            while(true){
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    Square freeParkingSquare = new FreeParking("Free Parking", pos);
                    squaresBackup[pos] =  freeParkingSquare;
                    currentPositions[pos] = true;

                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }

            }
        }
    }

    private static void generateChanceCardSquare(Square[] squaresBackup, String inputs[]) throws IOException {
        //Generate Chance Card Square according to the given inputs

        int numberOfChanceCardSquares = Integer.parseInt(inputs[10]);//number of chance card squares that taken from user

        for (int i = 0; i < numberOfChanceCardSquares; i++) {  //generated random position number to locate squares into the board
            double random = Math.random();
            boolean generated = false;
            int pos = (int) (random * 40 + 1);
            while(true){
                Square chanceCardSquare = null;
                if(pos < 40 && squaresBackup[pos] == null ){  //square object is generated with unique position number
                    if(!generated ){
                        chanceCardSquare = new ChanceCard(pos);
                        generated  = true;
                    }
                    squaresBackup[pos] =  chanceCardSquare;
                    currentPositions[pos] = true;
                    break;
                }
                else{   //If generated random position is already taken from another square type generate new random number
                    random = Math.random();
                    pos = (int) (random * 40 + 2);
                }
            }
        }
    }

    private static void generateCommunityCardSquare(Square[] squaresBackup, String inputs[]) throws IOException {
        //Generate Chance Card Square according to the given inputs

        positions = remainPositions();  //Remained index positions for place last type of square
        int numberOfCommunityCardSquares = Integer.parseInt(inputs[11]);//number of community card squares that taken from user
        Square communityCardSquare = null;
        boolean generated = false;
            for(int j=0; j< numberOfCommunityCardSquares ; j++){
                if(!generated ){
                    communityCardSquare = new CommunityChestCard(positions.get(j));
                    generated  = true;
                }
                squaresBackup[positions.get(j)] =  communityCardSquare;
            }
    }

    public static ArrayList<Integer> remainPositions() {    //Hold remained positions after generate each type of square except last one
        ArrayList<Integer> tempPositions = new ArrayList<Integer>();

        for (int i = 0; i < 40; i++) {
            if (currentPositions[i]==false) {
            tempPositions.add(i);
            }
        }
        return  tempPositions;
    }
}

