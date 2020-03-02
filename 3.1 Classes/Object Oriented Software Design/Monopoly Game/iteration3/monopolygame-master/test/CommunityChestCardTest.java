import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

public class CommunityChestCardTest extends TestCase {

    CommunityChestCard communityChestCard;

    {
        try {
            communityChestCard = new CommunityChestCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetOwner() {
        Assert.assertTrue(communityChestCard.getOwner() == null);
    }
}