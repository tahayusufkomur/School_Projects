import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest extends TestCase {

    Dice diceOne = new Dice(0);
    Dice diceTwo = new Dice(0);

    @Test
    public void rollDices() {
        Dice dice = new Dice(0);

        for(int i = 0; i < 100; i++){
            Assert.assertTrue(2<=dice.rollDices(diceOne, diceTwo) || 12>=dice.rollDices(diceOne, diceTwo));
        }
    }


}