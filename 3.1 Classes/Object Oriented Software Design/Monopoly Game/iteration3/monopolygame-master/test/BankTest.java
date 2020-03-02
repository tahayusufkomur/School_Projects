import junit.framework.TestCase;
import org.junit.Assert;

public class BankTest extends TestCase {

    Bank bank = new Bank();

    public void testGetBankAmount() {
        Assert.assertTrue(bank.getBankAmount() >= 1000);
    }
}