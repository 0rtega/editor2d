package editor2d.figures;

import java.awt.Color;
import org.joml.Vector3d;
import editor2d.control.ArcBallCamera3D;

public class Circle extends IFigure {
		
	private float stepForScale[] = { 1, 1.2f, 1.44f, 1.7279f, 2.0734f, 2.4883f, 2.9858f, 3.5833f, 4.2994f, 5.1597f,
			6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f };
		
	private Vector3d position = new Vector3d();
	private double radius = 1;
	private Color  color = Color.RED;
	private float scale = 1;
	
	private Square square;	
	private boolean unResize = true;
	
	
	public Circle(double x, double y, double z) {
		position.set(x, y, z);
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return square;
	}	
	
	public float getScale() {
		return scale;
	}

	public Vector3d getPosition() {
		return position;
	}

	public boolean isUnResize() {
		return unResize;
	}

	public void setUnResize(boolean unResize) {
		this.unResize = unResize;
	}

	public void setX(double x) {
		position.x = x;
	}
	
	public double getX() {
		return position.x;
	}
	
	public void setY(double y) {
		position.y = y;
	}
	
	public double getY() {
		return position.y;
	}
	
	public void setZ(double z) {
		position.z = z;
	}
	
	public double getZ() {
		return position.z;
	}
	
	public void setPosition(double x, double y, double z) {
		position.set(x,y,z);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		scale = (float)radius * stepForScale[10 - ArcBallCamera3D.getInstance().getCountPress()]/4;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
