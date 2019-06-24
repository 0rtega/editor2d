package editor2d.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import editor2d.Utils.Util;
import editor2d.base.Window;
import editor2d.control.ArcBallCamera3D;
import editor2d.meshs.Mesh;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageShaders.Figures;

public class Grid {

	private static final int restartIndex = 0xFFFFFFFF;
	private float stepForGridCell[] = { 1, 1.2f, 1.44f, 1.7279f, 2.0734f, 2.4883f, 2.9858f, 3.5833f, 4.2994f, 5.1597f,
			6.1912f, 7.4294f, 8.9155f, 10.6984f, 12.8382f, 15.4058f, 18.4866f, 22.1840f, 26.6210f, 31.9450f, 38.3341f };
	
	private ArcBallCamera3D camera;
	private Vector3f centerGrid = new Vector3f();
	private Window window;
	private Map<Integer, Mesh> meshs = new HashMap<Integer, Mesh>();
	private Shader shader;
	private double width,  height;
	private boolean init = false;
	

	public Grid(Window window) {
		this.camera = window.getCamera();
		this.window = window;
		shader = StorageShaders.getInstance().getShader(Figures.LINE);
	}

	private void createGrid(float step, int zoom, int halfWidthGrid) {
		List<Float> ver = new ArrayList<Float>();
		List<Integer> ind = new ArrayList<Integer>();
		int j = 0;
		for (float i = -halfWidthGrid; i < halfWidthGrid; i = i + step) {
			ver.add(i);
			ver.add(-halfWidthGrid + 1f);
			ver.add(0f);

			ver.add(i);
			ver.add(halfWidthGrid - 1f);
			ver.add(0f);

			ind.add(j);
			j++;
			ind.add(j);
			j++;
			ind.add(restartIndex);
		}

		for (float i = -halfWidthGrid; i < halfWidthGrid; i = i + step) {
			ver.add(-halfWidthGrid + 1f);
			ver.add(i);
			ver.add(0f);

			ver.add(halfWidthGrid - 1f);
			ver.add(i);
			ver.add(0f);

			ind.add(j);
			j++;
			ind.add(j);
			j++;
			ind.add(restartIndex);
		}

		FloatBuffer vertex = BufferUtils.createFloatBuffer(ver.size());
		vertex.put(Util.listFloatToArray(ver));
		vertex.flip();

		IntBuffer index = BufferUtils.createIntBuffer(ind.size());
		index.put(Util.listIntToArray(ind));
		index.flip();

		Mesh mesh = new Mesh(vertex, index, halfWidthGrid * 2 * 2 * 3 * 2, GL_LINES);
		meshs.put(zoom, mesh);
	}

	private double sizeInPixelOneCell = 2f / (0.092829 * 2f);

	public void update(double width, double height) {
		this.width =  width;
		this.height = height;
		init = false;
	}
	
	private void buildMesh() {
		init = true;
		cleanUp();
		int countLinesInWidth = (int) (width / sizeInPixelOneCell);
		int countLinesInHeight = (int) (height / sizeInPixelOneCell);
		int maxLines = Math.max(countLinesInWidth, countLinesInHeight);
		int zoom = ArcBallCamera3D.MAX_VALUE_ZOOM;
		for (int i = 0; i <= Math.abs(ArcBallCamera3D.MIN_VALUE_ZOOM - ArcBallCamera3D.MAX_VALUE_ZOOM); i++) {
			createGrid(stepForGridCell[i] / 2f, zoom, (((int) ((stepForGridCell[i] / 2f) + 5) * maxLines) / 2));
			zoom--;
		}
	}

	private Mesh getMesh() {
		int zoom = camera.getCountPress();
		return meshs.get(zoom);
	}

	public void render() {
		if(!init) {
			buildMesh();
		}
		centerGrid.set(camera.getCurrentPosition());
		centerGrid.z = 0;
		glLineWidth(1);
		shader.bind();
		shader.setUniform1i("color", 3);
		shader.setUniform3f("currentPosition", centerGrid);
		getMesh().render();
		shader.unbind();
	}

	public void cleanUp() {
		for (Mesh m : meshs.values()) {
			m.cleanUp();
		}
		meshs.clear();
	}

}
