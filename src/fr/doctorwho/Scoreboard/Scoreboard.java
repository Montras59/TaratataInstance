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
	//A ENLEVER car il va �tre ajout� � PlayerSQL!
	//function pour �vit� de faire deux fois la m�me requ�te � la db
	public static PlayerSQL getPlayerSQL(Player p){
		PlayerSQL ps = null;
		if(PlayerSQL.playersql.containsKey(p)){
			ps = PlayerSQL.getPlayerSQL(p);
		}else{
			ps = PlayerSQL.getPlayerSQL(p);
			if(ps == null){
				PlayerSQL.createAccount(p);
				ps = PlayerSQL.getPlayerSQL(p);
			}
		}
		return ps;
	}
	//update le nom d'un joueur dans la tablist
	public static void PlayerTablist(Player p){
		PlayerSQL ps = getPlayerSQL(p);
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
		if(!boards.containsKey(p)){
			createPlayerScoreboard(p);
		}
		ScoreboardSign sc = boards.get(p);
		HashMap<Integer,String> lignes = new HashMap<>(); 
		lignes.putAll(Translation.getLignes(p));
		for(Entry<Integer,String> ligne : lignes.entrySet()){
			sc.setLine(ligne.getKey(), ligne.getValue());
		}
	}
	//function interne cr�e le scoreboard du joueur cibl�
	public static boolean createPlayerScoreboard(Player p){
		if(!boards.containsKey(p)){
			ScoreboardSign scoreboard = new ScoreboardSign(p, ChatColor.AQUA+"�lDoctorWhoRP");
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