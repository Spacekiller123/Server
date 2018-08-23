package me.spacekiller.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerData {

	public static File PlayerData = new File("plugins/Server/", "PlayerData.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(PlayerData);

	public PlayerData() {

	}

	public static void reloadConfig() {
		try {
			cfg.save(PlayerData);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cfg.load(PlayerData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void saveConfig() {
		try {
			cfg.save(PlayerData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadConfig() {
		try {
			cfg.load(PlayerData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static FileConfiguration getConfig() {
		return cfg;
	}

	public static void addPlayer(Player p) {
		String pn = p.getName();
		cfg.set(pn + ".name", pn);
		cfg.set(pn + ".nick", p.getDisplayName());
		cfg.set(pn + ".uuid", p.getUniqueId().toString());
		cfg.set(pn + ".ip", p.getAddress().toString());
		cfg.set(pn + ".location.world", p.getLocation().getWorld().getName());
		cfg.set(pn + ".location.x", p.getLocation().getX());
		cfg.set(pn + ".location.y", p.getLocation().getY());
		cfg.set(pn + ".location.z", p.getLocation().getZ());
		cfg.set(pn + ".money", 0);
		saveConfig();
	}

}
