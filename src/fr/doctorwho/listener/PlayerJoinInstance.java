package fr.doctorwho.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.doctorwho.Main;
import fr.doctorwho.Scoreboard.Scoreboard;
import fr.doctorwho.animation.StartTardisAnimation;

public class PlayerJoinInstance implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		// Scoreboard
		new Scoreboard(player).createScoreboard();
		
		Main.getInformationFile().sendInformationMessage(player);
		
		new StartTardisAnimation(player,new Location(Bukkit.getWorlds().get(0), 44, 64, 159));
	
	}
}
