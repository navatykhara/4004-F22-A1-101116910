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
        public char toChar(){
            return 'C';
        }
    },

    MONKEY{
        public String toString(){
            return "MONKEY";
        }
        public char toChar(){
            return 'M';
        }
    },


    PARROT{
        public String toString(){
            return "PARROT";
        }
        public char toChar(){
            return 'P';
        }
    }


    ;

    public char toChar() {
        return '*';
    }

}
