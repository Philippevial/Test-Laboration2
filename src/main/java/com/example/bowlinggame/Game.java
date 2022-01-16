package com.example.bowlinggame;

public class Game {
    private int score;

    public void roll(int knockedPins) {
        score += knockedPins;
    }

    public int score() {
        return score;
    }
}
