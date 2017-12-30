package fr.doctorwho;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
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
		
		commandsListener();
		
		// Event
		ListenerManager listener = new ListenerManager(this);
		listener.register();
		
		informationFile = new InformationFile();
		
		if(Bukkit.getOnlinePlayers().size() == 0) return;
		
		for(Player player : Bukkit.getOnlinePlayers()){
			Bukkit.getPluginManager().callEvent(new PlayerJoinEvent(player, null));
		}
	}
	private void commandsListener(){
		
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
