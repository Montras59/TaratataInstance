package fr.doctorwho.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.doctorwho.Scoreboard.Scoreboard;
import fr.doctorwho.service.PlayerSQL;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;

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
			p.sendMessage("§4Vous n'avez pas la permission de exécuter la commande!");
			return true;
		}
		if(list.length==0){
			Scoreboard.stop();
			Scoreboard.start();
			p.sendMessage("§2Le scoreboard et la tablist on bien été update!");
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
