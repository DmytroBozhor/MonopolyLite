package org.example.card;

import org.example.Player;
import org.example.square.corner.StartSquare;

public class StartCard implements Card {
    @Override
    public void doCard(Player player) {
        player.setCurrentSquare(1);
        new StartSquare().doSquare(player);
    }
}
