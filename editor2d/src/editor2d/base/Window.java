package editor2d.base;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.GL_FRAMEBUFFER;
import static org.lwjgl.opengl.GL30.glBindFramebuffer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joml.Matrix4f;

import editor2d.Editor2DController;
import editor2d.LWJGLPolyline;
import editor2d.Utils.Antialiasing;
import editor2d.Utils.FactoryEditParts;
import editor2d.Utils.Point;
import editor2d.base.Animation.PropertieAnimation;
import editor2d.control.ArcBallCamera3D;
import editor2d.control.Mouse;
import editor2d.control.ProjectMatrix2D;
import editor2d.editparts.IEditPart;
import editor2d.graphics.Grid;
import editor2d.storages.StorageColors;
import editor2d.storages.StorageData;
import editor2d.storages.StorageEditParts;
import editor2d.storages.StorageFonts;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageUniformBuffers;
import modelData.Node;

public class Window {

	private Animation animation;
	private int width, height;
	private ProjectMatrix2D projectMatrix;
	private ArcBallCamera3D camera;
	private Mouse mouse;
	private Antialiasing antialiasing;
	private Editor2DController editor2dController;
	private Grid grid;
	private Map<PropertieAnimation, Boolean> properties = new HashMap<Animation.PropertieAnimation, Boolean>();
	{
		properties.put(PropertieAnimation.ANTIALIASING, true);
		properties.put(PropertieAnimation.GRID, true);
	}
	public Window(Animation animation) {
		this.animation = animation;
		projectMatrix = new ProjectMatrix2D(width, height);
		camera = new ArcBallCamera3D();
		antialiasing = new Antialiasing();
		grid = new Grid(this);
		mouse = new Mouse(this);
		editor2dController = new Editor2DController();
	}
	
	public void updateSize(int width, int height) {
		this.width = width;
		this.height = height;
		projectMatrix.update(width, height);
		if(properties.get(PropertieAnimation.ANTIALIASING))antialiasing.update(width, height);
		if(properties.get(PropertieAnimation.GRID))grid.update(width, height);
	}
	
	public void init() {	
		camera.setViewFromAbove();
		mouse.init();
		StorageShaders.getInstance().init();
		if(properties.get(PropertieAnimation.ANTIALIASING)) {		
			antialiasing.init();
		}		
		if(properties.get(PropertieAnimation.GRID)) {		
			grid.init();
		}	
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
		
		
		editor2dController.init();
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
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glViewport(0, 0, width, height);
		glClearColor(1, 1, 1, 1.0f);
		
		
		StorageUniformBuffers.getInstance().fillUniformBuffer(
				getProjectMatrix().getProjMatrix(),
				camera.viewMatrix(), 
				camera.getCurrentPosition());
		if(properties.get(PropertieAnimation.ANTIALIASING)) {
			glBindFramebuffer(GL_FRAMEBUFFER, antialiasing.framebuffer);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glEnable(GL_DEPTH_TEST);
		}
		
		if(properties.get(PropertieAnimation.GRID))grid.render();
		//render figures
		pol.draw();
		
	
		
		
		if(properties.get(PropertieAnimation.ANTIALIASING))antialiasing.render();
	}
	
	public void cleanUp() {
		StorageShaders.getInstance().cleanUp();
		StorageColors.getInstance().cleanUp();
		StorageFonts.getInstance().cleanUp();
		StorageUniformBuffers.getInstance().cleanUp();
		
		if(properties.get(PropertieAnimation.ANTIALIASING))antialiasing.cleanUp();
		if(properties.get(PropertieAnimation.GRID))grid.cleanUp();
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

	public Map<PropertieAnimation, Boolean> getProperties() {
		return properties;
	}

	public Grid getGrid() {
		return grid;
	}

	
	
	
	
	
}
