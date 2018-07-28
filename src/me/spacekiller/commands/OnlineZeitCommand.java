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
	
	private SystemData sys;
	
	public OnlineZeitCommand(Main main) {
		this.plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String labble, String[] args) {
		FileConfiguration cfg = SystemData.getOnlineConfig();
		if (sender.hasPermission("system.onlinezeit")) {
			if(args.length == 0) {
				String p = sender.getName();
				int days = sys.getDays(p);
				int hours  = sys.getHours(p);
				int minutes = sys.getMins(p);
				int seconds = sys.getSecs(p);
				sender.sendMessage(SystemData.Server + "§7Deine gesammte Spielzeit ist:");
				sender.sendMessage("§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " Sekunden" );
			}else if(args.length == 1) {
				if(cfg.contains(args[0])) {
					String p = args[0];
					int days = sys.getDays(p);
					int hours  = sys.getHours(p);
					int minutes = sys.getMins(p);
					int seconds = sys.getSecs(p);
					sender.sendMessage(SystemData.Server + "§7Die gesammte Spielzeit von §6§l" + cfg.getString(args[0]) + " §7ist:");
					sender.sendMessage("§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " Sekunden" );
				}else {
					sender.sendMessage("§7 Spieler nicht gefunden");
				}
				
			}
			}else {
			sender.sendMessage(SystemData.Server + "§7Verwendung: §6/onlinezeit <Spieler>");
			return true;
		}
		return false;
	}

}
