package org.aisimple.dev.game;

import java.util.ArrayList;

import org.bukkit.Location;

public class GameManager {
	
	private ArrayList<GamePlayer> players;
	private Location spawn;
	
	public GameManager() {
		this.players = new ArrayList<GamePlayer>();
	}
	
	public boolean containsPlayer(String p) {
		for(int i = 0 ; i < players.size(); i++) {
			if(players.get(i).getP().getName().equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addPlayer(GamePlayer p) {
		if(containsPlayer(p.getP().getName())) {
			this.players.add(p);
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean removePlayer(String p) {
		for(int i = 0 ; i < players.size(); i++) {
			if(players.get(i).getP().getName().equals(p)) {
				this.players.remove(p);
			}
		}
		return false;
	}
	
	public ArrayList<GamePlayer> getPlayers(){
		return players;
	}
	
	public Location getSpawn() {
		return spawn;
	}
	
	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}
	
	public int getPlayersCount() {
		return this.players.size();
	}
	
	public int getTotalKills() {
		int kills = 0;
		for(GamePlayer p : this.players) {
			kills = kills+p.getKills();
		}
		return kills;
	}

}
