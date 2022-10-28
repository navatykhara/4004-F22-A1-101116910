package Dice;

import FortuneCards.SeaBattle;

import java.util.HashMap;

public class Scorer {

    HashMap<DiceState, Integer> freq;

    public Scorer(){
        freq = new HashMap<>();

    }

    public int score(){
        int total = 0;
        for(DiceState d : freq.keySet()){
            
            if(d == DiceState.COIN || d == DiceState.DIAMOND) {
                total += 100 * freq.get(d);
            }

        }

        return  total;
    }

    public void count(Hand hand){
        freq = new HashMap<>();
        for(int i = 0; i < 8; i++){
            if(hand.getHand()[i] == null)
                continue;
            freq.put(hand.getHand()[i].getDice(), freq.get(hand.getHand()[i].getDice()) != null ? freq.get(hand.getHand()[i].getDice()) + 1 : 1);
        }
    }

    public HashMap<DiceState, Integer> getFrequency(){
        return freq;
    }

}
