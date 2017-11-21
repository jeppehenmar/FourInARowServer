package controllers;

import logic.PacketLogic;
import logic.UserLogic;
import models.User;
import senders.Sender;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by jeppe on 21-11-2017.
 */
public class MainController {
    PacketLogic packetLogic = new PacketLogic();
    UserLogic userLogic = new UserLogic();
    Sender sender = new Sender();

    public String readMsg(DatagramPacket packet){
        return packetLogic.readMsg(packet);
    }

    public User createUser(DatagramPacket packet, String username){
        return userLogic.createUser(packet, username);
    }

    public void sendWelcome(DatagramSocket socket, User user){
        sender.sendWelcome(socket, user);
    }

}
