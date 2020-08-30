package com.boardgames.snakesandladders.behaviour;

import com.boardgames.snakesandladders.model.Player;

import java.util.List;

public interface IWinnerPolicy {

    Player checkAndGetWinner(List<Player> players);
}
