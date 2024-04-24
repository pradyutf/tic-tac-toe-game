package com.harshkumar.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType,BotDifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> rows: board.getBoard()){
            for(Cell cell: rows){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell,this);
                }
            }
        }
        return null;
    }

}
