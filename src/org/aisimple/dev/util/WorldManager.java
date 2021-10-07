package org.aisimple.dev.util;

import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;

public class WorldManager {
	
	public static void createWorld(String name, WorldType type) {
		WorldCreator wc = new WorldCreator(name);
		
		wc.type(type);
		wc.environment(Environment.NORMAL);
		
		wc.createWorld();
	}

}
