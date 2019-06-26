package editor2d.storages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class StorageColors {

	 static Color red;
	 static Color green;
	 static Color cyan;
	 static Color grey;
	 static Color black;
	
	 static Color blue;
	 static Color redTransparent;
	 static Color yellow;
	 static Color orange;	
	 static Color white;
	
	 static Color lightGreyForSegment;
	 static Color lightGreyForNode;
	 static Color veryLightGreyForSegment;
	 static Color veryLightGreyForNode;
	
	
	private static StorageColors instance = new StorageColors();
	public static StorageColors getInstance() {
		return instance;
	}

	private StorageUniformBuffers uniformBuffer;
	
	private StorageColors(){
		red = new Color(1, 0, 0, 1);
		 green = new Color(0, 1, 0, 1);
		 cyan = new Color(0, 1, 1, 1);
		grey = Color.GRAY;
		 blue =new Color(0, 0, 1, 1);
		 redTransparent = new Color(1, 0, 0, 0.5f);
		yellow = new Color(1f, 1f, 0f, 1);
		orange = new Color(1f, 165f/255f, 0, 1);
		
		lightGreyForSegment = new Color(132f/255f, 132f/255f, 132f/255f, 1);
		veryLightGreyForSegment = new Color(245f/255f, 245f/255f, 245f/255f, 1);
		lightGreyForNode = new Color(102f/255f, 102f/255f, 102f/255f, 1);
		veryLightGreyForNode = new Color(225f/255f, 225f/255f, 225f/255f, 1);
		
		black = new Color(0, 0, 0, 1);
		white = new Color(1, 1, 1, 1);
	}

	private List<Color> colors = new ArrayList<>();
	
	public void init(){
		uniformBuffer = StorageUniformBuffers.getInstance();
		colors.clear();
		addColor(red);
		addColor(green);	
		addColor(cyan);
		addColor(grey);
		addColor(blue);
		addColor(new Color(0, 0, 0, 0));
		addColor(redTransparent);
		addColor(yellow);
		addColor(lightGreyForSegment);
		addColor(veryLightGreyForSegment);
		addColor(lightGreyForNode);
		addColor(veryLightGreyForNode);
		addColor(orange);
		addColor(black);
		addColor(white);
	}
	
	public void addColor(Color color){
		if(!colors.contains(color)){
			colors.add(color);
			uniformBuffer.addColorInGPU(color);
		}
	}
	
	public Color getColor(int index){
		return colors.get(index);
	}
	
	public boolean containsColor(Color color){
		return colors.contains(color);
	}	
	
	public int getIndexMyColor(Color myColor){
		return colors.indexOf(myColor);
	}
	
	public void cleanUp(){
		colors.clear();
	}	
	
	public List<Color> getColors() {
		return colors;
	}
	
}
