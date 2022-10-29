package Game;

import Dice.Scorer;

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

}
