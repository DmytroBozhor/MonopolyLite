package org.example.card;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;

public interface Card {
    void doCard(Player player);

    default void doMessage(Player player){
        System.out.println("Player {$player} got {$cardName} card."
                .replace("{$player}", player.getName())
                .replace("{$cardName}", this.getClass().getSimpleName()));
    }

    default void doSquareAgain(Player player){
        Square square = Main.GAME_MAP.get("" + player.getCurrentSquare());
        square.doSquare(player);
    }
}
