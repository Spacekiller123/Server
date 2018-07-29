package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import me.spacekiller.util.JsonBuilder;
import me.spacekiller.util.JsonBuilder.ClickAction;

public class HelpCommand implements CommandExecutor{

	JsonBuilder jb;
	
	Main plugin;
	
	public HelpCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("?") || cmd.getName().equalsIgnoreCase("h") || cmd.getName().equalsIgnoreCase("help")){
			sender.sendMessage(SystemData.Server + "§7§lDir stehen folgene Befehle zur Verfügung:");
			sender.sendMessage("/whisper");
			sender.sendMessage("/skypvp");
			sender.sendMessage("/warp");
			sender.sendMessage("/spawn");
			sender.sendMessage("/tp");
			sender.sendMessage("/msg");
			sender.sendMessage("/r");
			sender.sendMessage("/a");
			sender.sendMessage("/");
			sender.sendMessage("/");
			sender.sendMessage("/");
			sender.sendMessage("/");
			jb.parse("test").withClickEvent(ClickAction.RUN_COMMAND, "/help");
		}
		return false;
	}

}
