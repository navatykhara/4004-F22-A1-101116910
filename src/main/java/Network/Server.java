package Network;

import Dice.Dice;
import FortuneCards.Skulls;
import FortuneCards.TreasureChest;
import Game.Game;
import Game.Player;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket ss;
    private int numPlayers;
    private ServerSideConnection player1;
    private ServerSideConnection player2;
    private ServerSideConnection player3;

    private ServerSideConnection[] players;
    private List<String> playersList;
    private Player[] playerObjectList;

    private Game game;

    public List<String> getPlayers() {
        return playersList;
    }

    public Server() {

        playersList = new ArrayList<String>();
        numPlayers = 0;

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        playerObjectList = new Player[]{p1, p2, p3};

        game = new Game(playerObjectList);

        System.out.println("Piraten Kapern Game is starting");

        try {
            ss = new ServerSocket(90);
        } catch (IOException e) {
            System.out.println("IOException from Server constructor");
        }
    }

    public void acceptConnections() {

        try {
            System.out.println("\nWaiting for players to join ...");

            while (numPlayers < 3) {

                Socket s = ss.accept();
                numPlayers++;
                ServerSideConnection SSC = new ServerSideConnection(s, numPlayers);

                if (numPlayers == 1) {
                    player1 = SSC;
                } else if (numPlayers == 2) {
                    player2 = SSC;
                } else {
                    player3 = SSC;
                }
                players = new ServerSideConnection[]{player1, player2, player3};

                Thread t = new Thread(SSC);
                t.start();

            }
            ss.close();

        } catch (IOException ex) {
            System.out.println("IOException from accepting connections()");
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
        s.acceptConnections();
    }

    private class ServerSideConnection implements Runnable {
        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;
        private int playerID;

        private int winningRound;

        ServerSideConnection(Socket s, int id) {
            winningRound = 2;
            socket = s;
            playerID = id;
            try {
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("IOException from run() SSC construction.");
            }
        }

        public void run() {

            try {
                dataOut.writeInt(playerID);
                dataOut.flush();

                System.out.println("Player " + playerID + " has entered the game lobby!");

                playersList.add(Integer.toString(playerID));

                if (numPlayers == 3) {

                    String msg = "Game is starting soon.";

                    player1.sendToClient(msg);
                    player2.sendToClient(msg);
                    player3.sendToClient(msg);

                    game.getFortuneDeck().shuffle();

                    do {

                        for(int i = 0; i < playerObjectList.length; i++) {

                            System.out.println(game.getScoreBoard());
                            for(int j = 0; j < 3; j++) {
                                players[j].sendToClient(game.getScoreBoard());
                            }

                            System.out.println("It is Player " + playerObjectList[i].getId() + "'s turn.");
                            for(int j = 0; j < 3; j++) {
                                players[j].sendToClient("It is Player " + playerObjectList[i].getId() + "'s turn.");
                                if(j+1 == playerObjectList[i].getId())
                                    players[j].sendToClient(game.drawFortuneForPlayer(playerObjectList[i], new Skulls(2)));

                            }

                            game.getScorer().setFortune(playerObjectList[i].getFortune());
                            playerObjectList[i].getHand().initialize();
                            game.getScorer().setAlive(playerObjectList[i].isAlive());
                            playerObjectList[i].getHand().setOnSkullIsland(playerObjectList[i].getFortune());
                            //Main Game Loop
                            while(true){

                                if(playerObjectList[i].getFortune().getClass().equals(TreasureChest.class)) {
                                    System.out.println("Player " + playerObjectList[i].getId() + "'s hand = " + playerObjectList[i].getHand().toString() + " | " + playerObjectList[i].getHand().getChest(playerObjectList[i].getFortune()).toString(playerObjectList[i].getFortune()));
                                    players[i].sendToClient("Player " + playerObjectList[i].getId() + "'s hand = " + playerObjectList[i].getHand().toString() + " | " + playerObjectList[i].getHand().getChest(playerObjectList[i].getFortune()).toString(playerObjectList[i].getFortune()));
                                }else {
                                    System.out.println("Player " + playerObjectList[i].getId() + "'s hand = " + playerObjectList[i].getHand().toString());
                                    players[i].sendToClient("Player " + playerObjectList[i].getId() + "'s hand = " + playerObjectList[i].getHand().toString());
                                }

                                if(playerObjectList[i].getHand().isOnSkullIsland()) {
                                    System.out.println("Player " + playerObjectList[i].getId() + " is in Skull Island.");
                                    players[i].sendToClient("Player " + playerObjectList[i].getId() + " is in Skull Island.");
                                }else if(!playerObjectList[i].isAlive()){
                                    System.out.println("Player " + playerObjectList[i].getId() + " has died.");
                                    players[i].sendToClient("Player " + playerObjectList[i].getId() + " has died.");
                                    game.getScorer().setAlive(false);
                                    game.getScoreForPlayer(playerObjectList[i]);
                                    playerObjectList[i].setTotal((playerObjectList[i].getScore() + playerObjectList[i].getTotal()) < 0 ? 0 : (playerObjectList[i].getScore() + playerObjectList[i].getTotal()));
                                    break;
                                }

                                String scoreTemp = game.getScoreForPlayer(playerObjectList[i]);
                                System.out.println(scoreTemp);
                                players[i].sendToClient(scoreTemp);

                                players[i].sendToClient(game.offerChoicesForPlayer());

                                msg = players[i].receiveFromClient();
                                int choice = Integer.parseInt(msg);
                                boolean endTurn = false;

                                switch(choice){
                                    case 1:
                                        players[i].sendToClient("Choose the dice index you wish to roll (0-7) [no spaces]");
                                        String input = players[i].receiveFromClient();
                                        int[] temp = new int [input.length()];
                                        for(int k = 0; k < temp.length; k++)
                                            temp[k] = Integer.parseInt(input, k, k+1,10);

                                        int sizeofprevhand = 0;
                                        for(Dice p : playerObjectList[i].getHand().getHand()) {
                                            if(p != null)
                                                sizeofprevhand++;
                                        }

                                        String rollTemp = game.rollDiceForPlayer(playerObjectList[i], temp);
                                        System.out.println(rollTemp);
                                        players[i].sendToClient(rollTemp);

                                        int sizeofcurrhand = 0;
                                        for(Dice p : playerObjectList[i].getHand().getHand()) {
                                            if(p != null)
                                                sizeofcurrhand++;
                                        }

                                        if(sizeofprevhand-sizeofcurrhand < 1){
                                            if(playerObjectList[i].getHand().isOnSkullIsland()){
                                                for(int j = 0; j < 3; j++) {
                                                    if(j+1 != playerObjectList[i].getId())
                                                        playerObjectList[j].setTotal(playerObjectList[j].getTotal() - playerObjectList[i].getHand().getDeduction(playerObjectList[i].getFortune()));

                                                }
                                                players[i].sendToClient("Player " + playerObjectList[i].getId() + " has died.");
                                                endTurn = true;
                                            }
                                        }

                                        break;
                                    case 2:
                                        String skullTemp = game.rollSkullForPlayer(playerObjectList[i]);
                                        System.out.print(skullTemp);
                                        players[i].sendToClient(skullTemp);
                                        break;
                                    case 3:
                                        players[i].sendToClient("Choose the dice index you wish to add to treasure chest (0-7) [no spaces]");
                                        input = players[i].receiveFromClient();
                                        temp = new int [input.length()];
                                        for(int k = 0; k < temp.length; k++)
                                            temp[k] = Integer.parseInt(input, k, k+1,10);
                                        String chestTemp = game.addToChestForPlayer(playerObjectList[i], temp);
                                        System.out.println(chestTemp);
                                        players[i].sendToClient(chestTemp);
                                        break;
                                    case 4:
                                        players[i].sendToClient("Choose the dice index you wish to remove from treasure chest (0-7) [no spaces]");
                                        input = players[i].receiveFromClient();
                                        temp = new int [input.length()];
                                        for(int k = 0; k < temp.length; k++)
                                            temp[k] = Integer.parseInt(input, k, k+1,10);
                                        String chestRemoveTemp = game.removeFromChestForPlayer(playerObjectList[i], temp);
                                        players[i].sendToClient(chestRemoveTemp);
                                        break;
                                    case 5:
                                        if(playerObjectList[i].getHand().isOnSkullIsland()){
                                            for(int j = 0; j < 3; j++) {
                                                if(j+1 != playerObjectList[i].getId())
                                                    playerObjectList[j].setTotal(playerObjectList[j].getTotal() - playerObjectList[i].getHand().getDeduction(playerObjectList[i].getFortune()));

                                            }
                                            System.out.println("Player " + playerObjectList[i].getId() + " has died.");
                                            players[i].sendToClient("Player " + playerObjectList[i].getId() + " has died.");
                                            endTurn = true;
                                            break;
                                        }
                                        System.out.println("Player " + playerObjectList[i].getId() + "'s turn ended.");
                                        players[i].sendToClient("Player " + playerObjectList[i].getId() + "'s turn ended.");
                                        playerObjectList[i].setTotal((playerObjectList[i].getScore() + playerObjectList[i].getTotal()) < 0 ? 0 : (playerObjectList[i].getScore() + playerObjectList[i].getTotal()));
                                        endTurn = true;
                                        break;
                                    default:
                                }

                                if(endTurn)
                                    break;

                            }

                        }

                        if(game.checkWinCondition()){
                            winningRound--;
                        }else{
                            winningRound=2;
                        }

                    }while(!game.checkWinCondition() || winningRound > 0);

                    String winner = game.checkWinner();
                    System.out.println(winner);
                    for(int i = 0; i < 3; i++) {
                        players[i].sendToClient(winner);
                    }

                }


            } catch (IOException e) {
                System.out.println("IOException from run() SSC");
            }
        }
        public void sendToClient(String chart) {

            try {
                dataOut.writeUTF(chart);
                dataOut.flush();
            } catch (IOException e) {
                System.out.println("IOException from sendcharts() SSC");
            }
        }

        public String receiveFromClient() {

            String res = "";
            try {
                res = dataIn.readUTF();
            } catch (IOException e) {
                System.out.println("IOException from recieveFromServer() CSC");
            }

            return res;
        }


    }
}
