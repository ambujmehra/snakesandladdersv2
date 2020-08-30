package com.boardgames.snakesandladders.model;

import com.boardgames.snakesandladders.enums.PieceType;

public class Snake extends Piece {

    public Snake(PieceType pieceType, Cell startCell, Cell endCell) {
        super(pieceType, startCell, endCell);
    }
}
