package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tp")) {
			if(sender.hasPermission("server.tp")) {
				if(args.length == 1) {
					
				}
			}
			
		}else if(cmd.getName().equalsIgnoreCase("tpaccept")){
			
		}else if(cmd.getName().equalsIgnoreCase("tpdecline")) {
			
		}else if(cmd.getName().equalsIgnoreCase("tpdeny")) {
			
		}
		return false;
	}
	
	

}
