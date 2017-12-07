package fr.doctorwho.quetes;

import org.bukkit.entity.Player;

import fr.doctorwho.quetes.event.saison.one.Quete1;
import fr.doctorwho.quetes.event.saison.one.Quete2;

public class QueteBuilder {

	private Player player;
	private Story story;
	
	public QueteBuilder(Player player) {
		setStory(Story.getStory(player.getUniqueId()));
		setPlayer(player);
	}

	public Quete Build(){
	
		switch(story.getSaison().getId()){
		case 1: 
			switch(story.getQuete()){			
			case 1: return new Quete1(getPlayer());
			case 2: return new Quete2(getPlayer());
			
			}
		}
		
		return null;
		
		
	}
	
	
	
	
	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
