package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaptainTest {

    @Test
    void testToString() {
        Captain c = new Captain();
        assertEquals(c.toString(), "CAPTAIN");
    }

}
