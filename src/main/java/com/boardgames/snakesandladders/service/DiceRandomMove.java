package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IRandomMoveAlgorithm;

import java.util.Random;

public class DiceRandomMove implements IRandomMoveAlgorithm {

    private Random r = new Random();

    @Override
    public Integer getRandomNumber(int min, int max) {
        return r.nextInt(max - min) + min;
    }
}
