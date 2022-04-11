package Inventory;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ItemInteract {

	public static HashMap<ItemStack, Boolean> RightClick = new HashMap<ItemStack, Boolean>();
	public static HashMap<ItemStack, Boolean> MiddleClick = new HashMap<ItemStack, Boolean>();
	public static HashMap<ItemStack, Boolean> LeftCLick = new HashMap<ItemStack, Boolean>();


	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!e.getInventory().getName().equalsIgnoreCase("Général")) return;
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("HungerGames")) {

			e.setCancelled(true);
		}

		if(e.getClick() == ClickType.RIGHT && RightClick.get(e.getCurrentItem()) == true){

		}
	}	
}
