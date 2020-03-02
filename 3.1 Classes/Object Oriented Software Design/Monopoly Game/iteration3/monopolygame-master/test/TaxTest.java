import junit.framework.TestCase;
import org.junit.Assert;

public class TaxTest extends TestCase {
    Tax tax = new Tax();

    public void testGetPrice() {
        Assert.assertTrue(tax.getPrice() == 0);
    }

    public void testGetOwner() {
        Assert.assertTrue(tax.getOwner() == null);
    }
}