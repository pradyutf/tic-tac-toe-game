package com.harshkumar.tictactoe;

import com.harshkumar.tictactoe.controllers.GameController;
import com.harshkumar.tictactoe.exceptions.InvalidMoveException;
import com.harshkumar.tictactoe.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


public class TicTacToeApplication {

	public static void main(String[] args) throws InvalidMoveException {
		Scanner sc = new Scanner(System.in);
		GameController gameController = new GameController();
		System.out.println("Enter the size of board : ");
		int dimension = sc.nextInt();

		List<Player> players = List.of(
				new Player("Pradyut",new Symbol('X'), PlayerType.HUMAN),
				new Bot("Computer",new Symbol('O'),PlayerType.BOT,BotDifficultyLevel.EASY)
		);

		Game game = gameController.startGame(dimension,players);

		gameController.printBoard(game);

		while(game.getGameState().equals(GameState.IN_PROGRESS )){

			gameController.makeMove(game);

			gameController.printBoard(game);
		}
		if(!gameController.checkState(game).equals(GameState.ENDED)){
			game.setGameState(GameState.DRAW);
			System.out.println("Game drawn");
		}
		else{
			System.out.println(gameController.getwinner(game).getName()+" is the winner ");
		}
	}

}
