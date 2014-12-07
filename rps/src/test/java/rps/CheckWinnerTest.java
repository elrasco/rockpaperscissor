package rps;

import static org.junit.Assert.*;
import it.lucarasconi.game.CheckWinner;
import it.lucarasconi.game.Move;
import it.lucarasconi.game.Outcome;
import it.lucarasconi.game.Player;
import it.lucarasconi.game.Sign;

import org.junit.Test;

public class CheckWinnerTest {

	@Test
	public void test1() {
		CheckWinner cw = new CheckWinner();
		assertTrue(cw.check(Sign.PAPER, Sign.PAPER) == Outcome.DRAW);
		assertTrue(cw.check(Sign.PAPER, Sign.SCISSOR) == Outcome.LOSE);
		assertTrue(cw.check(Sign.PAPER, Sign.ROCK) == Outcome.WIN);

		assertTrue(cw.check(Sign.ROCK, Sign.PAPER) == Outcome.LOSE);
		assertTrue(cw.check(Sign.ROCK, Sign.SCISSOR) == Outcome.WIN);
		assertTrue(cw.check(Sign.ROCK, Sign.ROCK) == Outcome.DRAW);

		assertTrue(cw.check(Sign.SCISSOR, Sign.PAPER) == Outcome.WIN);
		assertTrue(cw.check(Sign.SCISSOR, Sign.SCISSOR) == Outcome.DRAW);
		assertTrue(cw.check(Sign.SCISSOR, Sign.ROCK) == Outcome.LOSE);

		assertFalse(cw.check(Sign.SCISSOR, Sign.ROCK) == Outcome.WIN);
	}

	@Test
	public void test2() {
		for (int i = 0; i < 100; i++) {
			Move m = new Move(new Player("session_" + i), Sign.randomSign());
			switch (m.getSign()) {
			case ROCK:
				assertTrue(m.checkAgainst(new Move(Sign.PAPER)) == Outcome.LOSE);
				assertTrue(m.checkAgainst(new Move(Sign.ROCK)) == Outcome.DRAW);
				assertTrue(m.checkAgainst(new Move(Sign.SCISSOR)) == Outcome.WIN);
				break;
			case PAPER:
				assertTrue(m.checkAgainst(new Move(Sign.PAPER)) == Outcome.DRAW);
				assertTrue(m.checkAgainst(new Move(Sign.ROCK)) == Outcome.WIN);
				assertTrue(m.checkAgainst(new Move(Sign.SCISSOR)) == Outcome.LOSE);
				break;
			case SCISSOR:
				assertTrue(m.checkAgainst(new Move(Sign.PAPER)) == Outcome.WIN);
				assertTrue(m.checkAgainst(new Move(Sign.ROCK)) == Outcome.LOSE);
				assertTrue(m.checkAgainst(new Move(Sign.SCISSOR)) == Outcome.DRAW);
				break;
			}
		}
	}
}
