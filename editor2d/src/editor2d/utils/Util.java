package editor2d.Utils;

import java.util.List;

import org.joml.Vector4f;

public class Util {

	public static float[] listFloatToArray(List<Float> list) {
		int size = list != null ? list.size() : 0;
		float[] floatArr = new float[size];
		for (int i = 0; i < size; i++) {
			floatArr[i] = list.get(i);
		}
		return floatArr;
	}

	public static int[] listIntToArray(List<Integer> list) {
		int size = list != null ? list.size() : 0;
		int[] floatArr = new int[size];
		for (int i = 0; i < size; i++) {
			floatArr[i] = list.get(i);
		}
		return floatArr;
	}
	
	 public static Vector4f getColotId(int id){
	    	Vector4f colotId = new Vector4f();    
	            colotId.x = (float) ((id & 0x000000FF)/255.0f);
	            colotId.y = (float) ((id & 0x0000FF00) >>  8)/255.0f;
	            colotId.z = (float) ((id & 0x00FF0000) >> 16)/255.0f;
	            colotId.w = 1;
	        return colotId;
	    }
}
