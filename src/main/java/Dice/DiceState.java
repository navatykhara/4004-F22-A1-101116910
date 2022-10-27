package Dice;

public enum DiceState {
    DIAMOND{
        public String toString(){
            return "DIAMOND";
        }
        public char toChar(){
            return 'D';
        }
    },

    COIN{
        public String toString(){
            return "COIN";
        }

    }

    ;

    public char toChar() {
        return '*';
    }

}
