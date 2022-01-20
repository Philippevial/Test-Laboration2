package com.example.bowlingtest;

import com.example.bowlinggame.Game;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {
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

        assertThat(game.score()).isZero();
    }

    @Test
    void singlePinKnockedShouldGiveScoreOne() {
        game.roll(1);
        fullSeries(19,0);

        assertThat(game.score()).isEqualTo(1);
    }

    @Test
    void scoreShouldReturnSumOfTwoRolls() {
        game.roll(2);
        game.roll(3);
        fullSeries(18,0);


        assertThat(game.score()).isEqualTo(5);
    }

    @Test
    void scoreShouldReturnSumOfAMultipleRolls() {
        fullSeries(20, 1);

        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void shouldReturnPointsOfOneSpareWithBonusInFullSeries() {
        game.roll(1);
        game.roll(9);
        game.roll(5);
        fullSeries(17,0);

        assertThat(game.score()).isEqualTo(20);

    }

    @Test
    void shouldReturnPointsOfOneStrikeWithBonusInMultipleRolls() {
        game.roll(10);
        game.roll(7);
        game.roll(1);
        fullSeries(17,0);

        assertThat(game.score()).isEqualTo(26);

    }

    @Test
    void shouldReturnCorrectBonusWhenTwoStrikesIsRolledInARow() {
        game.roll(10);
        game.roll(10);
        game.roll(9);
        game.roll(0);
        fullSeries(15,0);

        assertThat(game.score()).isEqualTo(57);

    }

    @Test
    void shouldReturnCorrectBonusWhenThreeStrikesIsRolledConsequently() {
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(0);
        game.roll(9);
        fullSeries(14,0);

        assertThat(game.score()).isEqualTo(78);
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

        assertThat(game.score()).isEqualTo(42);

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

        assertThat(game.score()).isEqualTo(133);

    }

    @Test
    void strikeOnLastFrameShouldGiveTwoExtraRolls() {
        fullSeries(18,0);
        game.roll(10);
        game.roll(4);
        game.roll(4);

        assertThat(game.score()).isEqualTo(18);

    }

    @Test
    void spareOnLastFrameShouldGiveOneExtraRoll() {
        fullSeries(18,0);
        game.roll(7);
        game.roll(3);
        game.roll(4);

        assertThat(game.score()).isEqualTo(14);
    }

}
