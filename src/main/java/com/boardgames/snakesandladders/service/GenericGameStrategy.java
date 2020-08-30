package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IGamePlay;
import com.boardgames.snakesandladders.behaviour.IWinnerPolicy;
import com.boardgames.snakesandladders.model.Board;
import com.boardgames.snakesandladders.model.Player;

public class GenericGameStrategy implements IGamePlay {

    private PlayerMoveFactory playerMoveFactory;

    private IWinnerPolicy winnerPolicy;

    public GenericGameStrategy(PlayerMoveFactory playerMoveFactory, IWinnerPolicy winnerPolicy) {
        this.playerMoveFactory = playerMoveFactory;
        this.winnerPolicy = winnerPolicy;
    }

    public void play(Board board) {
        boolean gameFlag = true;
        while (gameFlag) {
            for (Player player : board.getPlayers()) {
                Integer move = playerMoveFactory.getMoveBasedOnPlayerType(player.getPlayerType());
                board.makePlayerMove(player, move);
                if (winnerPolicy.checkIfPlayerWon(player)) {
                    System.out.println("Winner is - " + player.getName());
                    gameFlag = false;
                    break;
                }
            }
        }
    }
}
