package senders;

import models.Board;
import models.User;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

/**
 * Created by Jeppe Henmar on 21-11-2017.
 */
public class Sender {

    /*
        OUTDATED - USE sendMSG INSTEAD

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

        OUTDATED - USE sendMSG INSTEAD

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
    */

    public void sendBoardToPlayers(DatagramSocket socket, List<User> userList, Board board) {
        try{
            for(int i = 0; i<board.getRows(); i++){
                String boardRow = "";
                for(int j = 0; j<board.getColumns(); j++){
                    boardRow+=board.getBoard()[i][j]+" ";
                }
                byte[] data = boardRow.getBytes();
                for(User u : userList) {
                    DatagramPacket packet = new DatagramPacket(data, data.length, u.getIp(), u.getPort());
                    socket.send(packet);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMSG(DatagramSocket socket, User user, String msg){
        try{
            byte[] data = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, user.getIp(), user.getPort());
            socket.send(packet);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendBoard(DatagramSocket socket, User user, Board board) {
        try{
            for(int i = 0; i<board.getRows(); i++) {
                String boardRow = "";
                for (int j = 0; j < board.getColumns(); j++) {
                    boardRow += board.getBoard()[i][j] + " ";
                }
                byte[] data = boardRow.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, user.getIp(), user.getPort());
                socket.send(packet);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
