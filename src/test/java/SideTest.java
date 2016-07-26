import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by thtran on 26/07/16.
 */
public class SideTest {

    @Test
    public void testCreateSide(){
        final Side aSide = new Side("Player 1");

        assertThat(aSide.getPlayerNames(), is("Player 1"));
        assertThat(aSide.getPointScore(), is(0));
        assertThat(aSide.getGameScore(), is(0));
        assertThat(aSide.getSetScore(), is(0));
    }
}