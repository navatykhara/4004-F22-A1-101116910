package FortuneCards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeaBattleTest {

    @Test
    void initializeBaseCase() {
        try {
            SeaBattle sb = new SeaBattle(2);
        }catch(Exception e){
            if(e.equals(new IllegalArgumentException("Parameter invalid.")))
                assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    void initializeMiddleCase() {
        try {
            SeaBattle sb = new SeaBattle(3);
        }catch(Exception e){
            if(e.equals(new IllegalArgumentException("Parameter invalid.")))
                assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    void initializeEndCase() {
        try {
            SeaBattle sb = new SeaBattle(4);
        }catch(Exception e){
            if(e.equals(new IllegalArgumentException("Parameter invalid.")))
                assertTrue(false);
        }
        assertTrue(true);
    }

}
