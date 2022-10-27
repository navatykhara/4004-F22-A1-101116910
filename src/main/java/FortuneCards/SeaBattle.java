package FortuneCards;

import java.util.HashMap;

public class SeaBattle {


    int swords;
    public SeaBattle(int i){

        swords = i >= 2 && i <= 4 ? i : -1;

        if(swords == -1){
            throw new IllegalArgumentException("Parameter invalid.");
        }
    }

}
