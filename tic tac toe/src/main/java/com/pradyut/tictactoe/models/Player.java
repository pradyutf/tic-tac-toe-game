package com.harshkumar.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner sc = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public Move makeMove(Board board){
        System.out.println("Please enter the row where you to move ");
        int row = sc.nextInt();
        System.out.println("Please enter the column where you to move ");
        int column = sc.nextInt();
        return new Move(new Cell(row,column),this);
    }
}
