package editor2d.base;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.GL_FRAMEBUFFER;
import static org.lwjgl.opengl.GL30.glBindFramebuffer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.joml.Matrix4f;

import editor2d.LWJGLPolyline;
import editor2d.Utils.Antialiasing;
import editor2d.Utils.Point;
import editor2d.control.ArcBallCamera3D;
import editor2d.control.Mouse;
import editor2d.control.ProjectMatrix2D;
import editor2d.graphics.Grid;
import editor2d.storages.StorageColors;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageUniformBuffers;

public class Window {

	private Animation animation;
	private int width, height;
	private ProjectMatrix2D projectMatrix;
	private Matrix4f PVMatrix = new Matrix4f();
	private ArcBallCamera3D camera;
	private Mouse mouse;
	private Antialiasing antialiasing;
	private Grid grid;
	
	public Window(Animation animation) {
		this.animation = animation;
	}
	
	public void updateSize(int width, int height) {
		this.width = width;
		this.height = height;
		projectMatrix.update(width, height);
		antialiasing.update(width, height);
		grid.update(width, height);
	}
	
	public void init() {
		projectMatrix = new ProjectMatrix2D(width, height);
		camera = new ArcBallCamera3D();
		camera.setViewFromAbove();
		mouse = new Mouse(this);
		mouse.init();
		StorageShaders.getInstance().init();
		antialiasing = new Antialiasing();
		antialiasing.init();
		grid = new Grid(this);
		StorageUniformBuffers.getInstance().init();
		StorageColors.getInstance().init();
		
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glEnable(GL_DEPTH);
		glEnable(GL_DEPTH_TEST);
		glDepthFunc(GL_LEQUAL);
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(0,1,0));
		points.add(new Point(4,1,0));
		points.add(new Point(4,5,0));
		points.add(new Point(10,8,0));
		
		pol = new LWJGLPolyline(points, Color.BLUE, 1, 0);
	}
	LWJGLPolyline pol ;
	
	public void update() {
		camera.update(1);
	}
	
	public void render() {
		glViewport(0, 0, width, height);
		glClearColor(1, 1, 1, 1.0f);
		

		PVMatrix.set(getProjectMatrix().getProjMatrix()).mul(camera.viewMatrix());
		StorageUniformBuffers.getInstance().fillUniformBuffer(PVMatrix, camera.viewMatrix(), camera.getCurrentPosition());
		
		glBindFramebuffer(GL_FRAMEBUFFER, antialiasing.framebuffer);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glEnable(GL_DEPTH_TEST);
		
		grid.render();
		//render figures
		pol.draw();
		
	
		
		
		antialiasing.render();
	}
	
	public void cleanUp() {
		StorageShaders.getInstance().cleanUp();
		antialiasing.cleanUp();
		grid.cleanUp();
		pol.cleanUp();
	}
	
	public Animation getAnimation() {
		return animation;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ProjectMatrix2D getProjectMatrix() {
		return projectMatrix;
	}

	public ArcBallCamera3D getCamera() {
		return camera;
	}

	public Matrix4f getPVMatrix() {
		return PVMatrix;
	}
	
	
	
	
}
