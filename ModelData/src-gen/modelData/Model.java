/**
 */
package modelData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelData.Model#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modelData.Model#getArcs <em>Arcs</em>}</li>
 * </ul>
 *
 * @see modelData.ModelDataPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link modelData.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see modelData.ModelDataPackage#getModel_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Arcs</b></em>' containment reference list.
	 * The list contents are of type {@link modelData.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arcs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs</em>' containment reference list.
	 * @see modelData.ModelDataPackage#getModel_Arcs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Arc> getArcs();

} // Model
