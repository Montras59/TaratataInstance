package fr.doctorwho.Scoreboard;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.doctorwho.Main;
import net.md_5.bungee.api.ChatColor;

public class Scoreboard {
	private Plugin pl = Main.getInstance();
	//stockage des scoreboards de tout les joueur
	private static HashMap<Player,ScoreboardSign> boards;
	//constructeur que je n'ai pas utilisé
	public Scoreboard(){
	}
	//function pour ajouté tout les joueur sur le serveur au scoreboard
	public void start(){
		boards = new HashMap<>();
		for(Player p : Bukkit.getOnlinePlayers()){
			PlayerScoreboard(p);
		}
	}
	//function pour créer ou update le scoreboard d'un joueur
	public void PlayerScoreboard(Player p){
		if(!boards.containsKey(p)){
			createPlayerScoreboard(p);
		}
		updatePlayerScoreboard(p);
	}
	//function pour détruire tout les scoreboards
	public void stop(){
		for(Entry<Player, ScoreboardSign> p : boards.entrySet()){
			p.getValue().destroy();
		}
		boards.clear();
	}
	//function pour détruire le scoreboard du joueur ciblé
	public void Disconnecte(Player p){
		if(boards.containsKey(p)){
			boards.get(p).destroy();
			boards.remove(p);
		}
	}
	//function interne update le scoreboard du joueur ciblé
	private void updatePlayerScoreboard(Player p){
		ScoreboardSign sc = boards.get(p);
		HashMap<Integer,String> lignes = new HashMap<>();
		lignes.put(0,"§a");
		lignes.put(2, "§b");
		for(Entry<Integer, String> ligne: lignes.entrySet()){
			sc.setLine(ligne.getKey(), ligne.getValue());
		}
	}
	//function interne crée le scoreboard du joueur ciblé
	private void createPlayerScoreboard(Player p){
		//ScoreboardSign est une api 1.11 que j'ai mi à jour
		ScoreboardSign scoreboard = new ScoreboardSign(p, ChatColor.AQUA+"§lDoctorWhoRP");
		scoreboard.create();
		String[] lignes = {
				"§a",
				ChatColor.YELLOW+"§l§nInformation:",
				"§b",
				ChatColor.RED+"§lGrade: "+ChatColor.GRAY+"-------",
				ChatColor.RED+"§lNiveau: "+ChatColor.AQUA+"--",
				ChatColor.RED+"§lProgression: "+ChatColor.AQUA+"--%",
				ChatColor.RED+"§lServeur: "+ChatColor.YELLOW+"------",
				"§c",
				ChatColor.BLUE+"§lQuête (--):",
				ChatColor.DARK_AQUA+"§l---------",
				ChatColor.BLUE+"§lEtape (--/--):",
				ChatColor.GRAY+"§l---------",
				ChatColor.GOLD+"§lIncarnation: "+ChatColor.BLUE+"---------",
				"§d",
				ChatColor.GREEN+"§lDoctorWhoRP.fr"};
		int i=0;
		for(String l : lignes){
			scoreboard.setLine(i, l);
			i++;
		}
		boards.put(p, scoreboard);
	}
}
