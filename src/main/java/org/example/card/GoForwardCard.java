package org.example.card;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;

import java.util.Random;

public class GoForwardCard implements Card {
    @Override
    public void doCard(Player player) {
        doMessage(player);
        int steps = new Random().nextInt(1, 5);
        System.out.println("They go {$value} step(-s) forward"
                .replace("{$value}", "" + steps));
        player.increaseCurrentSquare(steps);
        doSquareAgain(player);
    }
}
