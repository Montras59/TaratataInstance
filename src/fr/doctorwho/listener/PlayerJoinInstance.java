package fr.doctorwho.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.doctorwho.Main;
import fr.doctorwho.Scoreboard.Scoreboard;
import fr.doctorwho.quetes.QueteSaison1;
import fr.doctorwho.service.PlayerSQL;

public class PlayerJoinInstance implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		PlayerSQL playersql = PlayerSQL.playersql.get(player);
		
		if(playersql == null) playersql = PlayerSQL.playersql.put(player, PlayerSQL.getPlayerSQL(player));
		
		// Scoreboard
		new Scoreboard(player).createScoreboard();
		
		Main.getInformationFile().sendInformationMessage(player);
		
		// Quetes
		if(playersql.getSeason() == null || playersql.getSeason().equalsIgnoreCase("saison1")) new QueteSaison1(player,playersql.getQuete()).loadQuete();
	}
}
