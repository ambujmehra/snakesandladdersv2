package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IGamePlay;
import com.boardgames.snakesandladders.behaviour.IWinnerPolicy;
import com.boardgames.snakesandladders.model.Board;

public class GenericGameStrategy implements IGamePlay {

    private PlayerMoveFactory playerMoveFactory;

    private IWinnerPolicy winnerPolicy;

    public GenericGameStrategy(PlayerMoveFactory playerMoveFactory, IWinnerPolicy winnerPolicy) {
        this.playerMoveFactory = playerMoveFactory;
        this.winnerPolicy = winnerPolicy;
    }

    public void play(Board board) {



    }
}
