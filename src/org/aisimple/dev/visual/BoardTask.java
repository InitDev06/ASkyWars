package org.aisimple.dev.visual;

import java.text.NumberFormat;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.clip.placeholderapi.PlaceholderAPI;
import org.aisimple.dev.ASkyWars;
import org.aisimple.dev.color.Color;

public class BoardTask {

	public void create() {
		new BukkitRunnable() {			
			@Override
			public void run() {
				FileConfiguration scoreboard = ASkyWars.getScoreboard();
				for(Player p : Bukkit.getOnlinePlayers()) {
					updateScoreboard(p, scoreboard);
				}
			}
		}.runTaskTimer(ASkyWars.getInstance(), 0, 20);
	}
	
	private void updateScoreboard(Player p, FileConfiguration scoreboard) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = sb.registerNewObjective("askywars", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(Color.t(scoreboard.getString("scoreboard.name")));
		List<String> scores = scoreboard.getStringList("scoreboard.lines");
		for(int i = 0 ; i < scores.size(); i++) {
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			Score score = objective.getScore(Color.t(PlaceholderAPI.setPlaceholders(p, scores.get(i))).replaceAll("%player_name%", 
					p.getDisplayName()).replaceAll("%level%", nf.format(p.getLevel())+"")
					.replaceAll("%max_experience%", nf.format(p.getExpToLevel())+"").
					replaceAll("%connected%", String.valueOf(Bukkit.getOnlinePlayers().size())));
			
			score.setScore(scores.size()-(i));
		}
		p.setScoreboard(sb);
	}
}
