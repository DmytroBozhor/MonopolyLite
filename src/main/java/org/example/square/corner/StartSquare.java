package org.example.square.corner;

import org.example.Player;

public class StartSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        System.out.println("Player finished the circle which gives him +500$.");
        player.setMoney(player.getMoney() + 500);
    }
}
