/**
 */
package modelData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelData.Arc#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link modelData.Arc#getBeginNode <em>Begin Node</em>}</li>
 *   <li>{@link modelData.Arc#getEndNode <em>End Node</em>}</li>
 * </ul>
 *
 * @see modelData.ModelDataPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
	 * The list contents are of type {@link modelData.Bendpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference list.
	 * @see modelData.ModelDataPackage#getArc_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bendpoint> getBendpoints();

	/**
	 * Returns the value of the '<em><b>Begin Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Node</em>' reference.
	 * @see #setBeginNode(Node)
	 * @see modelData.ModelDataPackage#getArc_BeginNode()
	 * @model
	 * @generated
	 */
	Node getBeginNode();

	/**
	 * Sets the value of the '{@link modelData.Arc#getBeginNode <em>Begin Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Node</em>' reference.
	 * @see #getBeginNode()
	 * @generated
	 */
	void setBeginNode(Node value);

	/**
	 * Returns the value of the '<em><b>End Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Node</em>' reference.
	 * @see #setEndNode(Node)
	 * @see modelData.ModelDataPackage#getArc_EndNode()
	 * @model
	 * @generated
	 */
	Node getEndNode();

	/**
	 * Sets the value of the '{@link modelData.Arc#getEndNode <em>End Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Node</em>' reference.
	 * @see #getEndNode()
	 * @generated
	 */
	void setEndNode(Node value);

} // Arc
