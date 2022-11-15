package Cucumber;

import Dice.*;
import Game.Player;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PartOneStepDefs {

    Player p1;
    Scorer scorer;

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
        scorer = new Scorer();
        scorer.setAlive(p1.isAlive());
        scorer.count(p1.getHand());
        assertEquals(scorer.score(), int1);
        System.out.println("I should get a score of " + int1);
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



}
