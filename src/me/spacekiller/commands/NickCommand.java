package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class NickCommand implements CommandExecutor {

	Main plugin;
	
	public NickCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("nick")) {
			Player p = (Player) sender;
			if(args.length == 0) {
				sender.sendMessage(SystemData.Server + "Dein Nickname ist: " + p.getDisplayName());
			}else if(args.length == 1) {
				if(sender.hasPermission("server.nick.set")) {
					p.setDisplayName(SystemData.getFormattingColorCodes(args[0]) + "§f");
					sender.sendMessage(SystemData.Server + "Dein Nickname ist nun: " + p.getDisplayName());
				}else {
					sender.sendMessage(SystemData.noPerm);
				}
			}else if(args.length == 2) {
				if(sender.hasPermission("server.nick.change")) {
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					if(op.isOnline()) {
						if(args[1].equalsIgnoreCase("remove")) {
							op.getPlayer().setDisplayName(SystemData.getFormattingColorCodes(op.getName()) + "§f");
							sender.sendMessage(SystemData.Server + "Der Nickname von §f§l" + op.getName() + "§7 wurde entfernt");
						}else {
							op.getPlayer().setDisplayName(SystemData.getFormattingColorCodes(args[1]));
							sender.sendMessage(SystemData.Server + "Der Nickname von §f§l" + op.getName() + "§7 wurde auf " + op.getPlayer().getDisplayName() + " §7geändert");
						}
					}else {
						sender.sendMessage(SystemData.Online);
					}
					
				}else {
					sender.sendMessage(SystemData.noPerm);
				}
			}
		}
		return false;
	}
	

}
