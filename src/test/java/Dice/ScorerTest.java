package Dice;

import FortuneCards.Captain;
import FortuneCards.Coin;
import FortuneCards.Diamond;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {

    @Test
    void count(){
        Hand hand = new Hand();

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

        Scorer scorer = new Scorer();
        scorer.count(hand);

        HashMap<DiceState, Integer> temp = new HashMap<>();
        temp.put(DiceState.COIN, 8);

        assertEquals(temp, scorer.getFrequency());

    }

    @Test
    void testDiamond() {
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.count(hand);
        assertEquals(scorer.score(), 100);
    }
    @Test
    void testCoin() {
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.count(hand);
        assertEquals(scorer.score(), 100);
    }
    @Test
    void testNonValueDice(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
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

        scorer.count(hand);
        assertEquals(scorer.score(), 0);
    }
    @Test
    void testTripleScoring(){
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
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});
        scorer.count(hand);

        assertEquals(scorer.score(), 100);
    }
    @Test
    void testQuadraScoring(){
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
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});
        scorer.count(hand);
        assertEquals(scorer.score(), 200);
    }
    @Test
    void testPentaScoring(){
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
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
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
        scorer.count(hand);

        assertEquals(scorer.score(), 500);
    }
    @Test
    void testHexaScoring(){
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
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void testSeptaScoring(){
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
        scorer.count(hand);
        assertEquals(scorer.score(), 2000);
    }
    @Test
    void testOctoScoring(){
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
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});
        scorer.count(hand);
        assertEquals(scorer.score() - 500, 4000);
    }
    @Test
    void testFullChestBonus(){
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
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});
        scorer.count(hand);

        assertEquals(scorer.score() - 4000, 500);
    }
    @Test
    void testCaptainScoring(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.setFortune(new Captain());
        scorer.count(hand);
        assertEquals(scorer.score(), 200);
    }
    @Test
    void testCoinScoring(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 100);
    }
    @Test
    void testCoinScoringWithGrouping(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.COIN);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 400);
    }
    @Test
    void testDiamondScoring(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.setFortune(new Diamond());
        scorer.count(hand);
        assertEquals(scorer.score(), 100);
    }
    @Test
    void testDiamondScoringWithGrouping(){
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
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.DIAMOND);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        scorer.setFortune(new Diamond());
        scorer.count(hand);
        assertEquals(scorer.score(), 400);
    }

}
