package me.spacekiller.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatListener implements Listener {
	
	Main plugin;
	
	PermissionsEx pex;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		if(e.getPlayer().hasPermission("server.formatting")) {
			e.setMessage(SystemData.getFormattingColorCodes(e.getMessage()));
		}
		String prefix = PermissionsEx.getPermissionManager().getUser(e.getPlayer().getUniqueId()).getPrefix().replaceAll("&", "§");
		String world = e.getPlayer().getLocation().getWorld().getName();
		e.setFormat("§8§l[§9§l" + world + "§8§l]§f" + prefix + " %s: %s");
	}
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerChat(AsyncPlayerChatEvent chat) {
		Player player = chat.getPlayer();
	    String message = chat.getMessage();
	    if (SystemData.teamchat.contains(player)) {
	    	for (Player teamplayer : SystemData.teamchat) {
	    		Bukkit.getPlayer(teamplayer.getName()).sendMessage(SystemData.Teamchat + player.getDisplayName() + ": " + message);
	    	}
	    	for (Player teamsee : SystemData.teamchatsee) {
	    		if(!SystemData.teamchat.contains(teamsee)) {
	    			Bukkit.getPlayer(teamsee.getName()).sendMessage(SystemData.Teamchat + player.getDisplayName() + ": " + message);
	    		}
	    	}
	    	chat.setCancelled(true);
	    }   
	}
	
}
