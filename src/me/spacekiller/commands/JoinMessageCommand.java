package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class JoinMessageCommand implements CommandExecutor {

	Main plugin;
	FileConfiguration cfg;
	
	public JoinMessageCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		cfg = plugin.getConfig();
		if(sender.hasPermission("server.joinmessage")) {
			if(cmd.getName().equalsIgnoreCase("joinmessage")) {
				if(args.length > 0) {
					if(args.length > 1) {
						System.out.println("boolean");
						String message = String.join(" ", args);
						cfg.set("JoinMessage", message);
						plugin.saveConfig();
					}else {	
						cfg.set("JoinMessage", Boolean.parseBoolean(args[0].replaceAll(" ", null)));
						plugin.saveConfig();
					}
					sender.sendMessage(SystemData.Server + "JoinMessage wurde auf " + cfg.getString("JoinMessage") + " gesetzt");
				}else {
					sender.sendMessage(SystemData.Server + "�7Verwendung: �6/joinmessage <message>");
				}
			}
		}else {
			sender.sendMessage(SystemData.noPerm);
		}
		
		return false;
	}
	
	
	
}
