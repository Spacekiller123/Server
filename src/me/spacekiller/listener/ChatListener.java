package me.spacekiller.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class ChatListener implements Listener {
	
	Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		System.out.println("test");
		if(e.getPlayer().hasPermission("server.formatting")) {
			System.out.println("test2");
			e.setMessage(SystemData.getFormattingColorCodes(e.getMessage()));
		}
		
	}
	
}
