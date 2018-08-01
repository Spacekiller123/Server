package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class OpenEnderInvCommand implements CommandExecutor {
 
	Main plugin;
	
	public OpenEnderInvCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("openenderinv")) {
			if(args.length == 0 && sender.hasPermission("server.openenderinv.self")) {
				p.openInventory(p.getEnderChest());
			}else if(args.length == 1 && sender.hasPermission("server.openenderinv.other")) {
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					p.openInventory(op.getPlayer().getEnderChest());
				}else {
					sender.sendMessage(SystemData.Online);
				}
				
			}else {
				sender.sendMessage(SystemData.noPerm);
			}
		}
		return false;
	}
	
}
