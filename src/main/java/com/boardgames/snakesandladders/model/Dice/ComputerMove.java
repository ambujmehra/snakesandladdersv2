package com.boardgames.snakesandladders.model.Dice;

import com.boardgames.snakesandladders.behaviour.IRandomMoveAlgorithm;

public class ComputerMove {

    private IRandomMoveAlgorithm iRandomMove;

    public ComputerMove(IRandomMoveAlgorithm iRandomMove) {
        this.iRandomMove = iRandomMove;
    }
    public Integer getRandomMove() {
        return iRandomMove.getRandomNumber(1,6);
    }
}
