package me.spacekiller.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class WhoIsCommand implements CommandExecutor {

	Main plugin;
	
	public WhoIsCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender.hasPermission("server.whois")) {
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
					String groups = "";
					PermissionUser u = PermissionsEx.getUser(p);
					List<String> gs = u.getParentIdentifiers(p.getLocation().getWorld().getName());
					for(String g : gs)  {
						groups = groups + PermissionsEx.getPermissionManager().getGroup(g).getName() + " ";
					}
					sender.sendMessage("§7§lRang: §f" + groups);
					sender.sendMessage("§7§lIP: §f" + p.getAddress().toString());
					sender.sendMessage("§7§lHost: §f" + p.getAddress().getHostString());
					sender.sendMessage("§7§lGespielte Zeit: §f" + time);
				}else if(args.length == 1){
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					if(op.isOnline()) {
						int days = cfg.getInt(sender.getName() + ".Tage");
						int hours  = cfg.getInt(sender.getName() + ".Stunden");
						int minutes = cfg.getInt(sender.getName() + ".Minuten");
						int seconds = cfg.getInt(sender.getName() + ".Sekunden");
						String time = "§r§l" + days + " §7Tage, §r§l" + hours + " §7Stunden, §r§l" + minutes + " §7Minuten und §r§l" + seconds + " §7Sekunden" ;
						sender.sendMessage("§7§lWhoIs von §f" + op.getPlayer().getName());
						sender.sendMessage("§7§lName: §f" + op.getPlayer().getName());
						sender.sendMessage("§7§lNickname: §f" + op.getPlayer().getDisplayName());
						sender.sendMessage("§7§lUUID: §f" + op.getPlayer().getUniqueId());
						sender.sendMessage("§7§lIP: §f" + op.getPlayer().getAddress().toString());
						sender.sendMessage("§7§lHost: §f" + op.getPlayer().getAddress().getHostString());
						sender.sendMessage("§7§lGespielte Zeit: §f" + time);
					}else {
						sender.sendMessage(SystemData.Online);
					}
				}
			}else {
				
			}
		}else {
			sender.sendMessage(SystemData.noPerm);
		}
		
		return false;
	}
}
