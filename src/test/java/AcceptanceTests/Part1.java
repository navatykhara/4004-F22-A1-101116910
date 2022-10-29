package AcceptanceTests;

import Dice.*;
import FortuneCards.Captain;
import FortuneCards.Coin;
import FortuneCards.Diamond;
import Game.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Part1 {

    @Test
    void row45(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

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
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setAlive(false);
        scorer.count(hand);
        assertEquals(scorer.score(), 0);
    }
    @Test
    void row46(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.PARROT);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.SKULL);
        rolled_d3.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                rolled_d3,
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setAlive(false);
    }
    @Test
    void row47(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

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
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                null,
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setAlive(false);
    }
    @Test
    void row49(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.PARROT);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.MONKEY);
        rolled_d3.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                rolled_d3,
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();

        rolled_k1.setDice(DiceState.SKULL);
        rolled_k2.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{ rolled_k1,
                rolled_k2,
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setAlive(false);
    }
    @Test
    void row51(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.PARROT);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.COIN);
        rolled_d2.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                rolled_d1,
                rolled_d2,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();
        Dice rolled_k3 = new Dice();

        rolled_k1.setDice(DiceState.COIN);
        rolled_k2.setDice(DiceState.COIN);
        rolled_k3.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_k1,
                rolled_k2,
                rolled_k3,
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());

        scorer.count(hand);
        assertEquals(scorer.score(), 4800);
    }
    @Test
    void row52(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.DIAMOND);
        d6.setDice(DiceState.DIAMOND);
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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setFortune(new Captain());
        scorer.count(hand);
        assertEquals(scorer.score(), 800);
    }
    @Test
    void row53(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();

        rolled_k1.setDice(DiceState.SWORD);
        rolled_k2.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{hand.getHand()[0],
                        hand.getHand()[1],
                        rolled_k1,
                        rolled_k1,
                        hand.getHand()[4],
                        hand.getHand()[5],
                        hand.getHand()[6],
                        null
                });

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 300);
    }
    @Test
    void row54(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.SKULL);
        d8.setDice(DiceState.SKULL);


        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 300);
    }
    @Test
    void row55(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.DIAMOND);
        d2.setDice(DiceState.DIAMOND);
        d3.setDice(DiceState.DIAMOND);
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.SKULL);
        d6.setDice(DiceState.MONKEY);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 500);
    }
    @Test
    void row56(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.COIN);
        d2.setDice(DiceState.COIN);
        d3.setDice(DiceState.COIN);
        d4.setDice(DiceState.COIN);
        d5.setDice(DiceState.SKULL);
        d6.setDice(DiceState.SKULL);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setFortune(new Diamond());
        scorer.count(hand);
        assertEquals(scorer.score(), 700);
    }
    @Test
    void row57(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

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
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 400);
    }
    @Test
    void row58(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.COIN);
        d3.setDice(DiceState.COIN);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.COIN);
        rolled_d2.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                rolled_d1,
                rolled_d2,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 800);
    }
    @Test
    void row59(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.COIN);
        d3.setDice(DiceState.COIN);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.COIN);
        rolled_d2.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                rolled_d1,
                rolled_d2,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                null});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Captain());
        scorer.count(hand);
        assertEquals(scorer.score(), 1200);
    }
    @Test
    void row61(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ rolled_d1,
                rolled_d2,
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();

        rolled_k1.setDice(DiceState.SWORD);
        rolled_k2.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{ rolled_k1,
                rolled_k2,
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 600);
    }
    @Test
    void row62(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.MONKEY);
        d7.setDice(DiceState.SKULL);
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 1100);
    }
    @Test
    void row63(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

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

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 2100);
    }
    @Test
    void row64(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.COIN);
        d2.setDice(DiceState.COIN);
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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 5400);
    }
    @Test
    void row65(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.COIN);
        d2.setDice(DiceState.COIN);
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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Diamond());
        scorer.count(hand);
        assertEquals(scorer.score(), 5400);
    }
    @Test
    void row66(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

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
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Captain());
        scorer.count(hand);
        assertEquals(scorer.score(), 9000);
    }
    @Test
    void row67(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.MONKEY);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.MONKEY);
        rolled_d2.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                rolled_d1,
                rolled_d2});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 4600);
    }
}
