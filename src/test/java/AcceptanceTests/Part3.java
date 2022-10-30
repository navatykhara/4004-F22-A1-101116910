package AcceptanceTests;

import Dice.*;
import FortuneCards.*;
import Game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part3 {

    @Test
    void row132(){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1,p2,p3});

        String temp = game.drawFortuneForPlayer(p1, new Captain());
        System.out.println(temp);

        assertEquals(temp, "Player 1 draws the CAPTAIN Fortune card.");

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SWORD);
        d2.setDice(DiceState.SWORD);
        d3.setDice(DiceState.SWORD);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SKULL);

        game.rollDiceForPlayer(p1, new Dice[] {d1, d2, d3, d4, d5, d6, d7, d8});
        game.getScorer().setFortune(p1.getFortune());
        game.getScorer().setAlive(p1.isAlive());

        System.out.println(p1.getHand().toString());
        assertEquals(p1.getHand().toString(), "[S][S][S][S][S][S][S]\t|\t[X]");
        System.out.println(game.getScoreForPlayer(p1));
        assertEquals(game.getScoreForPlayer(p1), "Player 1 scores 4000 points.");

        assertEquals(p1.getScore(), 4000);
        p1.setTotal(p1.getScore());

        temp = game.drawFortuneForPlayer(p2, new Skulls(1));
        System.out.println(temp);
        assertEquals(temp, "Player 2 draws the SKULLS=1 Fortune card.");

        Dice k1 = new Dice();
        Dice k2 = new Dice();
        Dice k3 = new Dice();
        Dice k4 = new Dice();
        Dice k5 = new Dice();
        Dice k6 = new Dice();
        Dice k7 = new Dice();
        Dice k8 = new Dice();

        k1.setDice(DiceState.SWORD);
        k2.setDice(DiceState.SWORD);
        k3.setDice(DiceState.SWORD);
        k4.setDice(DiceState.SWORD);
        k5.setDice(DiceState.SWORD);
        k6.setDice(DiceState.SWORD);
        k7.setDice(DiceState.SWORD);
        k8.setDice(DiceState.SKULL);

        game.rollDiceForPlayer(p2, new Dice[] {k1, k2, k3, k4, k5, k6, k7, k8});
        game.getScorer().setFortune(p2.getFortune());
        game.getScorer().setAlive(p2.isAlive());

        System.out.println(p2.getHand().toString());
        assertEquals(p2.getHand().toString(), "[S][S][S][S][S][S][S]\t|\t[X]");
        System.out.println(game.getScoreForPlayer(p2));
        assertEquals(game.getScoreForPlayer(p2), "Player 2 scores 2000 points.");

        assertEquals(p2.getScore(), 2000);
        p2.setTotal(p2.getScore());

        temp = game.drawFortuneForPlayer(p3, new Coin());
        System.out.println(temp);
        assertEquals(temp, "Player 3 draws the COIN Fortune card.");

        Dice j1 = new Dice();
        Dice j2 = new Dice();
        Dice j3 = new Dice();
        Dice j4 = new Dice();
        Dice j5 = new Dice();
        Dice j6 = new Dice();
        Dice j7 = new Dice();
        Dice j8 = new Dice();

        j1.setDice(DiceState.SKULL);
        j2.setDice(DiceState.SKULL);
        j3.setDice(DiceState.SKULL);
        j4.setDice(DiceState.MONKEY);
        j5.setDice(DiceState.MONKEY);
        j6.setDice(DiceState.MONKEY);
        j7.setDice(DiceState.MONKEY);
        j8.setDice(DiceState.MONKEY);

        game.rollDiceForPlayer(p3, new Dice[] {j1, j2, j3, j4, j5, j6, j7, j8});
        game.getScorer().setFortune(p3.getFortune());
        game.getScorer().setAlive(p3.isAlive());

        System.out.println(p3.getHand().toString());
        assertEquals(p3.getHand().toString(), "[M][M][M][M][M]\t|\t[X][X][X]");
        System.out.println(game.getScoreForPlayer(p3));
        assertEquals(game.getScoreForPlayer(p3), "Player 3 scores 0 points.");

        assertEquals(p3.getScore(), 0);
        p3.setTotal(p3.getScore());

        assertTrue(game.checkWinCondition());
        assertEquals(game.checkWinner(), "Player 1 won with 4000 points.");

    }

}
