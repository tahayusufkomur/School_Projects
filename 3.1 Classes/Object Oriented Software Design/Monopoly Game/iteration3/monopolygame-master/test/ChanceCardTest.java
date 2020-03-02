import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

public class ChanceCardTest extends TestCase {

    ChanceCard chanceCard;

    {
        try {
            chanceCard = new ChanceCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetOwner() {
        Assert.assertTrue(chanceCard.getOwner() == null);
    }
}