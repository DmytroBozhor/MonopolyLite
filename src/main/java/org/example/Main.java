package org.example;

import org.example.square.chance.ChanceSquareImplementation;
import org.example.square.corner.*;
import org.example.square.Square;
import org.example.square.realestate.car.BMW;
import org.example.square.realestate.car.Ferrari;
import org.example.square.realestate.car.Lexus;
import org.example.square.realestate.car.Toyota;
import org.example.square.realestate.clothing.Bershka;
import org.example.square.realestate.clothing.Gucci;
import org.example.square.realestate.clothing.Prada;
import org.example.square.realestate.clothing.Zara;
import org.example.square.realestate.phone.IPhone;
import org.example.square.realestate.phone.Nokia;
import org.example.square.realestate.phone.Samsung;
import org.example.square.realestate.phone.Xiaomi;
import org.example.square.realestate.restaurant.BurgerKing;
import org.example.square.realestate.restaurant.KFC;
import org.example.square.realestate.restaurant.Kebab;
import org.example.square.realestate.restaurant.McDonald;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Map<String, Square> GAME_MAP = new HashMap<>();
    public static int roundCounter;

    static {
        GAME_MAP.put("1", new StartSquare());
        GAME_MAP.put("2", new BMW());
        GAME_MAP.put("3", new Ferrari());
        GAME_MAP.put("4", new ChanceSquareImplementation());
        GAME_MAP.put("5", new Lexus());
        GAME_MAP.put("6", new Toyota());
        GAME_MAP.put("7", new JailSquare());
        GAME_MAP.put("8", new Bershka());
        GAME_MAP.put("9", new Gucci());
        GAME_MAP.put("10", new ChanceSquareImplementation());
        GAME_MAP.put("11", new Prada());
        GAME_MAP.put("12", new Zara());
        GAME_MAP.put("13", new PoliceSquare());
        GAME_MAP.put("14", new IPhone());
        GAME_MAP.put("15", new Nokia());
        GAME_MAP.put("16", new ChanceSquareImplementation());
        GAME_MAP.put("17", new Samsung());
        GAME_MAP.put("18", new Xiaomi());
        GAME_MAP.put("19", new PayingTaxesSquare());
        GAME_MAP.put("20", new BurgerKing());
        GAME_MAP.put("21", new Kebab());
        GAME_MAP.put("22", new ChanceSquareImplementation());
        GAME_MAP.put("23", new KFC());
        GAME_MAP.put("24", new McDonald());
    }

    public static void main(String[] args) {

        System.out.println("Enter players' names. Once you're done type start");

        List<Player> playerList = new ArrayList<>();

        initPlayers(playerList);

        while (true) {
            if (playerList.size() == 1) {
                System.out.println("Player {$name} win!!!"
                        .replace("{$name}", "" + playerList.get(0)));
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