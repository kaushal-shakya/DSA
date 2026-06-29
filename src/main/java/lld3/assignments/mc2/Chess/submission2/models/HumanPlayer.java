package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.Color;
import lld3.assignments.mc2.Chess.submission2.enums.PlayerType;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Color color) {
        super(name, color, PlayerType.HUMAN);
    }
}
