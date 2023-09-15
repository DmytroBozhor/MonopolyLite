package org.example;

import org.example.square.ChanceSquare;
import org.example.square.CornerSquare;
import org.example.square.RealEstateSquare;
import org.example.square.Square;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Map<String, Square> gameMap = new HashMap<>();

    static {
        gameMap.put("1", new CornerSquare());
        gameMap.put("2", new RealEstateSquare());
        gameMap.put("3", new RealEstateSquare());
        gameMap.put("4", new ChanceSquare());
        gameMap.put("5", new RealEstateSquare());
        gameMap.put("6", new RealEstateSquare());
        gameMap.put("7", new CornerSquare());
        gameMap.put("8", new RealEstateSquare());
        gameMap.put("9", new RealEstateSquare());
        gameMap.put("10", new ChanceSquare());
        gameMap.put("11", new RealEstateSquare());
        gameMap.put("12", new RealEstateSquare());
        gameMap.put("13", new CornerSquare());
        gameMap.put("14", new RealEstateSquare());
        gameMap.put("15", new RealEstateSquare());
        gameMap.put("16", new ChanceSquare());
        gameMap.put("17", new RealEstateSquare());
        gameMap.put("18", new RealEstateSquare());
        gameMap.put("19", new CornerSquare());
        gameMap.put("20", new RealEstateSquare());
        gameMap.put("21", new RealEstateSquare());
        gameMap.put("22", new ChanceSquare());
        gameMap.put("23", new RealEstateSquare());
        gameMap.put("24", new RealEstateSquare());
    }

    public static void main(String[] args) {

        System.out.println("Enter players' names. Once you're done type start");

        List<Player> playerList = new ArrayList<>();

        initPlayers(playerList);

        playerList.forEach(player -> System.out.println(player.getName()));


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

}