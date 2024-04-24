package com.harshkumar.tictactoe.strategies;

import com.harshkumar.tictactoe.models.Board;
import com.harshkumar.tictactoe.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {

    HashMap<Integer,HashMap<Character,Integer>> rowMaps = new HashMap<>();
    HashMap<Integer,HashMap<Character,Integer>> columnMaps = new HashMap<>();
    HashMap<Character,Integer> leftDiagonalMaps = new HashMap<>();
    HashMap<Character,Integer> rightDiagonalMaps = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getCharacter();

        //checking row hashmaps after every move
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> currRowMap = rowMaps.get(row);

        if(currRowMap.containsKey(character)){
            currRowMap.put(character,currRowMap.get(character)+1);
        }
        else{
            currRowMap.put(character,1);
        }

        if(currRowMap.get(character)== board.getSize()){
            return true;
        }

        //checking coln hashmaps after every move
        if(!columnMaps.containsKey(col)){
            columnMaps.put(col,new HashMap<>());
        }
        HashMap<Character,Integer> currColumnMap = columnMaps.get(col);

        if(currColumnMap.containsKey(character)){
            currColumnMap.put(character,currColumnMap.get(character)+1);
        }
        else{
            currColumnMap.put(character,1);
        }

        if(currColumnMap.get(character)== board.getSize()){
            return true;
        }

        //checking diagonals
        if(row==col){
            //left diagonal
            if(!leftDiagonalMaps.containsKey(character)){
                leftDiagonalMaps.put(character,1);
            }
            else{
                leftDiagonalMaps.put(character,leftDiagonalMaps.get(character)+1);
            }
            if(leftDiagonalMaps.get(character)== board.getSize()){
                return true;
            }

            //right diagonal
            if(!rightDiagonalMaps.containsKey(character)){
                rightDiagonalMaps.put(character,1);
            }
            else{
                rightDiagonalMaps.put(character,rightDiagonalMaps.get(character)+1);
            }
            if(rightDiagonalMaps.get(character)== board.getSize()){
                return true;
            }
        }
        return false;
    }
}
