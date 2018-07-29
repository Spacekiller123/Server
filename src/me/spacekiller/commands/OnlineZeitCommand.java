package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;


public class OnlineZeitCommand implements CommandExecutor{
	
private Main plugin;
	
	public OnlineZeitCommand(Main main) {
		this.plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String labble, String[] args) {
		FileConfiguration cfg = SystemData.getOnlineConfig();
		if (sender.hasPermission("server.onlinezeit")) {
			if(cmd.getName().equalsIgnoreCase("onlinezeit")) {
				if(args.length == 0) {
					int days = cfg.getInt(sender.getName() + ".Tage");
					int hours  = cfg.getInt(sender.getName() + ".Stunden");
					int minutes = cfg.getInt(sender.getName() + ".Minuten");
					int seconds = cfg.getInt(sender.getName() + ".Sekunden");
					sender.sendMessage(SystemData.Server + "§7Deine gesammte Spielzeit beträgt:");
					sender.sendMessage("§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " §7Sekunden" );
				}else if(args.length == 1) {
					if(cfg.contains(args[0])) {
						int days = cfg.getInt(args[0] + ".Tage");
						int hours  = cfg.getInt(args[0] + ".Stunden");
						int minutes = cfg.getInt(args[0] + ".Minuten");
						int seconds = cfg.getInt(args[0] + ".Sekunden");
						sender.sendMessage(SystemData.Server + "§7Die gesammte Spielzeit von §6§l" + cfg.getString(args[0]) + " §7beträgt:");
						sender.sendMessage("§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " §7Sekunden" );
					}
					
				}
			}else {
				sender.sendMessage(SystemData.Server + "§7Verwendung: §6/onlinezeit <Spieler>");
			}
		}else {
			sender.sendMessage(SystemData.noPerm);
		}
		return false;
	}

}
