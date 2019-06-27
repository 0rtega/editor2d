package editor2d.figures;

public abstract class IFigure {

	private boolean select = false;
	private boolean hover = true;
	
	
	public boolean isSelect() {
		return select;
	}
	
	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}
	
}
