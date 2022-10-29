package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void getScoreBoard(){

        Player[] p = new Player[]{ new Player(1),
                new Player(2),
                new Player(3)};
        Game game = new Game(p);

        assertEquals(game.getScoreBoard(), "| Player "+ p[0].getId() + " score = " + p[0].getScore() +
                " | Player " + p[1].getId() + " score = " + p[1].getScore() +
                " | Player " + p[2].getId() + " score = " + p[2].getScore() + " |");
    }
}
