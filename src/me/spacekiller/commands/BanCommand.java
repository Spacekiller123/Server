package me.spacekiller.commands;

import java.io.File;
import java.io.IOException;

import mkremins.fanciful.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;

public class BanCommand implements CommandExecutor {
	
	public static File sperre = new File("plugins/Server/", "Ban.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(sperre);
	
	private String reason = "Insult!";
	public String perma = "permanent";
	
	String prefix = SystemData.Ban;
	String prefix2 = SystemData.Kick;

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if (cmd.getName().equalsIgnoreCase("uban")) {
			if (sender.getName().equals("Spacekiller")
					|| sender.getName().equals("_sH0xy_")) {
				if (args.length <= 1) {
					sender.sendMessage(prefix + "§7Benutzung: /uban <Spieler> <Grund>");
					return true;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(args[1]);
					for (int i = 2; i < args.length; i++) {
						sb.append(" ");
						sb.append(args[i]);
					}
					String grund = sb.toString();
					if (Bukkit.getPlayer(args[0]) != null) {
						cfg.set("ban." + args[0] + ".grund", grund);
						cfg.set("ban." + args[0] + ".dauer", perma);
						try {
							cfg.save(sperre);
						} catch (IOException e) {
							e.printStackTrace();
						}
						sender.sendMessage(prefix + "§7Du wurdest von §9§l" + sender.getName() + " §7permanent gesperrt! §8§lGrund§7§l: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
						sender.sendMessage(prefix + "§7Du hast den Spieler  " + ChatColor.RED + args[0] + " §7gesperrt!");
						sender.sendMessage(prefix +  "§7Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
						return true;
					} else {
						cfg.set("ban." + args[0] + ".grund", grund);
						cfg.set("ban." + args[0] + ".dauer", perma);
						try {
							cfg.save(sperre);
						} catch (IOException e) {
							e.printStackTrace();
						}
						sender.sendMessage(prefix + "§7Du hast den Offline-Spieler " + ChatColor.RED + args[0] + " §7gesperrt!");
						sender.sendMessage(prefix + "§7Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
						return true;
					}
				}
			} else {
				sender.sendMessage(prefix + "§7Du hast leider keine Rechte diesen Befehl zu benutzten.");
				return true;
			}
		}

		if ((cmd.getName().equalsIgnoreCase("ban"))
				|| (cmd.getName().equalsIgnoreCase("sperre"))) {
			if (sender.hasPermission("system.ban")) {
				if (args.length == 1 && args[0].equalsIgnoreCase("see")) {
					sender.sendMessage(prefix + "Gebannte Spieler:");
					for (String banm : cfg.getConfigurationSection("ban").getKeys(false)) {
						if (cfg.getString("ban." + banm + ".dauer").equalsIgnoreCase("permanent")){
							sender.sendMessage(ChatColor.GRAY + banm + ": §9Permanent");
						}else {
							sender.sendMessage(ChatColor.GRAY + banm + ": §9Temporär");
						}
						
					}
					return true;
				}
				if (args.length <= 1) {
					sender.sendMessage(prefix + "Benutzung: /sperre | ban <Spieler> <Grund>");
					return true;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(args[1]);
					for (int i = 2; i < args.length; i++) {
						sb.append(" ");
						sb.append(args[i]);
					}
					String grund = sb.toString();
					if (Bukkit.getPlayer(args[0]) != null) {
						Player p2 = Bukkit.getPlayer(args[0]);
						if (sender == Bukkit.getPlayer(args[0])) {
							sender.sendMessage(prefix + "Du kannst dich nicht selbst bannen!");
							return true;
						} else if (args[0].equalsIgnoreCase("Spacekiller")) {
							sender.sendMessage(prefix + "Du darfst den Dev nicht bannen");
							return true;
						} else {
							if (p2.hasPermission("system.ban.ignore")) {
								sender.sendMessage(prefix + "Dieser Spieler hat die Ignore-Rechte");
								return true;
							}
							cfg.set("ban." + args[0] + ".grund", grund);
							cfg.set("ban." + args[0] + ".dauer", perma);
							try {
								cfg.save(sperre);
							} catch (IOException e) {
								e.printStackTrace();
							}
							Bukkit.getPlayer(args[0]).kickPlayer(prefix + "Du wurdest von §9§l" + sender.getName() + " §7permanent gesperrt! §8§lGrund§7§l: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
							Bukkit.broadcastMessage(prefix + "Der Spieler " + ChatColor.RED + args[0] + " §7wurde von §9§l" + sender.getName() + " §7gesperrt!");
							Bukkit.broadcastMessage(prefix + "Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
							return true;
						}
					} else {
						if (args[0].equalsIgnoreCase("Spacekiller")) {
							sender.sendMessage(prefix + "Du darfst den Dev nicht bannen.");
							return true;
						}
						cfg.set("ban." + args[0] + ".grund", grund);
						cfg.set("ban." + args[0] + ".dauer", perma);
						try {
							cfg.save(sperre);
						} catch (IOException e) {
							e.printStackTrace();
						}
						sender.sendMessage(prefix + "Du hast den Offline-Spieler " + ChatColor.RED + args[0] + " §7gesperrt!");
						sender.sendMessage(prefix + "Grund: " + ChatColor.translateAlternateColorCodes('&',new StringBuilder().append(ChatColor.DARK_RED).append(grund).toString()));
						return true;
					}
				}
			} else {
				sender.sendMessage(prefix + "Du hast leider keine Rechte diesen Befehl zu benutzten.");
				return true;
			}
		}

		if ((cmd.getName().equalsIgnoreCase("kick"))
				|| (cmd.getName().equalsIgnoreCase("kicken"))) {
			if (sender.hasPermission("system.kick")) {
				if (args.length == 0) {
					sender.sendMessage(prefix2 + "Benutzung: /kick | kicken <Spieler> <Grund>");
					return true;
				}
				if (args.length >= 2) {
					Player opfer = Bukkit.getPlayer(args[0]);
					this.reason = "";
					for (int i = 1; i < args.length; i++) {
						this.reason = (this.reason + " " + args[i]);
					}
					this.reason = ChatColor.translateAlternateColorCodes('&',
							this.reason);
					if (opfer != null) {
						if (opfer.getName().equals("Spacekiller")) {
							sender.sendMessage(prefix2 + "Du darfst den Dev nicht kicken");
							return true;
						} else if (opfer.hasPermission("system.ban.ignore")) {
							sender.sendMessage(prefix2 + "Dieser Spieler hat die Ignore-Rechte");
							return true;
						}
						opfer.kickPlayer(prefix2 + "Du wurdest von §9§l"
								+ sender.getName()
								+ " §7gekickt! §8§lGrund§7:§4" + this.reason);
						Bukkit.broadcastMessage(prefix2 + "Der Spieler §4"
								+ opfer.getName() + "§7 wurde gekickt");
						Bukkit.broadcastMessage("§8§l[§9§lReflexcraft§8§l] §8§lGrund§7:"
								+ this.reason);
						return true;
					}
				} else {
					sender.sendMessage(prefix2 + "Dieser Spieler ist nicht Online!");
					return true;
				}
			}
		} else {
			sender.sendMessage(prefix + "Du hast leider keine Rechte diesen Befehl zu benutzten.");
		}
		return true;
	}
}