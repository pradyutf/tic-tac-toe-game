package com.harshkumar.tictactoe.models;

import com.harshkumar.tictactoe.exceptions.InvalidMoveException;
import com.harshkumar.tictactoe.strategies.WinningAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimensions,List<Player>players){
        this.board = new Board(dimensions);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState= GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex=0;
        this.winningAlgorithm = new WinningAlgorithm();

    }

    public void printBoard(){
        this.board.printBoard();
    }

    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {

        Player currentPlayer = players.get(nextPlayerMoveIndex);

        System.out.println("It's "+currentPlayer.getName()+" 's chance" );
        //move that player want to make
        Move move = currentPlayer.makeMove(board);

        //move validation
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid move by "+currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToUpdate = board.getBoard().get(row).get(col);
        cellToUpdate.setPlayer(currentPlayer);
        cellToUpdate.setCellState(CellState.FILLED);

        //make the move asked by player and add it to the moves list
        Move finalMove = new Move(cellToUpdate,currentPlayer);
        moves.add(finalMove);

        //increase the index for the next players turn
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1)%players.size();

        if(winningAlgorithm.checkWinner(board,finalMove)){
            gameState=GameState.ENDED;
            winner = currentPlayer;
        }

        return;
    }
}
