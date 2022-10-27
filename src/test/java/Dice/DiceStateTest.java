package Dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceStateTest {

    @Test
    void testDiamondStateString(){
        assertEquals(DiceState.DIAMOND.toString(), "DIAMOND");
    }

}