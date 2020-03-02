import junit.framework.TestCase;
import org.junit.Assert;

public class GoToJailTest extends TestCase {

    GoToJail goToJail = new GoToJail();

    public void testGetOwner() {
        Assert.assertTrue(goToJail.getOwner() == null);
    }

    public void testGetPrice() {
        Assert.assertTrue(goToJail.getPrice() == 0);
    }
}