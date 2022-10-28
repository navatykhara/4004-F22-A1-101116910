package FortuneCards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fortunes {

    FortuneCards[] fortunes;
    int stackIndex;

    public Fortunes() {
        stackIndex = 0;
        fortunes = new FortuneCards[35];

        initialize();
    }

    public FortuneCards[] initialize(){
        int index = 0;

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new TreasureChest();

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new Sorceress();

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new Captain();

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new MonkeyBusiness();

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new Diamond();

        for (int i = 0; i < 4; i++, index++)
            fortunes[index] = (FortuneCards) new Coin();

        for (int i = 0; i < 2; i++, index++)
            fortunes[index] = (FortuneCards) new Skulls(2);

        for (int i = 0; i < 3; i++, index++)
            fortunes[index] = (FortuneCards) new Skulls(1);

        for (int i = 0; i < 2; i++, index++)
            fortunes[index] = (FortuneCards) new SeaBattle(2);

        for (int i = 0; i < 2; i++, index++)
            fortunes[index] = (FortuneCards) new SeaBattle(3);

        for (int i = 0; i < 2; i++, index++)
            fortunes[index] = (FortuneCards) new SeaBattle(4);

        return fortunes;
    }

    public FortuneCards[] shuffle(){

        List<FortuneCards> tempList = Arrays.asList(fortunes);
        Collections.shuffle(tempList);
        tempList.toArray(fortunes);

        stackIndex = 0;

        return fortunes;
    }

    public FortuneCards[] shuffle(FortuneCards[] f){
        fortunes = f;
        stackIndex = 0;
        return fortunes;
    }

    public FortuneCards getFortune(){
        if(stackIndex == fortunes.length)
            shuffle();
        return fortunes[stackIndex++];
    }

}
