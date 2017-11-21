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
                            controller.reject(socket, user);
                            System.out.println(user.getName() + " tried connecting to server, but was rejected");
                        } else{
                            System.out.println(user.getName() + " connected");
                            userList.add(user);
                            for (User u : userList) {
                                System.out.println(u.getName());
                            }
                            controller.sendWelcome(socket, user);
                            if(userList.size()==2){
                                board.resetBoard();
                                System.out.println(board.printBoard());
                                controller.sendBoard(socket, userList, board);
                                break;
                            }
                        }
                        break;
                        //TODO: If 2 players in list, start game
                    case "MOVE":
                        //TODO: Do something with boardthing
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
