package editor2d;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;

import editor2d.base.Animation;
import editor2d.base.Animation.PropertieAnimation;
import editor2d.graphics.Grid.SizeCellGrid;
import editor2d.storages.StorageData;
import modelData.Model;
import modelData.ModelDataFactory;
import modelData.Node;

public class Editor2DPart {

	
	@PostConstruct
	public void postConstruct(Composite parent) {		
		Animation animation = new Animation(parent);
		
		Model model = StorageData.getInstance().getModel();
		for (int i = 0; i < 3; i++) {
			Node node = ModelDataFactory.eINSTANCE.createNode();
			node.setX(i * 7);
			node.setY(10);
			node.setZ(0);
			model.getNodes().add(node);
		}
		
		animation.enable(PropertieAnimation.ANTIALIASING);
		animation.enable(PropertieAnimation.GRID);
		animation.setSizeCellGrid(SizeCellGrid.HALF_SIZE);
		animation.init();
	}
}
