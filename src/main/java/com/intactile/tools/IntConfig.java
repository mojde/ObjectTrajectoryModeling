package com.intactile.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class IntConfig {

  public static Properties props;

  public static String DIRECTORY = null;
  public static String ONTOLOGY_FILE = null;


  static {
    props = new Properties();
    FileInputStream fileInput;
    try {
      fileInput = new FileInputStream("src/main/resources/config.properties");
      props.load(fileInput);
      init();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void listProperties() {
    for (Entry<Object, Object> entry : props.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }


  private static void init() {
    DIRECTORY = props.getProperty("directory");
    ONTOLOGY_FILE = props.getProperty("ontology_file");
  }

}
