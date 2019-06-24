package editor2d;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;

import editor2d.base.Animation;
import editor2d.base.Animation.PropertieAnimation;
import editor2d.graphics.Grid.SizeCellGrid;

public class Editor2DPart {

	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		Animation animation = new Animation(parent);
		animation.enable(PropertieAnimation.ANTIALIASING);
		animation.enable(PropertieAnimation.GRID);
		animation.setSizeCellGrid(SizeCellGrid.HALF_SIZE);
		animation.init();
	}
}
