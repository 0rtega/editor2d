package editor2d.figures;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL31.*;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import editor2d.Utils.Util;
import editor2d.graphics.Shader;
import editor2d.meshs.Mesh;
import editor2d.storages.StorageDataForFigures;
import editor2d.storages.StorageDataForFigures.TypeFigure;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageShaders.TypeShader;

public class Circle implements IFigure{

	private Vector3d position = new Vector3d();
	private double radius = 3;
	private Color color;
	private boolean select = false;
	private boolean hover = false;
	private boolean init = false;
	private Shader shader;
	private Mesh mesh;
	
	
	public Circle(double x, double y, double z) {
		position.set(x, y, z);
		shader = StorageShaders.getInstance().getShader(TypeShader.CIRCLE);
	}
	
	@Override
	public void buildMesh() {
		cleanUp();
		init = true;
		mesh = new Mesh(StorageDataForFigures.getInstance().getData(TypeFigure.CIRCLE), GL_TRIANGLES);		
	}

	@Override
	public void cleanUp() {
		if(mesh != null) {
			mesh.cleanUp();
		}
	}

	@Override
	public void render() {
		if(!init) {
			buildMesh();
		}
		shader.bind();
		shader.setUniform3d("currentPosition", position);
		mesh.render();
		shader.unbind();
	}
	
	
	

}
