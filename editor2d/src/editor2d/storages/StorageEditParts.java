package editor2d.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import editor2d.base.IEditPart;

public class StorageEditParts {

	private static StorageEditParts instance = new StorageEditParts();
	private StorageEditParts() {}
	public static StorageEditParts getInstance() {
		return instance;
	}
	
	private List<IEditPart> editParts = new ArrayList<IEditPart>();
	
	public void addEditPart(IEditPart editPart) {
		editParts.add(editPart);
		StorageFigures.getInstance().addFigure(editPart.getFigure());
	}
	
	public void removeEditPart(IEditPart editPart) {
		editParts.remove(editPart);
		StorageFigures.getInstance().removeFigure(editPart.getFigure());
	}

	
	
}
