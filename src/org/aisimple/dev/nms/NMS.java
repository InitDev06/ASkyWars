package org.aisimple.dev.nms;

import org.bukkit.entity.Player;

public interface NMS {
	
	void sendTitle(Player p, String title, int fadeIn, int onScreen, int fadeOut);
	
	void sendSubtitle(Player p, String subtitle, int fadeIn, int onScreen, int fadeOut);
	
}
