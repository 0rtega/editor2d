package editor2d.storages;

import modelData.Model;
import modelData.ModelDataFactory;

public class StorageData {

	private static StorageData instance = new StorageData();

	public static StorageData getInstance() {
		return instance;
	}
	private StorageData() {
		model = ModelDataFactory.eINSTANCE.createModel();
	}
	
	
	private Model model;

	public Model getModel() {
		return model;
	}
	
	
}
