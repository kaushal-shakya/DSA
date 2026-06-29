package lld3.tictactoe.models;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;

    private Game() {

    }

    //Builder class
    private static class Builder {
        private int boardSize;
        private List<Player> players;

        public Builder(int boardSize, List<Player> players) {
            this.boardSize = boardSize;
            this.players = players;
        }


    }
}
