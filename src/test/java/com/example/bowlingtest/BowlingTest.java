package com.example.bowlingtest;

import com.example.bowlinggame.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @Test
    void gutterBallShouldReturnScoreZero() {
        Game game = new Game();

        game.roll(0);
        int result = game.score();

        assertEquals(0, result);
    }

    @Test
    void singlePinKnockedShouldGiveScoreOne() {
        Game game = new Game();

        game.roll(1);
        int result = game.score();

        assertEquals(1, result);
    }
}
