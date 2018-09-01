package me.spacekiller.commands;

import java.io.File;
import java.io.IOException;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;

public class WarpCommand implements CommandExecutor {
	
	public static File warps = new File("plugins/Server/", "Warps.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
	
	String prefix = SystemData.Warp;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player p = (Player) sender;
		if (args.length == 0 && cmd.getName().equalsIgnoreCase("warp") || args.length == 0 && cmd.getName().equalsIgnoreCase("swarp")) {
			sender.sendMessage(prefix + "§7Benutzung: /warp <name>");
			sender.sendMessage(prefix + "§7Liste der Warps /warps");
			return true;
		}
		/*
		if (cmd.getName().equalsIgnoreCase("pwarp")) {
			if (p.hasPermission("server.warp")) {
				String warp = args[0].toLowerCase();
				if (warp.equalsIgnoreCase("lager") && !p.hasPermission("server.warp.lager")) {
					sender.sendMessage(prefix + "Du hast keine Berechtigung für das Skypvp-Kistenlager.");
					return true;
				}
				if (cfg.contains("Warps." + warp)) {
					String w = cfg.getString("Warps." + warp + ".World");
					double x = cfg.getDouble("Warps." + warp + ".X");
					double y = cfg.getDouble("Warps." + warp + ".Y");
					double z = cfg.getDouble("Warps." + warp + ".Z");
					double yaw = cfg.getDouble("Warps." + warp + ".Yaw");
					double pitch = cfg.getDouble("Warps." + warp + ".Pitch");
					Location l = new Location(Bukkit.getWorld(w), x, y, z, (float) yaw, (float) pitch);
					p.teleport(l);
					sender.sendMessage(prefix + "§7Du wurdest erfolgreich teleportiert");
					//sender.sendMessage(prefix + "§7Du bist nun in §9" + Bukkit.getWorld(w).getName());
					return true;
				}else {
					sender.sendMessage(prefix + "§7Der Warp existiert nicht.");
				}
			}else {
				sender.sendMessage(prefix + "§7Du hast keine Rechte diesen Befehl auszuführen");
			}
		}
		*/
		if (cmd.getName().equalsIgnoreCase("warp")) {
			if (p.hasPermission("server.warp")) {
				String warp = args[0].toLowerCase();
				if (cfg.contains("Warps." + warp)) {
					String w = cfg.getString("Warps." + warp + ".World");
					double x = cfg.getDouble("Warps." + warp + ".X");
					double y = cfg.getDouble("Warps." + warp + ".Y");
					double z = cfg.getDouble("Warps." + warp + ".Z");
					double yaw = cfg.getDouble("Warps." + warp + ".Yaw");
					double pitch = cfg.getDouble("Warps." + warp + ".Pitch");
					Location l = new Location(Bukkit.getWorld(w), x, y, z, (float) yaw, (float) pitch);
					p.teleport(l);
					sender.sendMessage(prefix + "§7Du wurdest erfolgreich teleportiert");
					//sender.sendMessage(prefix + "§7Du bist nun in §9" + Bukkit.getWorld(w).getName());
					return true;
				}else {
					sender.sendMessage(prefix + "§7Der Warp existiert nicht.");
				}
			}else {
				sender.sendMessage(prefix + "§7Du hast keine Rechte diesen Befehl auszuführen");
			}
		}
		return true;
	}
}
