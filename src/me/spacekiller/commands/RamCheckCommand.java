package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class RamCheckCommand implements CommandExecutor {
	
	Main plugin;
	
	public RamCheckCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ramcheck")) {
			if ((p.hasPermission("system.ram")) && (args.length == 0)) {
				double ram = SystemData.usedMemory();
				double usedmemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L;
				if ((ram >= 0.0D) && (ram <= 10.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§a§l▄");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §a§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§a§l" + usedmemory + " §r§lMB§r/ §a§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §a§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 10.0D) && (ram <= 20.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§a§l█");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §a§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§a§l" + usedmemory + " §r§lMB§r/ §a§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §a§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 20.0D) && (ram <= 30.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§2§l██");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §2§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§2§l" + usedmemory + " §r§lMB§r/ §2§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §2§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 30.0D) && (ram <= 40.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§2§l███");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §2§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§2§l" + usedmemory + " §r§lMB§r/ §2§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §2§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 40.0D) && (ram <= 50.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§6§l" + usedmemory + " §r§lMB§r/ §6§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §6§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 50.0D) && (ram <= 60.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l█████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§6§l" + usedmemory + " §r§lMB§r/ §6§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §6§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 60.0D) && (ram <= 70.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§6§l██████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §6§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§6§l" + usedmemory + " §r§lMB§r/ §6§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §6§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 70.0D) && (ram <= 80.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§c§l███████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §c§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§c§l" + usedmemory + " §r§lMB§r/ §c§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §c§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 80.0D) && (ram <= 90.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§c§l████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §c§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§c§l" + usedmemory + " §r§lMB§r/ §c§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §c§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if ((ram >= 90.0D) && (ram < 100.0D)) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§4§l█████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §4§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§4§l" + usedmemory + " §r§lMB§r/ §4§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §4§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
				if (ram == 100.0D) {
					p.sendMessage("§3=======§9§lRam§3=======");
					p.sendMessage("§4§l██████████");
					p.sendMessage("§lDie aktulle Ram-Auslastung ist §4§l" + ram + "§r§l%!");
					p.sendMessage(
							"§l(§4§l" + usedmemory + " §r§lMB§r/ §4§l" + Runtime.getRuntime().totalMemory() / 1048576.0D
									+ " §r§lMB§r/ §4§l" + Runtime.getRuntime().maxMemory() / 1048576.0D + " §r§lMB)");
					p.sendMessage("(§7§lBenutzt§r/ §7§lReserviert§r/ §7§lMaximal)");
				}
			}
		} else {
			p.sendMessage(SystemData.noPerm);
		}
		return true;
	}

	public static double usedMemory() {
		double maxmemory = Runtime.getRuntime().maxMemory();
		double resmemory = Runtime.getRuntime().totalMemory();
		double usedmemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		double resm = resmemory / 1048576.0D;
		resm /= 100.0D;
		double usedm = usedmemory / 1048576.0D;
		double auslastung = usedm / resm;
		auslastung *= 100.0D;
		auslastung = Math.round(auslastung);
		auslastung /= 100.0D;
		return auslastung;
	}
}