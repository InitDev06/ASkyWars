package org.aisimple.dev.util;

import org.bukkit.GameMode;
import org.bukkit.inventory.ItemStack;

public class Elements {
	
	private ItemStack[] inventory;
	private ItemStack[] equipment;
	private GameMode gamemode;
	private float exp;
	private int level;
	private int food;
	private double health;
	private double maxHealth;
	
	public Elements(ItemStack[] inventory, ItemStack[] equipment, GameMode gamemode, float exp, int level, int food,
			double health, double maxHealth) {
		this.inventory = inventory;
		this.equipment = equipment;
		this.gamemode = gamemode;
		this.exp = exp;
		this.level = level;
		this.food = food;
		this.health = health;
		this.maxHealth = maxHealth;
	}

	public ItemStack[] getInventory() {
		return inventory;
	}

	public void setInventory(ItemStack[] inventory) {
		this.inventory = inventory;
	}

	public ItemStack[] getEquipment() {
		return equipment;
	}

	public void setEquipment(ItemStack[] equipment) {
		this.equipment = equipment;
	}

	public GameMode getGamemode() {
		return gamemode;
	}

	public void setGamemode(GameMode gamemode) {
		this.gamemode = gamemode;
	}

	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

}
