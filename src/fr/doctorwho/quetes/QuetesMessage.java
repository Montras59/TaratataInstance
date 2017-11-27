package fr.doctorwho.quetes;

import org.bukkit.entity.Player;

import fr.doctorwho.Main;

public class QuetesMessage {

	String quetes;
	
	public QuetesMessage(String quetes) {
		this.quetes = quetes;
	}
	
	public void sendMessage(Player player){
		System.out.println("sendMessage is active");
		if(Main.getQuetes().getConfig().contains(quetes)) System.out.println("Quetes is active");
		for(String string : Main.getQuetes().getConfig().getStringList(quetes)){
			player.sendMessage(string.replaceAll("&", "§"));
		}
	}
}
