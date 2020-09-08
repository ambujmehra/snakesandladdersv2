package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IBoardStrategy;
import com.boardgames.snakesandladders.model.Cell;
import com.boardgames.snakesandladders.model.Piece;
import com.boardgames.snakesandladders.model.Player;

import java.util.Map;

public class GenericBoardStrategy implements IBoardStrategy {

    public Cell getNextPosition(Integer move, Player player, Map<Cell, Piece> pieceMap, Map<Integer, Cell> cells) {
        Cell nextCell = null;
        // player is closed and move is 6
        if (!player.isOpen() && move == 6) {
            player.setOpen(true);
            nextCell = player.getPosition();
        } else if (player.isOpen()) {
            nextCell = cells.get(player.getPosition().getPosition() + move);
            if (nextCell == null)
                return player.getPosition();
            Piece piece = pieceMap.getOrDefault(nextCell, null);
            if (piece != null)
                nextCell = piece.getToCell();
        }
        return nextCell;
    }
}
