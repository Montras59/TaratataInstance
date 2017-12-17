package fr.doctorwho.animation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class StartTardisAnimation extends Animation{

	private Location tardis;
	
	public StartTardisAnimation(Player player,Location tardis) {
		super("Start Tardis",player,false);
		this.tardis = tardis;
	}

	@Override
	public void animation() {
		// Tardis Dématerialize in 25 ticks
		int timeTardis = 0;
		for(int x = 0; x < 8; x++){
			addTimeAnimation(timeTardis, spawnTardis(1));
			addTimeAnimation(timeTardis + 15, spawnTardis(0));
			timeTardis += 30;
		}
		// Spawn Player in 5 ticks
		addTimeAnimation(5, spawnPlayer());
		addTimeAnimation(timeTardis, stop());
	}

	public IEAnimation spawnTardis(final int spawn){
		return new IEAnimation() {
			
			@Override
			public void runAnimation() {
				Block block = tardis.getBlock();
				if(spawn == 0)	block.setType(Material.AIR);
				else block.setType(Material.JACK_O_LANTERN);
			}
		};
	}
	
	public IEAnimation spawnPlayer(){
		return new IEAnimation() {
			
			@Override
			public void runAnimation() {
				getPlayer().teleport(new Location(tardis.getWorld(), tardis.getX(),tardis.getY(), tardis.getZ() - 4));
			}
		};
	}
}
