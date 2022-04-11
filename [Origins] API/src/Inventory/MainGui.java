package Inventory;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainGui {
	
	////////////
	// Inventory tag :
	// 0 = General
    ////////////
	public ArrayList<Inventory> GuiResult = new ArrayList<Inventory>();

	public void createInventory(int size, String name) {
		Inventory inv = Bukkit.createInventory(null, size, name);
		GuiResult.add(inv); 
	}

	public Inventory General() {
		return GuiResult.get(0);
	}

	public void GeneralGui(Inventory inv) {
		inv = GuiResult.get(0);
		String[] Serv1Lore = {"Ligne 1", "Ligne 2"};
        ItemCreator Serveur1 = new ItemCreator("Serveur1", Serv1Lore, Material.DIRT);
        String[] Serv2Lore = {"Ligne 1", "Ligne 2"};
        ItemCreator Serveur2 = new ItemCreator("Serveur2", Serv2Lore, Material.DIRT);
        String[] Serv3Lore = {"Ligne 1", "Ligne 3"};
        ItemCreator Serveur3= new ItemCreator("Serveur3", Serv3Lore, Material.DIRT);
        inv.setItem(2, Serveur1.Creator());
        inv.setItem(4, Serveur2.Creator());
        inv.setItem(6, Serveur3.Creator());
        return;
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public void openG( Player p) {
		
		Material mat = p.getItemInHand().getType();
		
		switch(mat) {
		case BOOKSHELF:
			p.openInventory(GuiResult.get(0));
			break;
		case DIRT:
			p.openInventory(GuiResult.get(1));
		}
		
		
		
		
		
		
		
	}
	
	
	

	/* 
	 *         String[] GeneralLore = {"", ""};
        ItemCreator General = new ItemCreator("NAME", GeneralLore, Material.BOOKSHELF);
	 */

  
	
}