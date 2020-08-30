package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.enums.PlayerType;
import com.boardgames.snakesandladders.model.Dice.ComputerMove;
import com.boardgames.snakesandladders.model.Dice.Dice;

public class PlayerMoveFactory {
    Dice dice;
    ComputerMove computerMove;

    public PlayerMoveFactory(Dice dice, ComputerMove computerMove) {
        this.dice = dice;
        this.computerMove = computerMove;
    }

    public Integer getMoveBasedOnPlayerType(PlayerType playerType) {
        if (PlayerType.HUMAN.equals(playerType))
            return dice.getRandomMove();
        else
            return computerMove.getRandomMove();
    }
}
