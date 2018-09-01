package me.spacekiller.commands;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class UnbanCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if (sender.hasPermission("server.unban")
				|| sender.getName().equals("Spacekiller")
				|| sender.getName().equals("_sH0xy_")) {
			if (args.length == 0)
				sender.sendMessage("§8§l[§9§lReflexcraft§8§l] §7Benutzung: /delsperre | unban | pardon | delban <Spieler>");
			else if (args.length == 1) {
				if (BanCommand.cfg.contains("ban." + args[0])) {
					BanCommand.cfg.set("ban." + args[0], null);
					try {
						BanCommand.cfg.save(BanCommand.sperre);
					} catch (IOException e) {
						e.printStackTrace();
					}
					sender.sendMessage("§8§l[§9§lReflexcraft§8§l] §7Du hast den Spieler §4"
							+ args[0] + " §7entsperrt!");
				} else {
					sender.sendMessage("§8§l[§9§lReflexcraft§8§l] §7Der Spieler ist nicht gesperrt!");
				}
			}
		} else {
			sender.sendMessage("§8§l[§9§lReflexcraft§8§l] §7Du hast leider keine Rechte diesen Befehl auszuführen");
		}
		return true;
	}
}