package com.boardgames.snakesandladders.model;

import com.boardgames.snakesandladders.enums.PieceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Piece {

    private PieceType pieceType;
    private Cell fromCell;
    private Cell toCell;
}
