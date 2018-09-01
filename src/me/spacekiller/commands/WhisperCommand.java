package me.spacekiller.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.SystemData;

public class WhisperCommand implements CommandExecutor {
	
	HashMap<Player, Player> wis = new HashMap<Player, Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("whisper") && cmd.getName().equalsIgnoreCase("msg") && cmd.getName().equalsIgnoreCase("w")) {
			if(args.length == 2) {
				Player p = (Player) sender;
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					wis.put(p, op.getPlayer());
					p.sendMessage("§7§lDu §7--> " + op.getPlayer().getDisplayName()+ " §8§l> " + args[1]);
					op.getPlayer().sendMessage("§7§l" + p.getName() + "Dir §8§l> " + args[1]);
				}else {
					sender.sendMessage(SystemData.Online);
				}
			}else {
				sender.sendMessage(SystemData.Server + "Benutzung: /whisper <Spieler> <Nachricht>");
			}
		}else if(cmd.getName().equalsIgnoreCase("r")){
			if(args.length == 1) {
				
			}else {
				sender.sendMessage(SystemData.Server + "Benutzung: /r <Spieler>");
			}
		}
		return false;
	}
	
	

}
