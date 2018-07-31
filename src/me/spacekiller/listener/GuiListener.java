package me.spacekiller.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.spacekiller.main.Main;
import me.spacekiller.main.SystemData;

public class GuiListener implements Listener {

	Main plugin;
	
	public GuiListener(Main plugin) {
		this.plugin = plugin;
	}
	
	public void initateTpGui(Player p) {
		int i = 0;
		SystemData.tpGui = Bukkit.createInventory(null, 45,"§d§lTeleport");
		for(Player ph : Bukkit.getOnlinePlayers()) {
			if(ph != p) {
				ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				ArrayList<String> headList = new ArrayList<String>();
				SkullMeta headMeta = (SkullMeta) head.getItemMeta();
				headMeta.setOwner(ph.getName());
				headMeta.setDisplayName(ph.getName());
				headList.add("§f§lKlicken um zu " + ph.getDisplayName() + " §f§lzu teleportieren.");
				headMeta.setLore(headList);
				head.setItemMeta(headMeta);
				SystemData.tpGui.setItem(i, head);
				i++;
			}
		}
		
	}
	

	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			if(e.getInventory().equals(SystemData.spielerGui)) {
				if(e.getCurrentItem().equals(SystemData.warp)) {
					e.getWhoClicked().openInventory(SystemData.warpGui);
				}else if(e.getCurrentItem().equals(SystemData.tp)) {
					initateTpGui((Player) e.getWhoClicked());
					e.getWhoClicked().openInventory(SystemData.tpGui);
				}else if(e.getCurrentItem().equals(SystemData.iron)) {
					e.getWhoClicked().openInventory(SystemData.ironInv);
				}else if(e.getCurrentItem().equals(SystemData.gold)) {
					e.getWhoClicked().openInventory(SystemData.goldInv);
				}else if(e.getCurrentItem().equals(SystemData.diamond)) {
					e.getWhoClicked().openInventory(SystemData.diamondInv);
				}else if(e.getCurrentItem().equals(SystemData.food)) {
					e.getWhoClicked().openInventory(SystemData.foodInv);
				}else if(e.getCurrentItem().equals(SystemData.potions)) {
					e.getWhoClicked().openInventory(SystemData.potionsInv);
				}else if(e.getCurrentItem().equals(SystemData.enchantment)) {
					e.getWhoClicked().openInventory(SystemData.enchantmentInv);
				}
				e.setCancelled(true);
			}else if(e.getInventory().equals(SystemData.tpGui)){
				if(e.getCurrentItem().getItemMeta() != null) {
					OfflinePlayer op = Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
					if(op.isOnline()) {
						Player p = (Player) e.getWhoClicked();
						p.performCommand("tp " + op.getName());
						p.closeInventory();
					}else {
						e.getWhoClicked().sendMessage(SystemData.Online);
					}
					e.setCancelled(true);
				}
			}
		}
	}
	
}
