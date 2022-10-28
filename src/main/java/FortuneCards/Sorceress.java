package FortuneCards;

public class Sorceress implements FortuneCards{

    int roll = 1;

    public void useRoll(){
        roll = 0;
    }

    public int getRoll(){
        return roll;
    }

    @Override
    public String toString() {
        return "SORCERESS";
    }

}
