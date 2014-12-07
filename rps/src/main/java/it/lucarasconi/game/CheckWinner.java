package it.lucarasconi.game;

public class CheckWinner {

	/**
	 * the rule to check who wins
	 * @param sign
	 * @param anothersign
	 * @return an outcome result from a sign vs another sign
	 */
	public Outcome check(Sign sign, Sign anothersign) {
		switch (sign) {
		case ROCK:
			switch (anothersign) {
			case ROCK:
				return Outcome.DRAW;
			case PAPER:
				return Outcome.LOSE;
			case SCISSOR:
				return Outcome.WIN;
			}
		case PAPER:
			switch (anothersign) {
			case ROCK:
				return Outcome.WIN;
			case PAPER:
				return Outcome.DRAW;
			case SCISSOR:
				return Outcome.LOSE;
			}
		case SCISSOR:
			switch (anothersign) {
			case ROCK:
				return Outcome.LOSE;
			case PAPER:
				return Outcome.WIN;
			case SCISSOR:
				return Outcome.DRAW;
			}
		}
		return null;
	}

}
