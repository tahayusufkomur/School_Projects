import junit.framework.TestCase;
import org.junit.Assert;

public class GoTest extends TestCase {

    Go go = new Go();

    public void testGetPrice() {
        Assert.assertTrue(go.getPrice() == 0);
    }

    public void testGetOwner() {
        Assert.assertTrue(go.getOwner() == null);
    }
}