package fr.doctorwho.quetes;

import org.bukkit.Location;
import org.bukkit.entity.Player;


public abstract class Quete {

	private Player p;
	
	
	//Une Quete peux etre en plusieur partie, cr�e en une nouvelle � chaque �venement
	private Integer part;
	
	public Quete(Player p) {
		Story s = Story.getStory(p.getUniqueId());
		setPlayer(p);
		setPart(s.getSavedPart());
	}
	
	public void setSavedPart(Integer i, Boolean b){
		Story s = Story.getStory(p.getUniqueId());
		s.setSavedPart(i);
		s.setExecuteOnJoin(b);
		s.save();
	}
	//Executer la Quete, Generalement � faire dans les evenements, Integer ex permet � ici un role ID, grace � celle si, vous pourrez
	//faire en sorte de faire des execution � choix multiple
	public abstract void execute(Integer ex);
	
	//Attribuer un Titre � cette Quete
	public abstract String getTitle();
	
	//Attribuer une Description � cette Quete
	public abstract String getDesc();

	//Ceci permet de retourner la location � indiquer au joueur pour r�aliser sa quete
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
