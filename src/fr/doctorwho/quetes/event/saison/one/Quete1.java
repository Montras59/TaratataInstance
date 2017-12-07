package fr.doctorwho.quetes.event.saison.one;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.doctorwho.Main;
import fr.doctorwho.quetes.Quete;
import fr.doctorwho.quetes.Saison;

public class Quete1 extends Quete {

	public Quete1(Player p) {
		super(p);
		
	}

	@Override
	public void execute(Integer ex) {
		if(getPart() == 0 && ex == 0){
			getPlayer().teleport(new Location(Bukkit.getServer().getWorlds().get(0), 0 , 100 , 0));
			getPlayer().sendMessage("§3Que l'aventure commence!");
			setPart(1);
		}
		else if(getPart() == 1 && ex == 0){
			getPlayer().sendMessage("§3[Quete Test] tu viens de passer à la quete suivante");
			Main.getQueteManager().startQuete(getPlayer(), Saison.one, 2);
		}
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocIndicator() {
		// TODO Auto-generated method stub
		return null;
	}



}
