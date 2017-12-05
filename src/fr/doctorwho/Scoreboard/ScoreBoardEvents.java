package fr.attila46.Scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.attila46.Main.Main;

public class ScoreBoardEvents implements Listener {
	private Main main;
	private Scoreboard sc = new Scoreboard();
	public ScoreBoardEvents(Main main) {
		this.main=main;
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
