package editor2d.control;

import java.io.Serializable;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;

import editor2d.utils.FrustumCullingFilter;

class ScalarMover {

	double maxAcceleration = 1000000;
	double maxDeceleration = 1000000;
	double current;
	double target;
	double velocity;

	ScalarMover() {
	}

	void update(float elapsedTimeInSeconds) {
		if (this.current != this.target) {
			double currentToTarget = this.target - this.current;
			double directStopDistance = this.velocity * this.velocity / (2.0D * this.maxDeceleration);
			double acceleration = 0.0D;
			double way;
			if (this.velocity * currentToTarget > 0.0D && directStopDistance >= Math.abs(currentToTarget)) {
				way = this.maxDeceleration;
				acceleration = (double) (currentToTarget < 0.0D ? -1 : 1) * -way;
			} else {
				way = this.maxAcceleration;
				acceleration = (double) (currentToTarget < 0.0D ? -1 : 1) * way;
			}

			this.velocity += acceleration * (double) elapsedTimeInSeconds;
			way = this.velocity * (double) elapsedTimeInSeconds;
			if (this.velocity * currentToTarget > 0.0D && Math.abs(way) > Math.abs(currentToTarget)) {
				this.velocity = 0.0D;
				this.current = this.target;
			} else {
				this.current += way;
			}

		}
	}
}

class Vector3Mover {
	static final float SMALL_VALUE_THRESHOLD = 1.0E-5F;
	float maxDirectAcceleration = 1000000;
	float maxDirectDeceleration = 1000000;
	float maxPerpendicularDeceleration = 1000000;
	final Vector3f current = new Vector3f();
	final Vector3f target = new Vector3f();
	final Vector3f acceleration = new Vector3f();
	final Vector3f velocity = new Vector3f();
	private final Vector3f currentToTarget = new Vector3f();
	private final Vector3f currentToTargetNormalized = new Vector3f();
	private final Vector3f perpendicularVelocityComponent = new Vector3f();
	private final Vector3f directVelocityComponent = new Vector3f();
	private final Vector3f directAcceleration = new Vector3f();
	private final Vector3f perpendicularAcceleration = new Vector3f();
	private final Vector3f newAcceleration = new Vector3f();
	private final Vector3f newVelocity = new Vector3f();
	private final Vector3f way = new Vector3f();

	Vector3Mover() {
	}

	void update(float elapsedTimeInSeconds) {
		this.currentToTarget.set(this.target).sub(this.current);
		if ((double) this.currentToTarget.length() >= 1.0E-5D) {
			this.currentToTargetNormalized.set(this.currentToTarget).normalize();
			float dot = this.currentToTargetNormalized.dot(this.velocity);
			this.perpendicularVelocityComponent.set(this.currentToTargetNormalized);
			this.perpendicularVelocityComponent.mul(dot);
			this.perpendicularVelocityComponent.sub(this.velocity);
			this.directVelocityComponent.set(this.currentToTargetNormalized);
			this.directVelocityComponent.mul(Math.abs(dot));
			float timeToStopPerpendicular = this.perpendicularVelocityComponent.length()
					/ this.maxPerpendicularDeceleration;
			float directStopDistance = this.directVelocityComponent.lengthSquared()
					/ (2.0F * this.maxDirectDeceleration);
			float timeToStopDirect = this.directVelocityComponent.length() / this.maxDirectDeceleration;
			float neededPerpendicularAcc;
			float perpendicularDeceleration;
			if (dot < 1.0E-5F || directStopDistance < this.currentToTarget.length()
					&& timeToStopPerpendicular <= timeToStopDirect) {
				neededPerpendicularAcc = this.currentToTarget.length() / elapsedTimeInSeconds;
				perpendicularDeceleration = neededPerpendicularAcc;
				if (neededPerpendicularAcc > this.maxDirectAcceleration) {
					perpendicularDeceleration = this.maxDirectAcceleration;
				}

				this.directAcceleration.set(this.currentToTargetNormalized).mul(perpendicularDeceleration);
			} else {
				this.directAcceleration.set(this.currentToTargetNormalized).mul(this.maxDirectDeceleration).negate();
			}

			neededPerpendicularAcc = this.perpendicularVelocityComponent.length() / elapsedTimeInSeconds;
			perpendicularDeceleration = neededPerpendicularAcc;
			if (neededPerpendicularAcc > this.maxPerpendicularDeceleration) {
				perpendicularDeceleration = this.maxPerpendicularDeceleration;
			}

			if (this.perpendicularVelocityComponent.length() > 1.0E-5F) {
				this.perpendicularAcceleration.set(this.perpendicularVelocityComponent).normalize()
						.mul(perpendicularDeceleration);
			} else {
				this.perpendicularAcceleration.set(0.0F, 0.0F, 0.0F);
			}

			this.newAcceleration.set(this.directAcceleration).add(this.perpendicularAcceleration);
			this.newVelocity.set(this.newAcceleration).mul(elapsedTimeInSeconds).add(this.velocity);
			this.velocity.set(this.newVelocity);
			this.way.set(this.velocity).mul(elapsedTimeInSeconds);
			if (this.way.length() > this.currentToTarget.length()) {
				this.velocity.zero();
				this.way.set(this.currentToTarget);
			}

			this.current.add(this.way);
		}
	}
}

class ArcRotor {

	public double maxAcceleration = Math.toRadians(1000000);
	public double maxDeceleration = Math.toRadians(1000000);
	public double target;
	public double current;
	public double velocity;

	ArcRotor() {
	}

	void update(float elapsedTimeInSeconds) {
		if (this.current != this.target) {
			double currentToTarget = 3.141592653589793D
					- Math.abs(Math.abs(this.current - this.target) % 6.283185307179586D - 3.141592653589793D);
			if ((this.current - this.target + 6.283185307179586D) % 6.283185307179586D < 3.141592653589793D) {
				currentToTarget *= -1.0D;
			}

			double directStopDistance = this.velocity * this.velocity / (2.0D * this.maxDeceleration);
			double acceleration = 0.0D;
			double way;
			if (this.velocity * currentToTarget > 0.0D && directStopDistance >= Math.abs(currentToTarget)) {
				way = this.maxDeceleration;
				acceleration = (double) (currentToTarget < 0.0D ? -1 : 1) * -way;
			} else {
				way = this.maxAcceleration;
				acceleration = (double) (currentToTarget < 0.0D ? -1 : 1) * way;
			}

			this.velocity += acceleration * (double) elapsedTimeInSeconds;
			way = this.velocity * (double) elapsedTimeInSeconds;
			if (this.velocity * currentToTarget > 0.0D && Math.abs(way) > Math.abs(currentToTarget)) {
				this.velocity = 0.0D;
				this.current = this.target;
			} else {
				this.current = (this.current + way + 6.283185307179586D) % 6.283185307179586D;
			}

		}
	}
}

public class ArcBallCamera3D implements Serializable {

	private static float COEFFICIENT_OF_MOTION = 0.00045f;
	private static float COEFFICIENT_OF_ZOOM = 0.0045f;
	private static float COEFFICIENT_OF_ROTATION = 0.1f;
	private static double ANGLE = 1.5707963267948966D;
	private static double MAX_ANGLE = 6.283185307179586D;
	public static int MAX_VALUE_ZOOM = 10;
	public static int MIN_VALUE_ZOOM = -10;

	private Vector3Mover centerMover = new Vector3Mover();
	private ArcRotor betaMover = new ArcRotor();
	private ArcRotor zetMover = new ArcRotor();
	private ScalarMover zoomMover = new ScalarMover();
	private Vector3f currentPosition = new Vector3f();
	private Vector3f currentPositionInversion = new Vector3f();
	private FrustumCullingFilter cullingFilter = new FrustumCullingFilter();
	private float zoom = 100;
	private int countPress = 10;

	private boolean normalFunctionality = true;
	private boolean viewFromAbove = false;
	private boolean sideView = false;

	private ArcBallCamera3D() {
		zoomMover.target = 100;
		update(1f);
	}

	private static ArcBallCamera3D instance = new ArcBallCamera3D();

	public static ArcBallCamera3D getInstance() {
		return instance;
	}

	public void updateKeyBoard(Vector3f moveKey) {
		if (normalFunctionality)
			updateKeyBoardForNormalFunctionality(moveKey);
		else if (viewFromAbove)
			updateKeyBoardForViewFromAbove(moveKey);
		else if (sideView)
			updateKeyBoardForSideView(moveKey);

		calculateOffsetByZoom();
		addCenter(offsetCameraByKeyBoard);
	}

	private Vector3f offsetCameraByKeyBoard = new Vector3f();

	private void updateKeyBoardForNormalFunctionality(Vector3f moveKey) {
		offsetCameraByKeyBoard.set(
				(float) Math.sin(zetMover.target) * moveKey.y - (float) Math.cos(zetMover.target) * moveKey.x,
				(float) Math.sin(ANGLE - zetMover.target) * moveKey.y + (float) Math.sin(zetMover.target) * moveKey.x,
				moveKey.z);
	}

	private void updateKeyBoardForViewFromAbove(Vector3f moveKey) {
		offsetCameraByKeyBoard.set(
				(float) Math.sin(zetMover.target) * moveKey.y - (float) Math.cos(zetMover.target) * moveKey.x,
				(float) Math.sin(ANGLE - zetMover.target) * moveKey.y + (float) Math.sin(zetMover.target) * moveKey.x,
				moveKey.z);
	}

	private void updateKeyBoardForSideView(Vector3f moveKey) {
		offsetCameraByKeyBoard.set(moveKey.z,
				(float) Math.sin(ANGLE - zetMover.target) * moveKey.y + (float) Math.sin(zetMover.target) * moveKey.x,
				-(float) Math.sin(zetMover.target) * moveKey.y + (float) Math.cos(zetMover.target) * moveKey.x);
	}

	private void calculateOffsetByZoom() {
		float tempScalar = COEFFICIENT_OF_ZOOM * zoom;
		if (tempScalar < 1)
			tempScalar = 1;
		offsetCameraByKeyBoard.mul(tempScalar);
	}

	public void updateMoveCamera(Vector2f delta) {
		if (normalFunctionality)
			updateMoveCameraForNormalFunctionality(delta);
		else if (viewFromAbove)
			updateMoveCameraForViewFromAbove(delta);
		else if (sideView)
			updateMoveCameraForSideView(delta);

		addCenter(offsetMoveCameraByMouse);
	}

	private Vector3f offsetMoveCameraByMouse = new Vector3f();

	public void updateMoveCameraByMouseZPosition(Vector2f delta) {
		float tempY = delta.y * COEFFICIENT_OF_MOTION * zoom;
		offsetMoveCameraByMouse.set(0, 0, tempY);
		addCenter(offsetMoveCameraByMouse);
	}

	private void updateMoveCameraForNormalFunctionality(Vector2f delta) {
		float tempY = delta.y * COEFFICIENT_OF_MOTION * zoom;
		float tempX = delta.x * COEFFICIENT_OF_MOTION * zoom;

		offsetMoveCameraByMouse.set(
				(float) Math.sin(zetMover.target) * tempY - (float) Math.cos(zetMover.target) * tempX,
				(float) Math.sin(ANGLE - zetMover.target) * tempY + (float) Math.sin(zetMover.target) * tempX, 0);
	}

	private void updateMoveCameraForViewFromAbove(Vector2f delta) {
		float tempY = delta.y * COEFFICIENT_OF_MOTION * zoom;
		float tempX = delta.x * COEFFICIENT_OF_MOTION * zoom;
		offsetMoveCameraByMouse.set(
				(float) Math.sin(zetMover.target) * tempY - (float) Math.cos(zetMover.target) * tempX,
				(float) Math.sin(ANGLE - zetMover.target) * tempY + (float) Math.sin(zetMover.target) * tempX, 0);
	}

	private void updateMoveCameraForSideView(Vector2f delta) {
		float tempY = delta.y * COEFFICIENT_OF_MOTION * zoom;
		float tempX = delta.x * COEFFICIENT_OF_MOTION * zoom;
		offsetMoveCameraByMouse.set(0,
				(float) Math.sin(ANGLE - zetMover.target) * tempY + (float) Math.sin(zetMover.target) * tempX,
				-(float) Math.sin(zetMover.target) * tempY + (float) Math.cos(zetMover.target) * tempX);
	}

	public void updateRotationCamera(Vector2f delta) {
		if (normalFunctionality)
			updateRotationCameraForNormalFunctionality(delta);
		else if (viewFromAbove)
			updateRotationCameraForViewFromAbove(delta);
		else if (sideView)
			updateRotationCameraForSideView(delta);
	}

	private void updateRotationCameraForNormalFunctionality(Vector2f delta) {
		double t;

		t = Math.toRadians(delta.x * COEFFICIENT_OF_ROTATION);
		setZet(zetMover.target + t);
		t = Math.toRadians(delta.y * COEFFICIENT_OF_ROTATION);
		if (betaMover.target + t > Math.toRadians(0)) {
			t = 0;
		}
		setBeta(betaMover.target + t);
	}

	private void updateRotationCameraForViewFromAbove(Vector2f delta) {
		double t;

		t = Math.toRadians(delta.x * COEFFICIENT_OF_ROTATION);
		setZet(zetMover.target + t);
	}

	private void updateRotationCameraForSideView(Vector2f delta) {

	}

	public void updateZoomCamera(double scale) {
		if (scale > 0) {
			scale = 1f / 1.2f;
			countPress++;
		} else if (scale < 0) {
			scale = 1.2f;
			countPress--;
		}
		if (countPress > MAX_VALUE_ZOOM) {
			countPress = MAX_VALUE_ZOOM;
			scale = 1;
		} else if (countPress < MIN_VALUE_ZOOM) {
			countPress = MIN_VALUE_ZOOM;
			scale = 1;
		}
		zoom *= scale;
		zoom(zoom);
	}

	public int getCountPress() {
		return countPress;
	}

	public void setCountPress(int countPress) {
		this.countPress = countPress;
	}

	public void update(float interval) {
		this.zetMover.update(interval);
		this.betaMover.update(interval);
		this.zoomMover.update(interval);
		this.centerMover.update(interval);
		updateCurrentPosition(currentPosition);
	}

	private void updateCurrentPosition(Vector3f currentPosition) {
		currentPosition.set(
				centerMover.current.x - (float) zoomMover.current * (float) Math.cos(betaMover.current + ANGLE)
						* (float) Math.cos(ANGLE - zetMover.current),
				centerMover.current.y - (float) zoomMover.current * (float) Math.cos(betaMover.current + ANGLE)
						* (float) Math.cos(zetMover.current),
				centerMover.current.z + (float) zoomMover.current * (float) Math.sin(betaMover.current + ANGLE));
		currentPositionInversion.set(currentPosition.x, -currentPosition.y, currentPosition.z);

	}

	private Matrix4f viewMatrix = new Matrix4f();

	public Matrix4f viewMatrix() {
		viewMatrix = viewMatrix.identity();
		return viewMatrix.translate(0.0F, 0.0F, (float) (-zoomMover.current)).rotateX((float) betaMover.current)
				.rotateZ((float) zetMover.current)
				.translate(-centerMover.current.x, -centerMover.current.y, -centerMover.current.z);
	}

	public Matrix4f viewMatrixInverse() {
		viewMatrix.identity();
		return viewMatrix.translate(0.0F, 0.0F, (float) (-zoomMover.current)).rotateX((float) betaMover.current)
				.rotateZ((float) zetMover.current)
				.translate(-centerMover.current.x, -centerMover.current.y, -centerMover.current.z);
	}

	public void setZet(double zet) {
		this.zetMover.target = zet % MAX_ANGLE;
	}

	public float getZ() {
		return zoom;
	}

	public void setViewAbove() {
		setBeta(0);
		setZet(0);
	}

	public void setViewAbovePoints(Vector3d min, Vector3d max, Vector3d position, Matrix4f mat) {
		while (zoom > 100) {
			updateZoomCamera(1f);
		}
		center(position);
		while (true) {
			cullingFilter.updateFrustum(mat, viewMatrix());
			if (cullingFilter.insideFrustum(min, 1f) && cullingFilter.insideFrustum(max, 1f)) {
				break;
			}
			updateZoomCamera(-1);
			update(1);
		}
		update(1);

	}

	public void setBeta(double beta) {
		if (beta < -ANGLE) {
			beta = -ANGLE;
		} else if (beta > ANGLE) {
			beta = ANGLE;
		}
		this.betaMover.target = beta;
	}

	public double getZet() {
		return this.zetMover.current;
	}

	public double getBeta() {
		return this.betaMover.current;
	}

	public void zoom(double zoom) {
		this.zoomMover.target = zoom;
		update(1f);
	}

	public float getZoom() {
		return (float) zoomMover.current;
	}

	public void center(float x, float y, float z) {
		this.centerMover.target.set(x, y, z);
		update(1f);
	}

	public void center(double x, double y, double z) {
		this.centerMover.target.set((float) x, (float) y, (float) z);
		update(1f);
	}

	public void center(Vector3f currentPosition) {
		center(currentPosition.x, currentPosition.y, currentPosition.z);
	}

	public void center(Vector3d currentPosition) {
		center(currentPosition.x, currentPosition.y, currentPosition.z);
	}

	public void center(Vector3i currentPosition) {
		center(currentPosition.x, currentPosition.y, currentPosition.z);
	}

	public void addCenter(Vector3f vec) {
		centerMover.target.add(vec);
	}

	public Vector3f getCurrentPosition() {
		return currentPosition;
	}

	public Vector3f getCurrentPositionInversion() {
		return currentPositionInversion;
	}

	public void setNormalFunctionality() {
		update(0.1f);
		normalFunctionality = true;
		viewFromAbove = false;
		sideView = false;
	}

	public void setViewFromAbove() {
		update(0.1f);
		normalFunctionality = false;
		viewFromAbove = true;
		sideView = false;
	}

	public void setSideView() {
		betaMover.target = -ANGLE;
		zetMover.target = -ANGLE;
		update(0.1f);
		normalFunctionality = false;
		viewFromAbove = false;
		sideView = true;
	}

	public boolean isNormalFunctionality() {
		return normalFunctionality;
	}

	public boolean isViewFromAbove() {
		return viewFromAbove;
	}

	public boolean isSideView() {
		return sideView;
	}

}
