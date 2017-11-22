package logic;

import controllers.MainController;
import models.Board;
import models.User;

import java.net.DatagramSocket;
import java.util.List;

/**
 * Created by Jeppe Henmar on 22-11-2017.
 */
public class GameLogic {
    public void startGame(DatagramSocket socket, List<User> userList, Board board, MainController controller) {
        board.resetBoard();
        System.out.println(board.printBoard());
        for(int i = 0; i<userList.size(); i++){
            controller.sendMSG(socket, userList.get(i), "You are Player"+(i+1)+" and this is your board:");
            controller.sendBoard(socket, userList.get(i), board);
            controller.sendMSG(socket, userList.get(i), "Player1 starts.");
        }
    }
}
