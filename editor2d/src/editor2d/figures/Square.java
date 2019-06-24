package editor2d.figures;

import java.util.ArrayList;
import java.util.List;

import editor2d.meshs.ListInstanceMeshs;

public class Square implements IFigure {

	private List<Circle> circles = new ArrayList<Circle>();
	private ListInstanceMeshs circleMesh;
	
	public Square() {
		
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
	
	
	@Override
	public void buildMesh() {
		
	}

	@Override
	public void cleanUp() {
		circleMesh.cleanUp();
	}

	@Override
	public void render() {
		circleMesh.render();
	}

	
}
