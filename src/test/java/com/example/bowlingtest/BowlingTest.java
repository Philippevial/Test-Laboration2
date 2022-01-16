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
    void shouldReturnPointsOfOneSpareWithBonusInFullSeries() {
        Game game = new Game();

        game.roll(1);
        game.roll(9);
        game.roll(5);
        game.multipleRolls(17,0);

        assertEquals(20, game.score());
    }

    @Test
    void shouldReturnPointsOfOneStrikeWithBonusInMultipleRolls() {
        Game game = new Game();

        game.roll(10);
        game.roll(7);
        game.roll(1);
        game.multipleRolls(16,0);

        assertEquals(26, game.score());
    }

    @Test
    void shouldReturnCorrectBonusWhenTwoStrikesIsRolledInARow() {
        Game game = new Game();

        game.roll(10);
        game.roll(10);
        game.roll(9);
        game.roll(0);
        game.multipleRolls(16,0);

        assertEquals(57, game.score());
    }

    @Test
    void shouldReturnCorrectBonusWhenThreeStrikesIsRolledInARow() {
        Game game = new Game();

        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(0);
        game.roll(9);
        game.multipleRolls(15,0);

        assertEquals(78, game.score());
    }
}
