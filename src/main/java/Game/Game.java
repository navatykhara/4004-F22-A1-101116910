package Game;

import Dice.Scorer;
import Dice.SortHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Game {

    Player[] players;
    Scorer scorer;


    public Game(Player[] p){

        players = p;
        scorer = new Scorer();

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

}
