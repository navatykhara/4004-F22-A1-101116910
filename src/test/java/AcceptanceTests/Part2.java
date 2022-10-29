package AcceptanceTests;

import Dice.*;

import FortuneCards.Coin;
import FortuneCards.MonkeyBusiness;
import FortuneCards.Sorceress;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Part2 {

    @Test
    void row77(){
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
        d3.setDice(DiceState.SWORD);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.PARROT);
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
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Sorceress sc = new Sorceress();

        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.MONKEY);

        hand.rollSkull(sc, skullRoll);

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 500);
    }
    @Test
    void row78(){
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

        Sorceress sc = new Sorceress();
        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.PARROT);
        hand.rollSkull(sc, skullRoll);

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.PARROT);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void row79(){
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

        Sorceress sc = new Sorceress();
        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.PARROT);
        hand.rollSkull(sc, skullRoll);

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.PARROT);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void row82(){
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

        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 1100);
    }
    @Test
    void row83(){
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

        rolled_d1.setDice(DiceState.MONKEY);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                rolled_d1,
                rolled_d2,});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 1700);
    }
    @Test
    void row84(){
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
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.MONKEY);
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

        scorer.setAlive(false);
        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 0);
    }
}
