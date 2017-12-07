package fr.doctorwho;

import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.Scoreboard.Scoreboard;
import fr.doctorwho.listener.ListenerManager;
import fr.doctorwho.quetes.QueteManager;

public class Main extends JavaPlugin{

	private static Main instance;
	private static QueteManager manager;
	
	//Scoreboard
	private Scoreboard scoreboard = new Scoreboard();
	
	@Override
	public void onEnable() {
		instance = this;
		
		// Event
		ListenerManager listener = new ListenerManager(this);
		listener.register();
		
		manager = new QueteManager(this);
		
		//Scoreboard
		scoreboard.start();
	}
	
	public void onDisable(){
		//Scoreboard
		scoreboard.stop();
	}
	public static Main getInstance(){
		return instance;
	}

	public static QueteManager getQueteManager() {
		return manager;
	}
}
