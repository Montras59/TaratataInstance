package fr.doctorwho.quetes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
public abstract class Quete {

	private Player p;
	
	
	//Une Quete peux etre en plusieur partie, crée en une nouvelle à chaque évenement
	private Integer part;
	
	public Quete(Player p) {
		setPlayer(p);
		setPart(0);
	}
	
	//Executer la Quete, Generalement à faire dans les evenements, Integer ex permet à ici un role ID, grace à celle si, vous pourrez
	//faire en sorte de faire des execution à choix multiple
	public abstract void execute(Integer ex);
	
	//Attribuer un Titre à cette Quete
	public abstract String getTitle();
	
	//Attribuer une Description à cette Quete
	public abstract String getDesc();

	//Ceci permet de retourner la location à indiquer au joueur pour réaliser sa quete
	public abstract Location getLocIndicator();
	
	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
	}

	public Integer getPart() {
		return part;
	}

	public void setPart(Integer part) {
		this.part = part;
	}
	
}
