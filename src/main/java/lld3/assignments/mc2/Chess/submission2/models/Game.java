package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.Color;
import lld3.assignments.mc2.Chess.submission2.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private ChessBoard board;
    private List<Piece> removed;
    private GameStatus status;
    private Player winner ;
    private Player currentPlayer;
    private List<Move> moveHistory;
    private MoveValidator moveValidator;

    public Game(int boardSize) {
        players = new ArrayList<>(); // Two players
        players.add(new HumanPlayer("Sweta", Color.WHITE));
        players.add(new HumanPlayer("Satvik", Color.BLACK));
        status = GameStatus.ONGOING;
        removed = new ArrayList<>(); // No piece is removed initially, this will be filled on capture of piece
        board = new ChessBoard(boardSize);
        moveHistory = new ArrayList<>();
        this.moveValidator = new MoveValidator(board);
    }

    public boolean makeMove(Move move) {
        if(!move.getPlayer().equals(currentPlayer))
            return false;

        return true;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals(players.get(0)) ? players.get(1) : players.get(0);
    }
}
