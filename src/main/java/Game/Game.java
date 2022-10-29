package Game;

public class Game {

    Player[] players;

    public Game(Player[] p){

        players = p;

    }

    public String getScoreBoard(){
        String msg = "|";

        for(Player p : players){
            msg += " Player " + p.getId() + " score = " + p.getTotal() + " |";
        }

        return msg;
    }


}
