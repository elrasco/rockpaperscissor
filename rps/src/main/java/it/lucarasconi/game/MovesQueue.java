package it.lucarasconi.game;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MovesQueue {

	private static Queue<Move> moves = new ConcurrentLinkedQueue<Move>();
	
	public static Move getAValidMoveFor(Player p) {
		for (Move move : moves) {
			if (!move.getPlayer().isEqual(p)) {
				return moves.poll();
			}
		}
		return new Move(new Player("randomplayer_" + new Date().getTime()), Sign.randomSign());
	}
	
	public static void add(Move move) {
		moves.add(move);
	}
	
}
