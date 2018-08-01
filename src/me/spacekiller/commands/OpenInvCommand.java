package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class OpenInvCommand implements CommandExecutor {

	Main plugin;
	
	public OpenInvCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("openinv")) {
			if(args.length == 0 && sender.hasPermission("server.openinv.self")) {
				p.openInventory(p.getInventory());
			}else if(args.length == 1 && sender.hasPermission("server.openinv.other")) {
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					p.openInventory(op.getPlayer().getInventory());
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
