package Dice;

import java.util.ArrayList;

public class Hand {

    final int MAX_DICE = 8;

    Dice[] hand;
    ArrayList<Dice> graveyard;

    public Hand(){
        hand = new Dice[MAX_DICE];
        graveyard = new ArrayList<>();
    }

    public void initialize(){
        for(int i = 0; i < MAX_DICE; i++){
            hand[i] = new Dice();
            hand[i].roll();
        }

        graveyard = new ArrayList<>();
    }

    public Dice[] getHand(){
        return hand;
    }
    public void setHand(Dice[] hand){
        this.hand = hand;
    }

    public void cleanUp(){
        for(int i = MAX_DICE-1; i >= 0; i--){
            if(hand[i] == null) {
                continue;
            }else if(hand[i].getDice() == DiceState.SKULL){
                graveyard.add(hand[i]);
                hand[i] = null;
            }else{
                break;
            }
        }
    }

}
