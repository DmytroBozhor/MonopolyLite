package org.example.card;

import org.example.Player;
import org.example.square.corner.PoliceSquare;

public class PoliceCard implements Card {
    @Override
    public void doCard(Player player) {
        player.setCurrentSquare(13);
        new PoliceSquare().doSquare(player);
    }
}
