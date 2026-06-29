package lld3.assignments.mc2.Chess.submission2.factories;

import lld3.assignments.mc2.Chess.submission2.enums.PieceType;
import lld3.assignments.mc2.Chess.submission2.models.*;

public class PieceFactory {
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
