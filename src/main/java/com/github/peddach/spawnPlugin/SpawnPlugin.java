package com.github.peddach.spawnPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SpawnPlugin extends JavaPlugin{
	
	private static SpawnPlugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		this.saveDefaultConfig();
		this.saveConfig();
		this.reloadConfig();
		
	}

	public static SpawnPlugin getInstance() {
		return plugin;
	}
}
