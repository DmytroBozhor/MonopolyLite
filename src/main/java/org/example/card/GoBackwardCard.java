package org.example.card;

import org.example.Player;

import java.util.Random;

public class GoBackwardCard implements Card {
    @Override
    public void doCard(Player player) {
        player.increaseCurrentSquare(-new Random().nextInt(0, 5));
    }
}
