package fr.doctorwho.quetes.saison1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.doctorwho.quetes.Quete;

public class Quete1 extends Quete{

	private int i = 0;
	private boolean cancel = false;
	
	public Quete1(Player player) {
		super(player, "L'inconnue", "description au pif");
	}

	@Override
	public void execute() {
		if(getPart() == 1) partOne();
		else if(getPart() == 2) partTwo();
		else if(getPart() == 3) partThree();
		else stopQuete();
	}
	
	public void partOne(){
		i++;
		if(i == 1){
			getPlayer().teleport(new Location(Bukkit.getServer().getWorlds().get(0), 9, 21 , 2));
			getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 2));
			getPlayer().sendMessage("§7*sonnerie du réveil 7h30*");
		}
		else if(i == 15)getPlayer().sendMessage("§7*Allez! il faut se lever !*");	
		else if(i == 30){
		    for (PotionEffect effect : getPlayer().getActivePotionEffects ()){
		        getPlayer().removePotionEffect(effect.getType ());
		        setPart(1);
		    }
		}
		else if(i == 45){
			getPlayer().sendMessage("§7*Diriger vous vers le salon*");
			i = 0;
			setPart(2);
		}
	}
	
	public void partTwo(){
		Material material = getPlayer().getLocation().getBlock().getType();
		if(material != Material.CARPET && !cancel) return;
		cancel = true;
		i++;
		if(i == 1) getPlayer().sendMessage("§dRose : Salut !");
		else if(i == 15) getPlayer().sendMessage("§5Mère de Rose : à toute à l'heure.");
		else if(i == 30){
			getPlayer().sendMessage("§7Diriger vous vers le Bus");
			i = 0;
			setPart(3);
			cancel = false;
		}
	}
	
	public void partThree(){
		Material material = getPlayer().getLocation().add(0, -1, 0).getBlock().getType();
		if(material != Material.QUARTZ_STAIRS && !cancel)return;
		cancel = true;
		getPlayer().sendMessage("§7Attaché votre ceinture, on decolle!");
		setPart(4);
	}
}
