package it.lucarasconi.game;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MovesQueue {

	private static Queue<Move> moves = new ConcurrentLinkedQueue<Move>();
	
	/**
	 * return the first move, in a FIFO queue, not played by the player. Random play otherwise.
	 * @param p
	 * @return
	 */
	public static Move getAValidMoveFor(Player p) {
		for (Move move : moves) {
			if (!move.getPlayer().isEqual(p)) {
				moves.remove(move);
				return move;
			}
		}
		return new Move(new Player("randomplayer_" + new Date().getTime()), Sign.randomSign());
	}
	
	public static void add(Move move) {
		moves.add(move);
	}
	
}
