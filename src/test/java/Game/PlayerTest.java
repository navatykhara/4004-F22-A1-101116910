package Game;

import FortuneCards.Coin;
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

    @Test
    void setTotal() {
        Player p = new Player(1);
        p.setTotal(10);
        assertEquals(p.getTotal(), 10);
    }

    @Test
    void setFortune() {
        Player p = new Player(1);
        Coin coin = new Coin();
        p.setFortune(coin);
        assertEquals(p.getFortune(), coin);
    }

}