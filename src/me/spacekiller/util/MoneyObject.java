package me.spacekiller.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spacekiller.main.PlayerData;

public class MoneyObject {
	
	
	FileConfiguration cfg;
	
	public MoneyObject() {
		cfg = PlayerData.getConfig();
	}
	
	public void set(Player p, int i) {
		if(cfg.contains(p.getName())) {
			try {
				cfg.set(p.getName() + ".money", i);
				PlayerData.saveConfig();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
	}
	
	public void add(Player p, int i) {
		if(cfg.contains(p.getName())) {
			try {
				cfg.set(p.getName() + ".money", cfg.getInt(p.getName() + ".money") + i);
				PlayerData.saveConfig();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
	}
	
	public void remove(Player p, int i) {
		if(cfg.contains(p.getName())) {
			try {
				cfg.set(p.getName() + ".money", cfg.getInt(p.getName() + ".money") - i);
				PlayerData.saveConfig();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
	}

	public int get(Player p) {
		return cfg.getInt(p.getName() + ".money");
	}
}
