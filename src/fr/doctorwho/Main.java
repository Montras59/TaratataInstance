package fr.doctorwho;

import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.listener.ListenerManager;
import fr.doctorwho.quetes.QuetesFile;

public class Main extends JavaPlugin{

	private static Main instance;
	
	// SYSTEM COPY FILE
	private static QuetesFile quetes;
	//Scoreboard
	private Scoreboard scoreboard = new Scoreboard();
	
	@Override
	public void onEnable() {
		instance = this;
		
		// Event
		ListenerManager listener = new ListenerManager(this);
		listener.register();
		
		// File
		quetes = new QuetesFile();
		quetes.create();
		
		//Scoreboard
		scoreboard.start();
	}
	
	public static QuetesFile getQuetes(){
		return quetes;
	}
	public void onDisable(){
		//Scoreboard
		scoreboard.stop();
	}
	public static Main getInstance(){
		return instance;
	}
}
