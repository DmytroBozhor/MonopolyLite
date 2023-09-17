package org.example;

import java.util.Random;

public class Player {

    private String name;
    private int currentSquare = 1;
    private int money = 5000;
    private boolean available;
    private int bannedRound;
    private int banTime;

    public Player() {
    }

    public Player(String name, int currentSquare, int money, boolean available, int bannedRound, int banTime) {
        this.name = name;
        this.currentSquare = currentSquare;
        this.money = money;
        this.available = available;
        this.bannedRound = bannedRound;
        this.banTime = banTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(int currentSquare) {
        this.currentSquare = currentSquare;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBannedRound() {
        return bannedRound;
    }

    public void setBannedRound(int bannedRound) {
        this.bannedRound = bannedRound;
    }

    public int getBanTime() {
        return banTime;
    }

    public void setBanTime(int banTime) {
        this.banTime = banTime;
    }

    public void rollDice() {
        int diceNumber = new Random().nextInt(1, 7);
        System.out.println("Player {$player} got {$diceNumber}"
                .replace("{$player}", getName())
                .replace("{$diceNumber}", String.valueOf(diceNumber)));
        this.increaseCurrentSquare(diceNumber);
    }

    public void increaseCurrentSquare(int diceNumber) {
        this.setCurrentSquare(this.getCurrentSquare() + diceNumber);
        if (this.getCurrentSquare() > 24) {
            this.setCurrentSquare(this.getCurrentSquare() - 24);
        }
    }
}
