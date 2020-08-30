package com.boardgames.snakesandladders.model;

import com.boardgames.snakesandladders.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

    private PlayerType playerType;
    private String name;
    private Cell position;
    private boolean isOpen;
}
