package Game;

import Dice.Dice;
import Dice.DiceState;
import Dice.Hand;
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

    @Test
    void getHand(){
        Player p = new Player(1);
        assertTrue(p.getHand().getClass().equals(Hand.class));
    }


    @Test
    void isAliveBaseCase(){
        Player p = new Player(1);

        Hand hand = new Hand();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.COIN);
        d4.setDice(DiceState.COIN);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.COIN);
        d7.setDice(DiceState.COIN);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        hand.cleanUp();

        p.getHand().setHand(hand.getHand());
        assertTrue(p.isAlive());
    }
}