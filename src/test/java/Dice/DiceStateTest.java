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

    @Test
    void testMonkeyStateChar(){
        assertEquals(DiceState.MONKEY.toChar(), 'M');
    }

    @Test
    void testParrotStateString(){
        assertEquals(DiceState.PARROT.toString(), "PARROT");
    }

    @Test
    void testParrotStateChar(){
        assertEquals(DiceState.PARROT.toChar(), 'P');
    }

    @Test
    void testSwordStateString(){
        assertEquals(DiceState.SWORD.toString(), "SWORD");
    }

    @Test
    void testSwordStateChar(){
        assertEquals(DiceState.SWORD.toChar(), 'S');
    }

    @Test
    void testSkullStateString(){
        assertEquals(DiceState.SKULL.toString(), "SKULL");
    }

    @Test
    void testSkullStateChar(){
        assertEquals(DiceState.SKULL.toChar(), 'X');
    }

    @Test
    void testMPStateString(){
        assertEquals(DiceState.MONKEYPARROT.toString(), "MONKEY-PARROT");
    }
    @Test
    void testMPStateChar(){
        assertEquals(DiceState.MONKEYPARROT.toChar(), 'W');
    }

}