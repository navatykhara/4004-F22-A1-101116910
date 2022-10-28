package Dice;

import FortuneCards.*;


import java.util.HashMap;

public class Scorer {

    HashMap<DiceState, Integer> freq;
    HashMap<Integer, Integer> rule;

    FortuneCards fortune;
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
    public void setFortune(FortuneCards f){
        fortune = f;
    }
    public int score(){
        int total = 0;
        int count = 0;

        for(DiceState d : freq.keySet()){

            if((fortune != null && fortune.getClass().equals(MonkeyBusiness.class)) && (d == DiceState.MONKEY || d == DiceState.PARROT)){
                continue;
            }

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

        return (fortune != null && fortune.getClass().equals(Captain.class)) ? total*2 : total;
    }

    public void count(Hand hand){
        freq = new HashMap<>();
        for(int i = 0; i < 8; i++){
            if(hand.getHand()[i] == null)
                continue;
            freq.put(hand.getHand()[i].getDice(), freq.get(hand.getHand()[i].getDice()) != null ? freq.get(hand.getHand()[i].getDice()) + 1 : 1);
        }

        if(fortune != null) {
            if (fortune.getClass().equals(Coin.class))
                freq.put(DiceState.COIN, freq.get(DiceState.COIN) != null ? freq.get(DiceState.COIN) + 1 : 1);
            if (fortune.getClass().equals(Diamond.class))
                freq.put(DiceState.DIAMOND, freq.get(DiceState.DIAMOND) != null ? freq.get(DiceState.DIAMOND) + 1 : 1);
            if (fortune.getClass().equals(MonkeyBusiness.class)) {
                int monkey = freq.get(DiceState.MONKEY) != null ? freq.get(DiceState.MONKEY) : 0;
                int parrot = freq.get(DiceState.PARROT) != null ? freq.get(DiceState.PARROT) : 0;
                freq.put(DiceState.MONKEYPARROT, monkey + parrot);
            }
        }
    }

    public HashMap<DiceState, Integer> getFrequency(){
        return freq;
    }

}
