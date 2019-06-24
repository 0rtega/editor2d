package editor2d.editparts;

import editor2d.figures.Circle;
import modelData.Node;

public class NodeEditPart implements IEditPart{

	private Node node;
	private Circle circle;

	public NodeEditPart(Node node) {
		this.node = node;
		circle = new Circle();
	}
	
	
}
