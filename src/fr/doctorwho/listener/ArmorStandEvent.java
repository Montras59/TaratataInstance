package fr.doctorwho.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import fr.doctorwho.utils.ArmorStandUtils;

public class ArmorStandEvent implements Listener{

	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent event){
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();
		
		if(entity == null || entity.getType() != EntityType.ARMOR_STAND|| !ArmorStandUtils.ARMORSTAND.containsKey(entity.getLocation())) return;
		
		ArmorStandUtils.ARMORSTAND.get(entity.getLocation()).use(player);
		event.setCancelled(true);
	}
}
