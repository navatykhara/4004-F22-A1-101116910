package Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartOneStepDefs {
    @Given("I have a hand of {string}")
    public void i_have_a_hand_of(String hand){
    }
    @When("I die")
    public void i_die(){
    }
    @Then("I should get a score of {int}")
    public void i_should_get_a_score_of(Integer int1){
        System.out.println(int1);
    }

}
