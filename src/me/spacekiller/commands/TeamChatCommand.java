package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class TeamChatCommand implements CommandExecutor {
	
	Main plugin;
	
	String prefix = SystemData.Teamchat;
	
	public TeamChatCommand(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand (CommandSender sender, Command command, String string, String[] args) {
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("teamchat") && p.hasPermission("server.teamchat")) {
			if (args.length == 0) {
				p.sendMessage(prefix + "Benutzung: /teamchat see/join/leave/clear/list");
				return true;
			}
			if (!args[0].equalsIgnoreCase("join") && !args[0].equalsIgnoreCase("leave") && !args[0].equalsIgnoreCase("clear") && !args[0].equalsIgnoreCase("list") && !args[0].equalsIgnoreCase("see")) {
				p.sendMessage(prefix + "Benutzung: /teamchat see/join/leave/clear/list");
				return true;
			}
			if (args[0].equalsIgnoreCase("see")) {
				if (SystemData.teamchatsee.contains(p)) {
						SystemData.teamchatsee.remove(p);
						sender.sendMessage(prefix + "Du kannst den Teamchatverlauf nicht mehr sehen.");
						return true;
				}
				SystemData.teamchatsee.add(p);
				sender.sendMessage(prefix + "Du kannst jetzt den Teamchatverlauf sehen.");
				return true;
			}
			if (args[0].equalsIgnoreCase("clear") && p.hasPermission("system.teamchat.admin")) {
				if (args.length == 1) {
					sender.sendMessage(prefix + "Benutzung: /teamchat clear chat/see");
					return true;
				}
				if (args[1].equalsIgnoreCase("chat")) {
					int anzahl = 0;
					for (int i = 0; i < SystemData.teamchat.size(); i++) {
						if (p.getName() == SystemData.teamchat.get(i).getName()) {
							for (Player teamplayer : SystemData.teamchat) {
								Bukkit.getPlayer(SystemData.teamchat.get(anzahl).getName()).sendMessage(prefix + "Alle Spieler wurden aus dem Teamchat entfernt.");
							anzahl++;
							}
							anzahl = 0;
						}
				    }
					SystemData.teamchat.clear();
					return true;
				}
				if (args[1].equalsIgnoreCase("see")) {
					int anzahl = 0;
					for (int i = 0; i < SystemData.teamchatsee.size(); i++) {
						if (p.getName() == SystemData.teamchatsee.get(i).getName()) {
							for (Player teamplayer : SystemData.teamchatsee) {
								Bukkit.getPlayer(SystemData.teamchatsee.get(anzahl).getName()).sendMessage(prefix + "Alle Spieler wurden aus dem Teamchat entfernt.");
							anzahl++;
							}
							anzahl = 0;
						}
				    }
					SystemData.teamchatsee.clear();
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("list") && p.hasPermission("system.teamchat.admin")) {
				if (args.length == 1) {
					p.sendMessage(prefix + "/teamchat list chat/see");
					return true;
				}
				if (args[1].equalsIgnoreCase("chat")) {
					p.sendMessage(prefix + "Teamchat-Teilnehemer:");
					int temp = 0;
					for (Player player : SystemData.teamchat) {
						p.sendMessage("§7" + SystemData.teamchat.get(temp).getName());
						temp++;
					}
					return true;
				}
				if (args[1].equalsIgnoreCase("see")) {
					p.sendMessage(prefix + "Spieler die den Teamchat zu sehen:");
					int temp = 0;
					for (Player player : SystemData.teamchatsee) {
						p.sendMessage("§7" + SystemData.teamchatsee.get(temp).getName());
						temp++;
					}
					return true;
				}
				
			}
			if (args[0].equalsIgnoreCase("join")) {
				if (SystemData.teamchat.contains(p)) {
						sender.sendMessage(prefix + "Du bist breits im Teamchat.");
						return true;
				}
				SystemData.teamchat.add(p);
				sender.sendMessage(prefix + "Du bist nun im Teamchat.");
				return true;
			}
			if (args[0].equalsIgnoreCase("leave")) {
				if (SystemData.teamchat.contains(p)) {
					SystemData.teamchat.remove(p);
					sender.sendMessage(prefix + "Du bist nicht mehr im Teamchat.");
					return true;
					}
				}
				sender.sendMessage(prefix + "Du bist nicht im Teamchat");
				return true;
			}else {
				p.sendMessage(prefix + "Du hast leider keine Rechte diesen Befehl aus zu führen.");
			}
		return true;
	}
}
