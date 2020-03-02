import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameCreationTest {

    String[] inputs = new String[5];;
    @Test
    public void takeInputs() throws IOException {

        File file = new File("inputs.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 0;
        while ((st = br.readLine()) != null) {
            String[] tokens = st.split(":");
            inputs[i] = tokens[1];
            i++;
        }
        int numberOfPlayer= Integer.parseInt(inputs[0]);
        String [] playerNames = new String[numberOfPlayer];

        int playerNamesNumbers = Integer.parseInt(String.valueOf(playerNames.length));
        Assert.assertTrue(numberOfPlayer==playerNamesNumbers);
    }

    private ArrayList<Player> players = new ArrayList<Player>();

    public void build() throws IOException {
        players.clear();
        Board.createBoard(inputs); //Create game board
    }

    

}