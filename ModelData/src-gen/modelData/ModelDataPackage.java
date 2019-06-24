/**
 */
package modelData;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see modelData.ModelDataFactory
 * @model kind="package"
 * @generated
 */
public interface ModelDataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelData";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/modelData";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modelData";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelDataPackage eINSTANCE = modelData.impl.ModelDataPackageImpl.init();

	/**
	 * The meta object id for the '{@link modelData.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelData.impl.ModelImpl
	 * @see modelData.impl.ModelDataPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NODES = 0;

	/**
	 * The feature id for the '<em><b>Arcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ARCS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelData.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelData.impl.NodeImpl
	 * @see modelData.impl.ModelDataPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__X = 0;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__Z = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__Y = 2;

	/**
	 * The feature id for the '<em><b>In Arcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__IN_ARCS = 3;

	/**
	 * The feature id for the '<em><b>Out Arcs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUT_ARCS = 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelData.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelData.impl.ArcImpl
	 * @see modelData.impl.ModelDataPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 2;

	/**
	 * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__BENDPOINTS = 0;

	/**
	 * The feature id for the '<em><b>Begin Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__BEGIN_NODE = 1;

	/**
	 * The feature id for the '<em><b>End Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__END_NODE = 2;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modelData.impl.BendpointImpl <em>Bendpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modelData.impl.BendpointImpl
	 * @see modelData.impl.ModelDataPackageImpl#getBendpoint()
	 * @generated
	 */
	int BENDPOINT = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT__X = 0;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT__Z = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT__Y = 2;

	/**
	 * The feature id for the '<em><b>Arc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT__ARC = 3;

	/**
	 * The number of structural features of the '<em>Bendpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Bendpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENDPOINT_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link modelData.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see modelData.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link modelData.Model#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see modelData.Model#getNodes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link modelData.Model#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arcs</em>'.
	 * @see modelData.Model#getArcs()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Arcs();

	/**
	 * Returns the meta object for class '{@link modelData.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see modelData.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Node#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see modelData.Node#getX()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_X();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Node#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see modelData.Node#getZ()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Z();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Node#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see modelData.Node#getY()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Y();

	/**
	 * Returns the meta object for the reference list '{@link modelData.Node#getInArcs <em>In Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Arcs</em>'.
	 * @see modelData.Node#getInArcs()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_InArcs();

	/**
	 * Returns the meta object for the reference list '{@link modelData.Node#getOutArcs <em>Out Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Arcs</em>'.
	 * @see modelData.Node#getOutArcs()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutArcs();

	/**
	 * Returns the meta object for class '{@link modelData.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see modelData.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for the containment reference list '{@link modelData.Arc#getBendpoints <em>Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bendpoints</em>'.
	 * @see modelData.Arc#getBendpoints()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Bendpoints();

	/**
	 * Returns the meta object for the reference '{@link modelData.Arc#getBeginNode <em>Begin Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Begin Node</em>'.
	 * @see modelData.Arc#getBeginNode()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_BeginNode();

	/**
	 * Returns the meta object for the reference '{@link modelData.Arc#getEndNode <em>End Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Node</em>'.
	 * @see modelData.Arc#getEndNode()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_EndNode();

	/**
	 * Returns the meta object for class '{@link modelData.Bendpoint <em>Bendpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bendpoint</em>'.
	 * @see modelData.Bendpoint
	 * @generated
	 */
	EClass getBendpoint();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Bendpoint#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see modelData.Bendpoint#getX()
	 * @see #getBendpoint()
	 * @generated
	 */
	EAttribute getBendpoint_X();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Bendpoint#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see modelData.Bendpoint#getZ()
	 * @see #getBendpoint()
	 * @generated
	 */
	EAttribute getBendpoint_Z();

	/**
	 * Returns the meta object for the attribute '{@link modelData.Bendpoint#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see modelData.Bendpoint#getY()
	 * @see #getBendpoint()
	 * @generated
	 */
	EAttribute getBendpoint_Y();

	/**
	 * Returns the meta object for the reference '{@link modelData.Bendpoint#getArc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Arc</em>'.
	 * @see modelData.Bendpoint#getArc()
	 * @see #getBendpoint()
	 * @generated
	 */
	EReference getBendpoint_Arc();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelDataFactory getModelDataFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link modelData.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelData.impl.ModelImpl
		 * @see modelData.impl.ModelDataPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__NODES = eINSTANCE.getModel_Nodes();

		/**
		 * The meta object literal for the '<em><b>Arcs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ARCS = eINSTANCE.getModel_Arcs();

		/**
		 * The meta object literal for the '{@link modelData.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelData.impl.NodeImpl
		 * @see modelData.impl.ModelDataPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__X = eINSTANCE.getNode_X();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__Z = eINSTANCE.getNode_Z();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__Y = eINSTANCE.getNode_Y();

		/**
		 * The meta object literal for the '<em><b>In Arcs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__IN_ARCS = eINSTANCE.getNode_InArcs();

		/**
		 * The meta object literal for the '<em><b>Out Arcs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUT_ARCS = eINSTANCE.getNode_OutArcs();

		/**
		 * The meta object literal for the '{@link modelData.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelData.impl.ArcImpl
		 * @see modelData.impl.ModelDataPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '<em><b>Bendpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__BENDPOINTS = eINSTANCE.getArc_Bendpoints();

		/**
		 * The meta object literal for the '<em><b>Begin Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__BEGIN_NODE = eINSTANCE.getArc_BeginNode();

		/**
		 * The meta object literal for the '<em><b>End Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__END_NODE = eINSTANCE.getArc_EndNode();

		/**
		 * The meta object literal for the '{@link modelData.impl.BendpointImpl <em>Bendpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modelData.impl.BendpointImpl
		 * @see modelData.impl.ModelDataPackageImpl#getBendpoint()
		 * @generated
		 */
		EClass BENDPOINT = eINSTANCE.getBendpoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BENDPOINT__X = eINSTANCE.getBendpoint_X();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BENDPOINT__Z = eINSTANCE.getBendpoint_Z();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BENDPOINT__Y = eINSTANCE.getBendpoint_Y();

		/**
		 * The meta object literal for the '<em><b>Arc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENDPOINT__ARC = eINSTANCE.getBendpoint_Arc();

	}

} //ModelDataPackage
