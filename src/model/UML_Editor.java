package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UML_Editor {
	private int mode;
	private int currentDepth;
	private List<UML_Object> objects;

	public UML_Editor() {
		mode = -1;
		currentDepth = 0;
		objects = new ArrayList<UML_Object>();
	}

	public void setMode(int index) {
		mode = index;
	}

	public int getMode() {
		return mode;
	}

	public void setCurrentDepth(int depth) {
		currentDepth = depth;
	}

	public int getCurrentDepth() {
		return currentDepth;
	}

	public void addObject(UML_Object obj) {
		obj.setDepth(currentDepth);
		objects.add(obj);
		currentDepth++;
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
		;
	}

	public void unSelectAllObjects() {
		for (UML_Object i : objects) {
			i.setSelected(false);
		}
	}

	public int countSelectedObjects() {
		int count = 0;
		for (UML_Object i : objects) {
			if (i.selected) {
				count++;
			}
		}
		return count;
	}

	public UML_Object[] getSelectedObjects() {
		List<UML_Object> list = new ArrayList<UML_Object>();

		for (UML_Object i : objects) {
			if (i.selected) {
				list.add(i);
			}
		}

		UML_Object[] result = new UML_Object[list.size()];
		result = list.toArray(result);
		return result;
	}

}
