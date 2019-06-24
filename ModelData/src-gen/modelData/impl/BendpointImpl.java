/**
 */
package modelData.impl;

import modelData.Arc;
import modelData.Bendpoint;
import modelData.ModelDataPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bendpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelData.impl.BendpointImpl#getX <em>X</em>}</li>
 *   <li>{@link modelData.impl.BendpointImpl#getZ <em>Z</em>}</li>
 *   <li>{@link modelData.impl.BendpointImpl#getY <em>Y</em>}</li>
 *   <li>{@link modelData.impl.BendpointImpl#getArc <em>Arc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BendpointImpl extends MinimalEObjectImpl.Container implements Bendpoint {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected static final int Z_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected int z = Z_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArc() <em>Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArc()
	 * @generated
	 * @ordered
	 */
	protected Arc arc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BendpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelDataPackage.Literals.BENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.BENDPOINT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getZ() {
		return z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZ(int newZ) {
		int oldZ = z;
		z = newZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.BENDPOINT__Z, oldZ, z));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.BENDPOINT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Arc getArc() {
		if (arc != null && arc.eIsProxy()) {
			InternalEObject oldArc = (InternalEObject) arc;
			arc = (Arc) eResolveProxy(oldArc);
			if (arc != oldArc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelDataPackage.BENDPOINT__ARC, oldArc,
							arc));
			}
		}
		return arc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arc basicGetArc() {
		return arc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArc(Arc newArc) {
		Arc oldArc = arc;
		arc = newArc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.BENDPOINT__ARC, oldArc, arc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelDataPackage.BENDPOINT__X:
			return getX();
		case ModelDataPackage.BENDPOINT__Z:
			return getZ();
		case ModelDataPackage.BENDPOINT__Y:
			return getY();
		case ModelDataPackage.BENDPOINT__ARC:
			if (resolve)
				return getArc();
			return basicGetArc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelDataPackage.BENDPOINT__X:
			setX((Integer) newValue);
			return;
		case ModelDataPackage.BENDPOINT__Z:
			setZ((Integer) newValue);
			return;
		case ModelDataPackage.BENDPOINT__Y:
			setY((Integer) newValue);
			return;
		case ModelDataPackage.BENDPOINT__ARC:
			setArc((Arc) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelDataPackage.BENDPOINT__X:
			setX(X_EDEFAULT);
			return;
		case ModelDataPackage.BENDPOINT__Z:
			setZ(Z_EDEFAULT);
			return;
		case ModelDataPackage.BENDPOINT__Y:
			setY(Y_EDEFAULT);
			return;
		case ModelDataPackage.BENDPOINT__ARC:
			setArc((Arc) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelDataPackage.BENDPOINT__X:
			return x != X_EDEFAULT;
		case ModelDataPackage.BENDPOINT__Z:
			return z != Z_EDEFAULT;
		case ModelDataPackage.BENDPOINT__Y:
			return y != Y_EDEFAULT;
		case ModelDataPackage.BENDPOINT__ARC:
			return arc != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (x: ");
		result.append(x);
		result.append(", z: ");
		result.append(z);
		result.append(", y: ");
		result.append(y);
		result.append(')');
		return result.toString();
	}

} //BendpointImpl
