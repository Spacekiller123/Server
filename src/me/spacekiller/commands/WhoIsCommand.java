package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class WhoIsCommand implements CommandExecutor {

	Main plugin;
	
	public WhoIsCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("whois")) {
			FileConfiguration cfg = SystemData.getOnlineConfig();
			if(args.length == 0) {
				Player p = (Player) sender;
				int days = cfg.getInt(sender.getName() + ".Tage");
				int hours  = cfg.getInt(sender.getName() + ".Stunden");
				int minutes = cfg.getInt(sender.getName() + ".Minuten");
				int seconds = cfg.getInt(sender.getName() + ".Sekunden");
				String time = "§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " §7Sekunden" ;
				sender.sendMessage("§7§lWhoIs von §f" + p.getName());
				sender.sendMessage("§7§lName: §f" + p.getName());
				sender.sendMessage("§7§lNickname: §f" + p.getDisplayName());
				sender.sendMessage("§7§lUUID: §f" + p.getUniqueId());
				sender.sendMessage("§7§lIP: §f" + p.getAddress().toString());
				sender.sendMessage("§7§lHost: §f" + p.getAddress().getHostString());
				sender.sendMessage("§7§lGespielte Zeit: §f" + time);
			}else {
				
			}
		}
		return false;
	}
}
