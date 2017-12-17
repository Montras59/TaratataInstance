package fr.doctorwho.animation;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import fr.doctorwho.Main;

public abstract class Animation implements Runnable{

	private Map<Integer, IEAnimation> timeAnimation;
	private String name;
	private BukkitTask task;
	private Player player;
	private int time;
	private boolean move;
	
	private static Map<Player, Animation> animationPlayers = new HashMap<>();
	
	public Animation(String name,Player player,boolean move) {
		this.name = name;
		this.player = player;
		this.timeAnimation = new HashMap<>();
		this.time = 0;
		this.move = move;
		
		animation();
		
		this.task = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this, 0, 1);
		
		animationPlayers.put(player, this);
	}

	@Override
	public void run() {
		if(timeAnimation.containsKey(time)){
			timeAnimation.get(time).runAnimation();
		}
		time++;
	}
	
	public abstract void animation();
	
	public IEAnimation stop(){
		return new IEAnimation() {
			
			@Override
			public void runAnimation() {
				task.cancel();
			}
		};
	}
	
	public void addTimeAnimation(Integer key,IEAnimation value){
		if(timeAnimation.get(key) != null) throw new IllegalArgumentException("TimeAnimation Integer is not Null");
		timeAnimation.put(key, value);
	}
	
	public Map<Integer, IEAnimation> getTimeAnimation() {
		return timeAnimation;
	}

	public void setTimeAnimation(Map<Integer, IEAnimation> timeAnimation) {
		this.timeAnimation = timeAnimation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BukkitTask getTask() {
		return task;
	}

	public void setTask(BukkitTask task) {
		this.task = task;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public interface IEAnimation{
		public void runAnimation();
	}
}
