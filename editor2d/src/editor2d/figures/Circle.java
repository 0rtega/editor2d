package editor2d.figures;

import java.awt.Color;
import org.joml.Vector3d;
import editor2d.control.ArcBallCamera3D;
import editor2d.utils.Offset;

public class Circle extends IFigure {
		
	private float stepForScale[] = { 1, 1.2f, 1.44f, 1.7279f, 2.0734f, 2.4883f, 2.9858f, 3.5833f, 4.2994f, 5.1597f,
			6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f, 6.1912f };
		
	private Offset offset = new Offset();
	
	private Vector3d position = new Vector3d();
	private float radius = 1f;
	private Color color = Color.CYAN;
	private float scale = 1;
	
	private float widthBorder = 0.3f;
	private Color colorBorder = Color.BLACK;
	
	private float sizeVirtualBorderForHover = 1;
	
	private float widthHover = 1.2f;
	private Color colorHover = Color.BLUE;
	
	private float widthSelect = 1;
	private Color colorSelect = Color.BLUE;
	
	private Square square;	
	private boolean unResize = true;	
	
	public Circle(double x, double y, double z) {
		position.set(x, y, z);
		scale = (float)radius * stepForScale[10 - ArcBallCamera3D.getInstance().getCountPress()]/4;
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

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Offset getOffset() {
		return offset;
	}

	public float getWidthBorder() {
		return widthBorder;
	}

	public void setWidthBorder(float widthBorder) {
		this.widthBorder = widthBorder;
	}

	public Color getColorBorder() {
		return colorBorder;
	}

	public void setColorBorder(Color colorBorder) {
		this.colorBorder = colorBorder;
	}

	public float getSizeVirtualBorderForHover() {
		return sizeVirtualBorderForHover;
	}

	public void setSizeVirtualBorderForHover(float sizeVirtualBorderForHover) {
		this.sizeVirtualBorderForHover = sizeVirtualBorderForHover;
	}

	public float getWidthHover() {
		return widthHover;
	}

	public void setWidthHover(float widthHover) {
		this.widthHover = widthHover;
	}

	public float getWidthSelect() {
		return widthSelect;
	}

	public void setWidthSelect(float widthSelect) {
		this.widthSelect = widthSelect;
	}

	public Color getColorSelect() {
		return colorSelect;
	}

	public void setColorSelect(Color colorSelect) {
		this.colorSelect = colorSelect;
	}

	public Color getColorHover() {
		return colorHover;
	}

	public void setColorHover(Color colorHover) {
		this.colorHover = colorHover;
	}
	
	
	
}
