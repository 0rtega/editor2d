package editor2d.figures;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3d;

import editor2d.meshs.ListInstanceMeshs;

public class Square extends IFigure {

	private double x, y, width, height;
	
	private List<Circle> circles = new ArrayList<Circle>();
	private ListInstanceMeshs circleMesh = new ListInstanceMeshs();
	
	public Square() {
		
	}
	
	public boolean isEmpty() {
		return circles.isEmpty();
	}
	
	public boolean belongToPointOfSquare(Vector3d position) {
		return true;
	}
	
	public void addCicrle(Circle circle) {
		circles.add(circle);
		circleMesh.addData();
	}
	
	public void removeCircle(Circle circle) {
		circles.remove(circle);
		circleMesh.removeData();
	}
	
	public void addCircles(List<Circle> circles) {
		this.circles.addAll(circles);
		circleMesh.addData();
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
	

	
}
