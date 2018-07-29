package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class RamCommand implements CommandExecutor {
	
	Main plugin;
	
	public RamCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ram")) {
			if ((p.hasPermission("server.ram")) && (args.length == 0)) {
				double ram = SystemData.usedMemory();
				if ((ram >= 0.0D) && (ram <= 10.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§a§l▄");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §a§l" + ram + "§r§l%!");
					p.sendMessage("§l(§a§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §a§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 10.0D) && (ram <= 20.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§a§l█");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §a§l" + ram + "§r§l%!");
					p.sendMessage("§l(§a§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §a§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 20.0D) && (ram <= 30.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§2§l██");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §2§l" + ram + "§r§l%!");
					p.sendMessage("§l(§2§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §2§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 30.0D) && (ram <= 40.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§2§l███");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §2§l" + ram + "§r§l%!");
					p.sendMessage("§l(§2§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §2§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 40.0D) && (ram <= 50.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage("§l(§6§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §6§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 50.0D) && (ram <= 60.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l█████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage("§l(§6§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §6§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 60.0D) && (ram <= 70.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l██████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage("§l(§6§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §6§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 70.0D) && (ram <= 80.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§c§l███████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §c§l" + ram + "§r§l%!");
					p.sendMessage("§l(§c§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §c§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 80.0D) && (ram <= 90.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§c§l████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §c§l" + ram + "§r§l%!");
					p.sendMessage("§l(§c§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §c§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if ((ram >= 90.0D) && (ram < 100.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§4§l█████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §4§l" + ram + "§r§l%!");
					p.sendMessage("§l(§4§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §4§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
				if (ram == 100.0D) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§4§l██████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §4§l" + ram + "§r§l%!");
					p.sendMessage("§l(§4§l" + SystemData.RUNTIME.totalMemory() / 1048576.0D + " §r§lMB von §4§l"
							+ SystemData.RUNTIME.maxMemory() / 1048576.0D + " §r§lMB)");
				}
			}
		} else {
			p.sendMessage(SystemData.noPerm);
		}
		return true;
	}
}