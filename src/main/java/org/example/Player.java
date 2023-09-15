package org.example;

import java.util.Random;

public class Player {

    private String name;
    private int currentSquare;

    public Player() {
    }

    public Player(String name, int currentSquare) {
        this.name = name;
        this.currentSquare = currentSquare;
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

    public void rollDice() {
        int diceNumber = new Random().nextInt(0, 7);
        System.out.println("Player {$player} got {$diceNumber}"
                .replace("{$player}", getName())
                .replace("{$diceNumber}", String.valueOf(diceNumber)));
        this.increaseCurrentSquare(diceNumber);
    }

    private void increaseCurrentSquare(int diceNumber){
        this.setCurrentSquare(this.getCurrentSquare() + diceNumber);
        if (this.getCurrentSquare() > 24){
            this.setCurrentSquare(32 - this.getCurrentSquare());
        }
    }
}
