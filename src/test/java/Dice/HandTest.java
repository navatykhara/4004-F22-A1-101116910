package Dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void initialize() {
        Hand hand = new Hand();
        hand.initialize();
        for(int i = 0; i < 8; i++){
            if(hand.getHand()[i] == null)
                assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    void setHand(){
        Hand hand = new Hand();
        Hand compare = new Hand();

        hand.setHand(compare.getHand());
        assertTrue(hand.getHand().equals(compare.getHand()));

    }

    @Test
    void getHand(){
        Hand hand = new Hand();
        Hand compare = new Hand();

        hand.setHand(compare.getHand());
        assertTrue(hand.getHand().equals(compare.getHand()));
    }

}

