package org.example.card;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;
import org.example.square.corner.PoliceSquare;

public class PoliceCard implements Card {
    @Override
    public void doCard(Player player) {
        doMessage(player);
        player.setCurrentSquare(13);
        doSquareAgain(player);
    }
}
