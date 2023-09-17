package org.example.card;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;
import org.example.square.corner.JailSquare;

public class JailCard implements Card {
    @Override
    public void doCard(Player player) {
        doMessage(player);
        System.out.println("They goes to jail");
        player.setCurrentSquare(7);
        doSquareAgain(player);
    }
}
