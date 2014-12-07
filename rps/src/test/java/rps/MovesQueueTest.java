package rps;

import static org.junit.Assert.*;
import it.lucarasconi.game.Move;
import it.lucarasconi.game.MovesQueue;
import it.lucarasconi.game.Player;
import it.lucarasconi.game.Sign;

import org.junit.Test;

public class MovesQueueTest {
	
	public void initnotnull() {
		assertTrue(MovesQueue.getAValidMoveFor(new Player("luca")) != null);
	}

	@Test
	public void notthesame (){
		for (int i = 0; i < 100; i++) {
			Player theplayer = new Player("session_" + i);
			MovesQueue.add(new Move(theplayer, Sign.randomSign()));
			Move m = MovesQueue.getAValidMoveFor(theplayer);
			assertTrue(!m.getPlayer().getName().equalsIgnoreCase(theplayer.getName()));
		}
	}
}
