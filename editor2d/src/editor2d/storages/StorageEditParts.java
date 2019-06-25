package editor2d.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import editor2d.editparts.IEditPart;

public class StorageEditParts {

	private static StorageEditParts instance = new StorageEditParts();
	private StorageEditParts() {}
	public static StorageEditParts getInstance() {
		return instance;
	}
	
	private List<IEditPart> editParts = new ArrayList<IEditPart>();
	
	public void addEditPart(IEditPart editPart) {
		editParts.add(editPart);
	}
	public List<IEditPart> getEditParts() {
		return Collections.unmodifiableList(editParts);
	}
	
	
}
