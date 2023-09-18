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
    public static final Map<String, Square> GAME_MAP = new HashMap<>();
    public static final List<Square> AVAILABLE_BUSINESSES = new ArrayList<>();
    public static final Map<Square, Player> BOUGHT_BUSINESSES = new HashMap<>();
    public static final Map<Square, Integer> SQUARE_TAXES = new HashMap<>(); //// replace with field in estate squares classes
    public static final Map<Square, Integer> SQUARE_PRICES = new HashMap<>(); // replace with field in estate squares classes
    public static final List<Player> PLAYER_LIST = new ArrayList<>();
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

        AVAILABLE_BUSINESSES.add(GAME_MAP.get("2"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("3"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("5"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("6"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("8"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("9"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("11"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("12"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("14"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("15"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("17"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("18"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("20"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("21"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("23"));
        AVAILABLE_BUSINESSES.add(GAME_MAP.get("24"));

        SQUARE_TAXES.put(GAME_MAP.get("2"), 150);
        SQUARE_TAXES.put(GAME_MAP.get("3"), 180);
        SQUARE_TAXES.put(GAME_MAP.get("5"), 140);
        SQUARE_TAXES.put(GAME_MAP.get("6"), 160);
        SQUARE_TAXES.put(GAME_MAP.get("8"), 200);
        SQUARE_TAXES.put(GAME_MAP.get("9"), 220);
        SQUARE_TAXES.put(GAME_MAP.get("11"), 150);
        SQUARE_TAXES.put(GAME_MAP.get("12"), 130);
        SQUARE_TAXES.put(GAME_MAP.get("14"), 150);
        SQUARE_TAXES.put(GAME_MAP.get("15"), 150);
        SQUARE_TAXES.put(GAME_MAP.get("17"), 170);
        SQUARE_TAXES.put(GAME_MAP.get("18"), 180);
        SQUARE_TAXES.put(GAME_MAP.get("20"), 200);
        SQUARE_TAXES.put(GAME_MAP.get("21"), 210);
        SQUARE_TAXES.put(GAME_MAP.get("23"), 170);
        SQUARE_TAXES.put(GAME_MAP.get("24"), 140);

        SQUARE_PRICES.put(GAME_MAP.get("2"), 1500);
        SQUARE_PRICES.put(GAME_MAP.get("3"), 1700);
        SQUARE_PRICES.put(GAME_MAP.get("5"), 1300);
        SQUARE_PRICES.put(GAME_MAP.get("6"), 1400);
        SQUARE_PRICES.put(GAME_MAP.get("8"), 1800);
        SQUARE_PRICES.put(GAME_MAP.get("9"), 1900);
        SQUARE_PRICES.put(GAME_MAP.get("11"), 1200);
        SQUARE_PRICES.put(GAME_MAP.get("12"), 1100);
        SQUARE_PRICES.put(GAME_MAP.get("14"), 1700);
        SQUARE_PRICES.put(GAME_MAP.get("15"), 1500);
        SQUARE_PRICES.put(GAME_MAP.get("17"), 1500);
        SQUARE_PRICES.put(GAME_MAP.get("18"), 1600);
        SQUARE_PRICES.put(GAME_MAP.get("20"), 1300);
        SQUARE_PRICES.put(GAME_MAP.get("21"), 1700);
        SQUARE_PRICES.put(GAME_MAP.get("23"), 1900);
        SQUARE_PRICES.put(GAME_MAP.get("24"), 1300);
    }

    public static void main(String[] args) {

        System.out.println("Enter players' names. Once you're done type start");

        initPlayers();

        while (true) {
            if (PLAYER_LIST.size() == 1) {
                System.out.println("Player {$name} win!!!"
                        .replace("{$name}", "" + PLAYER_LIST.get(0).getName()));
                break;
            }
            roundCounter++;
            PLAYER_LIST.forEach(player -> {
                returnPlayerToGame(player);
                if (!player.isAvailable()) {
                    return;
                }
                checkBalanceOrRoll(player);
                Square square = GAME_MAP.get("" + player.getCurrentSquare());
                square.doSquare(player);
            });
        }


    }

    private static void checkBalanceOrRoll(Player player) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Roll dice - 1. Check balance - 2.");
            String response = scanner.nextLine();
            if (response.equals("1")) {
                player.rollDice();
                break;
            } else if (response.equals("2")) {
                System.out.println("{$Player}'s balance is {$balance}"
                        .replace("{$Player}", player.getName())
                        .replace("{$balance}", "" + player.getMoney()));
            } else {
                System.out.println("Command not recognized");
            }
        }
    }

    private static void initPlayers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Player player = new Player();
            String response = scanner.nextLine();
            if (response.equals("start")) {
                break;
            }
            player.setName(response);
            PLAYER_LIST.add(player);
        }
//        scanner.close();
    }

    private static void returnPlayerToGame(Player player) {
        if (roundCounter - player.getBannedRound() == player.getBanTime()) {
            player.setAvailable(true);
        }
    }

}