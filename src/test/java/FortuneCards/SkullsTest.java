package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkullsTest {

    @Test
    void getSkulls() {
        int skulls = 1;
        Skulls s = new Skulls(skulls);
        assertEquals(s.getSkulls(), skulls);
    }

    public String toString(){ return "SKULLS"; }
}
