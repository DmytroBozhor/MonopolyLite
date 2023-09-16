package org.example.card;

import org.example.Player;
import org.example.square.corner.JailSquare;

public class JailCard implements Card{
    @Override
    public void doCard(Player player) {
        player.setCurrentSquare(7);
        new JailSquare().doSquare(player);
    }
}
