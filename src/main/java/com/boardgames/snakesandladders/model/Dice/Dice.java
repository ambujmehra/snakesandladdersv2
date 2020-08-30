package com.boardgames.snakesandladders.model.Dice;

import com.boardgames.snakesandladders.behaviour.IRandomMoveAlgorithm;


public class Dice {
    private IRandomMoveAlgorithm iRandomMove;

    public Dice(IRandomMoveAlgorithm iRandomMove) {
        this.iRandomMove = iRandomMove;
    }
    public Integer getRandomMove() {
        return iRandomMove.getRandomNumber(1,6);
    }
}
