package senders;

import models.User;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Jeppe Henmar on 21-11-2017.
 */
public class Sender {
    public void sendWelcome (DatagramSocket socket, User user){
        try{
            String welcomeMSG = "You have succesfully connected to the server. Please wait while we find an opponent";
            byte[] data = welcomeMSG.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, user.getIp(), user.getPort());
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void reject(DatagramSocket socket, User user) {
        try{
            String rejectMSG = "You have been rejected, server is full";
            byte[] data = rejectMSG.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, user.getIp(), user.getPort());
            socket.send(packet);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}