package testproject.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFProperties;

import editor2d.storages.StorageData;
import editor2d.storages.StorageEditParts;
import modelData.Model;
import modelData.ModelDataPackage;
import modelData.Node;

public class Editor2DController {

	private IObservableValue<Model> observableModel =  new WritableValue<Model>();
	private IObservableList<Node> nodes = EMFProperties.list(ModelDataPackage.Literals.MODEL__NODES).observeDetail(observableModel);
	
	private Map<Node, NodeEditPart> nodesMap = new HashMap<Node, NodeEditPart>();
	
	
	public Editor2DController() {
	}
	
	public void init() {
		nodes.addListChangeListener(new IListChangeListener<Node>() {
			@Override
			public void handleListChange(ListChangeEvent arg0) {
				for (ListDiffEntry<Node> lde : arg0.diff.getDifferences()) {
					if (lde.isAddition()) {
						addObject(lde.getElement());
					} else {
						removeObject(lde.getElement());
					}
				}
			}
		});		
		
		observableModel.setValue(StorageData.getInstance().getModel());
	}
	
	private void addObject(Object o) {
		if(o == null) {
			throw new NullPointerException("Значение в модели данных равно null");
		}else if(o instanceof Node) {
			NodeEditPart nodeEditPart = new NodeEditPart((Node)o);
			nodesMap.put((Node)o, nodeEditPart);
			StorageEditParts.getInstance().addEditPart(nodeEditPart);
		}
	}
	
	private void removeObject(Object o) {
		if(o == null) {
			throw new NullPointerException("Значение в модели данных равно null");
		}else if(o instanceof Node) {
			Node node = (Node)o;
			NodeEditPart nodeEditPart = nodesMap.get(node);
			if(nodeEditPart == null) {
				throw new NullPointerException("Не нашлось соответствия node - NodeEditPart в мапе nodesMap");
			}else {
				nodesMap.remove(node);
				StorageEditParts.getInstance().removeEditPart(nodeEditPart);
			}
		}
	}
}
