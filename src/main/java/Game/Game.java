package Game;

import Dice.Scorer;
import Dice.Dice;
import Dice.SortHelper;
import FortuneCards.FortuneCards;
import FortuneCards.Fortunes;
import FortuneCards.Sorceress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Game {

    Player[] players;
    Scorer scorer;
    Fortunes fortuneDeck;

    public Game(Player[] p){

        players = p;
        scorer = new Scorer();
        fortuneDeck = new Fortunes();


    }

    public String getScoreBoard(){
        String msg = "|";

        for(Player p : players){
            msg += " Player " + p.getId() + " score = " + p.getTotal() + " |";
        }

        return msg;
    }
    public String getScoreForPlayer(Player p){
        String msg = "";
        scorer.count(p.getHand());
        int score = scorer.score();
        p.setScore(score);
        msg += "Player " + p.getId() + " scores " + score + " points.";
        return msg;
    }
    public boolean checkWinCondition(){
        for(Player player : players){
            if(player.getTotal() >= 3000){
                return true;
            }
        }
        return false;
    }
    public String checkWinner(){
        String msg = "";
        ArrayList<Player> sort = new ArrayList<>();

        for(Player p : players){
            if(p.getTotal() >= 3000) {
                sort.add(p);
            }
        }

        Collections.sort(sort, (p1, p2) -> {
            return p2.getTotal() - p1.getTotal();
        });

        msg += "Player " + sort.get(0).getId() + " won with " + sort.get(0).getTotal() + " points.";

        return msg;
    }
    public String drawFortuneForPlayer(Player p){
        String msg = "";
        p.setFortune(fortuneDeck.getFortune());
        msg += "Player " + p.getId() + " draws the " + p.getFortune().toString() + " Fortune card.";
        return msg;
    }
    public String drawFortuneForPlayer(Player p, FortuneCards fortune){
        String msg = "";
        p.setFortune(fortune);
        msg += "Player " + p.getId() + " draws the " + p.getFortune().toString() + " Fortune card.";
        return msg;
    }
    public String rollDiceForPlayer(Player p, int req[]){
        String msg = "";
        p.getHand().roll(req);
        msg += "Player " + p.getId() + " rolls the dice and receives " + p.getHand().toString();
        return msg;
    }
    public String rollDiceForPlayer(Player p, Dice[] hand){
        String msg = "";
        p.getHand().setHand(hand);
        msg += "Player " + p.getId() + " rolls the dice and receives " + p.getHand().toString();
        return msg;
    }
    public String rollSkullForPlayer(Player p){
        String msg = "";
        if(p.getFortune() != null && p.getFortune().getClass().equals(Sorceress.class)) {

            if(((Sorceress) p.getFortune()).getRoll() < 1)
                return "Player " + p.getId() + " has already rerolled a skull dice.";

            p.getHand().rollSkull(p.getFortune());
            msg += "Player " + p.getId() + " re-rolls the skull dice and receives " + p.getHand().toString();
        }else {
            msg += "Player " + p.getId() + " does not have the SORCERESS fortune card";
        }
        return msg;
    }
    public String rollSkullForPlayer(Player p, Dice d){
        String msg = "";
        if(p.getFortune() != null && p.getFortune().getClass().equals(Sorceress.class)) {

            if(((Sorceress) p.getFortune()).getRoll() < 1)
                return "Player " + p.getId() + " has already rerolled a skull dice.";

            p.getHand().rollSkull(p.getFortune(), d);
            msg += "Player " + p.getId() + " re-rolls the skull dice and receives " + p.getHand().toString();
        }else {
            msg += "Player " + p.getId() + " does not have the SORCERESS fortune card";
        }
        return msg;
    }

}

