package org.aisimple.dev.nms;

import org.aisimple.dev.ASkyWars;
import org.aisimple.dev.color.Color;
import org.aisimple.dev.nms.v1_8.NMS_v1_8_R1;
import org.aisimple.dev.nms.v1_8.NMS_v1_8_R2;
import org.aisimple.dev.nms.v1_8.NMS_v1_8_R3;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class NMSHelper {
	
	private static NMS nms;
	
	public static void setupNMS() {
		FileConfiguration config = ASkyWars.getConfigFile();
		String version = null;
		
		try {
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		} catch(ArrayIndexOutOfBoundsException e) {
			if(config.getString("language").equals("EN")) {
				Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &csomething went wrong while loading NMS!"));
				Bukkit.getScheduler().cancelAllTasks();
				Bukkit.getPluginManager().disablePlugin(ASkyWars.getInstance());
			} else if(config.getString("language").equals("ES")) {
				Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &cha ocurrido un error al cargar NMS!"));
				Bukkit.getScheduler().cancelAllTasks();
				Bukkit.getPluginManager().disablePlugin(ASkyWars.getInstance());
			}
		}
		
		if(version.equals("v1_8_R1")) {
			nms = new NMS_v1_8_R1();
			Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &aloaded components &bv1_8_R1"));
		} else if(version.equals("v1_8_R2")) {
			nms = new NMS_v1_8_R2();
			Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &aloaded components &bv1_8_R2"));
		} else if(version.equals("v1_8_R3")) {
			nms = new NMS_v1_8_R3();
			Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &aloaded components &bv1_8_R3"));
		} else {
			Bukkit.getConsoleSender().sendMessage(Color.t("&8[&bASW&8] &cyour server version is not supported with the plugin!"));
			Bukkit.getScheduler().cancelAllTasks();
			Bukkit.getPluginManager().disablePlugin(ASkyWars.getInstance());
		}
	}
	
	public static NMS getNMS() {
		return nms;
	}

}
