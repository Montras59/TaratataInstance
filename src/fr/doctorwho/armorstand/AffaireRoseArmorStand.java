package fr.doctorwho.armorstand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.EulerAngle;

import fr.doctorwho.items.AffaireRoseItem;
import fr.doctorwho.utils.ArmorStandUtils;

public class AffaireRoseArmorStand extends ArmorStandUtils{

	public AffaireRoseArmorStand() {
		super(new Location(Bukkit.getWorlds().get(0), 7, 19.1, 7.1), "Affaire de Rose", false);
		getArmorstand().setRightArmPose(new EulerAngle(0F, 0, 267F));
		addEquipment(new AffaireRoseItem());
	}

	@Override
	public void use(Player player) {
		player.getInventory().setChestplate(new AffaireRoseItem().build());

		destroy();
	}
}
