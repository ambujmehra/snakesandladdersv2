package com.boardgames.snakesandladders;

import com.boardgames.snakesandladders.enums.PlayerType;
import com.boardgames.snakesandladders.model.Cell;
import com.boardgames.snakesandladders.model.Player;
import com.boardgames.snakesandladders.service.WinnerPolicyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnerPolicyServiceImplTest {

    WinnerPolicyServiceImpl winnerPolicyService = new WinnerPolicyServiceImpl();
    List<Player> players;
    @Before
    public void setup() {
        players = new ArrayList<>();
        players.add(new Player(PlayerType.COMPUTER, "A", new Cell(8), true));
        players.add(new Player(PlayerType.HUMAN, "B", new Cell(50), true));
        players.add(new Player(PlayerType.HUMAN, "C", new Cell(99), true));
    }

    @Test
    public void testNoWinner() {
        Player winner = winnerPolicyService.checkAndGetWinner(players);
        Assert.assertNull(winner);
    }

    @Test
    public void testWinner() {
        players.get(0).setPosition(new Cell(100));
        Player winner = winnerPolicyService.checkAndGetWinner(players);
        Assert.assertNotNull(winner);
        Assert.assertEquals(winner.getName(),"A");
    }


}
