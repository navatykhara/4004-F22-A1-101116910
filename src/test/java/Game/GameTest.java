package Game;

import Dice.Dice;
import Dice.Hand;
import Dice.SortHelper;
import Dice.DiceState;
import FortuneCards.Coin;
import FortuneCards.Fortunes;
import FortuneCards.Sorceress;
import FortuneCards.TreasureChest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        assertEquals(game.checkWinner(), "Player " + p1.getId() + " won with " + p1.getTotal() + " points.");
    }
    @Test
    void checkWinnerTie(){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1, p2, p3});

        p1.setTotal(3000);
        p2.setTotal(3000);
        p3.setTotal(1000);

        assertEquals(game.checkWinner(), "Player " + p1.getId() + " won with " + p1.getTotal() + " points.");
    }
    @Test
    void drawFortuneForPlayer(){
        Player p1 = new Player(1);

        Game game = new Game(new Player[]{p1});

        assertEquals(game.drawFortuneForPlayer(p1, new Coin()), "Player " + p1.getId() + " draws the COIN Fortune card.");

    }
    @Test
    void rollDiceForPlayer(){

        Player p1 = new Player(1);

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

        Dice[] d = new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8};

        Game game = new Game(new Player[]{p1});
        String temp = game.rollDiceForPlayer(p1, d);

        assertEquals(d, p1.getHand().getHand());
        assertEquals(temp, "Player 1 rolls the dice and receives [P][P][P][P][P][P][P][P]\t|\t");


    }
    @Test
    void rollSkullForPlayer(){

        Player p1 = new Player(1);

        Game game = new Game(new Player[]{p1});

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
        d8.setDice(DiceState.SKULL);

        Dice[] d = new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8};

        Dice dice = new Dice();
        dice.setDice(DiceState.PARROT);

        Arrays.sort(d, new SortHelper());

        p1.getHand().setHand(d);
        p1.getHand().cleanUp();

        p1.setFortune(new Sorceress());

        assertEquals(game.rollSkullForPlayer(p1, dice), "Player 1 re-rolls the skull dice and receives [P][P][P][P][P][P][P][P]\t|\t");
    }
    @Test
    void rollSkullForPlayerNonSorceress(){

        Player p1 = new Player(1);

        Game game = new Game(new Player[]{p1});

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
        d8.setDice(DiceState.SKULL);

        Dice[] d = new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8};

        Dice dice = new Dice();
        dice.setDice(DiceState.PARROT);

        Arrays.sort(d, new SortHelper());

        p1.getHand().setHand(d);
        p1.getHand().cleanUp();

        assertEquals(game.rollSkullForPlayer(p1, dice), "Player 1 does not have the SORCERESS fortune card");
    }
    @Test
    void rollSkullForPlayerTwice(){

        Player p1 = new Player(1);

        Game game = new Game(new Player[]{p1});

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
        d8.setDice(DiceState.SKULL);

        Dice[] d = new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8};

        Dice dice = new Dice();
        dice.setDice(DiceState.PARROT);

        Arrays.sort(d, new SortHelper());

        p1.getHand().setHand(d);
        p1.getHand().cleanUp();

        p1.setFortune(new Sorceress());

        game.rollSkullForPlayer(p1, dice);
        assertEquals(game.rollSkullForPlayer(p1, dice), "Player 1 has already rerolled a skull dice.");
    }

    @Test
    void addToChestForPlayer(){
        Player p1 = new Player(1);

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

        Dice[] d = new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8};

        p1.getHand().setHand(d);
        p1.getHand().cleanUp();
        p1.setFortune(new TreasureChest());

        Game game = new Game(new Player[]{p1});
        
        assertEquals(game.addToChestForPlayer(p1,new int[]{0,1}), "Player 1 adds [P][P] to the TREASURE CHEST resulting in [P][P]");
    }
}
