package org.example.square.corner;

import org.example.Main;
import org.example.Player;

import java.util.Random;

public class JailSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        player.setAvailable(false);
        int randomValue = new Random().nextInt(2, 5);
        player.setBanTime(randomValue);
        player.setBannedRound(Main.roundCounter);
        System.out.println("Player {$player} goes to jail. They skip {$value} next round(-s)."
                .replace("{$player}", player.getName())
                .replace("{$value}", "" + (randomValue - 1)));
    }
}
