package fr.doctorwho.Scoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.doctorwho.quetes.Story;
import fr.doctorwho.service.PlayerSQL;



public enum Translation {	
	VIDE0(0,"�a","",""),
	INFO(1,"�e�l�n","Information:",""),
	VIDE(2,"�d","",""),
	GRADE(3,"�c�l","Grade:",""),
	NIVEAU(4,"�c�l","Niveau:",""),
	PROGRESSION(5,"�c�l","Progression:",""),
	SERVEUR(6,"�c�l","Serveur:",""),
	VIDE1(7,"�b","",""),
	SAISON(8,"�9�l�n","Saison",""),
	TITRE_SAISON(9,"�a�7�o","",""),
	QUETE(10,"�9�l","Qu�te",""),
	TITRE_QUETE(11,"�7�o","",""),
	ROLE(12,"�6�l","R�le:",""),
	VIDE2(13,"�c","",""),
	NAME_SERVEUR(14,"�a�l      ","doctorwhorp.fr","");
	
	//la ligne dans le scoreboard
	int ligne;
	//prefix de la ligne dans le scoreboad
	String color;
	//traduction fr
	String fr;
	//traduction en
	String en;
	private Translation(int ligne, String color, String fr, String en){
		this.color=color;
		this.ligne=ligne;
		this.fr=fr;
		this.en=en;		
	}
	//liste des valeurs en fonction du joueur HashMap<Integer,String> Integer=ligne String=value
	private static HashMap<Integer, String> getListValue(Player p){
		HashMap<Integer,String> value = new HashMap<>();
		PlayerSQL ps = Scoreboard.getPlayerSQL(p);
		Story s = Story.getStory(p.getUniqueId());
		//listValue.put(int ligne,String value);
		value.put(3, " "+ps.getRank().getRankPrefix());
		value.put(4, "�b�l "+1);
		value.put(5,"�b�l "+0+"%");
		value.put(6, "�e�l "+Bukkit.getServerName());
		value.put(8, " "+1+":");//s.getSaison()
		value.put(9,"...");
		value.put(10, " ["+s.getQuete()+"/"+10+"]:");
		value.put(11,"...");
		value.put(12, "�d�l "+"...");
		return value;
	}
	//liste des lignes � affich� dans le scoreboard en fonction du joueur HashMap<Integer,String> Integer=ligne String=le message de la ligne
	public static HashMap<Integer, String> getLignes(Player p){
		HashMap<Integer,String> listValue = getListValue(p);
		HashMap<Integer,String> result = new HashMap<>();
		for(Translation t: Translation.values()){
			String textTranslate = t.color;
			//a voir dans l'api !!!
			switch(0){
				case 0:
					textTranslate+=t.fr;
					break;
				case 1:
					textTranslate+=t.en;
					break;
				default:
					textTranslate+=t.fr;
					break;
			}
			if(listValue.containsKey(t.ligne)){
				textTranslate+=listValue.get(t.ligne);
			}
			result.put(t.ligne,textTranslate);
		}
		return result;	
	}	
}