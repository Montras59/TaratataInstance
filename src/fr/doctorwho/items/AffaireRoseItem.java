package fr.doctorwho.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.doctorwho.utils.ItemMenu;

public class AffaireRoseItem extends ItemMenu{

	public AffaireRoseItem() {
		super(Material.LEATHER_CHESTPLATE, "§d§lTee Shirt de Rose");
		setColor(Color.PURPLE);
	}

	@Override
	public void use(Player player) {
		return;
	}

}
