package org.aisimple.dev.color;

import org.bukkit.ChatColor;

public class Color {

	public static String t(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
