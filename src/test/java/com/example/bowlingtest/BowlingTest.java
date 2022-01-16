package com.example.bowlingtest;

import com.example.bowlinggame.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @Test
    void gutterBallShouldReturnScoreZero() {
        Game game = new Game();

        game.roll(0);

        assertEquals(0, game.score());
    }

    @Test
    void singlePinKnockedShouldGiveScoreOne() {
        Game game = new Game();

        game.roll(1);

        assertEquals(1, game.score());
    }

    @Test
    void scoreShouldReturnSumOfTwoRolls() {
        Game game = new Game();

        game.roll(2);
        game.roll(3);

        assertEquals(5, game.score());
    }

    @Test
    void scoreShouldReturnSumOfAMultipleRolls() {
        Game game = new Game();

        game.multipleRolls(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void shouldReturnPointsOfASpareInFullSeries() {
        Game game = new Game();

        game.roll(3);
        game.roll(7);
        game.roll(5);
        game.multipleRolls(17,0);

        assertEquals(20, game.score());
    }
}
