package com.example.bowlingtest;

import com.example.bowlinggame.Game;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {
    Game game = new Game();

    private void fullSeries(int roll, int knockedPins) {
        for (int i = 0; i < roll; i++) {
            game.roll(knockedPins);
        }
    }

    @Test
    void gutterBallShouldReturnScoreZero() {
        game.roll(0);
        fullSeries(19,0);

        assertEquals(0, game.score());
    }

    @Test
    void singlePinKnockedShouldGiveScoreOne() {
        game.roll(1);
        fullSeries(19,0);

        assertEquals(1, game.score());
    }

    @Test
    void scoreShouldReturnSumOfTwoRolls() {
        game.roll(2);
        game.roll(3);
        fullSeries(18,0);


        assertEquals(5, game.score());
    }

    @Test
    void scoreShouldReturnSumOfAMultipleRolls() {
        fullSeries(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    void shouldReturnPointsOfOneSpareWithBonusInFullSeries() {
        game.roll(1);
        game.roll(9);
        game.roll(5);
        fullSeries(17,0);

        assertEquals(20, game.score());
    }

    @Test
    void shouldReturnPointsOfOneStrikeWithBonusInMultipleRolls() {
        game.roll(10);
        game.roll(7);
        game.roll(1);
        fullSeries(17,0);

        assertEquals(26, game.score());
    }

    @Test
    void shouldReturnCorrectBonusWhenTwoStrikesIsRolledInARow() {
        game.roll(10);
        game.roll(10);
        game.roll(9);
        game.roll(0);
        fullSeries(15,0);

        assertEquals(57, game.score());
    }

    @Test
    void shouldReturnCorrectBonusWhenThreeStrikesIsRolledConsequently() {
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(0);
        game.roll(9);
        fullSeries(14,0);

        assertEquals(78, game.score());
    }

    @Test
    void shouldReturnCorrectBonusWhenThreeSparesIsRolledConsequently() {
        game.roll(1);
        game.roll(9);
        game.roll(5);
        game.roll(5);
        game.roll(7);
        game.roll(3);
        fullSeries(14,0);

        assertEquals(42, game.score());
    }

    @Test
    void testARealisticFullSeriesGame() {
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        game.roll(6);

        assertEquals(133, game.score());
    }

    @Test
    void strikeOnLastFrameShouldGiveTwoExtraRolls() {
        fullSeries(18,0);
        game.roll(10);
        game.roll(4);
        game.roll(4);

        assertEquals(30, game.score());

    }

}
