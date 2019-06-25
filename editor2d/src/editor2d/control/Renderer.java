package editor2d.control;

import editor2d.editparts.IEditPart;
import editor2d.storages.StorageEditParts;

public class Renderer {

	
	public void render() {
		for(IEditPart ed: StorageEditParts.getInstance().getEditParts()) {
			ed.getFigure().render();
		}
	}
	
}
