package com.harshkumar.tictactoe.controllers;

import com.harshkumar.tictactoe.exceptions.InvalidMoveException;
import com.harshkumar.tictactoe.models.Game;
import com.harshkumar.tictactoe.models.GameState;
import com.harshkumar.tictactoe.models.Move;
import com.harshkumar.tictactoe.models.Player;

import java.util.HashSet;
import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) throws InvalidMoveException {

        HashSet<Character> playerSet = new HashSet<>();
        for(Player player : players) {
            playerSet.add(player.getSymbol().getCharacter());
        }
        if(playerSet.size() != players.size()) {
            throw new InvalidMoveException("Two players have same symbols , fix it");
        }

        return new Game(dimension, players);

    }
    public void makeMove(Game game) throws InvalidMoveException {
         game.makeMove();
    }
    public GameState checkState(Game game) {
        return game.getGameState();
    }
    public Player getwinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game) {

         game.printBoard();
    }
}
