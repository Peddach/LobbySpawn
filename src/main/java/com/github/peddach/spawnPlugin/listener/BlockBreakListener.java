package com.github.peddach.spawnPlugin.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockBreakListener implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerBreakBlockEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(player.hasPermission("lobby.break")) {
			return;
		}
		player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		event.setCancelled(true);
	}
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		if(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getPlayer().hasPermission("lobby.break")) {
				return;
			}
			event.setCancelled(true);
		}
	}
}
