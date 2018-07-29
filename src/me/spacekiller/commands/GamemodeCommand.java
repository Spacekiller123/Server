package me.spacekiller.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
				Player p = (Player) sender;
				if(args.length == 0) {
					switch (p.getGameMode().toString()) {
						case "survival":
							gamemode = "Überlebens-Modus";
						case "creative":
							gamemode = "Kreativ-Modus";
						case "adventure":
							gamemode = "Abenteuer-Modus";
						case "spectator":
							gamemode = "Zuschauer-Modus"; 
						
					}
					sender.sendMessage(SystemData.Server + "Dein Spielmodus ist: §f§l" + gamemode);
				}else if(args.length == 1) {
					switch (args[0]) {
						case "survival":
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
						case "creative":
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
						case "adventure":
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
						case "spectator":
							gamemode = "Zuschauer-Modus"; 
							p.setGameMode(GameMode.SPECTATOR);
						case "überleben":
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
						case "kreativ":
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
						case "abenteuer":
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
						case "zuschauer":
							gamemode = "Zuschauer-Modus"; 
							p.setGameMode(GameMode.SPECTATOR);
						case "1":
							gamemode = "Überlebens-Modus";
							p.setGameMode(GameMode.SURVIVAL);
						case "2":
							gamemode = "Kreativ-Modus";
							p.setGameMode(GameMode.CREATIVE);
						case "3":
							gamemode = "Abenteuer-Modus";
							p.setGameMode(GameMode.ADVENTURE);
						case "4":
							gamemode = "Zuschauer-Modus"; 
							p.setGameMode(GameMode.SPECTATOR);	
						default: 
							sender.sendMessage(SystemData.Server + "Ungültiger Spielmodus");
					} 
					sender.sendMessage(SystemData.Server + "Du bist nun im: §f§l" + gamemode);
				}else if(args.length == 2) {
					p = Bukkit.getPlayer(args[1]);
					if(p.isOnline()) {
						switch (args[0]) {
							case "survival":
								gamemode = "Überlebens-Modus";
								p.setGameMode(GameMode.SURVIVAL);
							case "creative":
								gamemode = "Kreativ-Modus";
								p.setGameMode(GameMode.CREATIVE);
							case "adventure":
								gamemode = "Abenteuer-Modus";
								p.setGameMode(GameMode.ADVENTURE);
							case "spectator":
								gamemode = "Zuschauer-Modus"; 
								p.setGameMode(GameMode.SPECTATOR);
							case "überleben":
								gamemode = "Überlebens-Modus";
								p.setGameMode(GameMode.SURVIVAL);
							case "kreativ":
								gamemode = "Kreativ-Modus";
								p.setGameMode(GameMode.CREATIVE);
							case "abenteuer":
								gamemode = "Abenteuer-Modus";
								p.setGameMode(GameMode.ADVENTURE);
							case "zuschauer":
								gamemode = "Zuschauer-Modus"; 
								p.setGameMode(GameMode.SPECTATOR);
							case "1":
								gamemode = "Überlebens-Modus";
								p.setGameMode(GameMode.SURVIVAL);
							case "2":
								gamemode = "Kreativ-Modus";
								p.setGameMode(GameMode.CREATIVE);
							case "3":
								gamemode = "Abenteuer-Modus";
								p.setGameMode(GameMode.ADVENTURE);
							case "4":
								gamemode = "Zuschauer-Modus"; 
								p.setGameMode(GameMode.SPECTATOR);	
							default: 
								sender.sendMessage(SystemData.Server + "Ungültiger Spielmodus");
						}
						sender.sendMessage(SystemData.Server + p.getName() + " ist nun im: §f§l" + gamemode);
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
