package org.aisimple.dev;

import java.util.ArrayList;

import org.aisimple.dev.color.Color;
import org.aisimple.dev.commands.ASWCmd;
import org.aisimple.dev.config.Settings;
import org.aisimple.dev.game.Game;
import org.aisimple.dev.game.GamePlayer;
import org.aisimple.dev.nms.NMSHelper;
import org.aisimple.dev.visual.BoardTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ASkyWars extends JavaPlugin implements Listener {
	
	private static ASkyWars instance;
	
	private static FileConfiguration config;
	private static FileConfiguration chests;
	private static FileConfiguration langen;
	private static FileConfiguration langes;
	private static FileConfiguration arenas;
	private static FileConfiguration scoreboard;
	private static Settings s;
	private ArrayList<Game> games;
	
	public static ASkyWars getInstance() {
		return instance;
	}
	public static String getPluginVersion() {
		return getInstance().getDescription().getVersion();
	}
	public static String getServerVersion() {
		return Bukkit.getVersion();
	}
	public static Settings getSettings() {
		return s;
	}
	public static FileConfiguration getConfigFile() {
		return config;
	}
	public static FileConfiguration getLangEN() {
		return langen;
	}
	public static FileConfiguration getLangES() {
		return langes;
	}
	public static FileConfiguration getChests() {
		return chests;
	}
	public static FileConfiguration getArenas() {
		return arenas;
	}
	public static FileConfiguration getScoreboard() {
		return scoreboard;
	}
	public static void setConfig(FileConfiguration config) {
		ASkyWars.config = config;
	}
	public static void setChests(FileConfiguration chests) {
		ASkyWars.chests = chests;
	}
	public static void setLangEN(FileConfiguration langen) {
		ASkyWars.langen = langen;
	}
	public static void setLangES(FileConfiguration langes) {
		ASkyWars.langes = langes;
	}
	public static void setArenas(FileConfiguration arenas) {
		ASkyWars.arenas = arenas;
	}
	public static void setScoreboard(FileConfiguration scoreboard) {
		ASkyWars.scoreboard = scoreboard;
	}
	public static void setInstance(ASkyWars instance) {
		ASkyWars.instance = instance;
	}
	
	@Override
	public void onEnable() {
		setInstance(this);
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &cchecking your server version"));
		NMSHelper.setupNMS();
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &eloading components.."));
		BoardTask boardTask = new BoardTask();
		boardTask.create();
		this.createFiles();
		this.createCmds();
		this.createEvents();
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &aloaded &bdata &a& &bfiles"));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &cany database connected now!"));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &ethe plugin has been enabled correctly!"));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &6version &3" + getPluginVersion() + " &6running on &b" + getServerVersion()));
	}
	
	@Override
	public void onDisable() {
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &edisabling plugin.."));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &esaving databases.."));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &cthe plugin has been disabled"));
		this.getServer().getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &6version &3" + getPluginVersion()));
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public Game getGame(String name) {
		for(int i = 0 ; i < games.size(); i++) {
			if(games.get(i).getName().equals(name)) {
				return games.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Game> getGames(){
		return this.games;
	}
	
	public Game getPlayerGame(String player) {
		for(int i = 0 ; i < games.size(); i++) {
			ArrayList<GamePlayer> players = games.get(i).getPlayers();
			for(int c = 0 ; c < players.size(); c++) {
				if(players.get(c).getP().getName().equals(player)) {
					return games.get(i);
				}
			}
		}
		return null;
	}
	
	public void removeGame(String name) {
		for(int i = 0 ; i < games.size(); i++) {
			if(games.get(i).getName().equals(name)) {
				games.remove(i);
			}
		}
	}
	
	public void loadGames() {
		FileConfiguration arenas = getArenas();
		for(Game g : this.games) {
			String name = g.getName();
			arenas.set("arenas." + name + ".min_players", g.getMinPlayers());
			arenas.set("arenas." + name + ".max_players", g.getMaxPlayers());
			arenas.set("arenas." + name + ".max_time", g.getMaxTime());
			arenas.set("arenas." + name + ".state", g.getState());
			Location lobby = g.getLobby();
			if(lobby != null) {
				arenas.set("arenas." + name + ".lobby.x", lobby.getX());
				arenas.set("arenas." + name + ".lobby.y", lobby.getY());
				arenas.set("arenas." + name + ".lobby.z", lobby.getZ());
				arenas.set("arenas." + name + ".lobby.yaw", lobby.getYaw());
				arenas.set("arenas." + name + ".lobby.pitch", lobby.getPitch());
				arenas.set("arenas." + name + ".lobby.world", lobby.getWorld().getName());
			}
		}
	}
	
	private void createFiles() {
		s = new Settings();
		s.create("config");
		s.create("chests");
		s.create("lang_en");
		s.create("lang_es");
		s.create("arenas");
		s.create("scoreboard");
		config = s.getConfig("config");
		chests = s.getConfig("chests");
		langen = s.getConfig("lang_en");
		langes = s.getConfig("lang_es");
		arenas = s.getConfig("arenas");
		scoreboard = s.getConfig("scoreboard");
	}
	
	private void createCmds() {
		this.getCommand("askywars").setExecutor(new ASWCmd());
	}
	
	private void createEvents() {
		PluginManager pM = Bukkit.getPluginManager();
		pM.registerEvents(this, this);
	}
}
