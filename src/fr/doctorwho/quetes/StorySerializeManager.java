package fr.doctorwho.quetes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.sekori.chouettopia.historyinusesystem.History;

public class StorySerializeManager {

	private Gson gson;

	public StorySerializeManager() {

		//Genration de la config gson
		this.gson = new GsonBuilder()
							.setPrettyPrinting()
							
							.serializeNulls()
							.disableHtmlEscaping()
							.create();
	
	}
	
	//Convertire une class en Json
	public String serialize(Story s){
		return this.gson.toJson(s);
	}

	//Convertir un json de nouveau en class (Le Json doit avoir été serialize avec la meme class
	public Story deserialize(String json){
		return this.gson.fromJson(json, Story.class);
	}
}
