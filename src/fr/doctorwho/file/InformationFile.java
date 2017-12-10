package fr.doctorwho.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;

public class InformationFile {

	private List<String> informationString;
	
	public InformationFile() {
		this.informationString = getInformation();
	}
	
	@SuppressWarnings("deprecation")
	public List<String> getInformation(){
		List<String> information = new ArrayList<>();
		
		try {
			for(String lines : FileUtils.readLines(new File("/home/safety_data/information.txt"))){
				information.add(lines);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return information;
	}
	
	public void sendInformationMessage(Player player){
		for(String string : informationString){
			player.sendMessage(string);
		}
	}
}
