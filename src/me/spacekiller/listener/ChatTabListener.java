package me.spacekiller.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.server.TabCompleteEvent;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class ChatTabListener implements Listener{
	
	Main plugin;
	
	public ChatTabListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onTab(TabCompleteEvent e) {
		if(e.getCompletions().get(0).startsWith("/")) {
			e.setCancelled(true);
			e.getSender().sendMessage(SystemData.Server + "§7§lNutze /hilfe um die Befehle nachzuschauen.");
		}
	}

}
