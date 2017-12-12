package fr.doctorwho.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.doctorwho.Scoreboard.Scoreboard;

public class PlayerQuitInstance implements Listener{

	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		Scoreboard.PlayerDisconnecte(event.getPlayer());
	}
}
