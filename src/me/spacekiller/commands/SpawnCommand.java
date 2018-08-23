package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
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
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			Player p = (Player) sender;
			FileConfiguration cfg = plugin.getConfig();
			Location loc;
			if (cfg.contains("Spawn")) {
				World w = Bukkit.getWorld(cfg.getString("Spawn.world"));
				double x = cfg.getDouble("Spawn.x");
				double y = cfg.getDouble("Spawn.y");
				double z = cfg.getDouble("Spawn.z");
				float yaw = (float) cfg.getDouble("Spawn.yaw");
				loc = new Location(w, x, y, z, yaw, 0);
			} else {
				loc = p.getLocation().getWorld().getSpawnLocation();
			}

			if (args.length == 0) {
				p.teleport(loc);
			} else if (args.length == 1) {
				OfflinePlayer op = (Player) Bukkit.getOfflinePlayer(args[0]);
				if (op.isOnline()) {
					p.teleport(loc);
				} else {
					sender.sendMessage(SystemData.Server + "Der Spieler ist leider nicht online.");
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission("server.setspawn")) {
				FileConfiguration cfg = plugin.getConfig();
				Player p = (Player) sender;
				cfg.set("Spawn.world", p.getLocation().getWorld().getName());
				cfg.set("Spawn.x", p.getLocation().getX());
				cfg.set("Spawn.y", p.getLocation().getY());
				cfg.set("Spawn.z", p.getLocation().getZ());
				cfg.set("Spawn.yaw", p.getLocation().getYaw());
				sender.sendMessage(SystemData.Server + "Der neue Spawn:");
				sender.sendMessage("Welt: " + p.getLocation().getWorld().getName());
				sender.sendMessage("X: " + p.getLocation().getX());
				sender.sendMessage("Y: " + p.getLocation().getY());
				sender.sendMessage("Z: " + p.getLocation().getZ());
				plugin.saveConfig();
			} else {
				sender.sendMessage(SystemData.noPerm);
			}
		
		}
		return false;
	}

}
