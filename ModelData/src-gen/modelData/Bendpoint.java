/**
 */
package modelData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bendpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelData.Bendpoint#getX <em>X</em>}</li>
 *   <li>{@link modelData.Bendpoint#getZ <em>Z</em>}</li>
 *   <li>{@link modelData.Bendpoint#getY <em>Y</em>}</li>
 *   <li>{@link modelData.Bendpoint#getArc <em>Arc</em>}</li>
 * </ul>
 *
 * @see modelData.ModelDataPackage#getBendpoint()
 * @model
 * @generated
 */
public interface Bendpoint extends EObject {
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
	 * @see modelData.ModelDataPackage#getBendpoint_X()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link modelData.Bendpoint#getX <em>X</em>}' attribute.
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
	 * @see modelData.ModelDataPackage#getBendpoint_Z()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getZ();

	/**
	 * Sets the value of the '{@link modelData.Bendpoint#getZ <em>Z</em>}' attribute.
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
	 * @see modelData.ModelDataPackage#getBendpoint_Y()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link modelData.Bendpoint#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Arc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arc</em>' reference.
	 * @see #setArc(Arc)
	 * @see modelData.ModelDataPackage#getBendpoint_Arc()
	 * @model
	 * @generated
	 */
	Arc getArc();

	/**
	 * Sets the value of the '{@link modelData.Bendpoint#getArc <em>Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arc</em>' reference.
	 * @see #getArc()
	 * @generated
	 */
	void setArc(Arc value);

} // Bendpoint
