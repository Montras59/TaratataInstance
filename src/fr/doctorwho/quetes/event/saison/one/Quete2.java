package fr.doctorwho.quetes.event.saison.one;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.doctorwho.quetes.Quete;

public class Quete2 extends Quete{

	public Quete2(Player p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	
	//Executer la Quete, Generalement � faire dans les evenements, Integer ex permet � ici un role ID, grace � celle si, vous pourrez
	//faire en sorte de faire des execution � choix multiple
	@Override
	public void execute(Integer ex) {
		
		
	}

	@Override
	public String getTitle() {
		//Attribuer un Titre � cette Quete
		return "Titre de la Quete 2";
	}

	@Override
	public String getDesc() {
		//Attribuer une Description � cette Quete
		return "Ceci est la description de la Quete 2";
	}

	@Override
	public Location getLocIndicator() {
		//Ceci permet de retourner la location � indiquer au joueur pour r�aliser sa quete
		return null;
	}

}
