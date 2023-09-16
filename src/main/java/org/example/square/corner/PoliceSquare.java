package org.example.square.corner;

import org.example.Player;

public class PoliceSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        player.setCurrentSquare(7);
        new JailSquare().doSquare(player);
        System.out.println("Player goes to jail.");
    }
}
