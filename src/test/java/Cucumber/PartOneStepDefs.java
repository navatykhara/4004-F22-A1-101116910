package Cucumber;

import Dice.*;
import FortuneCards.*;
import Game.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PartOneStepDefs {

    Player p1;
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
    public void fcIs(String fc) {
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



}
