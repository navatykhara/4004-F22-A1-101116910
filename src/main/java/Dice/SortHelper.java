package Dice;

import java.util.Comparator;

public class SortHelper implements Comparator<Dice> {
    @Override
    public int compare(Dice o1, Dice o2) {
        int v1 = 0;
        int v2 = 0;

        if (o1 != null) {
            switch (o1.getDice()) {
                case DIAMOND:
                    v1 = 6;
                    break;
                case COIN:
                    v1 = 5;
                    break;
                case MONKEY:
                    v1 = 4;
                    break;
                case PARROT:
                    v1 = 3;
                    break;
                case SWORD:
                    v1 = 2;
                    break;
                case SKULL:
                    v1 = 1;
                    break;
            }
        }

        if (o2 != null) {
            switch (o2.getDice()) {
                case DIAMOND:
                    v2 = 6;
                    break;
                case COIN:
                    v2 = 5;
                    break;
                case MONKEY:
                    v2 = 4;
                    break;
                case PARROT:
                    v2 = 3;
                    break;
                case SWORD:
                    v2 = 2;
                    break;
                case SKULL:
                    v2 = 1;
                    break;
            }
        }

        return v2 - v1;
    }
}