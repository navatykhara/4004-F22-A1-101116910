package Dice;

import java.util.Random;

public class Dice {

    DiceState face;

    public Dice(){

    }

    public void setDice(DiceState face) {
        this.face = face;
    }

    public DiceState getDice(){
        return face;
    }



}
