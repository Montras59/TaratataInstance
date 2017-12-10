package fr.attila46.Scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.attila46.Main.Main;


public class ScoreBoardEvents implements Listener {
	private Main main;
	public ScoreBoardEvents(Main main) {
		this.setMain(main);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.sendMessage("§4§lNe pas utiliser ce plugin de test et jouer pendant les tests de celui-ci qui pourraient le faire crach!!! (attila46)");
		//________________________________Pour les teste en server solo sans connection à la db________________________________
		//PlayerSQL ps = new PlayerSQL();
		//ps.setPseudo(p.getName());
		//ps.setRank(EnumRank.DEVELOPPEUR);
		//ps.setUuid(p.getUniqueId().toString());
		//ps.setID(PlayerSQL.playersql.size());
		//ps.setCoins(1000);
		//ps.setQuetes("deso j'ai oublié la quete");
		//PlayerSQL.playersql.put(p, ps);
		//_____________________________________________________________________________________________________________________
		Scoreboard.PlayerUpdate(p);;
	}
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e){
		Scoreboard.PlayerDisconnecte(e.getPlayer());
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
}
