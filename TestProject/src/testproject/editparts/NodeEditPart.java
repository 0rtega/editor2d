package testproject.editparts;

import editor2d.base.IEditPart;
import editor2d.figures.Circle;
import editor2d.figures.IFigure;
import modelData.Node;

public class NodeEditPart implements IEditPart{

	private Node node;
	private Circle circle;

	public NodeEditPart(Node node) {
		this.node = node;
		circle = new Circle(node.getX(), node.getY(), node.getZ());
	}
	
	@Override
	public IFigure getFigure() {
		return circle;
	}
	
	
}
