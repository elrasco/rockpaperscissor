package it.lucarasconi.game;

import java.util.HashMap;
import java.util.Map;

public class RPSGameManager {
	
	public static final String OUTCOME_KEY = "outcome";
	public static final String SIGN_KEY = "against";
	
	private Player player;
	
	public RPSGameManager(String playername) {
		super();
		this.setPlayer(new Player(playername));
	}
	
	public Map<String, Object> play(String sign) {
		return play(RPSGameManager.getSignEnum(sign));
	}
	
	public Map<String, Object> play(Sign sign) {
		Map<String, Object> result = new  HashMap<String, Object>();
		Move move = new Move(getPlayer(), sign);
		Move anothermove = MovesQueue.getAValidMoveFor(getPlayer());
		if (anothermove == null) {
			MovesQueue.add(move);
			result.put(OUTCOME_KEY, Outcome.WAIT);
		} else {
			result.put(SIGN_KEY, anothermove.getSign());
			result.put(OUTCOME_KEY, move.checkAgainst(anothermove));
		}
		return result;
	}
	
	private static Sign getSignEnum(String sign) {
		switch(sign) {
		case "rock":
			return Sign.ROCK;
		case "paper":
			return Sign.PAPER;
		case "scissor":
			return Sign.SCISSOR;
		}
		return null;
	}

	protected Player getPlayer() {
		return player;
	}

	protected void setPlayer(final Player player) {
		this.player = player;
	}
	
	
}
