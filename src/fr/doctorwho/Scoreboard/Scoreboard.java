package fr.doctorwho.Scoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;

import fr.doctorwho.Main;
import fr.doctorwho.enums.EnumRank;
import fr.doctorwho.service.API;
import fr.doctorwho.service.PlayerSQL;
import net.md_5.bungee.api.ChatColor;


@SuppressWarnings("deprecation")
public class Scoreboard {
	private Plugin pl = Main.getInstance();
	//stockage des scoreboards de tout les joueur
	private static HashMap<Player,ScoreboardSign> boards;
	//stockage des Team de grade
	private static HashMap<String,Team> teamTablist;
	//stockage des nom de Team
	private static ArrayList<String> teamNames;
	public Scoreboard(){
	}
	//function pour ajout� tout les joueur du serveur au scoreboard et � la tablist 
	public static void start(){
		teamTablist = new HashMap<>();
		teamNames = new ArrayList<>();
		for(EnumRank r : EnumRank.values()){
			Team t;
			String teamName = "TablistRanck"+(r.getPower()*-1);
			teamNames.add(teamName);
			t = Bukkit.getScoreboardManager().getNewScoreboard().registerNewTeam(teamName);
			t.setPrefix(teamName);
			t.setNameTagVisibility(NameTagVisibility.ALWAYS);
			teamTablist.put(r.getRankName(), t);
		}
		boards = new HashMap<>();
		for(Player p : Bukkit.getOnlinePlayers()){
			PlayerScoreboard(p);
		}
	}
	//function pour cr�er ou update le scoreboard et la tablist d'un joueur
	public static void PlayerUpdate(Player p){
		PlayerScoreboard(p);
		PlayerTablist(p);
	}
	//update le nom d'un joueur dans la tablist
	public static void PlayerTablist(Player p){
		PlayerSQL ps = PlayerSQL.getPlayerSQL(p);
		EnumRank r = ps.getRank();
		p.setPlayerListName(r.getRankPrefix()+p.getDisplayName());
		System.out.println("testRun");
		Team t = teamTablist.get(r.getRankName());
		for(String tag : p.getScoreboardTags()){
			if(teamNames.contains(tag) ){
				p.removeScoreboardTag(tag);
			}
		}
		p.addScoreboardTag(t.getName());
	}
	//function pour d�truire tout les scoreboards
	public static void stop(){
		for(Entry<Player, ScoreboardSign> p : boards.entrySet()){
			p.getValue().destroy();
		}
		boards.clear();
	}
	//function pour d�truire le scoreboard du joueur cibl�
	public static void PlayerDisconnecte(Player p){
		if(boards.containsKey(p)){
			boards.get(p).destroy();
			boards.remove(p);
		}
	}
	//update ou cr�er le scoreboard d'un joueur
	public static void PlayerScoreboard(Player p){
		if(boards.get(p) == null || !boards.containsKey(p)){
			createPlayerScoreboard(p);
		}
		ScoreboardSign sc = boards.get(p);
		int lang = PlayerSQL.playersql.get(p).getLang();
		
		sc.setLine(1, API.getLang().getMessage("line.scoreboard.information", lang).replaceAll("%separation%", ":"));
		sc.setLine(3, API.getLang().getMessage("line.scoreboard.rank", lang).replaceAll("%separation%", ":").replaceAll("%rank%", PlayerSQL.playersql.get(p).getRank().getRankPrefix()));
		sc.setLine(4, API.getLang().getMessage("line.scoreboard.level", lang).replaceAll("%separation%", ":").replaceAll("%level%", 1+""));
		sc.setLine(5, API.getLang().getMessage("line.scoreboard.progress", lang).replaceAll("%separation%", ":").replaceAll("%progress%", 0+""));
		sc.setLine(6, API.getLang().getMessage("line.scoreboard.server", lang).replaceAll("%separation%", ":").replaceAll("%server%", Bukkit.getServerName()));
		sc.setLine(8, API.getLang().getMessage("line.scoreboard.season", lang).replaceAll("%separation%", ":").replaceAll("%season%", 1+""));
		sc.setLine(9, "...");
		sc.setLine(10, API.getLang().getMessage("line.scoreboard.quest", lang).replaceAll("%separation%", ":").replaceAll("%quest%", 1+"/" + 10));
		sc.setLine(11, "...");
		sc.setLine(12, API.getLang().getMessage("line.scoreboard.role", lang).replaceAll("%separation%", ":"));
		sc.setLine(14, "§a§l      doctorwhorp.fr");
	}
	//function interne cr�e le scoreboard du joueur cibl�
	public static boolean createPlayerScoreboard(Player p){
		if(!boards.containsKey(p)){
			ScoreboardSign scoreboard = new ScoreboardSign(p, ChatColor.AQUA+"DoctorWhoRP");
			scoreboard.create();
			boards.put(p, scoreboard);
			return true;
		}
		return false;
	}
	public Plugin getPl() {
		return pl;
	}
	public void setPl(Plugin pl) {
		this.pl = pl;
	}
}
