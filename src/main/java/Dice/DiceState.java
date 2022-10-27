package Dice;

public enum DiceState {
    DIAMOND{
        public String toString(){
            return "DIAMOND";
        }
        public char toChar(){
            return 'D';
        }
    };

    public char toChar() {
        return '*';
    }

}
