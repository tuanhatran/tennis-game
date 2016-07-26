import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by thtran on 26/07/16.
 */
public class TennisGameTest {

    @Test
    public void testCreateGameWith2Sides() throws Exception {
        final TennisGame expectedTennisGame = new TennisGame("Player 1", "Player 2");

        final TennisGame tennisGame = new TennisGame("Player 1", "Player 2");

        assertThat(tennisGame, is(expectedTennisGame));
    }

}