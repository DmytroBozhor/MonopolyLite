package org.example.square.corner;

import org.example.Player;

public class StartSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        System.out.println("Player {$player} finished the circle which gives him +500$."
                .replace("{$player}", player.getName()));
        player.setMoney(player.getMoney() + 500);
    }
}
