package org.example;

import org.example.square.chance.ChanceSquareImplementation;
import org.example.square.corner.*;
import org.example.square.realestate.RealEstateSquare;
import org.example.square.Square;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Map<String, Square> GAME_MAP = new HashMap<>();
    public static int roundCounter;

    static {
        GAME_MAP.put("1", new StartSquare());
        GAME_MAP.put("2", new RealEstateSquare());
        GAME_MAP.put("3", new RealEstateSquare());
        GAME_MAP.put("4", new ChanceSquareImplementation());
        GAME_MAP.put("5", new RealEstateSquare());
        GAME_MAP.put("6", new RealEstateSquare());
        GAME_MAP.put("7", new JailSquare());
        GAME_MAP.put("8", new RealEstateSquare());
        GAME_MAP.put("9", new RealEstateSquare());
        GAME_MAP.put("10", new ChanceSquareImplementation());
        GAME_MAP.put("11", new RealEstateSquare());
        GAME_MAP.put("12", new RealEstateSquare());
        GAME_MAP.put("13", new PoliceSquare());
        GAME_MAP.put("14", new RealEstateSquare());
        GAME_MAP.put("15", new RealEstateSquare());
        GAME_MAP.put("16", new ChanceSquareImplementation());
        GAME_MAP.put("17", new RealEstateSquare());
        GAME_MAP.put("18", new RealEstateSquare());
        GAME_MAP.put("19", new PayingTaxesSquare());
        GAME_MAP.put("20", new RealEstateSquare());
        GAME_MAP.put("21", new RealEstateSquare());
        GAME_MAP.put("22", new ChanceSquareImplementation());
        GAME_MAP.put("23", new RealEstateSquare());
        GAME_MAP.put("24", new RealEstateSquare());
    }

    public static void main(String[] args) {

        System.out.println("Enter players' names. Once you're done type start");

        List<Player> playerList = new ArrayList<>();

        initPlayers(playerList);

        while (true) {
            if (playerList.isEmpty()) {
                break;
            }
            roundCounter++;
            playerList.forEach(player -> {
                returnPlayerToGame(player);
                if (!player.isAvailable()) {
                    return;
                }
                player.rollDice();
                Square square = GAME_MAP.get("" + player.getCurrentSquare());
                square.doSquare(player);
            });
        }


    }

    private static void initPlayers(List<Player> playerList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Player player = new Player();
            String response = scanner.nextLine();
            if (response.equals("start")) {
                break;
            }
            player.setName(response);
            playerList.add(player);
        }
        scanner.close();
    }

    private static void returnPlayerToGame(Player player) {
        if (roundCounter - player.getBannedRound() == player.getBanTime()) {
            player.setAvailable(true);
        }
    }

}