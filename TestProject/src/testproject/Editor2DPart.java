package testproject;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;

import editor2d.base.Animation;
import editor2d.base.Animation.PropertieAnimation;
import editor2d.graphics.Grid.SizeCellGrid;
import editor2d.storages.StorageData;
import modelData.Model;
import modelData.ModelDataFactory;
import modelData.Node;
import testproject.editparts.Editor2DController;

public class Editor2DPart {

	
	@PostConstruct
	public void postConstruct(Composite parent) {		
		Animation animation = new Animation(parent);
		
		Model model = StorageData.getInstance().getModel();
		for (int i = -50; i < 50; i++) {
			for (int j = -20; j < 20; j++) {
				Node node = ModelDataFactory.eINSTANCE.createNode();
				node.setX(j * 7);
				node.setY(i * 10);
				node.setZ(0);
				model.getNodes().add(node);
			}
		}
		
		animation.enable(PropertieAnimation.ANTIALIASING);
		animation.enable(PropertieAnimation.GRID);
		animation.setSizeCellGrid(SizeCellGrid.HALF_SIZE);
		animation.init();
		Editor2DController controller = new Editor2DController();
		controller.init();
		
	}
}
