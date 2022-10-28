package FortuneCards;

import Dice.Hand;

public class TreasureChest implements  FortuneCards{

    Hand chest = new Hand();

    public Hand getHand(){
        return chest;
    }
    @Override
    public String toString() {
        return "TREASURE CHEST";
    }

}
