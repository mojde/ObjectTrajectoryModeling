package com.intactile.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class IntConfig {

	public static Properties props;
	
	public static String DIRECTORY ="/Users/soltanmohammadi/Documents/workspace/ObjectTrajectoryModeling/data";
	public static String ONTOLOGY_FILE = "/Users/soltanmohammadi/Documents/workspace/ObjectTrajectoryModeling/myST_Ontology.owl";
	

	static {
		props = new Properties();
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream("resources/config.properties");
			props.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void listProperties(){
		for(Entry<Object , Object > entry : props.entrySet()){
			System.out.println(entry.getKey() + " "+ entry.getValue());
		}
	}
	
}
