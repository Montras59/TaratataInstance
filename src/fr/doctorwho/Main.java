package fr.doctorwho;

import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.listener.ListenerManager;
import fr.doctorwho.quetes.QuetesFile;

public class Main extends JavaPlugin{

	private static Main instance;
	
	// SYSTEM COPY FILE
	private static QuetesFile quetes;
	
	@Override
	public void onEnable() {
		instance = this;
		
		// Event
		ListenerManager listener = new ListenerManager(this);
		listener.register();
		
		// File
		quetes = new QuetesFile();
		quetes.create();
	}
	
	public static QuetesFile getQuetes(){
		return quetes;
	}
	
	public static Main getInstance(){
		return instance;
	}
}
