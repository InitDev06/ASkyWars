package org.aisimple.dev.commands;

import org.aisimple.dev.ASkyWars;
import org.aisimple.dev.color.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ASWCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
		FileConfiguration config = ASkyWars.getConfigFile();
		FileConfiguration lang_en = ASkyWars.getLangEN();
		FileConfiguration lang_es = ASkyWars.getLangES();
		if(!(s instanceof Player)) {
			if(cmd.getName().equalsIgnoreCase("askywars")) {
				if(config.getString("language").equals("EN")) {
					if(args.length == 0) {
						s.sendMessage(Color.t(lang_es.getString("messages.cmd-args")));
						return true;
					}
					
					if(args[0].equalsIgnoreCase("info")) {
						if(s.hasPermission("askywars.info") || s.isOp()) {
							s.sendMessage(Color.t("&8[&bASW&8] &aversion &e" + ASkyWars.getPluginVersion() + "&a running on &e" + ASkyWars.getServerVersion()));
						} else {
							s.sendMessage(Color.t(lang_en.getString("messages.missing-permission")));
						}
						return true;
					}
				
					if(args[0].equalsIgnoreCase("help")) {
						if(s.hasPermission("askywars.help.admin") || s.isOp()) {
							s.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							s.sendMessage(Color.t(""));
							s.sendMessage(Color.t("&a/asw <help> &8- &fshow this message"));
							s.sendMessage(Color.t("&a/asw <info> &8- &fshow about the plugin"));
							s.sendMessage(Color.t("&a/asw join <map> &fjoin a aleatory map, or a one specified."));
						} else {
							s.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							s.sendMessage(Color.t(""));
							s.sendMessage(Color.t("&a/asw join <map> &fjoin a aleatory map, or a one specified."));
						}
						return true;
					}
					
					s.sendMessage(Color.t(lang_en.getString("messages.cmd-null")));
					return true;
					
				} else if(config.getString("language").equals("ES")) {
					if(args.length == 0) {
						s.sendMessage(Color.t(lang_es.getString("messages.cmd-args")));
						return true;
					}
					
					if(args[0].equalsIgnoreCase("info")) {
						if(s.hasPermission("askywars.info") || s.isOp()) {
							s.sendMessage(Color.t("&8[&bASW&8] &aversion &e" + ASkyWars.getPluginVersion() + "&a corriendo en &e" + ASkyWars.getServerVersion()));
						} else {
							s.sendMessage(Color.t(lang_es.getString("messages.missing-permission")));
						}
						return true;
					}
				
					if(args[0].equalsIgnoreCase("help")) {
						if(s.hasPermission("askywars.help.admin") || s.isOp()) {
							s.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							s.sendMessage(Color.t(""));
							s.sendMessage(Color.t("&a/asw <help> &8- &fmuestra este mensaje"));
							s.sendMessage(Color.t("&a/asw <info> &8- &fmuestra informacion sobre el plugin"));
							s.sendMessage(Color.t("&a/asw join <mapa> &fentra a un mapa especificado o aleatorio."));
						} else {
							s.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							s.sendMessage(Color.t(""));
							s.sendMessage(Color.t("&a/asw join <map> &fentra a un mapa especificado o aleatorio."));
						}
						return true;
					}
					
					s.sendMessage(Color.t(lang_es.getString("messages.cmd-null")));
					return true;
				} else {
					s.sendMessage(Color.t("&8[&bASW&8] &cthe plugin currently don't have support for this idiom, sorry."));
					return true;
				}
			}
			
		} else {
			Player p = (Player) s;
			
			if(cmd.getName().equalsIgnoreCase("askywars")) {
				if(config.getString("language").equals("EN")) {
					if(args.length == 0) {
						p.sendMessage(Color.t(lang_es.getString("messages.cmd-args")));
						return true;
					}
					
					if(args[0].equalsIgnoreCase("info")) {
						if(p.hasPermission("askywars.info") || p.isOp()) {
							p.sendMessage(Color.t("&8[&bASW&8] &aversion &e" + ASkyWars.getPluginVersion() + "&a running on &e" + ASkyWars.getServerVersion()));
						} else {
							p.sendMessage(Color.t(lang_en.getString("messages.missing-permission")));
						}
						return true;
					}
				
					if(args[0].equalsIgnoreCase("help")) {
						if(p.hasPermission("askywars.help.admin") || p.isOp()) {
							p.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							p.sendMessage(Color.t(""));
							p.sendMessage(Color.t("&a/asw <help> &8- &fshow this message"));
							p.sendMessage(Color.t("&a/asw <info> &8- &fshow about the plugin"));
							p.sendMessage(Color.t("&a/asw join <map> &fjoin a aleatory map, or a one specified."));
						} else {
							p.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							p.sendMessage(Color.t(""));
							p.sendMessage(Color.t("&a/asw join <map> &fjoin a aleatory map, or a one specified."));
						}
						return true;
					}
					
					p.sendMessage(Color.t(lang_en.getString("messages.cmd-null")));
					return true;
					
				} else if(config.getString("language").equals("ES")) {
					if(args.length == 0) {
						p.sendMessage(Color.t(lang_es.getString("messages.cmd-args")));
						return true;
					}
					
					if(args[0].equalsIgnoreCase("info")) {
						if(p.hasPermission("askywars.info") || p.isOp()) {
							p.sendMessage(Color.t("&8[&bASW&8] &aversion &e" + ASkyWars.getPluginVersion() + "&a corriendo en &e" + ASkyWars.getServerVersion()));
						} else {
							p.sendMessage(Color.t(lang_es.getString("messages.missing-permission")));
						}
						return true;
					}
				
					if(args[0].equalsIgnoreCase("help")) {
						if(p.hasPermission("askywars.help.admin") || p.isOp()) {
							p.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							p.sendMessage(Color.t(""));
							p.sendMessage(Color.t("&a/asw <help> &8- &fmuestra este mensaje"));
							p.sendMessage(Color.t("&a/asw <info> &8- &fmuestra informacion sobre el plugin"));
							p.sendMessage(Color.t("&a/asw join <mapa> &fentra a un mapa especificado o aleatorio."));
						} else {
							p.sendMessage(Color.t("&8[&bASkyWars&8] &e-"));
							p.sendMessage(Color.t(""));
							p.sendMessage(Color.t("&a/asw join <map> &fentra a un mapa especificado o aleatorio."));
						}
						return true;
					}
					
					p.sendMessage(Color.t(lang_es.getString("messages.cmd-null")));
					return true;
				} else {
					p.sendMessage(Color.t("&8[&bASW&8] &cthe plugin currently don't have support for this idiom, sorry."));
					return true;
				}
			}
		}
		return false;
	}
}
