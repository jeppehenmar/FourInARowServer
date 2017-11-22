package models;

/**
 * Created by Jeppe Henmar on 21-11-2017.
 */
public class Board {
    private int rows = 6;
    private int columns = 7;
    private String[][] board;

    public Board() {
        this.board = new String[6][7];
    }

    public void resetBoard(){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                board[i][j]=".";
            }
        }
    }

    public String printBoard(){
        String printBoard = "";
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                printBoard+=board[i][j]+" ";
            }
            printBoard+="\n";
        }
        return printBoard;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
