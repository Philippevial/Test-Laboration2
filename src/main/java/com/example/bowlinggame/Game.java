package com.example.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();
    int score = 0;
    int rollLimit = 20;
    int frameIndex = 0;
    int counter = 0;

    public void roll(int knockedPins) {

        if (rolls.size() <= rollLimit) {
            rolls.add(knockedPins);
            counter++;
        } else if (isStrike(counter)) {
            rollLimit++;
            roll(knockedPins);

        }

    }

    public int score() {

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
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
        score += rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }

    private void spareBonus(int frameIndex) {
        score += 10 + rolls.get(frameIndex + 2);
    }

    private boolean isStrike(int frameIndex) {
        if (rolls.get(frameIndex) == 10) {
            score += 10 + rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
            return true;
        } else
            return false;
    }

    private boolean isSpare(int frameIndex) {

        if (rolls.get(frameIndex) + rolls.get(frameIndex + 1) == 10) return true;
        else return false;
    }

}
