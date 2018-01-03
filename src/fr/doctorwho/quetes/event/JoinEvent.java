package fr.doctorwho.quetes.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

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
	
	@EventHandler	
	public void onMove(PlayerMoveEvent event){

		Player player = event.getPlayer();
		Story story = Story.getStory(event.getPlayer().getUniqueId());
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(story.getSaison() == Saison.one && story.getQuete() == 1){
					
					if(Main.getQueteManager().getQuete(player).getPart() == 1){
						if(event.getFrom().getBlock().getType() == Material.CARPET){
							Main.getQueteManager().getQuete(player).execute(0);
						}
					}
					if(Main.getQueteManager().getQuete(player).getPart() == 2){
						if(event.getFrom().getBlock().getType() == Material.SPRUCE_DOOR){
							Main.getQueteManager().getQuete(player).execute(0);
						}
					}
					if(Main.getQueteManager().getQuete(player).getPart() == 3){
						if(event.getFrom().getBlock().getLocation().add(0, -1, 0).getBlock().getType() == Material.QUARTZ_STAIRS){
							Main.getQueteManager().getQuete(player).execute(0);
							
						}
					}
					
				}
				cancel();
				
			}
		}.runTaskLater(Main.getInstance(), 1);

	}
}
