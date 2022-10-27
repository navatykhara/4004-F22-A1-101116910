package Dice;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceTest {


    @Test
    void setDice() {

        DiceState d = DiceState.COIN;
        Dice dice = new Dice();
        dice.setDice(d);
        assertEquals(d, dice.getDice());
        
    }


}
