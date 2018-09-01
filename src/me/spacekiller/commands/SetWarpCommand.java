package me.spacekiller.commands;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;

public class SetWarpCommand implements CommandExecutor{
	
	public static File warps = new File("plugins/Server/", "Warps.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
	
	String prefix = SystemData.Warp;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player p = (Player) sender;
		if (args.length == 0 && cmd.getName().equalsIgnoreCase("setwarp")) {
			p.sendMessage(prefix + "Benutzung: /setwarp <name>");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setwarp")) {
			if (p.hasPermission("server.warp.admin")) {
				String warp = args[0].toLowerCase();
				cfg.set("Warps." + warp + ".X", Double.valueOf(p.getLocation().getX()));
	            cfg.set("Warps." + warp + ".Y", Double.valueOf(p.getLocation().getY()));
	            cfg.set("Warps." + warp + ".Z", Double.valueOf(p.getLocation().getZ()));
	            cfg.set("Warps." + warp + ".Yaw", Float.valueOf(p.getLocation().getYaw()));
	            cfg.set("Warps." + warp + ".Pitch", Float.valueOf(p.getLocation().getPitch()));
	            cfg.set("Warps." + warp + ".World", p.getLocation().getWorld().getName());
				try {
					cfg.save(warps);
				}catch (IOException e) {
					e.printStackTrace();
				}
				sender.sendMessage(prefix + "Der Warp §9" + args[0] + " §7wurde erfolgreich gesetzt.");
				return true;
			}else {
				sender.sendMessage(prefix + "Du hast leider keine Rechte diesen Befehl zu benutzten.");
			}
		}
		return true;
	}
}
