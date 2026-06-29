package lld3.assignments.mc2.SnakeLadder.submission2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Q1. Snake & Ladder Game Class Diagram - 1
 *
 * Design a class diagram for the traditional game of Snake and Ladder with the following requirements:
 *
 * Board: A standard Snake and Ladder board contains 100 cells numbered from 1 to 100.
 * Players: The game can be played by 2-4 players.
 * Dice: The game will have a standard dice that can roll numbers between 1 to 6.
 * Snakes: Snakes will have a start point (mouth) and an endpoint (tail). If a player lands on the mouth, they are taken down to the tail.
 * Ladders: Ladders will have a start point (bottom) and an endpoint (top). If a player lands on the bottom, they climb up to the top.
 * Turns: Players take turns in a round-robin fashion to roll the dice and move.
 * Winning Condition: A player wins if they land on the 100th cell exactly. For example, if a player is on the 99th cell, they must roll a 1 to win.
 */

public class SnakeAndLadderClassDiagram2 {
    public static void main(String[] args) {

    }
}

abstract class Position {
    private int top;
    private int bottom;

    public Position(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
    public abstract String getType();
}

class Snake extends Position {

    public Snake(int top, int bottom) {
        super(top, bottom);
    }

    void bite(){

    }

    @Override
    public String getType() {
        return "SNAKE";
    }
}

class Ladder extends Position {
    public Ladder(int top, int bottom) {
        super(top, bottom);
    }

    public void climb()
    {}

    @Override
    public String getType() {
        return "LADDER";
    }
}

class Cell {
    private int number;
    private Snake snake;
    private Ladder ladder;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}

class Board {
    private List<Cell> cells;
    private List<Snake> snakes ;
    private List<Ladder> ladders;

    private int cellNumber = 1;

    public Board() {
        cells = new ArrayList<>(100);
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}

class Dice {
    private int noOfSides;

    public Dice(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public int roll(){
        Random r = new Random();
        int min = 1, max = noOfSides;
        return r.nextInt(max - min + 1) + min;
    };
}

class Player {
    private String name;
    private String color;
    // TODO: Not sure whether Dice should be in Player

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Game {
    private Dice dice;
    private List<Player> players;
    private Player winner;
    private Board board;
    private int nextPlayerIndex;
    private GameState gameState;

    public Game(int noOfplayers) {
        this.players = new ArrayList<>(noOfplayers);
        this.board = new Board();
    }

    void checkWinner(){};
}


enum GameState {
    STARTED,
    IN_PROGRESS,
    COMPLETED
}

interface WinningStrategy {
    boolean checkWinner();
}

class ExactRoll implements  WinningStrategy {
    @Override
    public boolean checkWinner() {
        return false;
    }
}

class AnyRoll implements WinningStrategy {
    @Override
    public boolean checkWinner() {
        return false;
    }
}
