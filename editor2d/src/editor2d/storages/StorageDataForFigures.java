package editor2d.storages;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import editor2d.Utils.LoaderResources;
import editor2d.Utils.LoaderResources.LinkOnBuffersInVideocard;

public class StorageDataForFigures {

	public enum TypeFigure{
		CIRCLE("circle")	;
		private String path;
		
		private TypeFigure(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}		
	}
	private ResourceBundle res = ResourceBundle.getBundle("paths");
	private static StorageDataForFigures instance = new StorageDataForFigures();
	private StorageDataForFigures() {
		
	}
	public static StorageDataForFigures getInstance() {
		return instance;
	}
	private Map<TypeFigure, LinkOnBuffersInVideocard> dataForFigures = new HashMap<TypeFigure, LinkOnBuffersInVideocard>();
	
	public LinkOnBuffersInVideocard getData(TypeFigure type) {
		if(dataForFigures.get(type) != null) {
			return dataForFigures.get(type);
		}else {
			LinkOnBuffersInVideocard link = LoaderResources.getnstance().loadOBJ(res.getString(type.getPath()));
			dataForFigures.put(type, link);
			return link;
		}
	}
	
}
