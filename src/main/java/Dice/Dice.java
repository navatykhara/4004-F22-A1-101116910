package Dice;

import java.util.Random;

public class Dice {

    DiceState[] dice;
    DiceState face;

    public Dice(){
        dice = new DiceState[]{DiceState.COIN, DiceState.DIAMOND, DiceState.MONKEY, DiceState.PARROT, DiceState.SWORD, DiceState.SKULL};
    }

    public void setDice(DiceState face) {
        this.face = face;
    }

    public DiceState getDice(){
        return face;
    }

    public DiceState roll(){
        face = dice[new Random().nextInt(6)];
        return face;
    }

}
