package fr.doctorwho.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.doctorwho.Scoreboard.Scoreboard;
import fr.doctorwho.service.API;
import fr.doctorwho.service.PlayerSQL;

public class updateScoreboardTablist implements CommandExecutor {
	private Plugin plugin;
	public updateScoreboardTablist(Plugin plugin) {
		this.plugin=plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] list) {
		if(!(sender instanceof Player)){
			System.out.println("Erreur: Vous ne pouvez pas utiliser cette commande ici!");
			return true;
		}
		Player p = (Player) sender;
		PlayerSQL ps = PlayerSQL.getPlayerSQL(p);
		if(ps.getRank().getPower() < 75){
			p.sendMessage(API.getLang().getMessage("tile.command.nopermission", ps.getLang()));
			return true;
		}
		if(list.length==0){
			Scoreboard.stop();
			Scoreboard.start();
			p.sendMessage(API.getLang().getMessage("tile.command.scoreboardupdate", ps.getLang()));
		}else{
			
		}
		return true;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

}
