import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractPlayer {

    ArrayList<Player> players = new ArrayList<>();

    String[] inputs;
    String[] playerNames;   //Array for player names

    public String[] takeInputs() throws IOException {   //Function for reading input file
        inputs = new String[17];

        File file = new File("inputs.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String string;  //each line from input
        int i = 0;
        while ((string = br.readLine()) != null) {
            String[] tokens = string.split(":");
            inputs[i] = tokens[1];
            i++;
        }
        return inputs;
    }

    public AbstractPlayer() throws IOException {
        inputs = takeInputs();

        int numberOfPlayer = Integer.parseInt(inputs[0]); //number of players that given by user
        String[] names = inputs[1].substring(1, inputs[1].length() - 1).split(","); //names of players that given by user

        playerNames = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            playerNames[i] = names[i];
        }

        for (int i = 0; i < numberOfPlayer; i++) {
            String player = playerNames[i];
            players.add(new Player(player)); //add player to the array list of players
        }
    }

    public ArrayList<Player> getPlayersAbstract(){
        return players;
    }
}
