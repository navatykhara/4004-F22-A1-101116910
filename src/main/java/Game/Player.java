package Game;

import Dice.Hand;
import FortuneCards.FortuneCards;

public class Player {

    Hand hand;
    FortuneCards fortune;
    int score;
    int id;
    int total;

    public Player(int i){
        this.id = i;
        score = 0;
        total =0;

        hand = new Hand();
    }

    public int getScore() {
        return this.score;
    }
    public void setScore(int s){
        this.score = s;
    }
    public int getId(){
        return this.id;
    }

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public void setFortune(FortuneCards f){
        fortune = f;
    }
    public FortuneCards getFortune(){
        return fortune;
    }
    public Hand getHand(){
        return hand;
    }

    public boolean isAlive(){
        if(hand.getNumSkulls(fortune) >= 3)
            return false;
        else
            return true;
    }
}
