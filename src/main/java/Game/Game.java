package Game;

import Dice.Scorer;
import Dice.Dice;
import Dice.SortHelper;
import FortuneCards.*;

import java.util.*;

public class Game {

    Player[] players;
    Scorer scorer;
    Fortunes fortuneDeck;

    int winningRound = 2;

    public Game(Player[] p){

        players = p;
        scorer = new Scorer();
        fortuneDeck = new Fortunes();

    }

    public void run(){

        System.out.println("Game starting.");
        System.out.println();

        do{


            for(int i = 0; i < players.length; i++) {
                System.out.println(getScoreBoard());

                System.out.println("It is Player " + players[i].getId() + "'s turn.");
                System.out.println(drawFortuneForPlayer(players[i]));
                scorer.setFortune(players[i].getFortune());

                players[i].getHand().initialize();
                scorer.setAlive(true);

                System.out.println(getScoreForPlayer(players[i]));

                while(true) {

                    System.out.println("HAND: " + players[i].getHand().toString());
                    if(players[i].getFortune().getClass().equals(TreasureChest.class))
                        System.out.println("TREASURE CHEST : " + players[i].getHand().getChest(players[i].getFortune()).toString(players[i].getFortune()));

                    System.out.println(offerChoicesForPlayer());

                    if(!players[i].isAlive()){
                        System.out.println("Player " + players[i].getId() + " has died.");
                        scorer.setAlive(false);
                        getScoreForPlayer(players[i]);
                        players[i].setTotal(players[i].getScore() + players[i].getTotal());
                        break;
                    }

                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    boolean endTurn = false;

                    switch(choice){
                        case 1:
                            System.out.println("Choose the dice index you wish to roll (0-7) [no spaces]");
                            String input = scanner.next();
                            int[] temp = new int [input.length()];
                            for(int k = 0; k < temp.length; k++)
                                temp[k] = Integer.parseInt(input, k, k+1,10);
                            System.out.println(rollDiceForPlayer(players[i], temp));
                            break;
                        case 2:
                            System.out.println(rollSkullForPlayer(players[i]));
                            break;
                        case 3:
                            System.out.println("Choose the dice index you wish to add to treasure chest (0-7) [no spaces]");
                            input = scanner.next();
                            temp = new int [input.length()];
                            for(int k = 0; k < temp.length; k++)
                                temp[k] = Integer.parseInt(input, k, k+1,10);
                            System.out.println(addToChestForPlayer(players[i], temp));
                            break;
                        case 4:
                            System.out.println("Choose the dice index you wish to remove from treasure chest (0-7) [no spaces]");
                            input = scanner.next();
                            temp = new int [input.length()];
                            for(int k = 0; k < temp.length; k++)
                                temp[k] = Integer.parseInt(input, k, k+1,10);
                            System.out.println(removeFromChestForPlayer(players[i], temp));
                            break;
                        case 5:
                            System.out.println("Player " + players[i].getId() + "'s turn ended.");
                            players[i].setTotal(players[i].getScore() + players[i].getTotal());
                            endTurn = true;
                            break;
                        default:

                    }

                    if(endTurn)
                        break;

                    System.out.println(getScoreForPlayer(players[i]));
                }


            }

            if(checkWinCondition()){
                winningRound--;
            }else{
                winningRound=2;
            }

        }while(!checkWinCondition() || winningRound > 0);

        System.out.println(checkWinner());

    }
    public Fortunes getFortuneDeck(){
        return fortuneDeck;
    }
    public Scorer getScorer(){
        return scorer;
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
        if(p.getFortune() != null && p.getFortune().getClass().equals(TreasureChest.class)) {
            scorer.count(p.getHand().getChest(p.getFortune()));
            int score = scorer.score();
            p.setScore(score);
            msg += "Player " + p.getId() + " scores " + score + " points.";
        }else{
            scorer.count(p.getHand());
            int score = scorer.score();
            p.setScore(score);
            msg += "Player " + p.getId() + " scores " + score + " points.";
        }
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
        String addon = "";
        if(p.getFortune().getClass().equals(Skulls.class))
            addon += "=" + ((Skulls) p.getFortune()).getSkulls();
        if(p.getFortune().getClass().equals(SeaBattle.class))
            addon += "=" + ((SeaBattle) p.getFortune()).getSwords();
        msg += "Player " + p.getId() + " draws the " + p.getFortune().toString() + addon + " Fortune card.";
        return msg;
    }
    public String drawFortuneForPlayer(Player p, FortuneCards fortune){
        String msg = "";
        p.setFortune(fortune);
        String addon = "";
        if(fortune.getClass().equals(Skulls.class))
            addon += "=" + ((Skulls) fortune).getSkulls();
        if(fortune.getClass().equals(SeaBattle.class))
            addon += "=" + ((SeaBattle) fortune).getSwords();
        msg += "Player " + p.getId() + " draws the " + p.getFortune().toString() + addon + " Fortune card.";
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
        System.out.println(p.getHand().toString());
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
    public String addToChestForPlayer(Player p, int[] req) {

        if(p.getFortune() == null || !p.getFortune().getClass().equals(TreasureChest.class))
            return "Player " + p.getId() + " does not have the TREASURE CHEST fortune card.";

        for(int i: req)
            if(i < 0 || i > 7)
                return "Player " + p.getId() + " has not provided valid input.";

        String temp = "";
        for(int i : req)
            temp += "[" +p.getHand().getHand()[i].getDice().toChar() + "]";

        p.getHand().addToChest(p.getFortune(), req);

        return "Player " + p.getId() + " adds " + temp + " to the TREASURE CHEST resulting in " + p.getHand().toString(p.getFortune());

    }
    public String removeFromChestForPlayer(Player p, int[] req) {

        if(p.getFortune() == null || !p.getFortune().getClass().equals(TreasureChest.class))
            return "Player " + p.getId() + " does not have the TREASURE CHEST fortune card.";

        for(int i: req)
            if(i < 0 || i > 7)
                return "Player " + p.getId() + " has not provided valid input.";

        String temp = "";
        for(int i : req)
            temp += "[" +p.getHand().getChest(p.getFortune()).getHand()[i].getDice().toChar() + "]";

        p.getHand().removeFromChest(p.getFortune(), req);

        return "Player " + p.getId() + " removes " + temp + " from the TREASURE CHEST resulting in " + p.getHand().toString(p.getFortune());

    }
    public String offerChoicesForPlayer(){
        String msg = "\n";
        msg += "Enter the corresponding integers to pick a choice \n" +
                "\t (1) Reroll dice \n" +
                "\t (2) Reroll skull \n" +
                "\t (3) Add to chest \n" +
                "\t (4) Remove from chest \n" +
                "\t (5) End turn \n";
        return msg;
    }
}

