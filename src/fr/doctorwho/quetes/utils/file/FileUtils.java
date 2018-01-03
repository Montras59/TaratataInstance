package fr.doctorwho.quetes.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	//Generation d'un fichier
	public static void createFile(File file) throws IOException{
		if(!file.exists()){
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
	}
	
	//Sauvegarde d'un fichier avec pour contenu "text"
	public static void save(File file, String text){
		final FileWriter fw;
		
		try {
			createFile(file);
			
			fw = new FileWriter(file);
			fw.write(text);
			fw.flush();
			fw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Recuper� le contenu d'un fichier
	public static String loadContant(File file) {
		
		if(file.exists()){
			
			try {
				final BufferedReader reader = new BufferedReader(new FileReader(file));
				final StringBuilder text = new StringBuilder();
				
				String line;
				
				while((line = reader.readLine()) != null){
					text.append(line);
				}
				
				reader.close();
			return text.toString();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return "";
		
		
		
	}
	
	
}
