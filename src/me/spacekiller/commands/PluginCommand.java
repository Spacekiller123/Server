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
		if(cmd.getName().equalsIgnoreCase("pl") || cmd.getName().equalsIgnoreCase("plugin")) {
			sender.sendMessage(SystemData.Server + "§7§lDiese Daten sind vertraulich...");
		}else if(cmd.getName().equalsIgnoreCase("?")){
			sender.sendMessage(SystemData.Server + "§7§lNutze /hilfe um die Befehle nachzuschauen.");
		}
		return false;
	}

}
