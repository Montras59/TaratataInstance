package fr.doctorwho.quetes.saison1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.doctorwho.armorstand.AffaireRoseArmorStand;
import fr.doctorwho.items.AffaireRoseItem;
import fr.doctorwho.quetes.Quete;

public class Quete1 extends Quete{

	private int i = 0;
	
	public Quete1(Player player,String episodeName) {
		super(player,episodeName, "L'inconnue", "description au pif");
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
			new AffaireRoseArmorStand().create();
			getPlayer().teleport(new Location(Bukkit.getServer().getWorlds().get(0), 9, 21 , 2));
			getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 2));
			getPlayer().sendMessage("§7*sonnerie du réveil 7h30*");
		}
		else if(i == 15)getPlayer().sendMessage("§7*Allez! il faut se lever !*");
		else if(i == 30){
		    for (PotionEffect effect : getPlayer().getActivePotionEffects ()){
		        getPlayer().removePotionEffect(effect.getType ());
		    }
		}
		else if(i == 45){
			getPlayer().sendMessage("§7*Vous devez prendre vos affaires et dirigez vous dans le salon*");
		}
		else if(i > 45){
			if(getPlayer().getInventory().getChestplate() == null) return;
			if(getPlayer().getLocation().getBlock().getType() != Material.CARPET && getPlayer().getInventory().getChestplate() != new AffaireRoseItem().build()) return;
			setPart(2);
			i = 0;
		}
	}
	
	public void partTwo(){
		i++;
		if(i == 1) getPlayer().sendMessage("§dRose : Salut !");
		else if(i == 15) getPlayer().sendMessage("§5Mère de Rose : À toute à l’heure.");
		else if(i == 30) getPlayer().sendMessage("§7*Dirigez-vous vers le bus*");
		else{
			if(getPlayer().getLocation().add(0, -1, 0).getBlock().getType() != getMaterialWithMetadata(Material.STEP, 7)) return;
			setPart(3);
			i = 0;
		}
	}
	
	public void partThree(){
		getPlayer().sendMessage("§7*Attachez votre ceinture! On décole!*");
		setPart(4);
	}
	
	public Material getMaterialWithMetadata(Material material,int metadata){
		ItemStack stack = new ItemStack(material,1,(short) metadata);
		return stack.getType();
	}
}
