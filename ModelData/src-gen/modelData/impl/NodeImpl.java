/**
 */
package modelData.impl;

import java.util.Collection;

import modelData.Arc;
import modelData.ModelDataPackage;
import modelData.Node;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelData.impl.NodeImpl#getX <em>X</em>}</li>
 *   <li>{@link modelData.impl.NodeImpl#getZ <em>Z</em>}</li>
 *   <li>{@link modelData.impl.NodeImpl#getY <em>Y</em>}</li>
 *   <li>{@link modelData.impl.NodeImpl#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link modelData.impl.NodeImpl#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends MinimalEObjectImpl.Container implements Node {
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
	 * The cached value of the '{@link #getInArcs() <em>In Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> inArcs;

	/**
	 * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> outArcs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelDataPackage.Literals.NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.NODE__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.NODE__Z, oldZ, z));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.NODE__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arc> getInArcs() {
		if (inArcs == null) {
			inArcs = new EObjectResolvingEList<Arc>(Arc.class, this, ModelDataPackage.NODE__IN_ARCS);
		}
		return inArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arc> getOutArcs() {
		if (outArcs == null) {
			outArcs = new EObjectResolvingEList<Arc>(Arc.class, this, ModelDataPackage.NODE__OUT_ARCS);
		}
		return outArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelDataPackage.NODE__X:
			return getX();
		case ModelDataPackage.NODE__Z:
			return getZ();
		case ModelDataPackage.NODE__Y:
			return getY();
		case ModelDataPackage.NODE__IN_ARCS:
			return getInArcs();
		case ModelDataPackage.NODE__OUT_ARCS:
			return getOutArcs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelDataPackage.NODE__X:
			setX((Integer) newValue);
			return;
		case ModelDataPackage.NODE__Z:
			setZ((Integer) newValue);
			return;
		case ModelDataPackage.NODE__Y:
			setY((Integer) newValue);
			return;
		case ModelDataPackage.NODE__IN_ARCS:
			getInArcs().clear();
			getInArcs().addAll((Collection<? extends Arc>) newValue);
			return;
		case ModelDataPackage.NODE__OUT_ARCS:
			getOutArcs().clear();
			getOutArcs().addAll((Collection<? extends Arc>) newValue);
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
		case ModelDataPackage.NODE__X:
			setX(X_EDEFAULT);
			return;
		case ModelDataPackage.NODE__Z:
			setZ(Z_EDEFAULT);
			return;
		case ModelDataPackage.NODE__Y:
			setY(Y_EDEFAULT);
			return;
		case ModelDataPackage.NODE__IN_ARCS:
			getInArcs().clear();
			return;
		case ModelDataPackage.NODE__OUT_ARCS:
			getOutArcs().clear();
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
		case ModelDataPackage.NODE__X:
			return x != X_EDEFAULT;
		case ModelDataPackage.NODE__Z:
			return z != Z_EDEFAULT;
		case ModelDataPackage.NODE__Y:
			return y != Y_EDEFAULT;
		case ModelDataPackage.NODE__IN_ARCS:
			return inArcs != null && !inArcs.isEmpty();
		case ModelDataPackage.NODE__OUT_ARCS:
			return outArcs != null && !outArcs.isEmpty();
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

} //NodeImpl
