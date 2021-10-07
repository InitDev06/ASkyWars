package org.aisimple.dev.game;

import org.aisimple.dev.util.Elements;
import org.bukkit.entity.Player;

public class GamePlayer {
	
	private Player p;
	private int kills;
	private int deaths;
	private boolean isRecentlyKilled;
	private Elements saved;
	
	public GamePlayer(Player p) {
		this.p = p;
		this.saved = new Elements(p.getInventory().getContents(), p.getInventory().getArmorContents(), p.getGameMode(), p.getExp(), p.getLevel()
				, p.getFoodLevel(), p.getHealth(), p.getMaxHealth());
	}
	
	public Elements getSaved() {
		return this.saved;
	}
	
	public void increaseKills() {
		this.kills++;
	}
	
	public void increaseDeahts() {
		this.deaths++;
	}
	
	public int getKills() {
		return this.kills;
	}
	
	public int getDeaths() {
		return this.deaths;
	}
	
	public Player getP() {
		return this.p;
	}
	
	public boolean isRecentlyKilled() {
		return isRecentlyKilled;
	}
	
	public void setRecentlyKilled(boolean isRecentlyKilled) {
		this.isRecentlyKilled = isRecentlyKilled;
	}

}
