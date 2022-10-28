package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getScore() {
        Player p = new Player(1);
        assertEquals(p.getScore(), 0);
    }

    @Test
    void setScore() {
        Player p = new Player(1);
        p.setScore(1);
        assertEquals(p.getScore(), 1);
    }

    @Test
    void setId() {
        Player p = new Player(1);
        assertEquals(p.getId(), 1);
    }
}