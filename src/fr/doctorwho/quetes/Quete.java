package fr.doctorwho.quetes;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import fr.doctorwho.Main;

public abstract class Quete implements Runnable{
	
	public static Map<Player, Quete> playerQuete = new HashMap<>();
	
	private BukkitTask task;
	private Player player;
	private String episodeName;
	private String title;
	private String description;
	
	private int part = 1;
	
	public Quete(Player player,String episodeName,String title,String description) {
		this.player = player;
		this.title = title;
		this.episodeName = episodeName;
		this.description = description;
		playerQuete.put(player, this);
		task = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this, 0, 1);
	}
	
	@Override
	public void run() {
		execute();
	}

	public abstract void execute();
	
	public void stopQuete(){
		task.cancel();
		playerQuete.remove(player);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
}
