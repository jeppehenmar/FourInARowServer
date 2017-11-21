package console;

import controllers.MainController;
import logic.PacketLogic;
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

        MainController controller = new MainController();

        while(true){
            try{
                DatagramPacket received = new DatagramPacket(new byte[1024], 1024);
                socket.receive(received);
                String msg = controller.readMsg(received);
                String header = msg.substring(0, 4);

                switch (header){
                    case "JOIN":
                        System.out.println("Someone joined");
                        String username = msg.substring(5);
                        userList.add(controller.createUser(received, username));
                        for (User u : userList){
                            System.out.println(u.getName());
                        }
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
