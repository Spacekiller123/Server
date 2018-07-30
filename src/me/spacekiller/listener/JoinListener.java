package me.spacekiller.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.spacekiller.main.Main;

public class JoinListener implements Listener {

	
	private Main plugin;
	private FileConfiguration cfg;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		cfg = plugin.getConfig();
		Object message = cfg.get("JoinMessage");
		if(message instanceof String) {
			e.setJoinMessage(message.toString().replaceAll("%Player%", e.getPlayer().getName()));
		}else if(!cfg.getBoolean("JoinMessage")) {
			e.setJoinMessage(null);
		}	
	}
}
