package lld2.flyweight.chessuseroptimization.solved;

import lombok.Getter;

@ExtrinsicState
@Getter
public class ChessUserExtrinsicState {
    private Colour colour;
    private int currentGameStreak;

    private final ChessUserIntrinsicState chessUserIntrinsicState;

    public ChessUserExtrinsicState( ChessUserIntrinsicState chessUserIntrinsicState , 
                                    Colour colour, 
                                    int currentGameStreak) {
        this.chessUserIntrinsicState = chessUserIntrinsicState;
        this.colour = colour;
        this.currentGameStreak = currentGameStreak;
    }
}