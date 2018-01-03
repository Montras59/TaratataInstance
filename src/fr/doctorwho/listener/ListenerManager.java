package fr.doctorwho.listener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.doctorwho.quetes.event.JoinEvent;

public class ListenerManager {

	Plugin plugin;
	
	public ListenerManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void register(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinInstance(), plugin);
		pm.registerEvents(new JoinEvent(), plugin);
	}
}
