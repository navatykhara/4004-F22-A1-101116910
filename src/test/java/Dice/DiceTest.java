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

    @Test
    void getDice() {

        DiceState d = DiceState.PARROT;
        Dice dice = new Dice();
        dice.setDice(d);
        assertEquals(d, dice.getDice());

    }

    @Test
    void roll() {
        Dice dice = new Dice();
        DiceState[] temp = new DiceState[]{DiceState.COIN, DiceState.DIAMOND, DiceState.MONKEY, DiceState.PARROT, DiceState.SWORD, DiceState.SKULL};
        DiceState rolledDice = dice.roll();
        for(DiceState d : temp){
            if(d.toString().equals(rolledDice.toString())) {
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }


}
