package fr.doctorwho.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.doctorwho.service.PlayerSQL;

public class PlayerJoinInstance implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		PlayerSQL playersql = PlayerSQL.playersql.get(player);
		
		if(playersql == null) System.out.println("cc");
		
		// DETECTION QUETES
		if(playersql.getQuetes().equalsIgnoreCase("s1ep1q1%0")){
			player.teleport(new Location(Bukkit.getWorlds().get(0), 100, 100, 100));
		}
	}
}
