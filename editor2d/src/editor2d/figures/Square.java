package editor2d.figures;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3d;
import org.lwjgl.BufferUtils;

import editor2d.meshs.ListInstanceMeshs;
import editor2d.storages.StorageColors;

public class Square extends IFigure {
	
	private final static int SIZE_FLOAT_IN_BYTE = 4;
	private final static int COUNT_DIGITS_IN_COLOR = 1;
	private final static int COUNT_DIGITS_IN_RADIUS = 1;
	private final static int COUNT_DIGITS_IN_POSITION = 3;
	private double startX, startY, width, height;
	
	private List<Circle> circles = new ArrayList<Circle>();
	private ListInstanceMeshs circleMesh = new ListInstanceMeshs();
	
	
	public Square(double startX, double startY, double width, double height) {
		this.startX = startX;
		this.startY = startY;
		this.width = width;
		this.height = height;
	}

	public boolean isEmpty() {
		return circles.isEmpty();
	}
	
	public boolean belongToPointOfSquare(Vector3d p) {
		if(p.x >= startX && p.x < startX + width && p.y <= startY && p.y > startY - height) {
			return true;
		}
		return false;
	}
	
	private FloatBuffer positionBuffer = BufferUtils.createFloatBuffer(COUNT_DIGITS_IN_POSITION);
	private IntBuffer colorBuffer = BufferUtils.createIntBuffer(COUNT_DIGITS_IN_COLOR);
	private FloatBuffer radiusBuffer = BufferUtils.createFloatBuffer(COUNT_DIGITS_IN_RADIUS);
	private IntBuffer colorBorderBuffer = BufferUtils.createIntBuffer(COUNT_DIGITS_IN_COLOR);
	private FloatBuffer widthBorderBuffer = BufferUtils.createFloatBuffer(COUNT_DIGITS_IN_RADIUS);
	private IntBuffer hoverBuffer = BufferUtils.createIntBuffer(COUNT_DIGITS_IN_COLOR);
	private IntBuffer colorHoverBuffer = BufferUtils.createIntBuffer(COUNT_DIGITS_IN_COLOR);
	private FloatBuffer widthHoverBuffer = BufferUtils.createFloatBuffer(COUNT_DIGITS_IN_RADIUS);
	
	public void addCicrle(Circle circle) {
		if(circles.contains(circle)) {
			throw new NullPointerException("Почему то добавился дубликат  Circle");
		}
		circles.add(circle);
		fillBufferData(circle);
		circleMesh.addData( positionBuffer, circle.getOffset().offsetPosition, 
							colorBuffer, circle.getOffset().offsetColor, 
							radiusBuffer, circle.getOffset().offsetRadius,
							colorBorderBuffer, circle.getOffset().offsetColorBorder, 
							widthBorderBuffer, circle.getOffset().offsetWidthBorder,
							hoverBuffer, circle.getOffset().offsetHover,
							colorHoverBuffer, circle.getOffset().offsetColorHover, 
							widthHoverBuffer, circle.getOffset().offsetWidthHover);
	}
	
	private void fillBufferData(Circle circle) {
		positionBuffer.clear();
		colorBuffer.clear();
		radiusBuffer.clear();
		colorBorderBuffer.clear();
		widthBorderBuffer.clear();
		hoverBuffer.clear();
		colorHoverBuffer.clear();
		widthHoverBuffer.clear();
		
		
		positionBuffer.put((float)circle.getX());
		positionBuffer.put((float)circle.getY());
		positionBuffer.put((float)circle.getZ());
		
		if(!StorageColors.getInstance().containsColor(circle.getColor())) {
			StorageColors.getInstance().addColor(circle.getColor());
		}
		colorBuffer.put(StorageColors.getInstance().getIndexMyColor(circle.getColor()));
		radiusBuffer.put(circle.getRadius());
		
		if(!StorageColors.getInstance().containsColor(circle.getColorBorder())) {
			StorageColors.getInstance().addColor(circle.getColorBorder());
		}
		colorBorderBuffer.put(StorageColors.getInstance().getIndexMyColor(circle.getColorBorder()));
		widthBorderBuffer.put(circle.getWidthBorder());
		
		if(!StorageColors.getInstance().containsColor(circle.getColorHover())) {
			StorageColors.getInstance().addColor(circle.getColorHover());
		}
		colorHoverBuffer.put(StorageColors.getInstance().getIndexMyColor(circle.getColorHover()));
		widthHoverBuffer.put(circle.getWidthHover());
		hoverBuffer.put(circle.isHover() ? 1 : 0);
		
		positionBuffer.flip();
		colorBuffer.flip();
		radiusBuffer.flip();
		colorBorderBuffer.flip();
		widthBorderBuffer.flip();
		hoverBuffer.flip();
		colorHoverBuffer.flip();
		widthHoverBuffer.flip();
		
		circle.getOffset().offsetPosition = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_POSITION * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetColor = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_COLOR * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetRadius = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_RADIUS * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetColorBorder = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_COLOR * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetWidthBorder = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_RADIUS * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetHover = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_RADIUS * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetColorHover = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_COLOR * SIZE_FLOAT_IN_BYTE;
		circle.getOffset().offsetWidthHover = circleMesh.getCurrentIndex() * COUNT_DIGITS_IN_RADIUS * SIZE_FLOAT_IN_BYTE;
	}
	
	public void removeCircle(Circle circle) {
		circles.remove(circle);
		circleMesh.removeData();
	}
	
	public void addCircles(List<Circle> circles) {
		this.circles.addAll(circles);
		//circleMesh.addData();
	}
	
	public void removeCircles(List<Circle> circles) {
		this.circles.removeAll(circles);
		circleMesh.removeData();
	}

	public ListInstanceMeshs getCircleMesh() {
		return circleMesh;
	}
	
	public void cleanUp() {
		circleMesh.cleanUp();
	}	

	public double getStartX() {
		return startX;
	}

	public double getStartY() {
		return startY;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
}
