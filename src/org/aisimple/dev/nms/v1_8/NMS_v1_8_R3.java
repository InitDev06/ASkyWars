package org.aisimple.dev.nms.v1_8;

import org.aisimple.dev.nms.NMS;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class NMS_v1_8_R3 implements NMS {

	@Override
	public void sendTitle(Player p, String title, int fadeIn, int onScreen, int fadeOut) {
		PacketPlayOutTitle titlepacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a(title), fadeIn, onScreen, fadeOut);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(titlepacket);
	}

	@Override
	public void sendSubtitle(Player p, String subtitle, int fadeIn, int onScreen, int fadeOut) {
		PacketPlayOutTitle subtitlepacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a(subtitle), fadeIn, onScreen, 
				fadeOut);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(subtitlepacket);
	}

}
