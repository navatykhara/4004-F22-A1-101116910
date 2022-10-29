package Game;

import Dice.Dice;
import Dice.DiceState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void getScoreBoard(){

        Player[] p = new Player[]{ new Player(1),
                new Player(2),
                new Player(3)};
        Game game = new Game(p);

        assertEquals(game.getScoreBoard(), "| Player "+ p[0].getId() + " score = " + p[0].getScore() +
                " | Player " + p[1].getId() + " score = " + p[1].getScore() +
                " | Player " + p[2].getId() + " score = " + p[2].getScore() + " |");
    }
    @Test
    void getScoreForPlayer(){
        Player p = new Player(1);

        Game game = new Game(new Player[]{p});

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.PARROT);
        d2.setDice(DiceState.PARROT);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        p.getHand().setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        assertEquals(game.getScoreForPlayer(p), "Player " + p.getId() + " scores " + p.getScore() + " points.");

    }
    @Test
    void checkWinCondition(){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1, p2, p3});

        p1.setTotal(3000);
        p2.setTotal(2000);
        p3.setTotal(1000);

        assertTrue(game.checkWinCondition());
    }

    @Test
    void checkWinConditionFalse(){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1, p2, p3});

        p1.setTotal(2000);
        p2.setTotal(2000);
        p3.setTotal(1000);

        assertFalse(game.checkWinCondition());
    }

    @Test
    void checkWinner(){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1, p2, p3});

        p1.setTotal(3000);
        p2.setTotal(2000);
        p3.setTotal(1000);

        System.out.println(game.checkWinner());

        assertEquals(game.checkWinner(), "Player " + p1.getId() + " won with " + p1.getTotal() + " points.");
    }
}
