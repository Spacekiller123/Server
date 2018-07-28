package me.spacekiller.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.spacekiller.main.Main;

public class LeaveListener implements Listener {
	
	private Main plugin;
	private FileConfiguration cfg;
	
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		cfg = plugin.getConfig();
		if(!cfg.getBoolean("LeaveMessage")) {
			e.setQuitMessage(null);
		}
	}
}
