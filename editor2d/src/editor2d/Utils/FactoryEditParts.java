package editor2d.Utils;

import editor2d.editparts.IEditPart;
import editor2d.editparts.NodeEditPart;
import modelData.Node;

public class FactoryEditParts {

	private static FactoryEditParts instance = new FactoryEditParts();
	private FactoryEditParts() {}
	public static FactoryEditParts getInstance() {
		return instance;
	}
	
	public IEditPart cretaeEditPart(Object obj) {
		if(obj == null) {
			throw new NullPointerException("Объект в модели данных равен null");
		}else if(obj instanceof Node) {
			NodeEditPart nodeEditPart = new NodeEditPart((Node)obj);
			return nodeEditPart;
		}else {
			throw new NullPointerException("Инстанс объекта неизвестен " + obj);
		}
	}
}
