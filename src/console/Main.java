package console;

import controllers.MainController;
import logic.PacketLogic;
import models.Board;
import models.User;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeppe on 21-11-2017.
 */
public class Main {
    public static void main(String[] args) throws SocketException {
        final DatagramSocket socket = new DatagramSocket(4711);
        List<User> userList = new ArrayList<>();
        Board board = new Board();
        int turnInt = 1;

        MainController controller = new MainController();

        while(true){
            try{
                DatagramPacket received = new DatagramPacket(new byte[1024], 1024);
                socket.receive(received);
                String msg = controller.readMsg(received);
                String header = msg.substring(0, 4);

                switch (header){
                    case "JOIN":
                        String username = msg.substring(5);
                        User user = controller.createUser(received, username);
                        if(userList.size()==2){
                            controller.sendMSG(socket, user, "You have been rejected, server is full");
                            System.out.println(user.getName() + " tried connecting to server, but was rejected");
                        } else{
                            System.out.println(user.getName() + " connected");
                            userList.add(user);
                            for (User u : userList) {
                                System.out.println(u.getName());
                            }
                            controller.sendMSG(socket, user, "You have successfully connected to the server. Please wait while we find an opponent.");
                            if(userList.size()==2){
                                board.resetBoard();
                                System.out.println(board.printBoard());
                                for(int i = 0; i<userList.size(); i++){
                                    controller.sendMSG(socket, userList.get(i), "You are Player"+(i+1)+" and this is your board:");
                                    controller.sendBoard(socket, userList.get(i), board);
                                    controller.sendMSG(socket, userList.get(i), "Player1 starts.");
                                }
                                controller.sendMSG(socket, userList.get(0), "Which column do you choose?");
                                String turnIntAsString = Integer.toString(turnInt);
                                controller.sendMSG(socket, userList.get(0), turnIntAsString);
                                turnInt++;
                                break;
                            }
                        }
                        break;
                    case "MOVE":
                        //TODO: Do something with boardthing
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
