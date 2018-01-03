package fr.doctorwho.quetes.event.saison.one;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.doctorwho.Main;
import fr.doctorwho.quetes.Quete;


public class Quete1 extends Quete {

	public Quete1(Player p) {
		super(p);
		
	}

	@Override
	public void execute(Integer ex) {
		if(getPart() == 0 && ex == 0){
			setPart(-1);
			getPlayer().teleport(new Location(Bukkit.getServer().getWorlds().get(0), 9, 21 , 2));
			getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 2));
			new BukkitRunnable() {
				int i =-1;
				@Override
				public void run() {
					i++;
					if(i == 1)getPlayer().sendMessage("§7*sonnerie du réveil 7h30*");
					if(i == 2)getPlayer().sendMessage("§7*Allez! il faut se lever !*");	
					if(i == 3){
					    for (PotionEffect effect : getPlayer().getActivePotionEffects ()){
					        getPlayer().removePotionEffect(effect.getType ());
					        setPart(1);
					    }
					}
					if(i == 4){
						getPlayer().sendMessage("§7*Diriger vous vers le salon*");
						cancel();
					}
						
				}
			}.runTaskTimer(Main.getInstance(), 0, 15);
		}
		else if(getPart() == 1){
			getPlayer().sendMessage("§dRose : Salut !");	
			setPart(-1);
			new BukkitRunnable() {				
				@Override
				public void run() {
					getPlayer().sendMessage("§5Mère de Rose : à toute à l'heure.");
					setPart(2);
					cancel();
				}
			}.runTaskLater(Main.getInstance(), 20);
		}else if(getPart() == 2){
			getPlayer().sendMessage("§7Diriger vous vers le Bus");
			setPart(3);
		}else if(getPart() == 3){
			getPlayer().sendMessage("§7Attaché votre ceinture, on decolle!");
			setPart(4);
		}
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocIndicator() {
		// TODO Auto-generated method stub
		return null;
	}



}
