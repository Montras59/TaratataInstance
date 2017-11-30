package fr.doctorwho.quetes;

import org.bukkit.entity.Player;

public interface Quete {

	//p est le Joueur qui recevra l'action, story est son avancer dans l'histoire et part, 
	//c'est si jamais une quete et separer en plusieur partie
	
	public void execute(Player p, Story story, Integer part);
	
}
