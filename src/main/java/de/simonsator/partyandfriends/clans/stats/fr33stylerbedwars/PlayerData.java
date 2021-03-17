package de.simonsator.partyandfriends.clans.stats.fr33stylerbedwars;


public class PlayerData {
	public final int wins;

	public final int loses;
	public final int destroyedBeds;
	public final double kd;
	public final int deaths;
	public final int kills;

	public PlayerData(int wins, int loses, int destroyedBeds, int deaths, int kills) {
		this.wins = wins;
		this.loses = loses;
		this.destroyedBeds = destroyedBeds;
		if (deaths != 0)
			this.kd = (double) kills / deaths;
		else kd = kills;
		this.deaths = deaths;
		this.kills = kills;
	}
}