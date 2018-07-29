package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class GamemodeCommand implements CommandExecutor {

	Main plugin;
	
	public GamemodeCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender.hasPermission("server.gamemode") || sender.hasPermission("server.gm")) {
			if(cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
				String gamemode = "";
				boolean valid = false;
				Player p = (Player) sender;
				if(args.length == 0) {
					if(p.getGameMode().name().equalsIgnoreCase("survival")) {
						gamemode = "Überlebens-Modus";
					}else if(p.getGameMode().name().equalsIgnoreCase("creative")) {
						gamemode = "Kreativ-Modus";
					}else if(p.getGameMode().name().equalsIgnoreCase("adventure")) {
						gamemode = "Abenteuer-Modus";
					}else if(p.getGameMode().name().equalsIgnoreCase("spectator")) {
						gamemode = "Zuschauer-Modus";
					}
					sender.sendMessage(SystemData.Server + "Dein Spielmodus ist: §f§l" + gamemode);
				}else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("survival")) {
						gamemode = "Überlebens-Modus";
						p.setGameMode(GameMode.SURVIVAL);
						valid = true;
					}else if(args[0].equalsIgnoreCase("creative")) {
						gamemode = "Kreativ-Modus";
						p.setGameMode(GameMode.CREATIVE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("adventure")) {
						gamemode = "Abenteuer-Modus";
						p.setGameMode(GameMode.ADVENTURE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("spectator")) {
						gamemode = "Zuschauer-Modus";
						p.setGameMode(GameMode.SPECTATOR);
						valid = true;
					}else if(args[0].equalsIgnoreCase("überleben")) {
						gamemode = "Überlebens-Modus";
						p.setGameMode(GameMode.SURVIVAL);
						valid = true;
					}else if(args[0].equalsIgnoreCase("kreativ")) {
						gamemode = "Kreativ-Modus";
						p.setGameMode(GameMode.CREATIVE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("abenteuer")) {
						gamemode = "Abenteuer-Modus";
						p.setGameMode(GameMode.ADVENTURE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("zuschauer")) {
						gamemode = "Zuschauer-Modus";
						p.setGameMode(GameMode.SPECTATOR);
						valid = true;
					}else if(args[0].equalsIgnoreCase("0")) {
						gamemode = "Überlebens-Modus";
						p.setGameMode(GameMode.SURVIVAL);
						valid = true;
					}else if(args[0].equalsIgnoreCase("1")) {
						gamemode = "Kreativ-Modus";
						p.setGameMode(GameMode.CREATIVE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("2")) {
						gamemode = "Abenteuer-Modus";
						p.setGameMode(GameMode.ADVENTURE);
						valid = true;
					}else if(args[0].equalsIgnoreCase("3")) {
						gamemode = "Zuschauer-Modus";
						p.setGameMode(GameMode.SPECTATOR);
						valid = true;
					}else {
						sender.sendMessage(SystemData.Server + "Ungültiger Spielmodus");
					}
					if(valid) {
						sender.sendMessage(SystemData.Server + "Du bist nun im: §f§l" + gamemode);
					}
				}else if(args.length == 2) {
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
					if(op.isOnline()) {
						if(args[1].equalsIgnoreCase("survival")) {
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
							valid = true;
						}else if(args[0].equalsIgnoreCase("creative")) {
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("adventure")) {
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("spectator")) {
							gamemode = "Zuschauer-Modus";
							p.setGameMode(GameMode.SPECTATOR);
							valid = true;
						}else if(args[0].equalsIgnoreCase("überleben")) {
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
							valid = true;
						}else if(args[0].equalsIgnoreCase("kreativ")) {
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("abenteuer")) {
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("zuschauer")) {
							gamemode = "Zuschauer-Modus";
							p.setGameMode(GameMode.SPECTATOR);
							valid = true;
						}else if(args[0].equalsIgnoreCase("0")) {
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
							valid = true;
						}else if(args[0].equalsIgnoreCase("1")) {
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("2")) {
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
							valid = true;
						}else if(args[0].equalsIgnoreCase("3")) {
							gamemode = "Zuschauer-Modus";
							p.setGameMode(GameMode.SPECTATOR);
							valid = true;
						}else {
							sender.sendMessage(SystemData.Server + "Ungültiger Spielmodus");
						}
						if(valid) {
							sender.sendMessage(SystemData.Server + "Du bist nun im: §f§l" + gamemode);
						}
					} else {
						sender.sendMessage(SystemData.Server + "Spieler ist nicht online oder existiert nicht");
					}
				}
			}
		}else {
			sender.sendMessage(SystemData.noPerm);
		}
		
		return false;
	}

}
