package rps;

import static org.junit.Assert.*;
import it.lucarasconi.game.Outcome;
import it.lucarasconi.game.RPSGameManager;
import it.lucarasconi.game.Sign;

import org.junit.Test;

public class RpsManagerTest {

	@Test
	public void test1() {
		RPSGameManager gm = new RPSGameManager("lucarasconi");
		for (int i = 0; i < 100; i++) {
			Outcome out = (Outcome) gm.play(Sign.randomSign()).get(RPSGameManager.OUTCOME_KEY);
			assertTrue(out == Outcome.WAIT || out == Outcome.DRAW || out == Outcome.LOSE || out == Outcome.WIN);
		}
		
	}
}
