package me.spacekiller.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TeamCommand implements CommandExecutor {
	String prefix = SystemData.Team;
	Set<PermissionUser> puo = PermissionsEx.getPermissionManager().getGroup("Owner").getUsers();
	Set<PermissionUser> puc = PermissionsEx.getPermissionManager().getGroup("CoOwner").getUsers();
	Set<PermissionUser> pua = PermissionsEx.getPermissionManager().getGroup("Administrator").getUsers();
	Set<PermissionUser> pud = PermissionsEx.getPermissionManager().getGroup("Developer").getUsers();
	Set<PermissionUser> pum = PermissionsEx.getPermissionManager().getGroup("Moderator").getUsers();
	Set<PermissionUser> pus = PermissionsEx.getPermissionManager().getGroup("Supporter").getUsers();
	Set<PermissionUser> puts = PermissionsEx.getPermissionManager().getGroup("T-Supporter").getUsers();
	String status = "";
	
	Main plugin;
	
	public TeamCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("team"))
				&& (p.hasPermission("server.team"))) {
			if (args.length == 0)
				return help(sender);
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("alle"))
					return all(sender, p);
				if (args[0].equalsIgnoreCase("owner"))
					return ownermess(sender, p);
				if (args[0].equalsIgnoreCase("coowner"))
					return coownermess(sender, p);
				if (args[0].equalsIgnoreCase("admin"))
					return adminmess(sender, p);
				if (args[0].equalsIgnoreCase("moderator"))
					return modmess(sender, p);
				if (args[0].equalsIgnoreCase("supporter"))
					return suppmess(sender, p);
				if (args[0].equalsIgnoreCase("t-supporter")) {
					return tsuppmess(sender, p);
				}
				return help(sender);
			}

		}

		return false;
	}

	public boolean help(CommandSender p) {
		p.sendMessage(prefix
				+ "Benutzung: /team owner|coowner|admin|moderator|supporter|t-supporter|alle");
		return true;
	}

	public boolean all(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		owner(sender, p);
		coowner(sender, p);
		admin(sender, p);
		mod(sender, p);
		supp(sender, p);
		tsupp(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean ownermess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		owner(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean coownermess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		coowner(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean adminmess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		admin(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean modmess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		mod(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean suppmess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		supp(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean tsuppmess(CommandSender sender, Player p) {
		sender.sendMessage(prefix);
		tsupp(sender, p);
		sender.sendMessage(prefix);
		return true;
	}

	public boolean owner(CommandSender sender, Player p) {
		for (PermissionUser owner : this.puo) {
			String ownername = owner.getName();
			String ownerprefix = owner.getPrefix();
			p = Bukkit.getPlayer(ownername);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData.getFormattingColorCodes(ownerprefix)
					+ ownername + " §8[" + this.status + "§8]");
		}
		return true;
	}

	public boolean coowner(CommandSender sender, Player p) {
		for (PermissionUser coowner : this.puc) {
			String coownername = coowner.getName();
			String coownerprefix = coowner.getPrefix();
			p = Bukkit.getPlayer(coownername);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData
					.getFormattingColorCodes(coownerprefix)
					+ coownername
					+ " §8[" + this.status + "§8]");
		}
		return true;
	}

	public boolean admin(CommandSender sender, Player p) {
		for (PermissionUser admin : this.pua) {
			String adminname = admin.getName();
			String adminprefix = admin.getPrefix();
			p = Bukkit.getPlayer(adminname);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData.getFormattingColorCodes(adminprefix)
					+ adminname + " §8[" + this.status + "§8]");
		}
		return true;
	}

	public boolean mod(CommandSender sender, Player p) {
		for (PermissionUser moderator : this.pum) {
			String moderatorname = moderator.getName();
			String moderatorprefix = moderator.getPrefix();
			p = Bukkit.getPlayer(moderatorname);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData
					.getFormattingColorCodes(moderatorprefix)
					+ moderatorname
					+ " §8[" + this.status + "§8]");
		}
		return true;
	}

	public boolean supp(CommandSender sender, Player p) {
		for (PermissionUser supporter : this.pus) {
			String supportername = supporter.getName();
			String supporterprefix = supporter.getPrefix();
			p = Bukkit.getPlayer(supportername);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData
					.getFormattingColorCodes(supporterprefix)
					+ supportername
					+ " §8[" + this.status + "§8]");
		}
		return true;
	}

	public boolean tsupp(CommandSender sender, Player p) {
		for (PermissionUser tsupporter : this.puts) {
			String tsupportername = tsupporter.getName();
			String tsupporterprefix = tsupporter.getPrefix();
			p = Bukkit.getPlayer(tsupportername);
			if (p == null)
				this.status = "§4Offline";
			else {
				this.status = "§2Online";
			}
			sender.sendMessage(SystemData
					.getFormattingColorCodes(tsupporterprefix)
					+ tsupportername
					+ " §8[" + this.status + "§8]");
		}
		return true;
	}
}