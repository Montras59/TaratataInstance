package fr.doctorwho.quetes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
public abstract class Quete {

	private Player p;
	private Integer part;
	
	public Quete(Player p) {
		setPlayer(p);
		setPart(0);
	}
	
	public abstract void execute(Integer ex);
	
	public abstract String getTitle();
	
	public abstract String getDesc();

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
