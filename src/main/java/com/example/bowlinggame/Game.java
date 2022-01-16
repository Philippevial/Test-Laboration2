package com.example.bowlinggame;

public class Game {
    private int score;

    public void roll(int knockedPins) {
            score += knockedPins;
    }

    public int score() {
        return score;
    }


    public void fullSeries(int rolls, int knockedPins) {
        for (int i = 0; i < rolls; i++) {
            score += knockedPins;
        }
    }
}
