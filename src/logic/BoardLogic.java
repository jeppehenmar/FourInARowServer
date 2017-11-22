package logic;

import models.Board;

/**
 * Created by Jeppe Henmar on 21-11-2017.
 */
public class BoardLogic {
    public Board updateBoard(String moveString, Board board, int turnInt) {
        int moveInt = Integer.parseInt(moveString)-1;
        try {
            if (board.getBoard()[board.getRows() - 1][moveInt].equals(".")) {
                if (turnInt == 1) {
                    board.getBoard()[board.getRows() - 1][moveInt] = board.getBoard()[board.getRows() - 1][moveInt].replace('.', 'X');
                } else if (turnInt == 2) {
                    board.getBoard()[board.getRows() - 1][moveInt] = board.getBoard()[board.getRows() - 1][moveInt].replace('.', 'O');
                }
                return board;
            }
            for (int i = 0; i < board.getRows(); i++) {
                if (board.getBoard()[i+1][moveInt].equals("X") || board.getBoard()[i+1][moveInt].equals("O")) {
                    if (turnInt == 1) {
                        board.getBoard()[i][moveInt] = board.getBoard()[i][moveInt].replace('.', 'X');
                        return board;
                    } else if (turnInt == 2) {
                        board.getBoard()[i][moveInt] = board.getBoard()[i][moveInt].replace('.', 'O');
                        return board;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return board;
    }

    public boolean isWon(Board board, int turnInt) {
        boolean won = false;
        String checkedString = null;
        if(turnInt==1){
            checkedString="X";
        } else if(turnInt==2){
            checkedString="O";
        }
        for(int i = 0; i<board.getRows(); i++){
            for(int j = 0; j<board.getColumns(); i++){

            }
        }
        return won;
    }
}
