package org.example.square.realestate;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;

import java.util.Scanner;

public interface RealEstateSquare extends Square {
    default void doSquare(Player player){
        Square currentBusinessSquare = Main.GAME_MAP.get("" + player.getCurrentSquare());
        if (Main.AVAILABLE_BUSINESSES.contains(currentBusinessSquare)) {
            System.out.println("This square is available for purchasing.");
            System.out.println("1 - to buy 2 - not to buy");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String response = scanner.nextLine();
                if (response.equals("1")) {
                    Main.AVAILABLE_BUSINESSES.remove(currentBusinessSquare);
                    Main.BOUGHT_BUSINESSES.put(currentBusinessSquare, player);
                    break;
                } else if (response.equals("2")) {
                    System.out.println("Player {$player} decided not to buy the square."
                            .replace("{$player}", player.getName()));
                    break;
                } else {
                    System.out.println("Answer was not recognized. Try again!");
                }
            }
            scanner.close();
        } else {
            Player squareOwnerPlayer = Main.BOUGHT_BUSINESSES.get(currentBusinessSquare);
            Integer squareTax = Main.SQUARE_TAXES.get(currentBusinessSquare);
            squareOwnerPlayer.setMoney(squareOwnerPlayer.getMoney() + squareTax);
            player.setMoney(player.getMoney() - squareTax);
        }
    }
}
