package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorceressTest {


    @Test
    void useRoll() {
        Sorceress s = new Sorceress();
        assertEquals(s.getRoll(), 1);
        s.useRoll();
        assertEquals(s.getRoll(), 0);
    }

}
