package me.spacekiller.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.spacekiller.main.Main;

public class GuiCommand implements CommandExecutor, Listener{

	Main plugin;
	
	boolean initated = false;
	
	Inventory spielerGui = Bukkit.createInventory(null, 45,"§c§lMineria");
	
	Inventory warpGui = Bukkit.createInventory(null, 45,"§2§lHolz- und Lederausrüstung");
	Inventory tpGui = Bukkit.createInventory(null, 45,"§7§lKettenausrüstung");
	Inventory ironInv = Bukkit.createInventory(null, 45,"§8§lEisenausrüstung");
	Inventory goldInv = Bukkit.createInventory(null, 45,"§6§lGoldausrüstungp");
	Inventory diamondInv = Bukkit.createInventory(null, 45,"§b§lDiamantenausrüstung");
	Inventory foodInv = Bukkit.createInventory(null, 45,"§c§lEssen");
	Inventory potionsInv = Bukkit.createInventory(null, 45,"§9§lTränke");
	Inventory enchantmentInv = Bukkit.createInventory(null, 45,"§5§lVerzauberungen");
	
	ArrayList<String> warpList = new ArrayList<String>();
	ArrayList<String> tpList = new ArrayList<String>();
	ArrayList<String> ironList = new ArrayList<String>();
	ArrayList<String> goldList = new ArrayList<String>();
	ArrayList<String> diamondList = new ArrayList<String>();
	ArrayList<String> foodList = new ArrayList<String>();
	ArrayList<String> potionsList = new ArrayList<String>();
	ArrayList<String> enchantmentList = new ArrayList<String>();
	
	ItemStack warp = new ItemStack(Material.PORTAL);
	ItemStack tp = new ItemStack(Material.SKULL_ITEM);
	ItemStack iron = new ItemStack(Material.IRON_CHESTPLATE);
	ItemStack gold = new ItemStack(Material.GOLD_CHESTPLATE);
	ItemStack diamond = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemStack food = new ItemStack(Material.APPLE);
	ItemStack potions = new ItemStack(Material.POTION);
	ItemStack enchantment = new ItemStack(Material.ENCHANTED_BOOK);
	
	public GuiCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public void initateInventory() {
		ItemMeta warpMeta = warp.getItemMeta();
		warpMeta.setDisplayName("§9§lWarps");
		warpList.add("§f§lKlicken um das Menu zu öffnen.");
		warpMeta.setLore(warpList);
		warp.setItemMeta(warpMeta);
		spielerGui.setItem(10, warp);
		
		ItemMeta tpMeta = tp.getItemMeta();
		tpMeta.setDisplayName("§7§lKettenausrüstung");
		tpList.add("§f§lKlicken um das Menu zu öffnen.");
		tpMeta.setLore(tpList);
		tp.setItemMeta(tpMeta);
		spielerGui.setItem(12, tp);
		
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName("§8§lEisenausrüstung");
		ironList.add("§f§lKlicken um das Menu zu öffnen.");
		ironMeta.setLore(ironList);
		iron.setItemMeta(ironMeta);
		spielerGui.setItem(14, iron);
		
		ItemMeta goldMeta = gold.getItemMeta();
		goldMeta.setDisplayName("§6§lGoldausrüstung");
		goldList.add("§f§lKlicken um das Menu zu öffnen.");
		goldMeta.setLore(goldList);
		gold.setItemMeta(goldMeta);
		spielerGui.setItem(16, gold);
		
		ItemMeta diamondMeta = diamond.getItemMeta();
		diamondMeta.setDisplayName("§b§lDiamantenausrüstung");
		diamondList.add("§f§lKlicken um das Menu zu öffnen.");
		diamondMeta.setLore(diamondList);
		diamond.setItemMeta(diamondMeta);
		spielerGui.setItem(28, diamond);
		
		ItemMeta foodMeta = food.getItemMeta();
		foodMeta.setDisplayName("§c§lEssen");
		foodList.add("§f§lKlicken um das Menu zu öffnen.");
		foodMeta.setLore(foodList);
		food.setItemMeta(foodMeta);
		spielerGui.setItem(30, food);
		
		ItemMeta potionsMeta = potions.getItemMeta();
		potionsMeta.setDisplayName("§9§lTränke");
		potionsList.add("§f§lKlicken um das Menu zu öffnen.");
		potionsMeta.setLore(potionsList);
		potions.setItemMeta(potionsMeta);
		spielerGui.setItem(32, potions);
		
		ItemMeta enchantmentMeta = enchantment.getItemMeta();
		enchantmentMeta.setDisplayName("§5§lVerzauberungen");
		enchantmentList.add("§f§lKlicken um das Menu zu öffnen.");
		enchantmentMeta.setLore(enchantmentList);
		enchantment.setItemMeta(enchantmentMeta);
		spielerGui.setItem(34, enchantment);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gui")) {
			if(!initated) {
				initateInventory();
				initated = true;
			}
			Player p = (Player) sender;
			p.openInventory(spielerGui);
		}
		return false;
	}

	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			if(e.getInventory().equals(spielerGui)) {
				if(e.getCurrentItem().equals(warp)) {
					e.getWhoClicked().openInventory(warpGui);
				}else if(e.getCurrentItem().equals(warp)) {
					e.getWhoClicked().openInventory(warpGui);
				}else if(e.getCurrentItem().equals(tpGui)) {
					e.getWhoClicked().openInventory(tpGui);
				}else if(e.getCurrentItem().equals(iron)) {
					e.getWhoClicked().openInventory(ironInv);
				}else if(e.getCurrentItem().equals(gold)) {
					e.getWhoClicked().openInventory(goldInv);
				}else if(e.getCurrentItem().equals(diamond)) {
					e.getWhoClicked().openInventory(diamondInv);
				}else if(e.getCurrentItem().equals(food)) {
					e.getWhoClicked().openInventory(foodInv);
				}else if(e.getCurrentItem().equals(potions)) {
					e.getWhoClicked().openInventory(potionsInv);
				}else if(e.getCurrentItem().equals(enchantment)) {
					e.getWhoClicked().openInventory(enchantmentInv);
				}
				e.setCancelled(true);
			}
		}
	}
	
}
