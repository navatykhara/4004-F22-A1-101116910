package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getScore() {
        Player p = new Player();
        assertEquals(p.getScore(), 0);
    }

    @Test
    void setScore() {
        Player p = new Player();
        p.setScore(1);
        assertEquals(p.getScore(), 1);
    }
}