package lld3.assignments.mc2.Chess.submission2.models;

import lld3.assignments.mc2.Chess.submission2.enums.Color;
import lld3.assignments.mc2.Chess.submission2.enums.PlayerType;

public class BotPlayer extends Player {
    public BotPlayer(String name, Color color) {
        super(name, color, PlayerType.BOT);
    }
}
