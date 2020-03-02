import junit.framework.TestCase;
import org.junit.Assert;

public class BoardTest extends TestCase {

    String[] inputs ;
    Board board = new Board(0, null);

    public void testGetSquares() {
        Assert.assertTrue(board.getSquares().size() == 40);
    }
}