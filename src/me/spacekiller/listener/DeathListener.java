package me.spacekiller.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.spacekiller.main.Main;

public class DeathListener implements Listener{
	
	private Main plugin;
	
	public DeathListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);
	}

}
