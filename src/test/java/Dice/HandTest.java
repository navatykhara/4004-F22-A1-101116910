package Dice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void initialize() {
        Hand hand = new Hand();
        hand.initialize();
        for(int i = 0; i < 8; i++){
            if(hand.getHand()[i] == null)
                assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    void setHand(){
        Hand hand = new Hand();
        Hand compare = new Hand();

        hand.setHand(compare.getHand());
        assertTrue(hand.getHand().equals(compare.getHand()));

    }

    @Test
    void getHand(){
        Hand hand = new Hand();
        Hand compare = new Hand();

        hand.setHand(compare.getHand());
        assertTrue(hand.getHand().equals(compare.getHand()));
    }
    @Test
    void cleanUp(){
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
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.SKULL);
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

        hand.cleanUp();

        int countNulls = 0;
        for(Dice d : hand.getHand())
            if(d == null)
                countNulls++;

        assertEquals(countNulls, hand.getHand().length);
    }

    @Test
    void cleanUpNoSkulls(){
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

        hand.cleanUp();
        int countNulls = 0;
        for(Dice d : hand.getHand())
            if(d == null)
                countNulls++;

        assertEquals(countNulls, 0);
    }

    @Test
    void cleanUpOneSkulls(){
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
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        hand.cleanUp();

        int countNulls = 0;
        for(Dice d : hand.getHand())
            if(d == null)
                countNulls++;

        assertEquals(countNulls, 1);
    }
    @Test
    void rollAllNulls(){

        Hand hand = new Hand();

        hand.setHand(new Dice[]{ null,
                null,
                null,
                null,
                null,
                null,
                null,
                null});

        hand.cleanUp();
        hand.roll(new int[] {0,1,2,3,4,5,6,7});

        for(int i = 0; i < hand.getHand().length; i++)
            if(hand.getHand()[i] != null)
                assertTrue(false);
        assertTrue(true);

    }

    @Test
    void rollAllNegatives(){

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

        hand.cleanUp();
        hand.roll(new int[] {-1, -1, -1, -1, -1, -1, -1, -1});

        for(int i = 0; i < hand.getHand().length; i++)
            if(hand.getHand()[i].toString().equals(DiceState.COIN.toString()))
                assertTrue(false);
        assertTrue(true);

    }
}

