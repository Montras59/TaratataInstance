package fr.doctorwho.Scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class ScoreBoardEvents implements Listener {
	private Plugin plugin;
	private Scoreboard sc = new Scoreboard();
	public ScoreBoardEvents(Plugin pl) {
		this.plugin=pl;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		sc.PlayerScoreboard(e.getPlayer());
	}
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e){
		sc.Disconnecte(e.getPlayer());
	}
}
