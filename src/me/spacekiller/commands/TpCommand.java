package me.spacekiller.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;
import me.spacekiller.util.TpaObject;

public class TpCommand implements CommandExecutor {

	Main plugin;
	
	SystemData sys = SystemData.instance;
	
	ArrayList<TpaObject> newList = new ArrayList<TpaObject>();
	
	public TpCommand(Main plugin) {
		this.plugin = plugin;
		startTimerTp();
		startTimerCd();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tp")) {
			if(sender.hasPermission("server.tp")) {
				if(args.length == 1) {
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					if(op.isOnline()){
						if(SystemData.tpdenyList.contains(op.getPlayer()) && !sender.hasPermission("server.tpoverride")) {
							sender.sendMessage(SystemData.Server + "Zu diesem Spieler kann momentan nicht teleportiert werden");
						}
						p.teleport(op.getPlayer().getLocation());
					}else {
						sender.sendMessage(SystemData.Online);
					}
				}else if(args.length == 2){ 
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					OfflinePlayer op2 = Bukkit.getOfflinePlayer(args[1]);
					if(op.isOnline()){
						if(op2.isOnline()) {
							if(SystemData.tpdenyList.contains(op2.getPlayer()) && !sender.hasPermission("server.tpoverride")) {
								sender.sendMessage(SystemData.Server + "Zu diesem Spieler kann momentan nicht teleportiert werden");
							}
							op.getPlayer().teleport(op2.getPlayer().getLocation());
						}
						
					}
				}
			}else {
				if(args.length == 1) {
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					if(op.isOnline()){
						if(SystemData.tpdenyList.contains(op.getPlayer()) && !sender.hasPermission("server.tpoverride")) {
							sender.sendMessage(SystemData.Server + "Zu diesem Spieler kann momentan nicht teleportiert werden");
						}else {
							TpaObject request = new TpaObject(p, op.getPlayer());
							SystemData.tpaList.add(request);
							p.sendMessage(SystemData.Server + "Du hast eine TP-Anfrage an §f§l" + op.getPlayer().getName() +  "§7 geschickt");
							op.getPlayer().sendMessage(SystemData.Server + "Du hast eine TP-Anfrage von §f§l" + p.getName() +  "§7 bekommen");
						}
					}else {
						sender.sendMessage(SystemData.Online);
					}
				}
				
			}
		}else if(cmd.getName().equalsIgnoreCase("tpaccept")){
			if(args.length == 0) {
				boolean accepted = false;
				for(TpaObject object : SystemData.tpaList) {
					if(object.getReceiver().getName().equalsIgnoreCase(sender.getName())) {
						object.changeAccepted();
						accepted = true;
					}
				}
				if(!accepted) {
					sender.sendMessage(SystemData.Server + "Du hast keine TP-Anfragen");
				}
			}else if(args.length == 1){
				boolean accepted = false;
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					for(TpaObject object : SystemData.tpaList) {
						if(object.getSender().getName().equalsIgnoreCase(op.getPlayer().getName()) && object.getReceiver().getName().equalsIgnoreCase(sender.getName())) {
							object.changeAccepted();
							accepted = true;
						}
					}
				}else {
					sender.sendMessage(SystemData.Online);
				}
				if(!accepted) {
					sender.sendMessage(SystemData.Server + "Du hast keine TP-Anfragen");
				}
			}else {
				sender.sendMessage(SystemData.Server + "Benutzung /tpaccept");
			}
			
		}else if(cmd.getName().equalsIgnoreCase("tpdecline")) {
			if(args.length == 0) {
				boolean declined = false;
				for(TpaObject object : SystemData.tpaList) {
					if(object.getReceiver().getName().equalsIgnoreCase(sender.getName())) {
						object.changeAccepted();
						declined = true;
					}
				}
				if(!declined) {
					sender.sendMessage(SystemData.Server + "Du hast keine TP-Anfragen");
				}
			}else if(args.length == 1){
				boolean declined = false;
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				if(op.isOnline()) {
					for(TpaObject object : SystemData.tpaList) {
						if(object.getSender().getName().equalsIgnoreCase(op.getPlayer().getName()) && object.getReceiver().getName().equalsIgnoreCase(sender.getName())) {
							object.changeAccepted();
							declined = true;
						}
					}
				}else {
					sender.sendMessage(SystemData.Online);
				}
				if(!declined) {
					sender.sendMessage(SystemData.Server + "Du hast keine TP-Anfragen");
				}
			}else {
				sender.sendMessage(SystemData.Server + "Benutzung /tpdecline");
			}
		}else if(cmd.getName().equalsIgnoreCase("tpdeny") && sender.hasPermission("tp.deny")) {
			if(SystemData.tpdenyList.contains(p)) {
				SystemData.tpdenyList.remove(p);
				sender.sendMessage(SystemData.Server + "Spieler können sich jetzt zu dir teleportieren.");
			}else {
				SystemData.tpdenyList.add(p);
				sender.sendMessage(SystemData.Server + "Spieler können sich jetzt nicht mehr zu dir teleportieren.");
			}
		}
		return false;
	}
	
	private void startTimerTp() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				if(!SystemData.tpaList.isEmpty()) {
					for(Iterator<TpaObject> it = SystemData.tpaList.iterator(); it.hasNext();) {
						TpaObject object = it.next();
						Player sender = object.getSender();
						Player receiver = object.getReceiver();
						if(object.getAccepted()) {
							sender.sendMessage(SystemData.Server  + "§f§l" + receiver.getName() + " §7hat die TP-Anfrage angenommen.");
							receiver.sendMessage(SystemData.Server + "Du hast die TP-Anfrage von "  + "§f§l" + sender.getName() + " §7angenommen.");
							sender.teleport(receiver.getLocation());
							it.remove();
						}
						if(object.getDenied()) {
							sender.sendMessage(SystemData.Server  + "§f§l" + receiver.getName() + " §7hat die TP-Anfrage abgelehnt.");
							receiver.sendMessage(SystemData.Server + "Du hast die TP-Anfrage von "  + "§f§l" + sender.getName() + " §7abgelehnt.");
							it.remove();
						}
						if(object.getTimer() == 0) {
							sender.sendMessage(SystemData.Server  + "§f§l" + receiver.getName() + " §7hat die TP-Anfrage nicht beantwortet.");
							receiver.sendMessage(SystemData.Server + "Du hast die TP-Anfrage von "  + "§f§l" + sender.getName() + " §7nicht beantwortet.");
							it.remove();
						}
					}
				}
			}	
		}, 20L, 10L);
	}
	private void startTimerCd() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				if(!SystemData.tpaList.isEmpty()) {
					for(TpaObject object : SystemData.tpaList) {
						object.countDown();
					}
				}
			}	
		}, 20L, 100L);
	}

}
