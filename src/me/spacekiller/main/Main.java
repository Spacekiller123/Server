package me.spacekiller.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.spacekiller.commands.JoinMessageCommand;
import me.spacekiller.listener.DeathListener;
import me.spacekiller.listener.JoinListener;
import me.spacekiller.listener.LeaveListener;

public class Main extends JavaPlugin {
	
	private FileConfiguration cfg;
	
	public void onEnable() {
		System.out.println("[]=============================[]");
		System.out.println("|       Server Aktiviert!       |");
		System.out.println("|        by Spacekiller!        |");
		System.out.println("[]=============================[]");

		loadConfig();
		SystemData.loadConfig();
		registerCommands();
		registerEvents();
		//startTimer();
	}
	
	public void registerCommands() {
		getCommand("joinMessage").setExecutor(new JoinMessageCommand(this));
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new DeathListener(this), this);
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new LeaveListener(this), this);
	}
	
	private void startTimer() {
		FileConfiguration online = SystemData.getOnlineConfig();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					int days = online.getInt(
							players.getName() + ".Tage");
					int hours = online.getInt(
							players.getName() + ".Stunden");
					int minutes = online.getInt(
							players.getName() + ".Minuten");
					int seconds = online.getInt(
							players.getName() + ".Sekunden");

					seconds += 3;

					online.set(players.getName() + ".Sekunden",
							Integer.valueOf(seconds));
					SystemData.saveOnline();

					if (seconds >= 60) {
						online.set(
								players.getName() + ".Sekunden",
								Integer.valueOf(0));
						minutes++;
						online.set(
								players.getName() + ".Minuten",
								Integer.valueOf(minutes));
						SystemData.saveOnline();
					}

					if (minutes >= 60) {
						online.set(
								players.getName() + ".Minuten",
								Integer.valueOf(0));
						hours++;
						online.set(
								players.getName() + ".Stunden",
								Integer.valueOf(hours));
						SystemData.saveOnline();
					}

					if (hours >= 24) {
						online.set(
								players.getName() + ".Stunden",
								Integer.valueOf(0));
						days++;
						online.set(players.getName() + ".Tage",
								Integer.valueOf(days));
						SystemData.saveOnline();
					}
				}
			}
		}, 60L, 60L);
	}
	
	public void loadConfig() {
		SystemData.loadConfig();
		cfg = getConfig();
		if (!cfg.contains("JoinMessage"))
			cfg.addDefault("JoinMessage", true);
		if (!cfg.contains("LeaveMessage"))
			cfg.addDefault("LeaveMessage", true);
		cfg.options().copyDefaults(true);
		saveConfig();
	}

}
