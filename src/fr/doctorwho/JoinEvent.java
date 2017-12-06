package fr.doctorwho.quetes.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.doctorwho.Main;
import fr.doctorwho.quetes.Saison;
import fr.doctorwho.quetes.Story;

public class JoinEvent implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		Story story = Story.getStory(player.getUniqueId());
		Main.getQueteManager().startQuete(player, story.getSaison(), story.getQuete());	
		
		
		if(story.getSaison() == Saison.one && story.getQuete() == 1){
			
			Main.getQueteManager().getQuete(player).execute(0);
			
		}
	}
	
}
