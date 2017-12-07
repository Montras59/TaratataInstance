package fr.doctorwho.quetes;

import java.io.File;
import java.util.UUID;

import fr.doctorwho.Main;
import fr.doctorwho.quetes.utils.file.FileUtils;

public class Story {

	private UUID uuid;
	private Saison saison;
	private Integer quete;
	
	public Story(UUID uuid) {
		setUuid(uuid);
		setSaison(Saison.one);
		setQuete(1);
	}

	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Saison getSaison() {
		return saison;
	}
	public void setSaison(Saison chapter) {
		this.saison = chapter;
	}
	public Integer getQuete() {
		return quete;
	}
	public void setQuete(Integer quete) {
		this.quete = quete;
	}

	public static Story getStory(UUID uuid){
		final File file = new File(new File(Main.getInstance().getDataFolder(), "/story/"), uuid + ".json");
		
		if(file.exists()){
			final StorySerializeManager hsm = new StorySerializeManager();	
			final String json = FileUtils.loadContant(file);
			final Story recipelist = hsm.deserialize(json);	
			return recipelist;
		}else{
			Story r = new Story(uuid);
			return r; 
		}
	}
	
	public Story save(){

		final File file = new File(new File(Main.getInstance().getDataFolder(), "/story/"), getUuid().toString() + ".json");
		final StorySerializeManager rsm = new StorySerializeManager();
		final String json = rsm.serialize(this);
		
		FileUtils.save(file, json);
		return this;
	}
}
