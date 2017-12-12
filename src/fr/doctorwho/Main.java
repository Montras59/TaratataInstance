package fr.doctorwho;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.file.InformationFile;
import fr.doctorwho.listener.ListenerManager;
import fr.doctorwho.quetes.QueteManager;

public class Main extends JavaPlugin{

	public static Plugin instance;
	public static QueteManager queteManager;
	public static InformationFile informationFile;
	
	@Override
	public void onEnable() {
		instance = this;
		queteManager = new QueteManager(this);
		
		commandsListener()
		
		// Event
		ListenerManager listener = new ListenerManager(this);
		listener.register();
		
		informationFile = new InformationFile();
	}
	private void commandsListener(){
		getCommand("updatescoreboard").setExecutor(new updateScoreboardTablist(this));
		getCommand("lang").setExecutor(new LangSelect(this));
	}
	public static Plugin getInstance(){
		return instance;
	}

	public static QueteManager getQueteManager() {
		return queteManager;
	}

	public static InformationFile getInformationFile() {
		return informationFile;
	}
}
