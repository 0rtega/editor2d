package editor2d.control;

import editor2d.editparts.IEditPart;
import editor2d.figures.Square;
import editor2d.graphics.Shader;
import editor2d.storages.StorageEditParts;
import editor2d.storages.StorageFigures;
import editor2d.storages.StorageShaders;
import editor2d.storages.StorageShaders.TypeShader;

public class Renderer {

	
	public void render() {
		Shader shader = StorageShaders.getInstance().getShader(TypeShader.CIRCLE);
		for(Square square: StorageFigures.getInstance().getSquares()) {
			shader.bind();
			square.getCircleMesh().render();
			shader.unbind();
		}
	}
	
}
