package me.spacekiller.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.spacekiller.util.TpaObject;

public class SystemData {

	public SystemData() {
	}
	
	public static ArrayList<Player> teamchat = new ArrayList<Player>();
	public static ArrayList<Player> teamchatsee = new ArrayList<Player>();
	
	public static SystemData instance;

	public static void loadConfig() {
		if (!cfg.contains("Server"))
			cfg.addDefault("Server", "�8�l[�9�lReflexcraft�8�l] �7");
		if (!cfg.contains("Benutzung"))
			cfg.addDefault("Benutzung", "�8�l[�9�lBenutzung�8�l] �7");
		if (!cfg.contains("Chat"))
			cfg.addDefault("Chat", "�8�l[�9�lChat�8�l] �7");
		if (!cfg.contains("Warp"))
			cfg.addDefault("Warp", "�8�l[�9�lWarp�8�l] �7");
		if (!cfg.contains("Regeln"))
			cfg.addDefault("Regeln", "�8�l[�9�lRegeln�8�l] �7");
		if (!cfg.contains("reset"))
			cfg.addDefault("reset", "�8�l[�9�lReset�8�l] �7");
		if (!cfg.contains("Spenden"))
			cfg.addDefault("Spenden", "�8�l[�9�lSpenden�8�l] �7");
		if (!cfg.contains("Teamchat"))
			cfg.addDefault("Teamchat", "�8�l[�9�lTeamchat�8�l] �7");
		if (!cfg.contains("Team"))
			cfg.addDefault("Team", "�8�l[�9�lTeam�8�l] �7");
		if (!cfg.contains("Ban"))
			cfg.addDefault("Ban", "�8�l[�9�lBan�8�l] �7");
		if (!cfg.contains("Kick"))
			cfg.addDefault("Kick", "�8�l[�9�lKick�8�l] �7");
		if (!cfg.contains("Tempban"))
			cfg.addDefault("Tempban", "�8�l[�9�lTempban�8�l] �7");
		if (!cfg.contains("Falsch"))
			cfg.addDefault("Falsch", "�8�l[�9�lReflexcraft�8�l] �7");
		if (!cfg.contains("noPerm"))
			cfg.addDefault("noPerm", "�8�l[�9�lReflexcraft�8�l] �7 Du hast leider keine Rechte um diesen Befehl auszuf�hren.");
		if (!cfg.contains("Online"))
			cfg.addDefault("Online", "�8�l[�9�lReflexcraft�8�l] �7 Dieser Spieler ist leider nicht online");
		if (!cfg.contains("Warn"))
			cfg.addDefault("Warn", "�8�l[�9�lWarn�8�l] �7");
		if (!cfg.contains("Tp"))
			cfg.addDefault("Tp", "�8�l[�9�lTp�8�l] �7");
		if (!cfg.contains("Broadcast"))
			cfg.addDefault("Broadcast", "�8�l[�9�lRundruf�8�l] �7");
		cfg.options().copyDefaults(true);
		cfg2.options().copyDefaults(true);
		saveData();
	}
	
	public static void saveOnline() {
		try {
			cfg2.save(OnlineData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveData() {
		try {
			cfg.save(SystemData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static FileConfiguration getOnlineConfig() {
		return cfg2;
	}
	
	public static String getFormattingColorCodes(String s) {
		s = s.replaceAll("&1", "\2471");
		s = s.replaceAll("&2", "\2472");
		s = s.replaceAll("&3", "\2473");
		s = s.replaceAll("&4", "\2474");
		s = s.replaceAll("&5", "\2475");
		s = s.replaceAll("&6", "\2476");
		s = s.replaceAll("&7", "\2477");
		s = s.replaceAll("&8", "\2478");
		s = s.replaceAll("&9", "\2479");
		s = s.replaceAll("&0", "\2470");
		s = s.replaceAll("&a", "\247a");
		s = s.replaceAll("&b", "\247b");
		s = s.replaceAll("&c", "\247c");
		s = s.replaceAll("&d", "\247d");
		s = s.replaceAll("&e", "\247e");
		s = s.replaceAll("&f", "\247f");
		s = s.replaceAll("&o", "\247o");
		s = s.replaceAll("&l", "\247l");
		s = s.replaceAll("&k", "\247k");
		s = s.replaceAll("&m", "\247m");
		s = s.replaceAll("&n", "\247n");
		s = s.replaceAll("&r", "\247r");
		return s;
	}

	public static String removeFormattingColorCodes(String s) {
		s = s.replaceAll("&1", "");
		s = s.replaceAll("&2", "");
		s = s.replaceAll("&3", "");
		s = s.replaceAll("&4", "");
		s = s.replaceAll("&5", "");
		s = s.replaceAll("&6", "");
		s = s.replaceAll("&7", "");
		s = s.replaceAll("&8", "");
		s = s.replaceAll("&9", "");
		s = s.replaceAll("&0", "");
		s = s.replaceAll("&a", "");
		s = s.replaceAll("&b", "");
		s = s.replaceAll("&c", "");
		s = s.replaceAll("&d", "");
		s = s.replaceAll("&e", "");
		s = s.replaceAll("&f", "");
		s = s.replaceAll("&o", "");
		s = s.replaceAll("&l", "");
		s = s.replaceAll("&k", "");
		s = s.replaceAll("&m", "");
		s = s.replaceAll("&n", "");
		s = s.replaceAll("&r", "");
		return s;
	}
	
	public static String design(String text) {
		String supertext = cfg.getString(".design");
		return supertext;
	}

	public static ChatColor ramCheck() {
		double raminpro = usedMemory();
		if (raminpro <= 50D)
			return ChatColor.GREEN;
		if (raminpro >= 50.100000000000001D && raminpro <= 80D)
			return ChatColor.YELLOW;
		if (raminpro >= 80.099999999999994D && raminpro <= 100D)
			return ChatColor.DARK_RED;
		else
			return ChatColor.WHITE;
	}

	public static double usedMemory() {
		double maxmemory = RUNTIME.maxMemory();
		double usedmemory = RUNTIME.totalMemory();
		double maxm = maxmemory / 1048576D;
		maxm /= 100D;
		double usedm = usedmemory / 1048576D;
		double auslastung = usedm / maxm;
		auslastung *= 100D;
		auslastung = Math.round(auslastung);
		auslastung /= 100D;
		return auslastung;
	}
	
	public static ArrayList<TpaObject> tpaList = new ArrayList<TpaObject>();
	public static ArrayList<Player> tpdenyList = new ArrayList<Player>();

	public static Inventory spielerGui = Bukkit.createInventory(null, 45,"�c�lMineria");
	public static Inventory warpGui = Bukkit.createInventory(null, 45,"�5�lWarps");
	public static Inventory tpGui;
	public static Inventory ironInv = Bukkit.createInventory(null, 45,"�8�lEisenausr�stung");
	public static Inventory goldInv = Bukkit.createInventory(null, 45,"�6�lGoldausr�stungp");
	public static Inventory diamondInv = Bukkit.createInventory(null, 45,"�b�lDiamantenausr�stung");
	public static Inventory foodInv = Bukkit.createInventory(null, 45,"�c�lEssen");
	public static Inventory potionsInv = Bukkit.createInventory(null, 45,"�9�lTr�nke");
	public static Inventory enchantmentInv = Bukkit.createInventory(null, 45,"�5�lVerzauberungen");
	
	public static ArrayList<String> warpList = new ArrayList<String>();
	public static ArrayList<String> tpList = new ArrayList<String>();
	public static ArrayList<String> ironList = new ArrayList<String>();
	public static ArrayList<String> goldList = new ArrayList<String>();
	public static ArrayList<String> diamondList = new ArrayList<String>();
	public static ArrayList<String> foodList = new ArrayList<String>();
	public static ArrayList<String> potionsList = new ArrayList<String>();
	public static ArrayList<String> enchantmentList = new ArrayList<String>();
	
	public static ItemStack warp = new ItemStack(Material.ENDER_PORTAL_FRAME);
	public static ItemStack tp = new ItemStack(Material.ENDER_PEARL);
	public static ItemStack iron = new ItemStack(Material.IRON_CHESTPLATE);
	public static ItemStack gold = new ItemStack(Material.GOLD_CHESTPLATE);
	public static ItemStack diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	public static ItemStack food = new ItemStack(Material.APPLE);
	public static ItemStack potions = new ItemStack(Material.POTION);
	public static ItemStack enchantment = new ItemStack(Material.ENCHANTED_BOOK);
	
	public static File SystemData;
	public static File OnlineData;
	public static FileConfiguration cfg;
	public static FileConfiguration cfg2;
	public static Runtime RUNTIME = Runtime.getRuntime();
	public static System plugin;
	public static int cdvipplus = 30;
	public static int cdpremiumvip = 45;
	public static int cdvip = 15;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static String Server;
	public static String Benutzung;
	public static String Chat;
	public static String Warp;
	public static String Regeln;
	public static String reset;
	public static String Spenden;
	public static String Teamchat;
	public static String Team;
	public static String Ban;
	public static String Kick;
	public static String Tempban;
	public static String Falsch;
	public static String fehler;
	public static String noPerm;
	public static String Online;
	public static String Warn;
	public static String Tp;
	public static String Broadcast;
	public static ChatColor Gold;
	public static ChatColor Red;
	public static ChatColor DRed;
	public static ChatColor Aqua;
	public static ChatColor DAqua;
	public static ChatColor Green;
	public static ChatColor Bold;
	public static ChatColor Gray;
	public static ChatColor DGray;
	public static ChatColor Yellow;
	public static ChatColor Blue;
	public static ChatColor DGreen;
	public static ChatColor Italic;
	public static ChatColor UL;
	public static ChatColor Strike;
	public static ChatColor Pink;
	public static ChatColor Lila;
	public static ChatColor DBlue;
	public static ChatColor Black;
	public static ChatColor White;
	public static ChatColor Magic;
	public static ChatColor Reset;

	static {
		SystemData = new File("plugins/Server/", "SystemData.yml");
		cfg = YamlConfiguration.loadConfiguration(SystemData);
		OnlineData = new File("plugins/Server/", "Onlinedata.yml");
		cfg2 = YamlConfiguration.loadConfiguration(OnlineData);
		Server = cfg.getString(".Server");
		Benutzung = cfg.getString(".Benutztung");
		Chat = cfg.getString(".Chat");
		Warp = cfg.getString(".Warp");
		Regeln = cfg.getString(".Regeln");
		reset = cfg.getString(".reset");
		Spenden = cfg.getString(".Spenden");
		Teamchat = cfg.getString(".Teamchat");
		Team = cfg.getString(".Team");
		Ban = cfg.getString(".Ban");
		Kick = cfg.getString(".Kick");
		Tempban = cfg.getString(".Tempban");
		Falsch = cfg.getString(".Falsch");
		fehler = cfg.getString(".fehler");
		noPerm = cfg.getString(".noPerm");
		Online = cfg.getString(".Online");
		Warn = cfg.getString(".Warn");
		Tp = cfg.getString(".Tp");
		Broadcast = cfg.getString(".Broadcast");
		Gold = ChatColor.GOLD;
		Red = ChatColor.RED;
		DRed = ChatColor.DARK_RED;
		Aqua = ChatColor.AQUA;
		DAqua = ChatColor.DARK_AQUA;
		Green = ChatColor.GREEN;
		Bold = ChatColor.BOLD;
		Gray = ChatColor.GRAY;
		DGray = ChatColor.DARK_GRAY;
		Yellow = ChatColor.YELLOW;
		Blue = ChatColor.BLUE;
		DGreen = ChatColor.DARK_GREEN;
		Italic = ChatColor.ITALIC;
		UL = ChatColor.UNDERLINE;
		Strike = ChatColor.STRIKETHROUGH;
		Pink = ChatColor.LIGHT_PURPLE;
		Lila = ChatColor.DARK_PURPLE;
		DBlue = ChatColor.DARK_BLUE;
		Black = ChatColor.BLACK;
		White = ChatColor.WHITE;
		Magic = ChatColor.MAGIC;
		Reset = ChatColor.RESET;
	}
}