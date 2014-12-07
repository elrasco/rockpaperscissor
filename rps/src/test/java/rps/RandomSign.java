package rps;

import static org.junit.Assert.*;
import it.lucarasconi.game.Sign;

import org.junit.Test;

public class RandomSign {
	@Test
	public void test1() {
		
		for (int i = 0; i < 100; i++) {
			Sign randomsign = Sign.randomSign();
			assertTrue(randomsign == Sign.PAPER  || randomsign == Sign.ROCK || randomsign == Sign.SCISSOR);
		}
		
	}
}
