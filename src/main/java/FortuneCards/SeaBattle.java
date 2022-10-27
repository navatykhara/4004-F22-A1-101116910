package FortuneCards;

import java.util.HashMap;

public class SeaBattle {

    HashMap<Integer, Integer> bonus;
    int swords;
    public SeaBattle(int i){

        bonus = new HashMap<Integer, Integer>();

        bonus.put(2,300);
        bonus.put(3,500);
        bonus.put(4,1000);

        swords = i >= 2 && i <= 4 ? i : -1;

        if(swords == -1){
            throw new IllegalArgumentException("Parameter invalid.");
        }
    }

    public int getSwords(){
        return swords;
    }

    public int getBonus(){
        return bonus.get(swords);
    }

}
