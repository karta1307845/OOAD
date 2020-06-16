package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import object.UML_Object;

public class CanvasModel {
	private static CanvasModel instance;
	private int currentDepth;
	private List<UML_Object> objects;

	private CanvasModel() {
		currentDepth = 0;
		objects = new ArrayList<UML_Object>();
	}

	public static CanvasModel getInstance() {
		if (instance == null) {
			instance = new CanvasModel();
		}
		return instance;
	}

	public void setCurrentDepth(int depth) {
		currentDepth = depth;
	}

	public int getCurrentDepth() {
		return currentDepth;
	}

	public void addObject(UML_Object obj) {
		obj.setDepth(currentDepth);
		if (currentDepth < 99) {
			currentDepth++;
		}
		objects.add(obj);
	}

	public UML_Object[] getSortedObject() {
		UML_Object[] array = new UML_Object[objects.size()];
		array = objects.toArray(array);
		Arrays.sort(array);
		return array;
	}

	public void removeObject(UML_Object obj) {
		objects.remove(obj);
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
