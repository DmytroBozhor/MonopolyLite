package org.example.square.corner;

import org.example.Main;
import org.example.Player;

import java.util.Random;

public class JailSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        player.setAvailable(false);
        int randomValue = new Random().nextInt(1, 3);
        player.setBanTime(randomValue);
        player.setBannedRound(Main.roundCounter);
        System.out.println("Player goes to jail. They skip {$value} next round(-s)."
                .replace("{$value}", "" + randomValue));
    }
}
