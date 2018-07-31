package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class HelpCommand implements CommandExecutor {
	
	Main plugin;
	
	public HelpCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("?") || cmd.getName().equalsIgnoreCase("h") || cmd.getName().equalsIgnoreCase("help")){
			Player p = (Player) sender;
			sender.sendMessage(SystemData.Server + "§7§lVersuche es mal mit /gui, da gibt es alles was du brauchst");
		}
		return false;
	}

}
