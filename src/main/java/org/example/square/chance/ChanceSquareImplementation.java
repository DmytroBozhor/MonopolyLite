package org.example.square.chance;

import org.example.Player;
import org.example.card.*;

import java.util.HashMap;
import java.util.Map;

public class ChanceSquareImplementation implements ChanceSquare {
    private static int cardNumber = 1;

    private static final Map<String, Card> GAME_CARDS = new HashMap<>();

    static {
        GAME_CARDS.put("1", new GoBackwardCard());
        GAME_CARDS.put("2", new JailCard());
        GAME_CARDS.put("3", new StartCard());
        GAME_CARDS.put("4", new GoForwardCard());
        GAME_CARDS.put("5", new PayingTaxesCard());
        GAME_CARDS.put("6", new PoliceCard());
    }

    @Override
    public void doSquare(Player player) {
        GAME_CARDS.get("" + cardNumber).doCard(player);
        increaseCardNumber();
    }

    private static void increaseCardNumber() {
        cardNumber++;
        if (cardNumber > GAME_CARDS.size()) {
            cardNumber = cardNumber - 6;
        }
    }
}
