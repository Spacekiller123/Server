package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;

public class WhoIsCommand implements CommandExecutor {

	Main plugin;
	
	public WhoIsCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("whois")) {
			if(args[0] != null) {
				
			}else {
				Player p = (Player) sender;
				sender.sendMessage("§7§lName: §f" + p.getName());
				sender.sendMessage("§7§lNickname: §f" + p.getDisplayName());
				sender.sendMessage("§7§lUUID: §f" + p.getUniqueId());
				sender.sendMessage("§7§IP: §f" + p.getAddress().toString());
				sender.sendMessage("§7§Host: §f" + p.getAddress().getHostString());
				sender.sendMessage("§7§lGespielte Zeit: §f" + p.getUniqueId());
			}
		}
		return false;
	}
}
