package com.boardgames.snakesandladders.model;

import com.boardgames.snakesandladders.enums.PieceType;

public class Ladder extends Piece {

    public Ladder(PieceType pieceType, Cell startCell, Cell endCell) {
        super(pieceType, startCell, endCell);
    }
}
