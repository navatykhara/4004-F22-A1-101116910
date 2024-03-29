package Dice;

import FortuneCards.Coin;
import FortuneCards.Skulls;
import FortuneCards.Sorceress;
import FortuneCards.TreasureChest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void initialize() {
        Hand hand = new Hand();
        hand.initialize();
        assertTrue(hand.getHand() != null);
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
    @Test
    void rollAllOutofBounds(){

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
        hand.roll(new int[] {8, 8, 8, 8, 8, 8, 8, 8});

        for(int i = 0; i < hand.getHand().length; i++)
            if(hand.getHand()[i].toString().equals(DiceState.COIN.toString()))
                assertTrue(false);
        assertTrue(true);

    }
    @Test
    void getNumSkulls(){

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

        assertEquals(hand.getNumSkulls(new Skulls(1)), 2);

    }
    @Test
    void getNumSkullsForNonSkullFortunes(){

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

        assertEquals(hand.getNumSkulls(new Coin()), 1);

    }
    @Test
    void rollSkullsWithSorceress(){
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

        Dice d = new Dice();
        d.setDice(DiceState.PARROT);
        hand.rollSkull(new Sorceress(), d);
        //Check to see if skulls are removed properly
        assertEquals(hand.getNumSkulls(null), 0);
        //Check to see if dice is rolled properly
        assertEquals(hand.getHand()[hand.getHand().length-1], d);

    }
    @Test
    void rollSkullsWithoutSorceress(){
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

        Dice d = new Dice();
        d.setDice(DiceState.PARROT);
        hand.rollSkull(new Coin(), d);

        assertEquals(hand.getNumSkulls(null), 1);

    }
    @Test
    void getTreasureChest(){
        Hand hand = new Hand();
        assertTrue(hand.getChest(new TreasureChest()).getClass().equals(Hand.class));
    }
    @Test
    void getTreasureChestNoFortune(){
        Hand hand = new Hand();
        assertTrue(hand.getChest(new Coin())== null);
    }
    @Test
    void addToChest(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {0, 1});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand())
            if(d != null)
                count++;

        assertEquals(count, 2);

    }
    @Test
    void addToChestInvalidCase(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {-1, -1});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand())
            if(d != null)
                count++;

        assertEquals(count, 0);

    }
    @Test
    void addToChestOutofBoundsCase(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {8, 8});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand())
            if(d != null)
                count++;

        assertEquals(count, 0);

    }
    @Test
    void removeFromChest(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {0, 1, 2});

        hand.removeFromChest(tc, new int[]{0, 1});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand()) {
            if(d != null)
                count++;
        }

        //Check to see removed correct number of dice
        assertEquals(count, 1);

        count = 0;
        for(Dice d: hand.getHand()) {
            if(d != null)
                count++;
        }

        //Check to see correct number of dice added back
        assertEquals(count, 7);


    }
    @Test
    void removeFromChestInvalidCase(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {0, 1, 2});

        hand.removeFromChest(tc, new int[]{-1, -1});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand()) {
            if(d != null)
                count++;
        }

        //Check to see removed correct number of dice
        assertEquals(count, 3);

        count = 0;
        for(Dice d: hand.getHand()) {
            if(d != null)
                count++;
        }

        //Check to see correct number of dice added back
        assertEquals(count, 5);


    }
    @Test
    void removeFromChestOutofBoundsCase(){

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

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {0, 1, 2});

        hand.removeFromChest(tc, new int[]{8, 8});

        int count = 0;
        for(Dice d: hand.getChest(tc).getHand()) {
            if(d != null)
                count++;
        }

        //Check to see removed correct number of dice
        assertEquals(count, 3);

        count = 0;
        for(Dice d: hand.getHand()) {
            if(d != null)
                count++;
        }

        //Check to see correct number of dice added back
        assertEquals(count, 5);


    }
    @Test
    void testToString(){
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
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.MONKEY);

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

        assertEquals("[C][M][P][P][S][S]\t|\t[X][X]", hand.toString());
    }
    @Test
    void testToStringChest(){
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
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.MONKEY);

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

        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[] {0, 1, 2});

        assertEquals("[C][M][P]", hand.toString(tc));
    }
    @Test
    void isOnSkullIsland(){
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
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.MONKEY);

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
        hand.setOnSkullIsland(new Coin());


        assertTrue(hand.isOnSkullIsland());
    }
}

