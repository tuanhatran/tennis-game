import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by thtran on 26/07/16.
 */
public class PlayerTest {

    @Test
    public void testCreatePlayer(){
        final Player player = new Player("Player 1");

        assertThat(player.getPlayerName(), is("Player 1"));
    }
}