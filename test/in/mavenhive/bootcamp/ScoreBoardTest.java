package in.mavenhive.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    void shouldReturnZeroGivenAllTurnsAreMissed() {
        ScoreBoard scoreBoard = new ScoreBoard("00 00 00 00 00 00 00 00 00 00");
        assertEquals(0, scoreBoard.total());
    }

    @Test
    void shouldReturnTenGivenAllFramesAreOne() {
        ScoreBoard scoreBoard = new ScoreBoard("01 01 01 10 01 10 01 10 01 10");
        assertEquals(10, scoreBoard.total());
    }

    @Test
    void shouldReturnEightyGivenAllFramesAreEight() {
        ScoreBoard scoreBoard = new ScoreBoard("08 53 08 17 35 44 17 35 44 53");
        assertEquals(80, scoreBoard.total());
    }

    @Test
    void shouldReturnTenGivenOnlyOneStrike() {
        ScoreBoard scoreBoard = new ScoreBoard("X 00 00 00 00 00 00 00 00 00");
        assertEquals(10, scoreBoard.total());
    }

    @Test
    void shouldReturnTenGivenOnlyOneSpare() {
        ScoreBoard scoreBoard = new ScoreBoard("0/ 00 00 00 00 00 00 00 00 00");
        assertEquals(10, scoreBoard.total());
    }

    @Test
    void shouldReturnTwelveGivenOneStrikeAndOnePointInTheFollowingFrame() {
        ScoreBoard scoreBoard = new ScoreBoard("X 01 00 00 00 00 00 00 00 00");
        assertEquals(12, scoreBoard.total());
    }

    @Test
    void shouldReturnOneFiftyFourGivenAlternativeStrikes() {
        ScoreBoard scoreBoard = new ScoreBoard("X 53 X 36 X 78 X 34 X 49");
        assertEquals(154, scoreBoard.total());
    }

    @Test
    void shouldReturnTwentyTwoGivenASpareFollowedByThreeAndSixInTheNextFrame() {
        ScoreBoard scoreBoard = new ScoreBoard("00 5/ 36 00 00 00 00 00 00 00");
        assertEquals(22, scoreBoard.total());
    }

    @Test
    void shouldReturnThirtyGivenAdjacentStrikes() {
        ScoreBoard scoreBoard = new ScoreBoard("X X 00 00 00 00 00 00 00 00");
        assertEquals(30, scoreBoard.total());
    }

    @Test
    void shouldReturnThirtyThreeGivenAdjacentStrikesFollowedByASinglePoint() {
        ScoreBoard scoreBoard = new ScoreBoard("X X 10 00 00 00 00 00 00 00");
        assertEquals(33, scoreBoard.total());
    }
}