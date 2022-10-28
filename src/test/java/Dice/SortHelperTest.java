package Dice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SortHelperTest {

    @Test
    void testSortFunction(){

        Hand hand = new Hand();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.DIAMOND);
        d2.setDice(DiceState.COIN);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SKULL);
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

        Dice k1 = new Dice();
        Dice k2 = new Dice();
        Dice k3 = new Dice();
        Dice k4 = new Dice();
        Dice k5 = new Dice();
        Dice k6 = new Dice();
        Dice k7 = new Dice();
        Dice k8 = new Dice();

        k1.setDice(DiceState.SKULL);
        k2.setDice(DiceState.SKULL);
        k3.setDice(DiceState.SKULL);
        k4.setDice(DiceState.SWORD);
        k5.setDice(DiceState.PARROT);
        k6.setDice(DiceState.MONKEY);
        k7.setDice(DiceState.COIN);
        k8.setDice(DiceState.DIAMOND);

        Hand temp = new Hand();
        temp.setHand(new Dice[]{ k1,
                k2,
                k3,
                k4,
                k5,
                k6,
                k7,
                k8});

        Arrays.sort(temp.getHand(), new SortHelper());

        for(int i = 0; i < temp.getHand().length; i++)
            if(!temp.getHand()[i].toString().equals(temp.getHand()[i].toString()))
                assertTrue(false);
        assertTrue(true);


    }
}
