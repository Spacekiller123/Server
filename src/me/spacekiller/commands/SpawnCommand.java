package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class SpawnCommand implements CommandExecutor {

	Main plugin;
	
	public SpawnCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			Player p = (Player) sender;
			Location loc = Bukkit.getWorld("map-lobby").getSpawnLocation();
			if(args.length == 0) {
				p.teleport(loc);
			}else if(args.length == 1){
				OfflinePlayer op = (Player) Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					p.teleport(loc);
				}else {
					sender.sendMessage(SystemData.Server + "Der Spieler ist leider nicht online.");
				}
			}
		}
		return false;
	}

}
