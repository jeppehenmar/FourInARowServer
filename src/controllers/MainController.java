package controllers;

import logic.PacketLogic;
import logic.UserLogic;
import models.Board;
import models.User;
import senders.Sender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

/**
 * Created by jeppe on 21-11-2017.
 */
public class MainController {
    private PacketLogic packetLogic = new PacketLogic();
    private UserLogic userLogic = new UserLogic();
    private Sender sender = new Sender();

    public String readMsg(DatagramPacket packet){
        return packetLogic.readMsg(packet);
    }

    public User createUser(DatagramPacket packet, String username){
        return userLogic.createUser(packet, username);
    }

    public void sendWelcome(DatagramSocket socket, User user){
        sender.sendWelcome(socket, user);
    }

    public void reject(DatagramSocket socket, User user) {
        sender.reject(socket, user);
    }

    public void sendBoard(DatagramSocket socket, List<User> userList, Board board) {
        sender.sendBoard(socket, userList, board);
    }
}
