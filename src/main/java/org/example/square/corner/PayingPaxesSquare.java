package org.example.square.corner;

import org.example.Player;

import java.util.Random;

public class PayingPaxesSquare implements CornerSquare {
    @Override
    public void doSquare(Player player) {
        int randomValue = new Random().nextInt(100, 1000);
        player.setMoney(player.getMoney() - randomValue);
        System.out.println("Player needs to pay some taxes. It will take him {$value}$"
                .replace("{$value}", "" + randomValue));
    }
}
