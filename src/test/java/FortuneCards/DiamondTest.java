package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamondTest {

    @Test
    void testToString() {
        Diamond d = new Diamond();
        assertEquals(d.toString(), "DIAMOND");
    }

}
