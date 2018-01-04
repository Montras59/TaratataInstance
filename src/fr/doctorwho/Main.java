package fr.doctorwho;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.doctorwho.file.InformationFile;
import fr.doctorwho.listener.ListenerManager;
import fr.doctorwho.utils.ArmorStandUtils;

public class Main extends JavaPlugin{

	public static Plugin instance;
	public static InformationFile informationFile;
	
	@Override
	public void onEnable() {
		instance = this;
		
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
	
	@Override
	public void onDisable() {
		for(Location location : ArmorStandUtils.ARMORSTAND.keySet()){
			ArmorStandUtils.ARMORSTAND.get(location).destroy();
		}
	}
	
	private void commandsListener(){
		
	}
	public static Plugin getInstance(){
		return instance;
	}

	public static InformationFile getInformationFile() {
		return informationFile;
	}
}
