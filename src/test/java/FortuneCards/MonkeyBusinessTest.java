package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonkeyBusinessTest {

    @Test
    void testToString() {
        MonkeyBusiness mb = new MonkeyBusiness();
        assertEquals(mb.toString(), "MONKEY BUSINESS");
    }

}
