package fr.attila46.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.attila46.Main.Main;
import fr.attila46.Scoreboard.Scoreboard;
import fr.doctorwho.service.PlayerSQL;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;

public class updateScoreboardTablist implements CommandExecutor {
	private Main main;
	public updateScoreboardTablist(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] list) {
		if(!(sender instanceof Player)){
			System.out.println("Erreur: Vous ne pouvez pas utiliser cette commande ici!");
			return true;
		}
		Player p = (Player) sender;
		PlayerSQL ps = Scoreboard.getPlayerSQL(p);
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

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

}
