package com.boardgames.snakesandladders.behaviour;

import com.boardgames.snakesandladders.model.Cell;
import com.boardgames.snakesandladders.model.Piece;
import com.boardgames.snakesandladders.model.Player;

import java.util.Map;

public interface IBoardStrategy {

    Cell getNextPosition(Integer move, Player player, Map<Cell, Piece> pieceMap);
}
