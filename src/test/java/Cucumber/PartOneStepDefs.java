package Cucumber;

import Dice.*;
import FortuneCards.*;
import Game.Player;
import Game.Game;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PartOneStepDefs {

    Player p1 = new Player(1);
    Player p2 = new Player(2);
    Player p3 = new Player(3);

    Player[] players = new Player[]{p1,p2,p3};
    Game game = new Game(players);
    Scorer scorer = new Scorer();

    //row45
    @Given("I have a hand of {string}")
    public void i_have_a_hand_of(String hand){
        p1 = new Player(1);
        stringToHand(hand);
        System.out.println("I have a hand of " + p1.getHand().toString());
    }
    @When("I die")
    public void i_die(){
        System.out.println("I die");
        assertFalse(p1.isAlive());
    }
    @Then("I should get a score of {int}")
    public void i_should_get_a_score_of(Integer int1){
        if(p1.getFortune() == null || p1.getFortune().getClass().equals(Coin.class))
            scorer.setFortune(new Coin());
        scorer.setAlive(p1.isAlive());
        if(p1.getFortune() != null && p1.getFortune().getClass().equals(TreasureChest.class))
            scorer.count(((TreasureChest)p1.getFortune()).getHand());
        else
            scorer.count(p1.getHand());
        assertEquals(scorer.score(), int1);
        System.out.println("I should get a score of " + int1);
    }
    //row46
    @When("I reroll {string} to {string}")
    public void i_reroll_to(String req, String reroll) {
        System.out.print("I reroll " + p1.getHand().toString() );
        stringToExistingHand(req, reroll);
        System.out.println(" to " + p1.getHand().toString());

    }
    //row52
    @When("FC is {string}")
    public void fc_is(String fc) {
        switch(fc){
            case "CAPTAIN":
                Captain c = new Captain();
                p1.setFortune(c);
                scorer.setFortune(c);
                break;
            case "COIN":
                Coin co = new Coin();
                p1.setFortune(co);
                scorer.setFortune(co);
                break;
            case "DIAMOND":
                Diamond d = new Diamond();
                p1.setFortune(d);
                scorer.setFortune(d);
                break;
            case "MONKEY BUSINESS":
                MonkeyBusiness mb = new MonkeyBusiness();
                p1.setFortune(mb);
                scorer.setFortune(mb);
                break;
            case "SORCERESS":
                Sorceress sc = new Sorceress();
                p1.setFortune(sc);
                scorer.setFortune(sc);
                break;
            case "TREASURE CHEST":
                TreasureChest tc = new TreasureChest();
                p1.setFortune(tc);
                scorer.setFortune(tc);
                break;
            default:
                break;
        }
    }
    @When("I reroll skull to {string}")
    public void i_reroll_skull(String reroll) {

        Dice d = new Dice();

        switch(reroll){
            case "DIAMOND":
                d.setDice(DiceState.DIAMOND);
                break;
            case "COIN":
                d.setDice(DiceState.COIN);
                break;
            case "MONKEY":
                d.setDice(DiceState.MONKEY);
                break;
            case "PARROT":
                d.setDice(DiceState.PARROT);
                break;
            case "SWORD":
                d.setDice(DiceState.SWORD);
                break;
            case "SKULL":
               d.setDice(DiceState.SKULL);
                break;
            default:
                break;
        }
        System.out.print("I reroll skull " + p1.getHand().toString() );
        p1.getHand().rollSkull(p1.getFortune(), d);
        System.out.println(" to " + p1.getHand().toString());

    }
    @When("I put {string} in chest")
    public void i_put_in_chest(String req) {
        String[] requests = req.split(",");
        ArrayList<Integer> index = new ArrayList<>();

        int counter = 0;
        for(int i = 0; i < 8; i++){
            if(counter >= requests.length)
                break;
            if(p1.getHand().getHand()[i].getDice().toString().equals(requests[counter])){
                index.add(i);
                counter++;
            }
        }

        int[] temp = new int[index.size()];
        for(int i = 0; i < temp.length; i++)
            temp[i] = index.get(i);

        p1.getHand().addToChest(p1.getFortune(), temp);
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(p1.getFortune()));
    }
    @When("I take out {string}")
    public void i_take_out(String req) {
        String[] requests = req.split(",");
        ArrayList<Integer> index = new ArrayList<>();

        int counter = 0;
        for(int i = 0; i < 8; i++){
            if(counter >= requests.length)
                break;
            if(((TreasureChest) p1.getFortune()).getHand().getHand()[i].getDice().toString().equals(requests[counter])){
                index.add(i);
                counter++;
            }
        }

        int[] temp = new int[index.size()];
        for(int i = 0; i < temp.length; i++)
            temp[i] = index.get(i);

        p1.getHand().removeFromChest(p1.getFortune(), temp);
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(p1.getFortune()));
    }
    @Then("I report death")
    public void i_report_death() {
        System.out.println("Player " + p1.getId() + " has died.");
    }
    @When("FC is {string} {int}")
    public void fc_is(String fc, int i) {
        switch(fc) {
            case "SEA BATTLE":
                SeaBattle sb = new SeaBattle(i);
                p1.setFortune(sb);
                scorer.setFortune(sb);
                break;
            case "SKULLS":
                Skulls s = new Skulls(i);
                p1.setFortune(s);
                scorer.setFortune(s);
                break;
            default:
                break;
        }
    }
    @And("I deduct {int}")
    public void i_deduct(int p) {
        p1.getHand().setOnSkullIsland(p1.getFortune());
        assertTrue(p1.getHand().isOnSkullIsland());

        System.out.println("I deduct " + p1.getHand().getDeduction(p1.getFortune()));
        if(p1.getHand().isOnSkullIsland()){
            p2.setTotal(p2.getTotal() - p1.getHand().getDeduction(p1.getFortune()));
            p3.setTotal(p3.getTotal() - p1.getHand().getDeduction(p1.getFortune()));
        }

        assertEquals(p, p1.getHand().getDeduction(p1.getFortune()));

        String msg = "| Player " + p1.getId() + " score = " + p1.getTotal() + " |" +
                " Player " + p2.getId() + " score = " + p2.getTotal() +
                "| Player " + p3.getId() + " score = " + p3.getTotal() + " |";
        System.out.println(msg);
    }
    //Multiplayer
    @Given("Player {int} has a hand of {string}")
    public void player_had_a_hand_of_with_fc(int id, String hand){
        int index = id - 1;
        players[index] = new Player(id);
        stringToHand(hand, players[index]);
        System.out.println("Player " + players[index].getId() + " has a hand of " + players[index].getHand().toString());
    }
    @When("Player {int} FC is {string}")
    public void player_fc_is(int id, String fc){
        int index = id - 1;
        switch(fc){
            case "CAPTAIN":
                Captain c = new Captain();
                game.drawFortuneForPlayer(players[index], c);
                game.getScorer().setFortune(c);
                break;
            case "COIN":
                Coin co = new Coin();
                game.drawFortuneForPlayer(players[index],co);
                game.getScorer().setFortune(co);
                break;
            case "DIAMOND":
                Diamond d = new Diamond();
                game.drawFortuneForPlayer(players[index],d);
                game.getScorer().setFortune(d);
                break;
            case "MONKEY BUSINESS":
                MonkeyBusiness mb = new MonkeyBusiness();
                game.drawFortuneForPlayer(players[index],mb);
                game.getScorer().setFortune(mb);
                break;
            case "SORCERESS":
                Sorceress sc = new Sorceress();
                game.drawFortuneForPlayer(players[index],sc);
                game.getScorer().setFortune(sc);
                break;
            case "TREASURE CHEST":
                TreasureChest tc = new TreasureChest();
                game.drawFortuneForPlayer(players[index],tc);
                game.getScorer().setFortune(tc);
                break;
            default:
                break;
        }    }
    @When("Player {int} FC is {string} {int}")
    public void fc_is(int id, String fc, int i) {
        int index = id - 1;
        switch(fc) {
            case "SEA BATTLE":
                SeaBattle sb = new SeaBattle(i);
                game.drawFortuneForPlayer(players[index],sb);
                game.getScorer().setFortune(sb);
                break;
            case "SKULLS":
                Skulls s = new Skulls(i);
                game.drawFortuneForPlayer(players[index],s);
                game.getScorer().setFortune(s);
                break;
            default:
                break;
        }
    }
    @When("Player {int} should score of {int}")
    public void player_should_score(int id, int score){
        int index = id - 1;
        game.getScorer().setAlive(players[index].isAlive());
        assertEquals(game.getScoreForPlayer(players[index]), "Player " + players[index].getId() + " scores " + score + " points.");
        System.out.println("Player " + players[index].getId() + " should get a score of " + score);
        players[index].setTotal(players[index].getTotal() + players[index].getScore());
    }

    @When("Game stops")
    public void game_stops(){
        assertTrue(game.checkWinCondition());
    }

    @Then("Player {int} should win")
    public void player_should_win(int id){
        int index = id - 1;
        System.out.println(game.getScoreBoard());
        String temp = game.checkWinner();
        System.out.println(temp);
        assertEquals(temp, "Player " + players[index].getId() + " won with " + players[index].getTotal() + " points.");
    }
    @When("Player {int} deduct {int}")
    public void player_deduct(int id, int dd){
        int index = id - 1;

        players[index].getHand().setOnSkullIsland(players[index].getFortune());
        assertTrue(players[index].getHand().isOnSkullIsland());

        System.out.println("I deduct " + players[index].getHand().getDeduction(players[index].getFortune()));
        if(players[index].getHand().isOnSkullIsland()){

            switch(id){
                case 1:
                    players[1].setTotal(players[1].getTotal() - players[0].getHand().getDeduction(players[0].getFortune()));
                    players[2].setTotal(players[2].getTotal() - players[0].getHand().getDeduction(players[0].getFortune()));
                    break;
                case 2:
                    players[0].setTotal(players[0].getTotal() - players[1].getHand().getDeduction(players[1].getFortune()));
                    players[2].setTotal(players[2].getTotal() - players[1].getHand().getDeduction(players[1].getFortune()));
                    break;
                case 3:
                    players[0].setTotal(players[0].getTotal() - players[2].getHand().getDeduction(players[2].getFortune()));
                    players[1].setTotal(players[1].getTotal() - players[2].getHand().getDeduction(players[2].getFortune()));
                    break;
                default:
                    break;
            }
        }

        assertEquals(dd, players[index].getHand().getDeduction(players[index].getFortune()));
        System.out.println(game.getScoreBoard());
    }
    @When("Player {int} should total {int}")
    public void player_should_total(int id, int t){
        int index = id - 1;
        assertEquals(players[index].getTotal(), t);
    }
    @When("Player {int} has a new hand of {string}")
    public void player_has_a_new_hand_of(int id, String hand){
        int index = id - 1;
        players[index].getHand().initialize();
        stringToHand(hand, players[index]);
        System.out.println("Player " + players[index].getId() + " has a hand of " + players[index].getHand().toString());
    }

    public void stringToHand(String hand){

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        Dice[] dices = new Dice[]{d1, d2, d3, d4, d5, d6, d7, d8};

        String[] cards = hand.split(",");

        for(int i = 0; i < 8; i++){
            switch(cards[i]){
                case "DIAMOND":
                    dices[i].setDice(DiceState.DIAMOND);
                    break;
                case "COIN":
                    dices[i].setDice(DiceState.COIN);
                    break;
                case "MONKEY":
                    dices[i].setDice(DiceState.MONKEY);
                    break;
                case "PARROT":
                    dices[i].setDice(DiceState.PARROT);
                    break;
                case "SWORD":
                    dices[i].setDice(DiceState.SWORD);
                    break;
                case "SKULL":
                    dices[i].setDice(DiceState.SKULL);
                    break;
                default:
                    break;
            }
        }

        Arrays.sort(dices, new SortHelper());

        p1.getHand().setHand(dices);
        p1.getHand().cleanUp();

    }
    public void stringToExistingHand(String req, String reroll){

        Dice rerolled_d1 = new Dice();
        Dice rerolled_d2 = new Dice();
        Dice rerolled_d3 = new Dice();
        Dice rerolled_d4 = new Dice();
        Dice rerolled_d5 = new Dice();
        Dice rerolled_d6 = new Dice();
        Dice rerolled_d7 = new Dice();
        Dice rerolled_d8 = new Dice();

        Dice[] dices = new Dice[]{rerolled_d1, rerolled_d2, rerolled_d3, rerolled_d4, rerolled_d5, rerolled_d6, rerolled_d7, rerolled_d8};

        String[] requests = req.split(",");
        String[] rerolls = reroll.split(",");

        int counter = 0;
        for(int i = 0; i < 8; i++){
            if(counter >= requests.length)
                break;
            if(p1.getHand().getHand()[i].getDice().toString().equals(requests[counter])){
                switch(rerolls[counter]){
                    case "DIAMOND":
                        dices[i].setDice(DiceState.DIAMOND);
                        break;
                    case "COIN":
                        dices[i].setDice(DiceState.COIN);
                        break;
                    case "MONKEY":
                        dices[i].setDice(DiceState.MONKEY);
                        break;
                    case "PARROT":
                        dices[i].setDice(DiceState.PARROT);
                        break;
                    case "SWORD":
                        dices[i].setDice(DiceState.SWORD);
                        break;
                    case "SKULL":
                        dices[i].setDice(DiceState.SKULL);
                        break;
                    default:
                        break;
                }
                p1.getHand().getHand()[i] = dices[i];
                counter++;
            }
        }


        Arrays.sort(p1.getHand().getHand(), new SortHelper());

        p1.getHand().cleanUp();

    }
    public void stringToHand(String hand, Player p){

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        Dice[] dices = new Dice[]{d1, d2, d3, d4, d5, d6, d7, d8};

        String[] cards = hand.split(",");

        for(int i = 0; i < 8; i++){
            switch(cards[i]){
                case "DIAMOND":
                    dices[i].setDice(DiceState.DIAMOND);
                    break;
                case "COIN":
                    dices[i].setDice(DiceState.COIN);
                    break;
                case "MONKEY":
                    dices[i].setDice(DiceState.MONKEY);
                    break;
                case "PARROT":
                    dices[i].setDice(DiceState.PARROT);
                    break;
                case "SWORD":
                    dices[i].setDice(DiceState.SWORD);
                    break;
                case "SKULL":
                    dices[i].setDice(DiceState.SKULL);
                    break;
                default:
                    break;
            }
        }

        Arrays.sort(dices, new SortHelper());

        game.rollDiceForPlayer(p, dices);

    }
    public void stringToExistingHand(String req, String reroll, Player p){

        Dice rerolled_d1 = new Dice();
        Dice rerolled_d2 = new Dice();
        Dice rerolled_d3 = new Dice();
        Dice rerolled_d4 = new Dice();
        Dice rerolled_d5 = new Dice();
        Dice rerolled_d6 = new Dice();
        Dice rerolled_d7 = new Dice();
        Dice rerolled_d8 = new Dice();

        Dice[] dices = new Dice[]{rerolled_d1, rerolled_d2, rerolled_d3, rerolled_d4, rerolled_d5, rerolled_d6, rerolled_d7, rerolled_d8};

        String[] requests = req.split(",");
        String[] rerolls = reroll.split(",");

        int counter = 0;
        for(int i = 0; i < 8; i++){
            if(counter >= requests.length)
                break;
            if(p.getHand().getHand()[i].getDice().toString().equals(requests[counter])){
                switch(rerolls[counter]){
                    case "DIAMOND":
                        dices[i].setDice(DiceState.DIAMOND);
                        break;
                    case "COIN":
                        dices[i].setDice(DiceState.COIN);
                        break;
                    case "MONKEY":
                        dices[i].setDice(DiceState.MONKEY);
                        break;
                    case "PARROT":
                        dices[i].setDice(DiceState.PARROT);
                        break;
                    case "SWORD":
                        dices[i].setDice(DiceState.SWORD);
                        break;
                    case "SKULL":
                        dices[i].setDice(DiceState.SKULL);
                        break;
                    default:
                        break;
                }
                p.getHand().getHand()[i] = dices[i];
                counter++;
            }
        }


        Arrays.sort(p.getHand().getHand(), new SortHelper());

        p.getHand().cleanUp();

    }


}
