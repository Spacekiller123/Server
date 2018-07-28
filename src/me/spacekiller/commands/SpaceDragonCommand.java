package me.spacekiller.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEnderDragon;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import net.minecraft.server.v1_12_R1.EntityEnderDragon;

public class SpaceDragonCommand implements CommandExecutor, Listener{
	
	static String prefix = "§9§l[§8§lSpace§9§l] §7";
	
	ArrayList<EnderDragon> dra = new ArrayList<EnderDragon>();
	
	Main plugin;
	
	Player p;
	
	public SpaceDragonCommand(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("spacedragon") && p.hasPermission("system.dragon")) {
			Location loc = p.getLocation();
			if (args.length == 0) {
				p.sendMessage(prefix + "/spacedragon spawn/remove");
				return true;
			}
			if (args[0].equalsIgnoreCase("spawn")) {
				EnderDragon ed = loc.getWorld().spawn(loc, EnderDragon.class);
				ed.setVelocity(new Vector(0, 0.3, 0));
				ed.setCustomName("§4§lSpaceDragon");
				ed.setCustomNameVisible(false);
				ed.setPassenger(p);
				dra.add(ed);
				startMovement();
				return true;
			}
			if (args[0].equalsIgnoreCase("remove")) {
				dra.get(0).setHealth(0);
				dra.remove(0);
				return true;
			}
		}
		return true;
	}
	private void startMovement() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				if(!dra.isEmpty()) {
					System.out.println("Test");
					dra.get(0).setVelocity(p.getLocation().getDirection().multiply(-3));
				}
			}
		}, 10L, 10L);
	}
}
