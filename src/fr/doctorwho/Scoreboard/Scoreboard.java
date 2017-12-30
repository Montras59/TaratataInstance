package fr.doctorwho.Scoreboard;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.doctorwho.Main;
import fr.doctorwho.service.API;
import fr.doctorwho.service.PlayerSQL;

public class Scoreboard implements Runnable{

		private BukkitTask task;
	
	private Player player;
	private int lang;
	
	private ScoreboardManager sm;
	private org.bukkit.scoreboard.Scoreboard scoreboard;
	private Objective obj;
	
	private Map<Integer, String> scores = new HashMap<>();
	
	public Scoreboard(Player player) {
		this.player = player;
		if(PlayerSQL.playersql.get(player) == null) PlayerSQL.playersql.put(player, PlayerSQL.getPlayerSQL(player));
		this.lang = PlayerSQL.playersql.get(player).getLang();
		this.setTask(Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this, 0, 20));
	}
	
	private void initScoreboard(){
		sm = Bukkit.getScoreboardManager();
		scoreboard = sm.getNewScoreboard();
		obj = scoreboard.registerNewObjective("point", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§b§lDoctorWho");
	}
	
	public void initTeam(){
		if(Bukkit.getOnlinePlayers().size() == 0) return;
		
		for(Player all : Bukkit.getOnlinePlayers()){
			all.setPlayerListName(PlayerSQL.playersql.get(all).getRank().getRankPrefix() + all.getName());
		}
	}
	
	public void createScoreboard(){
		initScoreboard();
		scores.clear();
		
		int tile = 15;
		addScore(tile--, "§a");
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.Information", lang).replaceAll("%separation%", ":"));
		addScore(tile--, "§c");
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.rank", lang).replaceAll("%separation%", ":").replaceAll("%rank%", PlayerSQL.playersql.get(player).getRank().getRankPrefix()));
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.level", lang).replaceAll("%separation%", ":").replaceAll("%level%", 1+""));
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.progress", lang).replaceAll("%separation%", ":").replaceAll("%progress%", 0+""));
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.server", lang).replaceAll("%separation%", ":").replaceAll("%server%", Bukkit.getServerName()));
		addScore(tile--, "§e");
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.season", lang).replaceAll("%separation%", ":").replaceAll("%season%", 1+""));
		addScore(tile--, "§3§l...");
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.quest", lang).replaceAll("%separation%", ":").replaceAll("%quest%", 1+"/" + 10));
		addScore(tile--, "§9§l...");
		addScore(tile--, API.getLang().getMessage("tile.scoreboard.role", lang).replaceAll("%separation%", ":"));
		addScore(tile--, "§d");
		addScore(tile--, "§a§l      doctorwhorp.fr");
		
		player.setScoreboard(scoreboard);
	}
	
	public void addScore(int key,String value){
		Score score = obj.getScore(value);
		score.setScore(key);
		scores.put(key, value);
	}
	
	@Override
	public void run() {
		initTeam();
		
		lang = PlayerSQL.playersql.get(player).getLang();
		if(scores.containsValue(API.getLang().getMessage("tile.scoreboard.rank", lang).replaceAll("%separation%", ":").replaceAll("%rank%", PlayerSQL.playersql.get(player).getRank().getRankPrefix()))
				&& scores.containsValue(API.getLang().getMessage("tile.scoreboard.level", lang).replaceAll("%separation%", ":").replaceAll("%level%", 1+""))
				&& scores.containsValue(API.getLang().getMessage("tile.scoreboard.progress", lang).replaceAll("%separation%", ":").replaceAll("%progress%", 0+""))
				&& scores.containsValue(API.getLang().getMessage("tile.scoreboard.season", lang).replaceAll("%separation%", ":").replaceAll("%season%", 1+""))
				&& scores.containsValue(API.getLang().getMessage("tile.scoreboard.quest", lang).replaceAll("%separation%", ":").replaceAll("%quest%", 1+"/" + 10))
				&& scores.containsValue(API.getLang().getMessage("tile.scoreboard.role", lang).replaceAll("%separation%", ":"))){
			return;
		}
		
		createScoreboard();
	}

	public BukkitTask getTask() {
		return task;
	}

	public void setTask(BukkitTask task) {
		this.task = task;
	}
}
