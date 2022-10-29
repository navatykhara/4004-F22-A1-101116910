package AcceptanceTests;

import Dice.*;
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
    

}
