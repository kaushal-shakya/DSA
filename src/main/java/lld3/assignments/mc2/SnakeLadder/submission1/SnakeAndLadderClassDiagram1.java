package lld3.assignments.mc2.SnakeLadder.submission1;

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

public class SnakeAndLadderClassDiagram1 {
    public static void main(String[] args) {

    }
}

abstract class Position {
    private int top;
    private int bottom;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}

class Snake extends Position{
    void bite(){

    }
}

class Ladder extends Position {
    public void climb()
    {}
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
    private List<List<Cell>> cells;
    private List<Snake> snakes ;
    private List<Ladder> ladders;

    private int cellNumber = 1;

    public Board() {
        cells = new ArrayList<>(10);
        for (int i = 0; i < cells.size(); i++) {
            cells.add(new ArrayList<>(10));
            List<Cell> cellList = cells.get(i);
            int size = cellList.size();
            //if i is even 0,2,4,6,8 --> fill cells number from left to right
            if(i%2==0) {
                for (int j = 0; j < size; j++) {
                    Cell c = cellList.get(j);
                    c.setNumber(cellNumber++);
                    cellList.add(c);
                }
            } else { // If i is odd 1,3,5,7,9 --> fill cells number from right to left

            }
        }
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
    private int diceNumber;

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public int roll(){
        Random r = new Random();
        int min = 1, max = 6;
        return r.nextInt(max - min + 1) + min;
    };
}

class Move {
    private Cell cell;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}

class Player {
    private String name;
    private String color;
    private Move move; // Represents current position and update it after dice roll
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

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}

class Game {
    private Dice dice;
    private List<Player> players;
    private Player winner;
    private Board board;
    private int nextPlayerIndex;

    public Game(int noOfplayers) {
        this.players = new ArrayList<>(noOfplayers);
        this.board = new Board();
    }

    void checkWinner(){};
}


