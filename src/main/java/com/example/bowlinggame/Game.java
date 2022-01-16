package com.example.bowlinggame;

public class Game {
    private int score;
    private final int[] rolls = new int[21];
    private int currentRoll;


    public void roll(int knockedPins) {
        rolls[currentRoll++] = knockedPins;
    }

    public int score() {
        int index = 0;

        for (int i = 0; i < 10; i++) {
            if(rolls[index] + rolls[index + 1] == 10) {
                score += 10 + rolls[index + 2];
                index += 2;
            } else {
                score += rolls[index] + rolls[index + 1];
                index += 2;
            }
        }
        return score;
    }


    public void multipleRolls(int roll, int knockedPins) {
        for (int i = 0; i < roll; i++) {
            score += knockedPins;
        }
    }
}
