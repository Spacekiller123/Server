package me.spacekiller.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.spacekiller.data.Ban;
import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;


public class TempBanCommand implements CommandExecutor {
	Main plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("tempban"))
				|| (cmd.getName().equalsIgnoreCase("tban"))) {
			if (args.length < 3) {
				sender.sendMessage(SystemData.Ban + "Benutzung: /tempban <Spieler> <Zeit> <Art> <Grund>");
			}
			if (sender.hasPermission("server.tempban")) {
				if (args.length > 3) {
					if (Main.isNumber(args[1])) {
						if (Bukkit.getPlayer(args[0]) != null) {
							long ende = System.currentTimeMillis() + Ban.getTicks(args[2], Integer.parseInt(args[1]));
							long jetzt = System.currentTimeMillis();
							long laenge = ende - jetzt;
							if (laenge > 0L) {
								StringBuilder sb = new StringBuilder();
								for (int i = 3; i < args.length; i++) {
									sb.append(args[i]);
									sb.append(" ");
								}
								String grund = sb.toString();
								BanCommand.cfg.set("ban." + args[0] + ".grund", grund);
								BanCommand.cfg.set("ban." + args[0] + ".dauer", ende);
								try {
									BanCommand.cfg.save(BanCommand.sperre);
								} catch (IOException e) {
									e.printStackTrace();
								}
								Bukkit.getPlayer(args[0]).kickPlayer(SystemData.Ban + "Du wurdest von §9§l" + sender.getName() + " §7für §9" + Ban.getTimeConvert(ende) + " §7gebannt! §8§lGrund§7§l: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
								Bukkit.broadcastMessage(SystemData.Ban + "Der Spieler " + ChatColor.RED + args[0] + " §7wurde von §9§l" + sender.getName() + " §7für §9" + Ban.getTimeConvert(ende) + " §7gebannt!");
								Bukkit.broadcastMessage(SystemData.Ban + "Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
								return true;
							}else {
								sender.sendMessage(SystemData.Ban + "Keine gültige Zahl");
								return true;
							}
							}else {
								long ende = System.currentTimeMillis() + Ban.getTicks(args[2], Integer.parseInt(args[1]));
								long jetzt = System.currentTimeMillis();
								long laenge = ende - jetzt;
								if (laenge > 0L) {
									StringBuilder sb = new StringBuilder();
									for (int i = 3; i < args.length; i++) {
										sb.append(args[i]);
										sb.append(" ");
									}
									String grund = sb.toString();
									BanCommand.cfg.set("ban." + args[0] + ".grund", grund);
									BanCommand.cfg.set("ban." + args[0] + ".dauer", ende);
									try {
										BanCommand.cfg.save(BanCommand.sperre);
									} catch (IOException e) {
										e.printStackTrace();
									}
									Bukkit.broadcastMessage(SystemData.Ban + "Der Spieler " + ChatColor.RED + args[0] + " §7wurde von §9§l" + sender.getName() + " §7für §9" + Ban.getTimeConvert(ende) + " §7gebannt!");
									Bukkit.broadcastMessage(SystemData.Ban + "Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
									return true;
								}else {
									sender.sendMessage(SystemData.Ban + "Keine gültige Zahl");
									return true;
								}
							}
						}else {
							sender.sendMessage(SystemData.Ban + "Keine gültige Zahl");
							return true;
						}
				}
			}else {
				sender.sendMessage(SystemData.Ban + "Du hast leider keine Rechte diesen Befehl auszuführen");
				return true;
			}
		}else {
			sender.sendMessage(SystemData.Ban + "Benutzung: /tempban <Spieler> <Zeit> <Art> <Grund>");
			return true;
		}
		return true;
	}

}
