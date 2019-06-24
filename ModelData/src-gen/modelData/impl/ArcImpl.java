/**
 */
package modelData.impl;

import java.util.Collection;

import modelData.Arc;
import modelData.Bendpoint;
import modelData.ModelDataPackage;
import modelData.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modelData.impl.ArcImpl#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link modelData.impl.ArcImpl#getBeginNode <em>Begin Node</em>}</li>
 *   <li>{@link modelData.impl.ArcImpl#getEndNode <em>End Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArcImpl extends MinimalEObjectImpl.Container implements Arc {
	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Bendpoint> bendpoints;

	/**
	 * The cached value of the '{@link #getBeginNode() <em>Begin Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginNode()
	 * @generated
	 * @ordered
	 */
	protected Node beginNode;

	/**
	 * The cached value of the '{@link #getEndNode() <em>End Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndNode()
	 * @generated
	 * @ordered
	 */
	protected Node endNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelDataPackage.Literals.ARC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Bendpoint> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList<Bendpoint>(Bendpoint.class, this,
					ModelDataPackage.ARC__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getBeginNode() {
		if (beginNode != null && beginNode.eIsProxy()) {
			InternalEObject oldBeginNode = (InternalEObject) beginNode;
			beginNode = (Node) eResolveProxy(oldBeginNode);
			if (beginNode != oldBeginNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelDataPackage.ARC__BEGIN_NODE,
							oldBeginNode, beginNode));
			}
		}
		return beginNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetBeginNode() {
		return beginNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBeginNode(Node newBeginNode) {
		Node oldBeginNode = beginNode;
		beginNode = newBeginNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.ARC__BEGIN_NODE, oldBeginNode,
					beginNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getEndNode() {
		if (endNode != null && endNode.eIsProxy()) {
			InternalEObject oldEndNode = (InternalEObject) endNode;
			endNode = (Node) eResolveProxy(oldEndNode);
			if (endNode != oldEndNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelDataPackage.ARC__END_NODE,
							oldEndNode, endNode));
			}
		}
		return endNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetEndNode() {
		return endNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndNode(Node newEndNode) {
		Node oldEndNode = endNode;
		endNode = newEndNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDataPackage.ARC__END_NODE, oldEndNode, endNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelDataPackage.ARC__BENDPOINTS:
			return ((InternalEList<?>) getBendpoints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelDataPackage.ARC__BENDPOINTS:
			return getBendpoints();
		case ModelDataPackage.ARC__BEGIN_NODE:
			if (resolve)
				return getBeginNode();
			return basicGetBeginNode();
		case ModelDataPackage.ARC__END_NODE:
			if (resolve)
				return getEndNode();
			return basicGetEndNode();
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
		case ModelDataPackage.ARC__BENDPOINTS:
			getBendpoints().clear();
			getBendpoints().addAll((Collection<? extends Bendpoint>) newValue);
			return;
		case ModelDataPackage.ARC__BEGIN_NODE:
			setBeginNode((Node) newValue);
			return;
		case ModelDataPackage.ARC__END_NODE:
			setEndNode((Node) newValue);
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
		case ModelDataPackage.ARC__BENDPOINTS:
			getBendpoints().clear();
			return;
		case ModelDataPackage.ARC__BEGIN_NODE:
			setBeginNode((Node) null);
			return;
		case ModelDataPackage.ARC__END_NODE:
			setEndNode((Node) null);
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
		case ModelDataPackage.ARC__BENDPOINTS:
			return bendpoints != null && !bendpoints.isEmpty();
		case ModelDataPackage.ARC__BEGIN_NODE:
			return beginNode != null;
		case ModelDataPackage.ARC__END_NODE:
			return endNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ArcImpl
