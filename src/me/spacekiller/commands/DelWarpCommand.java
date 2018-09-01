package me.spacekiller.commands;

import java.io.File;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;

public class DelWarpCommand implements CommandExecutor {
	
	String prefix = SystemData.Warp;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player p = (Player) sender;
		if (args.length == 0 && cmd.getName().equalsIgnoreCase("delwarp")) {
			p.sendMessage(prefix + "Benutzung: /delwarp <name>");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("delwarp")) {
			if (p.hasPermission("server.warp.admin")) {
				File warps = new File("plugins/Server/", "Warps.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
				String warp = args[0].toLowerCase();
				if (cfg.contains("Warps." + warp)) {
					cfg.set("Warps." + warp, null);
					try {
						cfg.save(warps);
					} catch (IOException e) {
						e.printStackTrace();
					}
					sender.sendMessage(prefix + "Der Warp §9" + args[0] + " §7wurde erfolgreich gelöscht.");
					return true;
				}else {
					sender.sendMessage(prefix + "Der Warp existiert nicht.");
					return true;
				}
			}else {
				sender.sendMessage(prefix + "Du hast leider keine Rechte diesen Befehl zu benutzten.");
			}
		}
		return true;
	}
}

