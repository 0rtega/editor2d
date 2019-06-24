package editor2d.storages;

import modelData.Model;

public class StorageData {

	private static StorageData instance = new StorageData();

	public static StorageData getInstance() {
		return instance;
	}
	private Model model;

	public Model getModel() {
		return model;
	}
	
	
}
