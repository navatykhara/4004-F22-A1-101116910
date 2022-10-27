package Dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {


    @Test
    void setDice() {

        DiceState d = DiceState.COIN;
        Dice dice = new Dice();
        dice.setDice(d);
        assertEquals(d, dice.getDice());

    }


}
