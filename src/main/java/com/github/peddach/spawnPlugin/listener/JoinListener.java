package com.github.peddach.spawnPlugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.peddach.spawnPlugin.SpawnPlugin;

public class JoinListener implements Listener {

	private static long x = SpawnPlugin.getInstance().getConfig().getLong("X");
	private static long y = SpawnPlugin.getInstance().getConfig().getLong("Y");
	private static long z = SpawnPlugin.getInstance().getConfig().getLong("Z");
	private static long pitch = SpawnPlugin.getInstance().getConfig().getLong("Pitch");
	private static long yaw = SpawnPlugin.getInstance().getConfig().getLong("Yaw");
	private static World world = Bukkit.getWorld(SpawnPlugin.getInstance().getConfig().getString("World"));
	private static String title = SpawnPlugin.getInstance().getConfig().getString("Title");
	private static String subtitle = SpawnPlugin.getInstance().getConfig().getString("Subtitle");

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		event.getPlayer().sendTitle(title, subtitle, 20, 60, 20);
		Location location = new Location(world, x, y, z, yaw, pitch);
		event.getPlayer().playSound(location, Sound.ENTITY_PLAYER_LEVELUP, 1F, 1F);
		event.getPlayer().teleport(location);
	}

}
