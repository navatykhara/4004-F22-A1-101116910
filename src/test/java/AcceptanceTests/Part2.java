package AcceptanceTests;

import Dice.*;

import FortuneCards.*;

import Game.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Part2 {

    @Test
    void row77(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.DIAMOND);
        d2.setDice(DiceState.DIAMOND);
        d3.setDice(DiceState.SWORD);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.MONKEY);
        rolled_d3.setDice(DiceState.MONKEY);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                rolled_d3,
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Sorceress sc = new Sorceress();

        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.MONKEY);

        hand.rollSkull(sc, skullRoll);

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 500);
    }
    @Test
    void row78(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Sorceress sc = new Sorceress();
        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.PARROT);
        hand.rollSkull(sc, skullRoll);

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.PARROT);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void row79(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Sorceress sc = new Sorceress();
        Dice skullRoll = new Dice();
        skullRoll.setDice(DiceState.PARROT);
        hand.rollSkull(sc, skullRoll);

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.PARROT);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(sc);
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void row82(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.SKULL);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 1100);
    }
    @Test
    void row83(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.COIN);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.MONKEY);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                rolled_d1,
                rolled_d2,});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 1700);
    }
    @Test
    void row84(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.MONKEY);
        d6.setDice(DiceState.MONKEY);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setAlive(false);
        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 0);
    }
    @Test
    void row90(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.PARROT);
        d2.setDice(DiceState.PARROT);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.DIAMOND);
        d7.setDice(DiceState.DIAMOND);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        //PUT 2 DIAMONDS 1 COIN IN CHEST
        TreasureChest tc = new TreasureChest();
        hand.addToChest(tc, new int[]{0,1,2});
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        //REROLL 2 SWORDS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.PARROT);
        rolled_d2.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                rolled_d1,
                rolled_d2,
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        //PUT 5 PARROTS IN CHEST
        hand.addToChest(tc, new int[]{0,1,2,3,4,5});
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        //REMOVE 2 DIAMONDS AND 1 COIN FROM CHEST
        hand.removeFromChest(tc, new int[]{0,1,2});
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        //REROLL 3 DICES
        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();
        Dice rolled_k3 = new Dice();

        rolled_k1.setDice(DiceState.SKULL);
        rolled_k2.setDice(DiceState.COIN);
        rolled_k3.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ rolled_k1,
                rolled_k2,
                rolled_k3,
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        hand.addToChest(tc, new int[]{0,1});
        System.out.println(hand.toString() + "| CHEST : " + hand.toString(tc));

        scorer.setFortune(tc);
        scorer.count(hand.getChest(tc));
        assertEquals(scorer.score(), 1100);
    }
    @Test
    void row94(){
        Player p1 = new Player(1);

        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.PARROT);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.COIN);
        d7.setDice(DiceState.COIN);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        System.out.println(hand.toString());
        p1.getHand().setHand(hand.getHand());
        p1.getHand().cleanUp();

        //PUT 3 COINS IN CHEST
        TreasureChest tc = new TreasureChest();
        p1.getHand().addToChest(tc, new int[]{0,1,2});
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(tc));

        //REROLL 3 PARROTS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();

        rolled_d1.setDice(DiceState.DIAMOND);
        rolled_d2.setDice(DiceState.DIAMOND);
        rolled_d3.setDice(DiceState.COIN);

        p1.getHand().setHand(new Dice[]{ rolled_d1,
                rolled_d2,
                rolled_d3,
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7],});

        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(tc));

        //PUT 3 COINS IN CHEST
        p1.getHand().addToChest(tc, new int[]{2});
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(tc));

        //REROLL 3 PARROTS
        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();

        rolled_k1.setDice(DiceState.SKULL);
        rolled_k2.setDice(DiceState.COIN);

        p1.getHand().setHand(new Dice[]{ rolled_k1,
                rolled_k2,
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7],});
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();
        System.out.println(p1.getHand().toString() + "| CHEST : " + p1.getHand().toString(tc));

        scorer.setFortune(tc);
        scorer.count(hand.getChest(tc));
        assertEquals(scorer.score(), 600);

        System.out.println("Player " + p1.getId() + " has died.");
    }
    @Test
    void row97(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.DIAMOND);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 400);
    }
    @Test
    void row98(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.COIN);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Captain());
        scorer.count(hand);
        assertEquals(scorer.score(), 1800);
    }
    @Test
    void row99(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.DIAMOND);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new Coin());
        scorer.count(hand);
        assertEquals(scorer.score(), 1000);
    }
    @Test
    void row102(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.COIN);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        //REROLL 2 PARROTS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.COIN);
        rolled_d2.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                hand.getHand()[4],
                rolled_d1,
                rolled_d2,
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new SeaBattle(2));
        scorer.count(hand);
        assertEquals(scorer.score(), 1200);
    }
    @Test
    void row103(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.PARROT);
        d4.setDice(DiceState.COIN);
        d5.setDice(DiceState.COIN);
        d6.setDice(DiceState.DIAMOND);
        d7.setDice(DiceState.DIAMOND);
        d8.setDice(DiceState.DIAMOND);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());


        scorer.setFortune(new MonkeyBusiness());
        scorer.count(hand);
        assertEquals(scorer.score(), 1200);
    }
    @Test
    void row106(){
        Player p1 = new Player(1);

        Hand hand = new Hand();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SWORD);
        d3.setDice(DiceState.SWORD);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();
        System.out.println(p1.getHand().toString());

        p1.setFortune(new Skulls(2));
        assertFalse(p1.isAlive());
    }
    @Test
    void row107(){
        Player p1 = new Player(1);

        Hand hand = new Hand();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SKULL);
        d2.setDice(DiceState.SKULL);
        d3.setDice(DiceState.SWORD);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();
        System.out.println(p1.getHand().toString());

        p1.setFortune(new Skulls(1));
        assertFalse(p1.isAlive());


    }
    @Test
    void row114(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.SKULL);
        d6.setDice(DiceState.SKULL);
        d7.setDice(DiceState.SKULL);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        p1.getHand().setHand(hand.getHand());
        p1.getHand().cleanUp();
        System.out.println(hand.toString());

        scorer.setAlive(p1.isAlive());
        scorer.setFortune(new SeaBattle(2));
        scorer.count(p1.getHand());

        assertFalse(p1.isAlive());
        assertEquals(scorer.score(), -300);
    }
    @Test
    void row115(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.SWORD);
        d2.setDice(DiceState.SWORD);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.PARROT);
        d6.setDice(DiceState.PARROT);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());

        //REROLL 4 PARROTS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();
        Dice rolled_d4 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.SKULL);
        rolled_d3.setDice(DiceState.SKULL);
        rolled_d4.setDice(DiceState.SKULL);

        p1.getHand().setHand(new Dice[]{rolled_d1,
                rolled_d2,
                rolled_d3,
                rolled_d4,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());

        scorer.setAlive(p1.isAlive());
        scorer.setFortune(new SeaBattle(3));
        scorer.count(p1.getHand());

        assertFalse(p1.isAlive());
        assertEquals(scorer.score(), -500);
    }
    @Test
    void row116(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.SKULL);
        d4.setDice(DiceState.SKULL);
        d5.setDice(DiceState.SKULL);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SWORD);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());


        scorer.setAlive(p1.isAlive());
        scorer.setFortune(new SeaBattle(4));
        scorer.count(p1.getHand());

        assertFalse(p1.isAlive());
        assertEquals(scorer.score(), -1000);
    }
    @Test
    void row117(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.COIN);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());


        scorer.setAlive(p1.isAlive());
        scorer.setFortune(new SeaBattle(2));
        scorer.count(p1.getHand());

        assertEquals(scorer.score(), 500);
    }
    @Test
    void row119(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SKULL);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());

        //REROLL 2 PARROTS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.SWORD);
        rolled_d2.setDice(DiceState.SKULL);

        p1.getHand().setHand(new Dice[]{
                hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());


        scorer.setFortune(new SeaBattle(2));
        scorer.count(p1.getHand());

        assertEquals(scorer.score(), 500);
    }
    @Test
    void row120(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());


        scorer.setFortune(new SeaBattle(3));
        scorer.count(hand);
        assertEquals(scorer.score(), 800);
    }
    @Test
    void row122(){
        Player p1 = new Player(1);
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.MONKEY);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SKULL);
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        p1.getHand().setHand(hand.getHand());
        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();

        System.out.println(p1.getHand().toString());

        //REROLL 2 PARROTS
        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();
        Dice rolled_d3 = new Dice();
        Dice rolled_d4 = new Dice();

        rolled_d1.setDice(DiceState.SKULL);
        rolled_d2.setDice(DiceState.SKULL);
        rolled_d3.setDice(DiceState.SWORD);
        rolled_d4.setDice(DiceState.SWORD);

        p1.getHand().setHand(new Dice[]{
                rolled_d1,
                rolled_d2,
                rolled_d3,
                rolled_d4,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(p1.getHand().getHand(), new SortHelper());
        p1.getHand().cleanUp();
        System.out.println(p1.getHand().toString());

        assertFalse(p1.isAlive());

        scorer.setFortune(new SeaBattle(3));

        scorer.setAlive(p1.isAlive());
        scorer.count(p1.getHand());

        assertEquals(scorer.score(), -500);
    }
    @Test
    void row123(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SWORD);
        d6.setDice(DiceState.SWORD);
        d7.setDice(DiceState.SWORD);
        d8.setDice(DiceState.SKULL);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());


        scorer.setFortune(new SeaBattle(4));
        scorer.count(hand);
        assertEquals(scorer.score(), 1300);
    }
    @Test
    void row124(){
        Hand hand = new Hand();
        Scorer scorer = new Scorer();

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();
        Dice d6 = new Dice();
        Dice d7 = new Dice();
        Dice d8 = new Dice();

        d1.setDice(DiceState.MONKEY);
        d2.setDice(DiceState.MONKEY);
        d3.setDice(DiceState.MONKEY);
        d4.setDice(DiceState.SWORD);
        d5.setDice(DiceState.SKULL);
        d6.setDice(DiceState.DIAMOND);
        d7.setDice(DiceState.PARROT);
        d8.setDice(DiceState.PARROT);

        hand.setHand(new Dice[]{ d1,
                d2,
                d3,
                d4,
                d5,
                d6,
                d7,
                d8});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        //REROLL 2 PARROTS

        Dice rolled_d1 = new Dice();
        Dice rolled_d2 = new Dice();

        rolled_d1.setDice(DiceState.SWORD);
        rolled_d2.setDice(DiceState.SWORD);


        hand.setHand(new Dice[]{
                hand.getHand()[0],
                hand.getHand()[1],
                hand.getHand()[2],
                hand.getHand()[3],
                rolled_d1,
                rolled_d2,
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        //REROLL 3 MONKEYS

        Dice rolled_k1 = new Dice();
        Dice rolled_k2 = new Dice();
        Dice rolled_k3 = new Dice();

        rolled_k1.setDice(DiceState.SWORD);
        rolled_k2.setDice(DiceState.PARROT);
        rolled_k3.setDice(DiceState.PARROT);


        hand.setHand(new Dice[]{
                hand.getHand()[0],
                rolled_k1,
                rolled_k2,
                rolled_k3,
                hand.getHand()[4],
                hand.getHand()[5],
                hand.getHand()[6],
                hand.getHand()[7]});

        Arrays.sort(hand.getHand(), new SortHelper());
        hand.cleanUp();
        System.out.println(hand.toString());

        scorer.setFortune(new SeaBattle(4));
        scorer.count(hand);
        assertEquals(scorer.score(), 1300);
    }

}
