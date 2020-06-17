package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import object.UML_Object;

public class CanvasModel {
	private static CanvasModel instance;
	private List<UML_Object> objects;

	private CanvasModel() {
		objects = new ArrayList<UML_Object>();
	}

	public static CanvasModel getInstance() {
		if (instance == null) {
			instance = new CanvasModel();
		}
		return instance;
	}

	public int getCurrentDepth() {
		UML_Object[] sorted = getSortedObjects();

		for (int i = sorted.length - 1; i >= 0; i--) {
			UML_Object obj = sorted[i];
			if (obj.isBasicObject() || obj.isCompositeObject()) {
				return obj.getDepth() + 1;
			}
		}
		return 0;
	}

	public void addObject(UML_Object obj) {
		obj.setDepth(getCurrentDepth());
		objects.add(obj);
	}

	public UML_Object[] getSortedObjects() {
		UML_Object[] array = new UML_Object[objects.size()];
		array = objects.toArray(array);
		Arrays.sort(array);
		return array;
	}

	public void removeObject(UML_Object obj) {
		objects.remove(obj);
		if (obj.isBasicObject() || obj.isCompositeObject()) {
			for (UML_Object i : objects) {
				int depth = i.getDepth();
				i.setDepth(depth - 1);
			}
		}
	}

	public void selectObject(UML_Object obj) {
		int index = objects.indexOf(obj);
		objects.get(index).setSelected(true);
	}

	public void unSelectAllObjects() {
		for (UML_Object i : objects) {
			i.setSelected(false);
		}
	}

	public int countSelectedObjects() {
		int count = 0;
		for (UML_Object i : objects) {
			if (i.getSelected()) {
				count++;
			}
		}
		return count;
	}

	public UML_Object[] getSelectedObjects() {
		List<UML_Object> list = new ArrayList<UML_Object>();

		for (UML_Object i : objects) {
			if (i.getSelected()) {
				list.add(i);
			}
		}

		UML_Object[] result = new UML_Object[list.size()];
		result = list.toArray(result);
		return result;
	}

}
