package Dice;

import FortuneCards.FortuneCards;
import FortuneCards.Skulls;
import FortuneCards.Sorceress;
import FortuneCards.TreasureChest;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    final int MAX_DICE = 8;

    Dice[] hand;
    ArrayList<Dice> graveyard;

    public Hand(){
        hand = new Dice[MAX_DICE];
        graveyard = new ArrayList<>();
    }

    public void initialize(){
        for(int i = 0; i < MAX_DICE; i++){
            hand[i] = new Dice();
            hand[i].roll();
        }

        graveyard = new ArrayList<>();
    }

    public Dice[] getHand(){
        return hand;
    }
    public void setHand(Dice[] hand){
        this.hand = hand;
    }

    public int getNumSkulls(FortuneCards f){
        if(f != null && f.getClass().equals(Skulls.class))
            return graveyard.size() + ((Skulls) f).getSkulls();
        return graveyard.size();
    }

    public void roll(int[] req){
        for(int i : req){
            if((i < 0 || i > MAX_DICE-1) || hand[i] == null)
                break;
            hand[i].roll();
        }

        Arrays.sort(hand, new SortHelper());
        cleanUp();

    }

    public void cleanUp(){
        for(int i = MAX_DICE-1; i >= 0; i--){
            if(hand[i] == null) {
                continue;
            }else if(hand[i].getDice() == DiceState.SKULL){
                graveyard.add(hand[i]);
                hand[i] = null;
            }else{
                break;
            }
        }
    }

    public void rollSkull(FortuneCards fortune){

        if(fortune != null && fortune.getClass().equals(Sorceress.class))
            if(graveyard.size() > 0 && ((Sorceress) fortune).getRoll() == 1) {
                for (int j = 0; j < hand.length; j++) {
                    if (hand[j] == null) {
                        hand[j] = graveyard.remove(0);
                        hand[j].roll();
                        ((Sorceress) fortune).useRoll();
                        break;
                    }
                }
            }


        Arrays.sort(hand, new SortHelper());
        cleanUp();
    }

    public void rollSkull(FortuneCards fortune, Dice d){

        if(fortune != null && fortune.getClass().equals(Sorceress.class))
            if(graveyard.size() > 0 && ((Sorceress) fortune).getRoll() == 1) {
                for (int j = 0; j < hand.length; j++) {
                    if (hand[j] == null) {
                        hand[j] = graveyard.remove(0);
                        hand[j] = d;
                        ((Sorceress) fortune).useRoll();
                        break;
                    }
                }
            }

        Arrays.sort(hand, new SortHelper());
        cleanUp();
    }

    public Hand getChest(FortuneCards fortune){
        if(fortune != null && fortune.getClass().equals(TreasureChest.class)){
            return ((TreasureChest) fortune).getHand();
        }
        return null;
    }

    public void addToChest(FortuneCards fortune, int[] h){

        if(fortune != null && fortune.getClass().equals(TreasureChest.class)){

            ArrayList<Dice> toAdd = new ArrayList<>();

            for(int i : h){
                if((i < 0 || i > MAX_DICE-1) || hand[i] == null)
                    break;
                toAdd.add(hand[i]);
                hand[i] = null;
            }

            Arrays.sort(hand, new SortHelper());
            cleanUp();


            ((TreasureChest) fortune).getHand().setHand(toAdd.toArray(new Dice[8]));
        }

    }
    public void removeFromChest(FortuneCards fortune, int[] h){

        if(fortune != null && fortune.getClass().equals(TreasureChest.class)){

            for(int i : h){
                if((i < 0 || i > getChest(fortune).getHand().length-1) || hand[i] == null)
                    break;

                for(int j = 0; j < MAX_DICE; j++){
                    if(hand[j] == null) {
                        hand[j] = getChest(fortune).getHand()[i];
                        getChest(fortune).getHand()[i] = null;
                        break;
                    }
                }
            }

            Arrays.sort(hand, new SortHelper());
            cleanUp();
        }
    }

    public String toString(){
        String display = "";
        for(Dice d : hand){
            if(d == null)
                break;
            display += "[" + d.getDice().toChar() + "]";
        }
        display += "\t|\t";
        for(Dice d : graveyard){
            if(d == null)
                break;
            display += "[" + d.getDice().toChar() + "]";
        }
        return display;
    }

    public String toString(FortuneCards fortune){
        String display = "";
        if(fortune != null && fortune.getClass().equals(TreasureChest.class))
            for(Dice d : getChest(fortune).getHand()){
                if(d == null)
                    break;
                display += "[" + d.getDice().toChar() + "]";
            }
        return display;
    }
}
