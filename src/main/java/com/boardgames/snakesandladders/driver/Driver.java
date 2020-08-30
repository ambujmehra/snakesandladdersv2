package com.boardgames.snakesandladders.driver;

import com.boardgames.snakesandladders.behaviour.IRandomMoveAlgorithm;
import com.boardgames.snakesandladders.enums.PieceType;
import com.boardgames.snakesandladders.model.Board;
import com.boardgames.snakesandladders.model.Cell;
import com.boardgames.snakesandladders.model.Dice.ComputerMove;
import com.boardgames.snakesandladders.model.Dice.Dice;
import com.boardgames.snakesandladders.model.Ladder;
import com.boardgames.snakesandladders.model.Piece;
import com.boardgames.snakesandladders.service.*;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        IRandomMoveAlgorithm iRandomMove = new DiceRandomMove();
        Dice dice = new Dice(iRandomMove);
        ComputerMove computerMove = new ComputerMove(iRandomMove);
        PlayerMoveFactory playerMoveFactory = new PlayerMoveFactory(dice, computerMove);

        WinnerPolicyServiceImpl winnerPolicyService = new WinnerPolicyServiceImpl();
        GenericGameStrategy genericGameStrategy = new GenericGameStrategy(playerMoveFactory, winnerPolicyService);

        GenericBoardStrategy genericBoardStrategy = new GenericBoardStrategy();
        Board board = new Board.Builder()
                .makeCells()
                .addPlayers(2)
                .setPieces()
                .setStrategy(genericBoardStrategy)
                .build();
        Map<Cell, Piece> pieceMap = new HashMap<>();
        pieceMap.put(board.getCells().get(5), new Ladder(PieceType.LADDERS,board.getCells().get(5), board.getCells().get(15)));
        pieceMap.put(board.getCells().get(17), new Ladder(PieceType.LADDERS,board.getCells().get(17), board.getCells().get(25)));
        pieceMap.put(board.getCells().get(57), new Ladder(PieceType.LADDERS,board.getCells().get(57), board.getCells().get(81)));
        pieceMap.put(board.getCells().get(88), new Ladder(PieceType.LADDERS,board.getCells().get(88), board.getCells().get(93)));

        pieceMap.put(board.getCells().get(7), new Ladder(PieceType.SNAKES,board.getCells().get(7), board.getCells().get(2)));
        pieceMap.put(board.getCells().get(25), new Ladder(PieceType.SNAKES,board.getCells().get(25), board.getCells().get(10)));
        pieceMap.put(board.getCells().get(65), new Ladder(PieceType.SNAKES,board.getCells().get(65), board.getCells().get(30)));
        pieceMap.put(board.getCells().get(97), new Ladder(PieceType.SNAKES,board.getCells().get(97), board.getCells().get(45)));
        board.setPieceMap(pieceMap);


        SnakesAndLaddersGame snakesAndLaddersGame = new SnakesAndLaddersGame();
        snakesAndLaddersGame.setBoard(board);
        snakesAndLaddersGame.setIGamePlay(genericGameStrategy);

        snakesAndLaddersGame.playGame();

    }
}
