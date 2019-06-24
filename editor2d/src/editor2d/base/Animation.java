package editor2d.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Composite;
import org.lwjgl.opengl.GL;

import editor2d.graphics.Grid.SizeCellGrid;


public class Animation extends Composite {

	private double MAX_VALUE_FPS = 50;
	private double TIME_BETWEEN_FRAME = 1000 / (MAX_VALUE_FPS + 2);
	private GLCanvas canvas;
	private Window window;

	public Animation(Composite parent) {
		super(parent, SWT.NONE);
		
		GLData data = new GLData();
		data.doubleBuffer = true;
		canvas = new GLCanvas(this, SWT.NO_BACKGROUND, data);
		canvas.setCurrent();
		GL.createCapabilities();
		
		window = new Window(this);
		window.init();
		
		this.addListener(SWT.Resize, event -> {
			Rectangle bounds = this.getBounds();
			int width = bounds.width;
			int height = bounds.height;
			canvas.setSize(width, height);
			canvas.setLocation(0, 0);
			window.updateSize(width, height);
			render();
		});
		
		this.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				cleanUp();
			}
		});		
	}
	
	private long lastTime = System.currentTimeMillis();
	private boolean canRender() {
		long currentTime = System.currentTimeMillis();
		long delta = currentTime - lastTime;
		if(delta > TIME_BETWEEN_FRAME) {
			lastTime = currentTime;
			return true;
		}
		return false;
	}
	
	public void render() {
		if(!canRender())return;
		if (!canvas.isDisposed()) {
			getDisplay().asyncExec(new Runnable() {
				public void run() {				
					if (!canvas.isDisposed()) {
						canvas.setCurrent();
						window.update();
						window.render();						
						canvas.swapBuffers();
						getParent().getDisplay().readAndDispatch();
					}
				}
			});
		}
	}
	
	public void cleanUp() {
		window.cleanUp();
	}

	public GLCanvas getCanvas() {
		return canvas;
	}
	
	public void enable(PropertieAnimation propertie) {
		window.getProperties().put(propertie, true);
	}
	
	public void disable(PropertieAnimation propertie) {
		window.getProperties().put(propertie, false);
	}
	
	public void setSizeCellGrid(SizeCellGrid size) {
		window.getGrid().setSizeCell(size);
	}
	
	public enum PropertieAnimation {
		ANTIALIASING, GRID, 
	}
	
}
