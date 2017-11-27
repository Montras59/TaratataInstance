package fr.doctorwho.quetes;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.doctorwho.Main;

public class QuetesFile {
	
	private File quetesFile;
	private FileConfiguration config = new YamlConfiguration();
	
	public void create(){
		if(!Main.getInstance().getDataFolder().exists()){
			Main.getInstance().getDataFolder().mkdir();
		}
		
		quetesFile = new File(Main.getInstance().getDataFolder() +File.separator+ "quetes.yml");
		if(!quetesFile.exists()){
			Main.getInstance().saveResource("quetes.yml", false);
			try {
				config.load(quetesFile);
			} catch (IOException | InvalidConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		save();
	}
	
	public void save(){
		try{
			if(config != null){
				config.save(quetesFile);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public FileConfiguration getConfig(){
		return config;
	}
}
