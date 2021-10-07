package org.aisimple.dev.game;

import java.util.ArrayList;

import org.aisimple.dev.enums.StateType;
import org.bukkit.Location;

public class Game {
	
	private String name;
	private int maxPlayers;
	private int minPlayers;
	private int onPlayers;
	private StateType state;
	private Location lobby;
	private int maxTime;
	private int onTime;
	
	public Game(String name) {
		this.name = name;
		this.maxPlayers = 0;
		this.minPlayers = 0;
		this.onPlayers = 0;
		this.state = StateType.WAITING;
		this.onTime = 0;
		this.maxTime = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getMaxTime() {
		return maxTime;
	}
	
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	
	public void reduceTime() {
		this.onTime--;
	}
	
	public void increaseTime() {
		this.onTime++;
	}
	
	public void setTime(int onTime) {
		this.onTime = onTime;
	}
	
	public int getTime() {
		return this.onTime;
	}
	
	public void addPlayer(GamePlayer p) {
		this.onPlayers++;
	}
	
	public void removePlayer(GamePlayer p) {
		this.onPlayers--;
	}
	
	public ArrayList<GamePlayer> getPlayers(){
		ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
		return players;
	}
	
	public GamePlayer getPlayer(String player) {
		ArrayList<GamePlayer> players = getPlayers();
		for(int i = 0 ; i < players.size(); i++) {
			if(players.get(i).getP().getName().equals(player)) {
				return players.get(i);
			}
		}
		return null;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getCurrentPlayers() {
		return this.onPlayers;
	}
	
	public StateType getState() {
		return this.state;
	}
	
	public void setState(StateType state) {
		this.state = state;
	}
	
	public boolean isStarted() {
		if(state.equals(StateType.WAITING) || state.equals(StateType.DEACTIVATED) || state.equals(StateType.STARTING)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isFull() {
		if(this.onPlayers == this.maxPlayers) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isActivated() {
		if(!state.equals(StateType.DEACTIVATED)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setLobby(Location lobby) {
		this.lobby = lobby;
	}
	
	public Location getLobby() {
		return this.lobby;
	}
	
	public GamePlayer getWinner() {
		if(this.onPlayers == 1 && state.equals(StateType.INGAME)) {
			this.setState(StateType.FINALIZED);
		}
		return null;
	}
	
}
