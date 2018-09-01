package me.spacekiller.commands;

import java.io.File;
import java.io.IOException;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;
import mkremins.fanciful.FancyMessage;

public class WarpsCommand implements CommandExecutor {
	
	String prefix = SystemData.Warp;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("warps")) {
			if (p.hasPermission("server.warp")) {
				File warps = new File("plugins/Server/", "Warps.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
				p.sendMessage(prefix + "Warps:");
				for (String warp : cfg.getConfigurationSection("Warps").getKeys(false)) {
					new FancyMessage(warp).command("/warp " + warp).color(ChatColor.GRAY).send(p);;
				}
			}
		}	
		return true;
	}
}
