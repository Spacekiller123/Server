package me.spacekiller.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.spacekiller.commands.*;
import me.spacekiller.listener.*;

public class Main extends JavaPlugin {

	private FileConfiguration cfg;
	
	public void onEnable() {
		System.out.println("[]=============================[]");
		System.out.println("|       Server Aktiviert!       |");
		System.out.println("|        by Spacekiller!        |");
		System.out.println("[]=============================[]");

		loadConfig();;
		registerCommands();
		registerEvents();
		startTimer();
	}

	public void registerCommands() {
		getCommand("gm").setExecutor(new GamemodeCommand(this));
		getCommand("gamemode").setExecutor(new GamemodeCommand(this));
		getCommand("gui").setExecutor(new GuiCommand(this));
		getCommand("?").setExecutor(new HelpCommand(this));
		getCommand("h").setExecutor(new HelpCommand(this));
		getCommand("help").setExecutor(new HelpCommand(this));
		getCommand("joinMessage").setExecutor(new JoinMessageCommand(this));
		getCommand("nick").setExecutor(new NickCommand(this));
		getCommand("onlinezeit").setExecutor(new OnlineZeitCommand(this));
		getCommand("openinv").setExecutor(new OpenInvCommand(this));
		getCommand("openenderinv").setExecutor(new OpenEnderInvCommand(this));
		getCommand("pl").setExecutor(new PluginCommand(this));
		getCommand("plugin").setExecutor(new PluginCommand(this));
		getCommand("ram").setExecutor(new RamCommand(this));
		getCommand("ramcheck").setExecutor(new RamCheckCommand(this));
		getCommand("spacedragon").setExecutor(new SpaceDragonCommand(this));
		getCommand("teamchat").setExecutor(new TeamChatCommand(this));
		getCommand("tp").setExecutor(new TpCommand(this));
		getCommand("tpaccept").setExecutor(new TpCommand(this));
		getCommand("tpdecline").setExecutor(new TpCommand(this));
		getCommand("tpdeny").setExecutor(new TpCommand(this));
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("setspawn").setExecutor(new SpawnCommand(this));
		getCommand("team").setExecutor(new TeamCommand(this));
		getCommand("test").setExecutor(new TestCommand(this));
		getCommand("whois").setExecutor(new WhoIsCommand(this));
		
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new ChatTabListener(this), this);
		pm.registerEvents(new DeathListener(this), this);
		pm.registerEvents(new GuiCommand(this), this);
		pm.registerEvents(new GuiListener(this), this);
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new LeaveListener(this), this);
		pm.registerEvents(new SpaceDragonCommand(this), this);
	//	pm.registerEvents(new TablistListener(this), this);
	}

	private void startTimer() {
		FileConfiguration online = SystemData.getOnlineConfig();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					int days = online.getInt(players.getName() + ".Tage");
					int hours = online.getInt(players.getName() + ".Stunden");
					int minutes = online.getInt(players.getName() + ".Minuten");
					int seconds = online.getInt(players.getName() + ".Sekunden");

					seconds += 3;

					online.set(players.getName() + ".Sekunden", Integer.valueOf(seconds));
					SystemData.saveOnline();

					if (seconds >= 60) {
						online.set(players.getName() + ".Sekunden", Integer.valueOf(0));
						minutes++;
						online.set(players.getName() + ".Minuten", Integer.valueOf(minutes));
						SystemData.saveOnline();
					}

					if (minutes >= 60) {
						online.set(players.getName() + ".Minuten", Integer.valueOf(0));
						hours++;
						online.set(players.getName() + ".Stunden", Integer.valueOf(hours));
						SystemData.saveOnline();
					}

					if (hours >= 24) {
						online.set(players.getName() + ".Stunden", Integer.valueOf(0));
						days++;
						online.set(players.getName() + ".Tage", Integer.valueOf(days));
						SystemData.saveOnline();
					}
				}
			}
		}, 60L, 60L);
	}

	public void loadConfig() {
		SystemData.loadConfig();
		PlayerData.loadConfig();
		cfg = getConfig();
		if (!cfg.contains("JoinMessage"))
			cfg.addDefault("JoinMessage", true);
		if (!cfg.contains("LeaveMessage"))
			cfg.addDefault("LeaveMessage", true);
		cfg.options().copyDefaults(true);
		saveConfig();
	}

}
