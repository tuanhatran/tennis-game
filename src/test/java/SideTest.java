import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by thtran on 26/07/16.
 */
public class SideTest {

    @Test
    public void testCreateSideAsSingleGame(){
        final List<Player> expectedPlayers = new ArrayList<>();
        expectedPlayers.add(new Player("Player 1"));

        final Side aSide = new Side("Player 1");

        assertThat(aSide.getPlayers(), is(expectedPlayers));
        assertThat(aSide.getPointScore(), is(0));
        assertThat(aSide.getGameScore(), is(0));
        assertThat(aSide.getSetScore(), is(0));
    }

    @Test
    public void testCreateSideAsDoubleGame() throws Exception {
        final List<Player> expectedPlayers = new ArrayList<>();
        expectedPlayers.add(new Player("Player 1"));
        expectedPlayers.add(new Player("Player 2"));

        final Side aSide = new Side("Player 1", "Player 2");

        assertThat(aSide.getPlayers(), is(expectedPlayers));
        assertThat(aSide.getPointScore(), is(0));
        assertThat(aSide.getGameScore(), is(0));
        assertThat(aSide.getSetScore(), is(0));
    }
}