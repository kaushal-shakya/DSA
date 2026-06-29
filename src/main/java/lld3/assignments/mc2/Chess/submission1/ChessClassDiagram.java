package lld3.assignments.mc2.Chess.submission1;

import java.util.ArrayList;
import java.util.List;

public class ChessClassDiagram {
}

enum GameStatus {
    STARTED,
    ONGOING,
    CHECK,
    STALEMATE,
    CHECKMATE
}

enum PieceType {
    KING,
    QUEEN,
    BISHOP,
    KNIGHT,
    ROOK,
    PAWN
}

enum Color {
    WHITE,
    BLACK
}

class Cell {
    private int row;
    private int column;
    private Piece piece;
    
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

abstract class Piece {
    protected Color color;
    protected PieceType type;
    protected Cell Cell;

    public Piece() {}
    public Piece(Cell Cell) {
        this.Cell = new Cell(Cell.getRow(), Cell.getColumn());
    }

    public abstract List<Cell> possibleMoves(Cell currentCell);

    public PieceType getType() {
        return type;
    }
}

class King extends Piece {

    public King(){
        super();
    }

    public King(Cell Cell) {
        super(Cell);
        type = PieceType.KING;
    }
    
    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        // logic to return all the possible moves
        return new ArrayList<>();
    }
}

class Bishop extends Piece {
    public Bishop() {
        super();
    }

    public Bishop(Cell Cell) {
        super(Cell);
        type = PieceType.BISHOP;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        // logic to return all the possible moves
        return new ArrayList<>();
    }
}

class Queen extends Piece {

    public Queen() {
        super();
    }

    public Queen(Cell Cell) {
        super(Cell);
        type = PieceType.QUEEN;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}

class Knight extends Piece {

    public Knight() {
        super();
    }

    public Knight(Cell Cell) {
        super(Cell);
        type = PieceType.KNIGHT;
    }
    
    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}

class Rook extends Piece {

    public Rook() {
        super();
    }

    public Rook(Cell Cell) {
        super(Cell);
        type = PieceType.ROOK;
    }
    
    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}

class Pawn extends Piece {

    public Pawn() {
        super();
    }

    public Pawn(Cell Cell) {
        super(Cell);
        type = PieceType.PAWN;
    }

    @Override
    public List<Cell> possibleMoves(Cell currentCell) {
        return List.of();
    }
}

class PieceFactory {
    private Piece piece;

    public Piece getPiece(PieceType pieceType) {
        return switch (pieceType) {
            case KING -> new King();
            case QUEEN -> new Queen();
            case ROOK -> new Rook();
            case BISHOP -> new Bishop();
            case KNIGHT -> new Knight();
            case PAWN -> new Pawn();
            default -> throw new IllegalArgumentException(pieceType + " is not valid");
        };
    }
}

class Player {
    private String name;
    private Color color;
    private List<Piece> pieces;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}

class ChessBoard {
    private List<List<Cell>> cells;

    public ChessBoard(int size) {
        //Setup board
        createBoard(size);
        //put all white key on cells of one side --> row 0, 1
        placesAllBlackPieces();
        //pub all black key on cells on opposite side --> row 6,7
        placesAllWhitePieces();
    }
    
    private void createBoard(int size){
        cells = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
             cells.add(new ArrayList<>(size));
        }
    }
    
    private void placesAllBlackPieces() {
        
    }

    private void placesAllWhitePieces() {

    }
}

class Game {
    private List<Player> players;
    private ChessBoard board;
    private List<Piece> removed;
    private GameStatus status;
    private Player winner ;

    public Game() {
        players = new ArrayList<>(); // Two players

        players.add(new Player("Sweta", Color.WHITE));
        players.add(new Player("Satvik", Color.BLACK));

        status = GameStatus.STARTED;
        removed = new ArrayList<>(); // No piece is removed initially, this will be filled on capture of piece
        board = new ChessBoard(8);
    }



}

