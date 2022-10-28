package Dice;

import FortuneCards.Coin;
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

}
