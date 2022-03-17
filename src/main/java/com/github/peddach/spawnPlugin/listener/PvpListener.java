package com.github.peddach.spawnPlugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.github.peddach.spawnPlugin.SpawnPlugin;

public class PvpListener implements Listener{

	@EventHandler
	public void onPlayerAttackEvent(EntityDamageEvent event) {
		if(event.getCause() == DamageCause.VOID) {
			
			double x = SpawnPlugin.getInstance().getConfig().getLong("X");
			double y = SpawnPlugin.getInstance().getConfig().getLong("Y");
			double z = SpawnPlugin.getInstance().getConfig().getLong("Z");
			long pitch = SpawnPlugin.getInstance().getConfig().getLong("Pitch");
			long yaw = SpawnPlugin.getInstance().getConfig().getLong("Yaw");
			World world = Bukkit.getWorld(SpawnPlugin.getInstance().getConfig().getString("World"));
			
			event.getEntity().teleport(new Location(world, x, y, z, yaw, pitch));
		}
		event.setCancelled(true);
	}
}
