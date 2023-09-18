package org.example.square.realestate;

import org.example.Main;
import org.example.Player;
import org.example.square.Square;

import java.util.*;

public interface RealEstateSquare extends Square {
    default void doSquare(Player player) {
        Square currentBusinessSquare = Main.GAME_MAP.get("" + player.getCurrentSquare());
        Scanner scanner = new Scanner(System.in);
        if (Main.AVAILABLE_BUSINESSES.contains(currentBusinessSquare)) {
            buyBusinessOrGoPast(player, currentBusinessSquare, scanner);
        } else {
            paySquareTaxOrLose(player, currentBusinessSquare, scanner);
        }
    }

    private static void paySquareTaxOrLose(Player player, Square currentBusinessSquare, Scanner scanner) {
        Player squareOwnerPlayer = Main.BOUGHT_BUSINESSES.get(currentBusinessSquare);
        Integer squareTax = Main.SQUARE_TAXES.get(currentBusinessSquare);
        System.out.println("Pay - 1. Sell businesses - 2.");
        while (true) {
            String response = scanner.nextLine();
            if (response.equals("1")) {
                if (player.getMoney() > squareTax) {
                    transferMoney(player, squareOwnerPlayer, squareTax);
                    break;
                } else {
                    System.out.println("Not enough money");
                }
            } else if (response.equals("2")) {
                List<Square> playerBusinesses = getBusinessListOrPlayerLosesIfEmpty(player);
                if (playerBusinesses == null) break;
                System.out.println("Choose business to sell: ");
                playerBusinesses.forEach(square -> System.out.println((playerBusinesses.indexOf(square)) +
                        ": " + square.getClass().getSimpleName() + " - " + squareTax));
                sellBusinessTillFinished(player, scanner, playerBusinesses);
            }
        }
    }

    private static void sellBusinessTillFinished(Player player, Scanner scanner, List<Square> playerBusinesses) {
        System.out.println("Type exit if you're done");
        while (true) {
            String response2 = scanner.nextLine();
            if (response2.equals("exit")) {
                break;
            }
            try {
                sellBusiness(player, playerBusinesses, response2);
            } catch (Exception e) {
                System.out.println("Business not found");
            }
        }
    }

    private static void buyBusinessOrGoPast(Player player, Square currentBusinessSquare, Scanner scanner) {
        System.out.println("This square is available for purchasing. \n 1 - to buy 2 - sell my businesses 3 - not to buy");
        while (true) {
            String response = scanner.nextLine();
            if (response.equals("1")) {
                int currentSquarePrice = Main.SQUARE_PRICES.get(currentBusinessSquare);
                if (player.getMoney() >= currentSquarePrice) {
                    buyBusiness(player, currentBusinessSquare, currentSquarePrice);
                    break;
                } else {
                    System.out.println("Not enough money");
                }
            } else if (response.equals("2")) {
                // implement selling a business
            } else if (response.equals("3")) {
                System.out.println("Player {$player} decided not to buy the square."
                        .replace("{$player}", player.getName()));
                break;
            } else {
                System.out.println("Answer was not recognized. Try again!");
            }
        }
    }

    private static void sellBusiness(Player player, List<Square> playerBusinesses, String response2) {
        Main.AVAILABLE_BUSINESSES.add(playerBusinesses.get(Integer.parseInt(response2)));
        Main.BOUGHT_BUSINESSES.remove(playerBusinesses.get(Integer.parseInt(response2)));
        player.setMoney(player.getMoney() + Main.SQUARE_PRICES.get(playerBusinesses.get(Integer.parseInt(response2))));
    }

    private static List<Square> getBusinessListOrPlayerLosesIfEmpty(Player player) {
        Set<Map.Entry<Square, Player>> entrySet = Main.BOUGHT_BUSINESSES.entrySet();
        List<Square> playerBusinesses = entrySet.stream()
                .filter(squarePlayerEntry -> squarePlayerEntry.getValue() == player)
                .map(Map.Entry::getKey)
                .toList();
        if (playerBusinesses.isEmpty()) {
            System.out.println("Player {$player} loses because they do not have enough money."
                    .replace("{$player}", player.getName()));
            Main.PLAYER_LIST.remove(player);
            return null;
        }
        return playerBusinesses;
    }

    private static void transferMoney(Player player, Player squareOwnerPlayer, Integer squareTax) {
        player.setMoney(player.getMoney() - squareTax);
        squareOwnerPlayer.setMoney(squareOwnerPlayer.getMoney() + squareTax);
    }

    private static void buyBusiness(Player player, Square currentBusinessSquare, int currentSquarePrice) {
        player.setMoney(player.getMoney() - currentSquarePrice);
        Main.AVAILABLE_BUSINESSES.remove(currentBusinessSquare);
        Main.BOUGHT_BUSINESSES.put(currentBusinessSquare, player);
        System.out.println("Player {$player} bought {$squareName} square"
                .replace("{$player}", player.getName())
                .replace("{$squareName}", currentBusinessSquare.getClass().getSimpleName()));
    }
}
