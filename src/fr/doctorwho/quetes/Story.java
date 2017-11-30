package fr.doctorwho.quetes;

import java.io.File;
import java.util.UUID;

import fr.doctorwho.Main;
import fr.sekori.chouettopia.api.Chouettopia;
import fr.sekori.chouettopia.api.FileUtils;
import fr.sekori.chouettopia.history.Story;
import fr.sekori.chouettopia.history.StorySerializeManager;

public class Story {

	private UUID uuid;
	private Chapter chapter;
	private Integer quete;
	
	public Story getStory(){
		final File file = new File(new File(Main.getInstance().getDataFolder(), "/story/"), getUuid().toString() + ".json");
		
		if(file.exists()){
			final StorySerializeManager hsm = new StorySerializeManager();	
			final String json = FileUtils.loadContant(file);
			final Story recipelist = hsm.deserialize(json);	
			return recipelist;
		}else{
			Story r = new Story(getUuid());
			return r; 
		}
	}
	//Utiliser la methode getStory, ne pas utiliser ce constructeur séparement
	public Story(UUID uuid) {
		setUuid(uuid);
		setChapter(Chapter.one);
		setQuete(0);
	}

	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public Integer getQuete() {
		return quete;
	}
	public void setQuete(Integer quete) {
		this.quete = quete;
	}
	//Effectuer une sauvegarde de la "story" du joueur
	public Story save(){

		final File file = new File(new File(Main.getInstance().getDataFolder(), "/story/"), this.uuid.toString() + ".json");
		final StorySerializeManager rsm = new StorySerializeManager();
		final String json = rsm.serialize(this);
		
		FileUtils.save(file, json);
		return this;
	}
}
