package com.github.peddach.spawnPlugin;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class SpawnPlugin extends JavaPlugin {

	private static SpawnPlugin plugin;
	private static Chat chat = null;

	@Override
	public void onEnable() {
		plugin = this;

		this.saveDefaultConfig();
		this.saveConfig();
		this.reloadConfig();
		
		if(setupChat() == false) {
			getServer().getPluginManager().disablePlugin(this);
		}

	}

	private boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	public static SpawnPlugin getInstance() {
		return plugin;
	}
	
	public static Chat getChat() {
		return chat;
	}
}
