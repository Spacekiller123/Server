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
import me.spacekiller.main.SystemData;

public class GuiCommand implements CommandExecutor, Listener{

	Main plugin;
	
	boolean initatedsG = false;
	
	public GuiCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public void initateInventory() {
		ItemMeta warpMeta = SystemData.warp.getItemMeta();
		warpMeta.setDisplayName("§5§lWarps");
		SystemData.warpList.add("§f§lKlicken um das Warp-Menu zu öffnen.");
		warpMeta.setLore(SystemData.warpList);
		SystemData.warp.setItemMeta(warpMeta);
		SystemData.spielerGui.setItem(10, SystemData.warp);
		
		ItemMeta tpMeta = SystemData.tp.getItemMeta();
		tpMeta.setDisplayName("§d§lTeleport");
		SystemData.tpList.add("§f§lKlicken um das Teleport-Menu zu öffnen.");
		tpMeta.setLore(SystemData.tpList);
		SystemData.tp.setItemMeta(tpMeta);
		SystemData.spielerGui.setItem(12, SystemData.tp);
		
		ItemMeta ironMeta = SystemData.iron.getItemMeta();
		ironMeta.setDisplayName("§8§lEisenausrüstung");
		SystemData.ironList.add("§f§lKlicken um das Menu zu öffnen.");
		ironMeta.setLore(SystemData.ironList);
		SystemData.iron.setItemMeta(ironMeta);
		SystemData.spielerGui.setItem(14, SystemData.iron);
		
		ItemMeta goldMeta = SystemData.gold.getItemMeta();
		goldMeta.setDisplayName("§6§lGoldausrüstung");
		SystemData.goldList.add("§f§lKlicken um das Menu zu öffnen.");
		goldMeta.setLore(SystemData.goldList);
		SystemData.gold.setItemMeta(goldMeta);
		SystemData.spielerGui.setItem(16, SystemData.gold);
		
		ItemMeta diamondMeta = SystemData.diamond.getItemMeta();
		diamondMeta.setDisplayName("§b§lDiamantenausrüstung");
		SystemData.diamondList.add("§f§lKlicken um das Menu zu öffnen.");
		diamondMeta.setLore(SystemData.diamondList);
		SystemData.diamond.setItemMeta(diamondMeta);
		SystemData.spielerGui.setItem(28, SystemData.diamond);
		
		ItemMeta foodMeta = SystemData.food.getItemMeta();
		foodMeta.setDisplayName("§c§lEssen");
		SystemData.foodList.add("§f§lKlicken um das Menu zu öffnen.");
		foodMeta.setLore(SystemData.foodList);
		SystemData.food.setItemMeta(foodMeta);
		SystemData.spielerGui.setItem(30, SystemData.food);
		
		ItemMeta potionsMeta = SystemData.potions.getItemMeta();
		potionsMeta.setDisplayName("§9§lTränke");
		SystemData.potionsList.add("§f§lKlicken um das Menu zu öffnen.");
		potionsMeta.setLore(SystemData.potionsList);
		SystemData.potions.setItemMeta(potionsMeta);
		SystemData.spielerGui.setItem(32, SystemData.potions);
		
		ItemMeta enchantmentMeta = SystemData.enchantment.getItemMeta();
		enchantmentMeta.setDisplayName("§5§lVerzauberungen");
		SystemData.enchantmentList.add("§f§lKlicken um das Menu zu öffnen.");
		enchantmentMeta.setLore(SystemData.enchantmentList);
		SystemData.enchantment.setItemMeta(enchantmentMeta);
		SystemData.spielerGui.setItem(34, SystemData.enchantment);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gui")) {
			if(!initatedsG) {
				initateInventory();
				initatedsG = true;
			}
			Player p = (Player) sender;
			p.openInventory(SystemData.spielerGui);
		}
		return false;
	}

	
}
