package FortuneCards;

import Dice.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreasureChestTest {

    @Test
    void getHand() {
        TreasureChest tc = new TreasureChest();
        assertEquals(tc.getHand().getClass(), Hand.class);
    }
    @Override
    public String toString() {
        return "TREASURE CHEST";
    }

}
