package com.example.bowlinggame;

public class Game {
    private final int[] rolls = new int[21];
    int score = 0;
    private int currentRoll;


    public void roll(int knockedPins) {
        rolls[currentRoll++] = knockedPins;
    }

    public int score() {
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                frameScore(frameIndex);
                frameIndex += 2;
            }

        }
        return score;
    }

    private void frameScore(int frameIndex) {
        score += rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private void spareBonus(int frameIndex) {
        score += 10 + rolls[frameIndex + 2];
    }

    private void strikeBonus(int frameIndex) {
        score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    public void multipleRolls(int roll, int knockedPins) {
        for (int i = 0; i < roll; i++) {
            roll(knockedPins);
        }
    }

}
