import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Working_Main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		GameCreation game = new GameCreation(); //Create the game element
        game.play(); //Play the game
	}

}
