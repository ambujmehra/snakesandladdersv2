package com.boardgames.snakesandladders;

import com.boardgames.snakesandladders.enums.PieceType;
import com.boardgames.snakesandladders.model.*;
import com.boardgames.snakesandladders.service.GenericBoardStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GenericBoardStrategyTest {

    private Board board;
    GenericBoardStrategy genericBoardStrategy = new GenericBoardStrategy();
    @Before
    public void setup() {
        board = new Board.Builder()
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

    }

    @Test
    public void testInitialMoveWithNoSix() {
        int move = 5;
        Player player = board.getPlayers().get(0);
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertFalse(player.isOpen());
        Assert.assertNull(nextCell);
    }

    @Test
    public void testInitialMoveWithSix() {
        int move = 6;
        Player player = board.getPlayers().get(0);
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertNotNull(nextCell);
        Assert.assertTrue(player.isOpen());
    }


    @Test
    public void testMoveWithNoPiece() {
        int move = 3;
        Player player = board.getPlayers().get(0);
        player.setOpen(true);
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertTrue(player.isOpen());
        Assert.assertEquals(nextCell.getPosition().intValue(), 4);
    }

    @Test
    public void testMovetoSnake() {
        Player player = board.getPlayers().get(0);
        player.setPosition(board.getCells().get(23));
        player.setOpen(true);
        int move = 2;
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertNotNull(nextCell);
        Assert.assertTrue(player.isOpen());
        Assert.assertEquals(nextCell.getPosition().intValue(), 10);
    }


    @Test
    public void testMoveToLadder() {
        Player player = board.getPlayers().get(0);
        player.setPosition(board.getCells().get(15));
        player.setOpen(true);
        int move = 2;
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertNotNull(nextCell);
        Assert.assertTrue(player.isOpen());
        Assert.assertEquals(nextCell.getPosition().intValue(), 25);
    }

    @Test
    public void testOverFlowCase() {
        Player player = board.getPlayers().get(0);
        player.setPosition(board.getCells().get(98));
        player.setOpen(true);
        int move = 4;
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap(), board.getCells());
        Assert.assertNotNull(nextCell);
        Assert.assertTrue(player.isOpen());
        Assert.assertEquals(nextCell.getPosition().intValue(), 98);
    }
}
