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

        if (counter < rollLimit) {
            rolls.add(knockedPins);
        }
        if (counter == 18 && knockedPins == 10) {
            rollLimit += 2;
        }else if (counter == 19 && rolls.get(18) + knockedPins == 10) {
            rollLimit++;
        }
        counter++;
    }

    public int score() {

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                frameIndex++;
            } else if (isSpare(frameIndex)) {
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

    private boolean isStrike(int frameIndex) {
        if (rolls.get(frameIndex) == 10) {
            score += 10 + rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
            return true;
        } else
            return false;
    }

    private boolean isSpare(int frameIndex) {
        if (rolls.get(frameIndex) + rolls.get(frameIndex + 1) == 10) {
            score += 10 + rolls.get(frameIndex + 2);
            return true;
        } else
            return false;
    }

}
