package editor2d;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;

import editor2d.base.Animation;

public class Editor2DPart {

	
	@PostConstruct
	public void postConstruct(Composite parent) {
		Animation animation = new Animation(parent);
	}
}
