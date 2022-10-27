package Dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceStateTest {

    @Test
    void testDiamondStateString(){
        assertEquals(DiceState.DIAMOND.toString(), "DIAMOND");
    }

    @Test
    void testDiamondStateChar(){
        assertEquals(DiceState.DIAMOND.toChar(), 'D');
    }

    @Test
    void testCoinStateString(){
        assertEquals(DiceState.COIN.toString(), "COIN");
    }

    @Test
    void testCoinStateChar(){
        assertEquals(DiceState.COIN.toChar(), 'C');
    }

    @Test
    void testMonkeyStateString(){
        assertEquals(DiceState.MONKEY.toString(), "MONKEY");
    }


}