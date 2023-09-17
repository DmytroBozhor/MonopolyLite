package org.example.square.corner;

import org.example.Player;

public class PoliceSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        player.setCurrentSquare(7);
        System.out.println("Player {$player} goes to jail."
                .replace("{$player}", player.getName()));
        new JailSquare().doSquare(player);
    }
}
