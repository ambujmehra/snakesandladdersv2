package com.boardgames.snakesandladders.service;

import com.boardgames.snakesandladders.behaviour.IGamePlay;
import com.boardgames.snakesandladders.model.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    //TODO :: decoupling
    private Board board;
    private IGamePlay iGamePlay;

    public void playGame() {
        iGamePlay.play(this.board);
    }

}
