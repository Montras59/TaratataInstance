package fr.doctorwho.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public abstract class ArmorStandUtils {

	private Location location;
	private String title;
	private boolean isNameVisible;
	ArmorStand armorstand;
	
	public static Map<Location, ArmorStandUtils> ARMORSTAND = new HashMap<>();
	
	public ArmorStandUtils(Location location,String title,boolean isNameVisible) {
		this.location = location;
		this.title = title;
		this.isNameVisible = isNameVisible;
		
		armorstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
	}
	
	public void addEquipment(ItemMenu item){
		armorstand.setItemInHand(item.build());
	}
	
	public abstract void use(Player player);
	
	public void create(){
		armorstand.teleport(location);
		armorstand.setVisible(false);
		armorstand.setCustomName(title);
		armorstand.setGravity(false);
		armorstand.setArms(true);
		armorstand.setCustomNameVisible(isNameVisible);
		
		ARMORSTAND.put(location, this);
	}
	
	public void destroy(){
		ARMORSTAND.remove(location);
		
		armorstand.remove();
	}

	public ArmorStand getArmorstand() {
		return armorstand;
	}

	public void setArmorstand(ArmorStand armorstand) {
		this.armorstand = armorstand;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isNameVisible() {
		return isNameVisible;
	}

	public void setNameVisible(boolean isNameVisible) {
		this.isNameVisible = isNameVisible;
	}
}
