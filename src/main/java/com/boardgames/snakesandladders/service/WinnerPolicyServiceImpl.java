package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IWinnerPolicy;
import com.boardgames.snakesandladders.model.Player;

import java.util.List;

public class WinnerPolicyServiceImpl implements IWinnerPolicy {

    @Override
    public Player checkAndGetWinner(List<Player> players) {
        Player winner = null;
        for (int i=0;i< players.size();i++) {
            if (players.get(i).getPosition().getPosition().equals(100)) {
                winner = players.get(i);
                break;
            }
        }
        return winner;
    }
}
