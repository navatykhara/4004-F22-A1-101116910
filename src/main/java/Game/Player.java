package Game;

public class Player {

    int score;
    int id;
    int total;

    public Player(int i){
        this.id = i;
        score = 0;
        total =0;
    }

    public int getScore() {
        return this.score;
    }
    public void setScore(int s){
        this.score = s;
    }
    public int getId(){
        return this.id;
    }

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
