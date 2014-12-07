package it.lucarasconi.game;

/**
 * someone make a move
 * @author luca.rasconi
 *
 */
public class Move {
	
	private Player player;
	private Sign sign;

	public Move(Player player, Sign sign) {
		this.setPlayer(player);
		this.setSign(sign);
	}

	public Move(Sign sign) {
		this.setSign(sign);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}
	
	public Outcome checkAgainst (Move anothermove) {
		return new CheckWinner().check(sign, anothermove.getSign());
	}

}
