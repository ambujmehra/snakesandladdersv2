package com.boardgames.snakesandladders.model;

import com.boardgames.snakesandladders.behaviour.IBoardStrategy;
import com.boardgames.snakesandladders.enums.PlayerType;
import com.boardgames.snakesandladders.model.Dice.Dice;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Board {

    private Map<Integer,Cell> cells;
    private List<Player> players;
    private Map<Cell, Piece> pieceMap;
    private IBoardStrategy iBoardStrategy;

    @Getter
    @Setter
    public static class Builder {
        private Map<Integer,Cell> cells;
        private List<Player> players;
        private Map<Cell, Piece> pieceMap;
        private IBoardStrategy iBoardStrategy;

        public Builder makeCells() {
            this.cells = new HashMap<>();
            for (int i = 1; i <=100; i++) {
                this.cells.put(i, new Cell(i));
            }
            return this;
        }

        public Builder addPlayers(int count) {
            this.players = new ArrayList<>();
            PlayerType playerType = PlayerType.HUMAN;
            for (int i=0;i<count;i++) {
                this.players.add(new Player(playerType, "Player" + i, cells.get(1), false));
                playerType = PlayerType.COMPUTER;
            }
            return this;
        }

        public Builder setPieces() {
            this.pieceMap =new HashMap<>();
            return this;
        }

        public Builder setStrategy(IBoardStrategy iBoardStrategy) {
            this.iBoardStrategy = iBoardStrategy;
            return this;
        }


        public Board build() {

            return new Board(this);
        }

        public int getRandomCell() {
            Random r = new Random();
            int Low = 5;
            int High = 95;
            return r.nextInt(High - Low) + Low;
        }
    }

    private Board(Builder builder) {
        cells = builder.getCells();
        players = builder.getPlayers();
        pieceMap = builder.pieceMap;
        iBoardStrategy = builder.iBoardStrategy;
    }



}
