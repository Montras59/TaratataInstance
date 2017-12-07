package fr.doctorwho.quetes;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class QueteManager {

	
	private HashMap<Player, Quete> quetesActive = new HashMap<>();
			
	private Plugin plugin;
	
	public QueteManager(Plugin plugin) {
		setPlugin(plugin);
		
	}
	
	//redemarer la quete de tout les joueurs
	public void rebootAll(){
		for(Player p : Bukkit.getOnlinePlayers()){
			
			Story story = Story.getStory(p.getUniqueId());
			startQuete(p, story.getSaison(), story.getQuete());		
		}
	}
	
	//recuperer la quete active d'un joueur
	public Quete getQuete(Player player){
		if(quetesActive.containsKey(player)){
			return quetesActive.get(player);
		}
		return null;
		
	}
	
	//recommencer la quete au point de depart
	public void rebootOnly(Player player){
		
		Story story = Story.getStory(player.getUniqueId());
		startQuete(player, story.getSaison(), story.getQuete());	
	}
	
	
	//cette fonction permet de charger une nouvelle quete à un joueur
	public Quete startQuete(Player player, Saison saison, Integer queteNumber){
		Story story = Story.getStory(player.getUniqueId());
		Boolean announce = false;
		if(story.getQuete() != queteNumber || story.getSaison() != saison){
			story.setSaison(saison);
			story.setQuete(queteNumber);
			story.save();
			announce = true;
		}
		Quete quete = new QueteBuilder(player).Build();
		if(quete!= null){
			this.quetesActive.put(player, quete);
			if(announce){
				player.sendMessage("");
				player.sendMessage("");
				player.sendMessage(" §3§lNouvelle Quete Disponible:");
				player.sendMessage(" §3§lNom: §6"+ quete.getTitle());
				player.sendMessage(" §3§lDescription: " + "§6" +quete.getDesc());
				player.sendMessage("");
				player.sendMessage("");
				player.playSound(player.getLocation(), Sound.BLOCK_NOTE_CHIME, 1, 1);
			}
			
			
			return quete;
		}
		
		Bukkit.getServer().getLogger().warning("Attention! la quete numero " + queteNumber + " de la saison " +saison.getName() + " n'est pas répertorié");
		return null;

	}
	
	//Supprimer l'avancement d'une Quete d'un joueur
	public void cancelQuete(Player player){
		quetesActive.remove(player);	
	}
	

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}


	
}
