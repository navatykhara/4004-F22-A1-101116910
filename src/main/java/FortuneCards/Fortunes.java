package FortuneCards;

public class Fortunes {

    FortuneCards[] fortunes;

    public Fortunes() {
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

}
