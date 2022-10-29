package Game;

public class Runner {

    public static void main(String args[]){
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game(new Player[]{p1, p2, p3});
        game.run();
    }
}
