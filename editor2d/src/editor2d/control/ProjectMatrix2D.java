package editor2d.control;

import org.joml.Matrix3x2f;
import org.joml.Matrix4f;

public class ProjectMatrix2D {

	private Matrix3x2f view = new Matrix3x2f();
	private Matrix4f viewproj = new Matrix4f();
	private int width, height;


	public ProjectMatrix2D(int width, int height) {
		this.width = width;
		this.height = height;
		view.scaleLocal(22.186134f, 22.186134f);
	}

	public void update(int width, int height) {
		this.width = width;
		this.height = height;
		viewproj.setOrtho(-width / 2, width / 2, -height / 2, height / 2, 10f, 6000.0f);
	}

	public Matrix4f getProjMatrix() {
		viewproj = viewproj.identity();
		viewproj.setOrtho(-width / 2, width / 2, -height / 2, height / 2, 10f, 6000.0f).mul(view);
		return viewproj;
	}

	private int countPress = 10;
	public void zoom(float count) {
		float scale = 1.1f;
		if (count < 0.0) {
			scale = 1.0f / 1.2f;			
			countPress--;
		} else {
			scale = 1.2f;
			countPress++;
		}
		
		if (countPress > ArcBallCamera3D.MAX_VALUE_ZOOM) {
			countPress = ArcBallCamera3D.MAX_VALUE_ZOOM;
			scale = 1;
		}else if(countPress < ArcBallCamera3D.MIN_VALUE_ZOOM) {
			countPress = ArcBallCamera3D.MIN_VALUE_ZOOM;
			scale = 1;
		}
		view.scaleLocal(scale, scale);
	}
}
