package Dice;

import FortuneCards.SeaBattle;

import java.util.HashMap;

public class Scorer {

    HashMap<DiceState, Integer> freq;
    HashMap<Integer, Integer> rule;

    public Scorer(){
        freq = new HashMap<>();
        rule = new HashMap<>();

        rule.put(3, 100);
        rule.put(4, 200);
        rule.put(5, 500);
        rule.put(6, 1000);
        rule.put(7, 2000);
        rule.put(8, 4000);

    }

    public int score(){
        int total = 0;
        int count = 0;

        for(DiceState d : freq.keySet()){

            if(rule.containsKey(freq.get(d))) {
                total += rule.get(freq.get(d));
                if(!(d == DiceState.COIN || d == DiceState.DIAMOND)){
                    count += freq.get(d);
                }
            }

            if (d == DiceState.COIN || d == DiceState.DIAMOND) {
                total += 100 * freq.get(d);
                count += freq.get(d);
            }
        }

        if(count == 8){
            total += 500;
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
