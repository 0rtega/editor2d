package editor2d.storages;


import java.util.HashMap;
import java.util.Map;

import editor2d.graphics.text.AtlasTexture;

public  class StorageFonts {
	
	private static StorageFonts fontsInstance = new StorageFonts();
	private int numberOfOccupiedTextures = 0;
	public  static StorageFonts getInstance(){
		return fontsInstance;
	}
	
	private Map<String, AtlasTexture> atlases;
	private StorageFonts(){
		atlases = new HashMap<>();
	}	
	
	public  AtlasTexture getAtlas(String name, int style){
		AtlasTexture atlas = null;
		atlas = atlases.get(name + style);
		
		if(atlas == null){
			
			atlas = new AtlasTexture(name, style);
			atlases.put(name + style,  atlas);
		}	
		return atlas;
	}
	
	public  int getNumberOfOccupiedTextures(){
		return numberOfOccupiedTextures;
	}
	
	public  void incrementNumberOfOccupiedTextures(){
		numberOfOccupiedTextures++;
	}
	
	public  void cleanUp(){
		for(AtlasTexture atl : atlases.values()){
			atl.cleanUp();
		}
		numberOfOccupiedTextures = 0;
		atlases.clear();
	}

}