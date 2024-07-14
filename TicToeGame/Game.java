package TicToeGame;

import TicToeGame.entities.*;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private LinkedList<Player> playerList;

    private Board board;

    Game() {
        initialiseGame();
    }

    private void initialiseGame() {
        //board initialse  size 3
        board = new Board(3);
        //empty player listr
        playerList = new LinkedList<>();
        //2 player
        PlayingPiece playingPieceX = new PlayingPeiceX();
        Player player1 = new Player("Player1", playingPieceX);
        PlayingPiece playingPieceO = new PlayingPieceO();
        Player player2 = new Player("Player2", playingPieceO);
        playerList.addLast(player1);
        playerList.addLast(player2);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player currentPlayer = playerList.removeFirst();
            board.printBoard();
            List<Pair<Integer, Integer>> freeCells = board.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;

            }
            //asking the player to enter the position
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the row");
            int row = sc.nextInt();
            System.out.println("enter the column");
            int col = sc.nextInt();


            boolean isPeiceAddedSuccesfully = board.addPeice(row, col, currentPlayer.getPlayingPiece());
            if (!isPeiceAddedSuccesfully) {
                System.out.println("The postion that you have entered is incorrect , please try again later");
                playerList.addFirst(currentPlayer);
                continue;
            } else {
                System.out.println("The place is correct , Inserted properly");
                playerList.addLast(currentPlayer);
            }

            boolean isWinner = getWinner(row, col, currentPlayer.getPlayingPiece());
            if (isWinner) {
                return currentPlayer.getPlayerId() + " won the game";
            }
        }
        return "TIE";
    }

    private boolean getWinner(int row, int col, PlayingPiece playingPiece) {
        PlayingPiece gameBoard[][] = board.getBoard();
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //check rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][col] == null || gameBoard[i][col] != playingPiece) {
                rowMatch = false;
            }
        }

        //check cols
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[row][i] == null || gameBoard[row][i] != playingPiece) {
                columnMatch = false;
            }
        }
        //check for diagonals
        for (int i = 0, j = 0; i < gameBoard.length; i++, j++) {
            if (gameBoard[i][j] == null || gameBoard[i][j] != playingPiece) {
                diagonalMatch = false;
            }
        }
        //check for antidiagonals
        for (int i = 0, j = gameBoard.length - 1; i < gameBoard.length; i++, j--) {
            if (gameBoard[i][j] == null || gameBoard[i][j] != playingPiece) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }

}
