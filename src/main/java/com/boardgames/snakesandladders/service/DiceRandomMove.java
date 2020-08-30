package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IRandomMoveAlgorithm;

public class DiceRandomMove implements IRandomMoveAlgorithm {

    @Override
    public Integer getRandomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
