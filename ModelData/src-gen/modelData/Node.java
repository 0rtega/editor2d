/**
 */
package modelData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelData.Node#getX <em>X</em>}</li>
 *   <li>{@link modelData.Node#getZ <em>Z</em>}</li>
 *   <li>{@link modelData.Node#getY <em>Y</em>}</li>
 *   <li>{@link modelData.Node#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link modelData.Node#getOutArcs <em>Out Arcs</em>}</li>
 * </ul>
 *
 * @see modelData.ModelDataPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see modelData.ModelDataPackage#getNode_X()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link modelData.Node#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Z</em>' attribute.
	 * @see #setZ(int)
	 * @see modelData.ModelDataPackage#getNode_Z()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getZ();

	/**
	 * Sets the value of the '{@link modelData.Node#getZ <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Z</em>' attribute.
	 * @see #getZ()
	 * @generated
	 */
	void setZ(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see modelData.ModelDataPackage#getNode_Y()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link modelData.Node#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
	 * The list contents are of type {@link modelData.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Arcs</em>' reference list.
	 * @see modelData.ModelDataPackage#getNode_InArcs()
	 * @model
	 * @generated
	 */
	EList<Arc> getInArcs();

	/**
	 * Returns the value of the '<em><b>Out Arcs</b></em>' reference list.
	 * The list contents are of type {@link modelData.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Arcs</em>' reference list.
	 * @see modelData.ModelDataPackage#getNode_OutArcs()
	 * @model
	 * @generated
	 */
	EList<Arc> getOutArcs();

} // Node
