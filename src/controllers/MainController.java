package controllers;

import logic.PacketLogic;
import logic.UserLogic;
import models.User;

import java.net.DatagramPacket;

/**
 * Created by jeppe on 21-11-2017.
 */
public class MainController {
    PacketLogic packetLogic = new PacketLogic();
    UserLogic userLogic = new UserLogic();

    public String readMsg(DatagramPacket packet){
        return packetLogic.readMsg(packet);
    }

    public User createUser(DatagramPacket packet, String username){
        return userLogic.createUser(packet, username);
    }

}
