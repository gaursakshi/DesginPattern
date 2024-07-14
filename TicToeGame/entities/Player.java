package TicToeGame.entities;

public class Player {

     private String playerId;

     private PlayingPiece playingPiece;

     public Player(String playerId,PlayingPiece playingPiece){
         this.playerId = playerId;
         this.playingPiece = playingPiece;
     }


     public String getPlayerId() {
         return playerId;
     }

     public void setPlayerId(String playerId) {
         this.playerId = playerId;
     }

     public PlayingPiece getPlayingPiece() {
         return playingPiece;
     }

     public void setPlayingPiece(PlayingPiece playingPiece) {
         this.playingPiece = playingPiece;
     }
 }
