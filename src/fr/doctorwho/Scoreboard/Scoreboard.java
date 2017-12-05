package fr.attila46.Scoreboard;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.attila46.Main.Main;
import net.md_5.bungee.api.ChatColor;

public class Scoreboard {
	private Plugin pl = Main.getInstance();
	private static HashMap<Player,ScoreboardSign> boards;
	public Scoreboard(){
	}
	public void start(){
		boards = new HashMap<>();
		for(Player p : Bukkit.getOnlinePlayers()){
			PlayerScoreboard(p);
		}
	}
	public void PlayerScoreboard(Player p){
		if(!boards.containsKey(p)){
			createPlayerScoreboard(p);
		}
		updatePlayerScoreboard(p);
	}
	public void stop(){
		for(Entry<Player, ScoreboardSign> p : boards.entrySet()){
			p.getValue().destroy();
		}
		boards.clear();
	}
	public void Disconnecte(Player p){
		if(boards.containsKey(p)){
			boards.get(p).destroy();
			boards.remove(p);
		}
	}
	public void updatePlayerScoreboard(Player p){
		ScoreboardSign sc = boards.get(p);
		HashMap<Integer,String> lignes = new HashMap<>();
		lignes.put(0,"§a");
		lignes.put(2, "§b");
		for(Entry<Integer, String> ligne: lignes.entrySet()){
			sc.setLine(ligne.getKey(), ligne.getValue());
		}
	}
	public boolean createPlayerScoreboard(Player p){
		if(!boards.containsKey(p)){
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
			return true;
		}
		return false;
	}
}