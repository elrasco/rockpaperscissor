package it.lucarasconi.game;

/**
 * Outcome Enum : represents the outocome of a game
 * @author luca.rasconi
 *
 */
public enum Outcome {
	DRAW("draw"), WIN("win"), LOSE("lose"), WAIT("wait");

	private String outcome;

	private Outcome(String outcome){
		this.outcome = outcome;
	}

	public String toString() {
		return outcome;
	}
}
