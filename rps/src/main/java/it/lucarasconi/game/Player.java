package it.lucarasconi.game;

public class Player {

	private String name;

	public Player(String player) {
		this.setName(player);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEqual(Player anotherPlayer) {
		return anotherPlayer.getName().equalsIgnoreCase(getName());
	}

}
