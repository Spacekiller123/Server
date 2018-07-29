package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class PluginCommand implements CommandExecutor{

	Main plugin;
	
	public PluginCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(!sender.isOp() || !sender.hasPermission("server.plugin")) {
			if(cmd.getName().equalsIgnoreCase("pl") || cmd.getName().equalsIgnoreCase("plugin")) {
				sender.sendMessage(SystemData.Server + "§7§lDiese Daten sind vertraulich...");
			}
		}
		
		return false;
	}

}
