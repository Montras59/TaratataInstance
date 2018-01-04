package fr.doctorwho.quetes;

import org.bukkit.entity.Player;

import fr.doctorwho.quetes.saison1.Quete1;

public class QueteSaison1 {
	
	private String EPISODE1 = "Rose";
	
	private Player player;
	private String queteName;
	
	public QueteSaison1(Player player,String queteName) {
		this.player = player;
		this.queteName = queteName;
	}
	
	public void loadQuete(){
		switch(queteName){
		case "quete1": new Quete1(player,EPISODE1);
		}
	}

	public String getQueteName() {
		return queteName;
	}

	public void setQueteName(String queteName) {
		this.queteName = queteName;
	}
}
