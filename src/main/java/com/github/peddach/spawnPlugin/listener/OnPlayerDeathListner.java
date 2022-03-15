package com.github.peddach.spawnPlugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.github.peddach.spawnPlugin.SpawnPlugin;

public class OnPlayerDeathListner implements Listener {
	@EventHandler
	public void onPlayerDieEvent(PlayerDeathEvent event) {
		event.setDeathMessage(null);
		event.setDroppedExp(0);
		event.setKeepInventory(true);
		event.getEntity().spigot().respawn();
		
		long x = SpawnPlugin.getInstance().getConfig().getLong("X");
		long y = SpawnPlugin.getInstance().getConfig().getLong("Y");
		long z = SpawnPlugin.getInstance().getConfig().getLong("Z");
		long pitch = SpawnPlugin.getInstance().getConfig().getLong("Pitch");
		long yaw = SpawnPlugin.getInstance().getConfig().getLong("Yaw");
		World world = Bukkit.getWorld(SpawnPlugin.getInstance().getConfig().getString("World"));
		
		event.getEntity().teleport(new Location(world, x, y, z, yaw, pitch));
	}
	
}
