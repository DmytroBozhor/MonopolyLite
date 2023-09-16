package org.example.card;

import org.example.Player;
import org.example.square.corner.PayingTaxesSquare;

public class PayingTaxesCard implements Card{
    @Override
    public void doCard(Player player) {
        player.setCurrentSquare(19);
        new PayingTaxesSquare().doSquare(player);
    }
}
