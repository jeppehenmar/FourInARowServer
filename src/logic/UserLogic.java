package logic;

import models.User;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeppe on 21-11-2017.
 */
public class UserLogic {

    public User createUser(DatagramPacket packet, String username){
        return new User(username, packet.getAddress(), packet.getPort());
    }
}
