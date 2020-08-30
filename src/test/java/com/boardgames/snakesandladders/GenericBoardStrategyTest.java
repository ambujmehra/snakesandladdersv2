package com.boardgames.snakesandladders;

import com.boardgames.snakesandladders.enums.PieceType;
import com.boardgames.snakesandladders.model.Board;
import com.boardgames.snakesandladders.model.Cell;
import com.boardgames.snakesandladders.model.Player;
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


        Map<PieceType, Integer> pieceCount = new HashMap<>();
        pieceCount.put(PieceType.LADDERS, 5);
        pieceCount.put(PieceType.SNAKES, 4);
        board = new Board.Builder()
                .makeCells()
                .addPlayers(2)
                .setStrategy(genericBoardStrategy)
                .setPieces(pieceCount)
                .build();

    }

    @Test
    public void testInitialMoveWithSix() {
        int move = 6;
        Player player = board.getPlayers().get(0);
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap());
        Assert.assertNotNull(nextCell);
        Assert.assertTrue(player.isOpen());
        player.setOpen(false);
    }

    @Test
    public void testInitialMoveWithNoSix() {
        int move = 5;
        Player player = board.getPlayers().get(0);
        Cell nextCell = genericBoardStrategy.getNextPosition(move, player, board.getPieceMap());
        Assert.assertFalse(player.isOpen());
        Assert.assertNull(nextCell);
    }
}
