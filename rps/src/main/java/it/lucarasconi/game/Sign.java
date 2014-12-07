package it.lucarasconi.game;

import java.util.Random;

public enum Sign {
	ROCK("Rock"), PAPER("Paper"), SCISSOR ("Scissor");
	
	private String sign;
	private static final Random RANDOM = new Random();
	private static final Sign VALUES[] = values();
	
	private Sign(String sign) {
		this.sign = sign;
	}
	
	public static Sign randomSign() {
		return VALUES[RANDOM.nextInt(VALUES.length)];
	}
	
	public String toString() {
		return sign;
	}

}
