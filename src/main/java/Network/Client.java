package Network;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {

    private BufferedReader reader;
    private String name = "";
    private ClientSideConnection csc;

    private int playerID;


    public Client() {


        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void main(String[] args) {

        Client app = new Client();

        try {
            app.name = args[0];
        } catch (Exception e) {
        }

        app.connectToServer();
        app.startReceivingInfo();

    }

    public void startReceivingInfo() {

        Thread T = new Thread(new Runnable() {

            public void run() {

                //Game is starting soon
                System.out.println(csc.receiveFromServer());
                boolean gameEnded = false;

                while(!gameEnded) {

                    String msg = csc.receiveFromServer();
                    boolean myTurn = false;

                    while(!myTurn) {
                        if(msg.equals("It is Player " + playerID + "'s turn.")){
                            myTurn = true;
                            break;
                        }else{
                            myTurn = false;
                        }

                        //Scoreboard
                        System.out.println(msg);

                        //Check win
                        if(msg.contains("won with")){
                            myTurn = false;
                            gameEnded = true;
                            break;
                        }
                        msg = csc.receiveFromServer();

                    }

                    if(myTurn) {
                        //Player turn
                        System.out.println(msg);

                        msg = csc.receiveFromServer();

                        //Fortune
                        System.out.println(msg);

                        while(true) {
                            //Player Hand
                            msg = csc.receiveFromServer();

                            if(msg.equals("Player " + playerID + " has died.")){
                                System.out.println(msg);
                                break;
                            }

                            System.out.println(msg);

                            msg = csc.receiveFromServer();

                            if(msg.equals("Player " + playerID + " has died.")){
                                System.out.println(msg);
                                break;
                            }else if(msg.equals("Player " + playerID + " is in Skull Island.")){
                                System.out.println(msg);
                                msg = csc.receiveFromServer();
                            }

                            //Player Score
                            System.out.println(msg);

                            //Player choices
                            System.out.println(csc.receiveFromServer());

                            try {
                                msg = reader.readLine();
                                csc.sendToServer(msg);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            msg = csc.receiveFromServer();



                            if(msg.equals("Choose the dice index you wish to roll (0-7) [no spaces]") ||
                                    msg.equals("Choose the dice index you wish to add to treasure chest (0-7) [no spaces]")
                                    || msg.equals("Choose the dice index you wish to remove from treasure chest (0-7) [no spaces]")){

                                System.out.println(msg);
                                try {
                                    msg = reader.readLine();
                                    csc.sendToServer(msg);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                //Game message
                                System.out.println(csc.receiveFromServer());
                            }else if(!msg.equals("Player " + playerID + "'s turn ended.") && !msg.equals("Player " + playerID + " has died.")){ //Reroll skulls case
                                //Rerolled skull message
                                System.out.println(msg);
                            }else{
                                break;
                            }

                        }
                        myTurn = false;
                    }

                }
            }


        });

        T.start();
    }

    private void connectToServer() {
        csc = new ClientSideConnection();
    }

    private class ClientSideConnection {

        private Socket socket;
        private DataInputStream dataIn;
        private DataOutputStream dataOut;

        public ClientSideConnection() {

            try {

                socket = new Socket("localhost", 90);
                dataIn = new DataInputStream(socket.getInputStream());
                dataOut = new DataOutputStream(socket.getOutputStream());
                playerID = dataIn.readInt();

            } catch (IOException ex) {
                System.out.println("IO Exception from CSC construction");
            }

        }

        public void sendToServer(String res) {

            try {
                dataOut.writeUTF(res);
                dataOut.flush();
            } catch (IOException e) {
                System.out.println("IOException from sendToServer() CSC");
            }
        }

        public String receiveFromServer() {

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