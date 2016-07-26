import com.sun.tools.javac.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by thtran on 26/07/16.
 */
public class TennisGameTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() throws Exception {
        tennisGame = new TennisGame("Player 1", "Player 2");
    }

    @Test
    public void testCreateGameWith2Sides() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");

        assertThat(tennisGame, is(expectedTennisGame));
    }

    @Test
    public void testFirstSideWinOnePoint() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");
        expectedTennisGame.setPointScore(new Pair<>(15, 0));
        expectedTennisGame.setGameScore(new Pair<>(0, 0));
        expectedTennisGame.setSetScore(new Pair<>(0, 0));
        expectedTennisGame.getFirstSide().markPoint();

        tennisGame.markPoint(tennisGame.getFirstSide());

        assertThat(tennisGame, is(expectedTennisGame));
    }

    @Test
    public void testSecondSideWinOnePoint() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");
        expectedTennisGame.setPointScore(new Pair<>(0, 15));
        expectedTennisGame.setGameScore(new Pair<>(0, 0));
        expectedTennisGame.setSetScore(new Pair<>(0, 0));
        expectedTennisGame.getSecondSide().markPoint();

        tennisGame.markPoint(tennisGame.getSecondSide());

        assertThat(tennisGame, is(expectedTennisGame));
    }

    @Test
    public void testFirstSideWinByMark4PointsFirst() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");
        expectedTennisGame.setPointScore(new Pair<>(0, 0));
        expectedTennisGame.setGameScore(new Pair<>(1, 0));
        expectedTennisGame.setSetScore(new Pair<>(0, 0));
        expectedTennisGame.getFirstSide().setGameScore(1);

        allSidesMarkPoint();
        allSidesMarkPoint();
        firstSideMark2Points();

        assertThat(tennisGame, is(expectedTennisGame));
    }

    @Test
    public void testSecondSideWinByMark4PointsFirst() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");
        expectedTennisGame.setPointScore(new Pair<>(0, 0));
        expectedTennisGame.setGameScore(new Pair<>(0, 1));
        expectedTennisGame.setSetScore(new Pair<>(0, 0));
        expectedTennisGame.getSecondSide().setGameScore(1);

        allSidesMarkPoint();
        allSidesMarkPoint();
        secondSideMark2Points();

        assertThat(tennisGame, is(expectedTennisGame));
    }

    private void secondSideMark2Points() {
        tennisGame.markPoint(tennisGame.getSecondSide());
        tennisGame.markPoint(tennisGame.getSecondSide());
    }

    private void firstSideMark2Points() {
        tennisGame.markPoint(tennisGame.getFirstSide());
        tennisGame.markPoint(tennisGame.getFirstSide());
    }

    private void allSidesMarkPoint() {
        tennisGame.markPoint(tennisGame.getFirstSide());
        tennisGame.markPoint(tennisGame.getSecondSide());
    }
}