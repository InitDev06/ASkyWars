package org.aisimple.dev.config;

import java.io.File;

import org.aisimple.dev.ASkyWars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Settings {
	
	public Settings() {
		
	}
	
	public void create(String name) {
		File configFile = new File(ASkyWars.getInstance().getDataFolder(), name + ".yml");
		if(!configFile.exists()) {
			ASkyWars.getInstance().saveResource(name + ".yml", false);
		}
	}
	
	public FileConfiguration getConfig(String fileName) {
		return YamlConfiguration.loadConfiguration(new File(ASkyWars.getInstance().getDataFolder(), fileName + ".yml"));
	}
	
	public File getFile(String fileName) { return new File(ASkyWars.getInstance().getDataFolder(), fileName + ".yml"); }

}
