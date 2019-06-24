package editor2d.storages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class StorageColors {

	 static NnspgColor red;
	 static NnspgColor green;
	 static NnspgColor cyan;
	 static NnspgColor grey;
	 static NnspgColor black;
	
	 static NnspgColor blue;
	 static NnspgColor redTransparent;
	 static NnspgColor yellow;
	 static NnspgColor orange;	
	 static NnspgColor white;
	
	 static NnspgColor lightGreyForSegment;
	 static NnspgColor lightGreyForNode;
	 static NnspgColor veryLightGreyForSegment;
	 static NnspgColor veryLightGreyForNode;
	
	
	private static StorageColors instance = new StorageColors();
	public static StorageColors getInstance() {
		return instance;
	}

	private StorageUniformBuffers uniformBuffer;
	
	private StorageColors(){
		red = new NnspgColor(1, 0, 0, 1);
		 green = new NnspgColor(0, 1, 0, 1);
		 cyan = new NnspgColor(0, 1, 1, 1);
		grey = new NnspgColor(0.5f, 0.5f, 0.5f, 1);
		
		 blue =new NnspgColor(0, 0, 1, 1);
		 redTransparent = new NnspgColor(1, 0, 0, 0.5f);
		yellow = new NnspgColor(1f, 1f, 0f, 1);
		orange = new NnspgColor(1f, 165f/255f, 0, 1);
		
		lightGreyForSegment = new NnspgColor(132f/255f, 132f/255f, 132f/255f, 1);
		veryLightGreyForSegment = new NnspgColor(245f/255f, 245f/255f, 245f/255f, 1);
		lightGreyForNode = new NnspgColor(102f/255f, 102f/255f, 102f/255f, 1);
		veryLightGreyForNode = new NnspgColor(225f/255f, 225f/255f, 225f/255f, 1);
		
		black = new NnspgColor(0, 0, 0, 1);
		white = new NnspgColor(1, 1, 1, 1);
	}

	private List<NnspgColor> colors = new ArrayList<>();
	
	public void init(){
		uniformBuffer = StorageUniformBuffers.getInstance();
		colors.clear();
		addColor(red);
		addColor(green);	
		addColor(cyan);
		addColor(grey);
		addColor(blue);
		addColor(new NnspgColor(0, 0, 0, 0));
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
	
	public void addColor(NnspgColor color){
		if(!colors.contains(color)){
			colors.add(color);
			uniformBuffer.addColorInGPU(color);
		}
	}
	
	public void updateColor(NnspgColor myColor, Color c){
		myColor.setColor(c.getRed()/255f, c.getGreen()/255f,c.getBlue()/255f,c.getAlpha()/255f);
		uniformBuffer.updateColorInGPU(myColor, colors.indexOf(myColor));
	}
	
	public NnspgColor getColor(int index){
		return colors.get(index);
	}
	
	public boolean containsColor(NnspgColor color){
		return colors.contains(color);
	}
	
	
	public int getIndexMyColor(NnspgColor myColor){
		return colors.indexOf(myColor);
	}
	
	public void cleanUp(){
		colors.clear();
	}
	
	
	public List<NnspgColor> getColors() {
		return colors;
	}




public 	 class NnspgColor{
		private float red,green,blue,alpha;
	
		public NnspgColor(float red, float green, float blue, float alpha){
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.alpha = alpha;
		}
		
		public void setColor(float red, float green, float blue, float alpha){
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.alpha = alpha;
		}
		
		public float getRed() {
			return red;
		}

		public float getGreen() {
			return green;
		}

		public float getBlue() {
			return blue;
		}

		public float getAlpha() {
			return alpha;
		}

		
		public float [] getAsBuffer(){
			float [] f = {red, green, blue, alpha};
			return f;
		}
		
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(alpha);
			result = prime * result + Float.floatToIntBits(blue);
			result = prime * result + Float.floatToIntBits(green);
			result = prime * result + Float.floatToIntBits(red);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NnspgColor other = (NnspgColor) obj;
			if (Float.floatToIntBits(alpha) != Float.floatToIntBits(other.alpha))
				return false;
			if (Float.floatToIntBits(blue) != Float.floatToIntBits(other.blue))
				return false;
			if (Float.floatToIntBits(green) != Float.floatToIntBits(other.green))
				return false;
			if (Float.floatToIntBits(red) != Float.floatToIntBits(other.red))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "red = " + red + " " + "green = " + green + " blue = " + blue + " alpha = " + alpha;
		}

	}
	
	
}
