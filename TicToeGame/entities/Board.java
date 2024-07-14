package TicToeGame.entities;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private  int size;

  private PlayingPiece[][]board;

  public Board(int size){
      this.size = size;
      board = new PlayingPiece[size][size];
  }

  public int getSize(){
      return size;
  }

  public PlayingPiece [][] getBoard(){
      return this.board;

    }

  public boolean addPeice(int row,int col,PlayingPiece piece){
      if(board[row][col]!=null){
          System.out.println("Place is already occupied");
          return false;
      }
      board[row][col]=piece;
      return true;
  }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }


    public  List<Pair<Integer,Integer>> getFreeCells(){
      List<Pair<Integer,Integer>> freeCells = new ArrayList<Pair<Integer,Integer>>();
      for(int i=0;i<board.length;i++){
          for(int j =0;j<board[i].length;j++){
              if(board[i][j]==null){
                  freeCells.add(new Pair<>(i,j));
              }
          }
      }
      return freeCells;

    }
}
