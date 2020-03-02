import junit.framework.TestCase;
import org.junit.Assert;

public class JailTest extends TestCase {

    Jail jail = new Jail("", 0);

    public void testGetOwner() {
        Assert.assertTrue(jail.getOwner() == null);
    }

    public void testGetPrice() {
        Assert.assertTrue(jail.getPrice() == -1);
    }
}