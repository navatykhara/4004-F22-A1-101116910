package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FortunesTest {

    @Test
    void initialize() {
        FortuneCards[] temp = new FortuneCards[]{
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new Sorceress(),
                (FortuneCards) new Sorceress(),
                (FortuneCards) new Sorceress(),
                (FortuneCards) new Sorceress(),
                (FortuneCards) new Captain(),
                (FortuneCards) new Captain(),
                (FortuneCards) new Captain(),
                (FortuneCards) new Captain(),
                (FortuneCards) new MonkeyBusiness(),
                (FortuneCards) new MonkeyBusiness(),
                (FortuneCards) new MonkeyBusiness(),
                (FortuneCards) new MonkeyBusiness(),
                (FortuneCards) new Diamond(),
                (FortuneCards) new Diamond(),
                (FortuneCards) new Diamond(),
                (FortuneCards) new Diamond(),
                (FortuneCards) new Coin(),
                (FortuneCards) new Coin(),
                (FortuneCards) new Coin(),
                (FortuneCards) new Coin(),
                (FortuneCards) new Skulls(2),
                (FortuneCards) new Skulls(2),
                (FortuneCards) new Skulls(1),
                (FortuneCards) new Skulls(1),
                (FortuneCards) new Skulls(1),
                (FortuneCards) new SeaBattle(2),
                (FortuneCards) new SeaBattle(2),
                (FortuneCards) new SeaBattle(3),
                (FortuneCards) new SeaBattle(3),
                (FortuneCards) new SeaBattle(4),
                (FortuneCards) new SeaBattle(4)
        };

        Fortunes fortune = new Fortunes();
        int index = 0;
        for(FortuneCards f : fortune.initialize()){
            if(!f.toString().equals(temp[index].toString()))
                assertTrue(false);
            if(f.getClass().equals(Skulls.class))
                assertEquals(((Skulls) f).getSkulls(), ((Skulls) temp[index]).getSkulls());
            if(f.getClass().equals(SeaBattle.class))
                assertEquals(((SeaBattle) f).getSwords(), ((SeaBattle) temp[index]).getSwords());
            index++;
        }
        assertTrue(true);
    }

    @Test
    void shuffle() {

        FortuneCards[] temp = new FortuneCards[]{
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new Coin(),
                (FortuneCards) new TreasureChest(),
                (FortuneCards) new Sorceress(),
                (FortuneCards) new SeaBattle(4)
        };

        Fortunes fortunes = new Fortunes();

        assertEquals(temp, fortunes.shuffle(temp));
    }

    @Test
    void getFortuneBaseCase() {

        Fortunes fortune = new Fortunes();
        fortune.initialize();
        FortuneCards[] temp = fortune.shuffle();
        assertEquals(temp[0], fortune.getFortune());
    }

    @Test
    void getFortuneEndCase() {

        Fortunes fortune = new Fortunes();

        fortune.initialize();
        FortuneCards[] temp = fortune.shuffle();

        for(int i = 0; i < temp.length-1; i++)
            fortune.getFortune();

        assertEquals(temp[temp.length-1], fortune.getFortune());
    }

    @Test
    void getFortuneMiddleCase() {

        Fortunes fortune = new Fortunes();

        fortune.initialize();
        FortuneCards[] temp = fortune.shuffle();

        for(int i = 0; i < (temp.length-1)/2; i++)
            fortune.getFortune();

        assertEquals(temp[(temp.length-1)/2], fortune.getFortune());
    }

    
}
