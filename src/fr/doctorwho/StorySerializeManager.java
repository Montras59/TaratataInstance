package fr.doctorwho.quetes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class StorySerializeManager {

	private Gson gson;

	public StorySerializeManager() {

		this.gson = new GsonBuilder()
							.setPrettyPrinting()
							
							.serializeNulls()
							.disableHtmlEscaping()
							.create();
	
	}
	
	public String serialize(Story s){
		return this.gson.toJson(s);
	}

	
	public Story deserialize(String json){
		return this.gson.fromJson(json, Story.class);
	}
}
