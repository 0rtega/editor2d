package editor2d.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.BufferUtils;


public class LoaderResources {

	private static LoaderResources instance = new LoaderResources();

	private LoaderResources() {
	}

	public static LoaderResources getnstance() {
		return instance;
	}

	public String loadShader(String fileName) {
		String result = "";

		InputStream io = LoaderResources.class.getResourceAsStream(fileName);
		if(io == null) {
			throw new NullPointerException("error");
		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(io))) {
			while (reader.ready()) {
				String str = reader.readLine();
				result += "\n" + str;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public DataObj loadOBJ(String fileName) throws Exception {
		List<String> listString = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		while (reader.ready()) {
			listString.add(reader.readLine());
		}

		reader.close();

		List<Float> preVertex = new ArrayList<>();
		List<Float> preNormal = new ArrayList<>();
		List<Integer> preIndex = new ArrayList<>();
		String[] arr;
		for (String str : listString) {
			arr = str.split(" ");
			if (arr[0].equals("v")) {
				preVertex.add(Float.parseFloat(arr[1]));
				preVertex.add(Float.parseFloat(arr[2]));
				preVertex.add(Float.parseFloat(arr[3]));
			} else if (arr[0].equals("f")) {
				preIndex.add(Integer.parseInt(arr[1].split("//")[0]) - 1);
				preIndex.add(Integer.parseInt(arr[2].split("//")[0]) - 1);
				preIndex.add(Integer.parseInt(arr[3].split("//")[0]) - 1);
			} else if (arr[0].equals("vn")) {
				preNormal.add(Float.parseFloat(arr[1]));
				preNormal.add(Float.parseFloat(arr[2]));
				preNormal.add(Float.parseFloat(arr[3]));
			}
		}
		FloatBuffer vertex;
		FloatBuffer normal;
		IntBuffer index;
		vertex = BufferUtils.createFloatBuffer(preVertex.size());
		for (float f : preVertex) {
			vertex.put(f);
		}
		vertex.flip();

		index = BufferUtils.createIntBuffer(preIndex.size());
		for (int i : preIndex) {
			index.put(i);
		}
		index.flip();

		normal = BufferUtils.createFloatBuffer(preNormal.size());
		for (float f : preNormal) {
			normal.put(f);
		}
		normal.flip();

		DataObj dataObj = new DataObj(vertex, normal, index);
		return dataObj;
	}

	public class DataObj {
		private FloatBuffer vertex;
		private FloatBuffer normal;
		private IntBuffer index;

		DataObj(FloatBuffer vertex, FloatBuffer normal, IntBuffer index) {
			this.vertex = vertex;
			this.normal = normal;
			this.index = index;
		}

		FloatBuffer getVertex() {
			return vertex;
		}

		FloatBuffer getNormal() {
			return normal;
		}

		IntBuffer getIndex() {
			return index;
		}
	}

}