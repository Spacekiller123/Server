package me.spacekiller.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TestCommand implements CommandExecutor {

	Main plugin;
	
	public TestCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")) {
			Player p = (Player) sender;
			PermissionManager pex = PermissionsEx.getPermissionManager();
			sender.sendMessage("" + pex.getUser(p.getUniqueId()).inGroup("Owner"));
			String groups = "";
			for(PermissionGroup g : pex.getGroups()) {
				groups = groups + g.getName() + " ";
			}
			sender.sendMessage(groups);
			String owners = "";
			for(PermissionUser pp : pex.getGroup("Owner").getUsers()) {
				owners = owners + pp.getName() + " ";
			}
			sender.sendMessage(owners);
		}
		return false;
	}

}
