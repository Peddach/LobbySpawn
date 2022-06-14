package com.github.peddach.spawnPlugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.peddach.spawnPlugin.SpawnPlugin;

public class JoinListener implements Listener {

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {

		long x = SpawnPlugin.getInstance().getConfig().getLong("X");
		long y = SpawnPlugin.getInstance().getConfig().getLong("Y");
		long z = SpawnPlugin.getInstance().getConfig().getLong("Z");
		long pitch = SpawnPlugin.getInstance().getConfig().getLong("Pitch");
		long yaw = SpawnPlugin.getInstance().getConfig().getLong("Yaw");
		World world = Bukkit.getWorld(SpawnPlugin.getInstance().getConfig().getString("World"));
		String title = ChatColor.translateAlternateColorCodes('&', SpawnPlugin.getInstance().getConfig().getString("Title"));
		String subtitle = ChatColor.translateAlternateColorCodes('&', SpawnPlugin.getInstance().getConfig().getString("Subtitle"));

		event.setJoinMessage(null);
		event.getPlayer().sendTitle(title, subtitle, 20, 60, 20);
		Location location = new Location(world, x, y, z, yaw, pitch);
		event.getPlayer().playSound(location, Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
		event.getPlayer().teleport(location);
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}

}
