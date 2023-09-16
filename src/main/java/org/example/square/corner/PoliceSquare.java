package org.example.square.corner;

import org.example.Player;

public class PoliceSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        player.setCurrentSquare(7);
        System.out.println("Player goes to jail.");
        new JailSquare().doSquare(player);
    }
}
