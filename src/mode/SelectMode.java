package mode;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.CanvasModel;
import model.Location;
import object.SelectArea;
import object.UML_Object;

public class SelectMode extends Mode {
	private UML_Object selectedObj;
	private SelectArea selectArea;
	private Location start;
	private boolean multiSelect;

	public SelectMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
		multiSelect = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		start = new Location(x, y);

		selectedObj = getClickedObject(e);
		canvas.unSelectAllObjects();
		if (selectedObj != null) {
			canvas.selectObject(selectedObj);
		}
		if (getClickedBasicObject(e) == null) {
			multiSelect = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int deltaX = e.getX() - start.getX();
		int deltaY = e.getY() - start.getY();

		if (selectedObj != null) {
			start = start.move(deltaX, deltaY);
			selectedObj.move(deltaX, deltaY);
		}
		if (multiSelect) {
			if (selectArea != null) {
				canvas.removeObject(selectArea);
			}
			selectArea = new SelectArea(start, new Location(e.getX(), e.getY()));
			canvas.addObject(selectArea);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(selectArea != null) {
			selectArea.selectAllObjects(canvas.getSortedObjects());
			canvas.removeObject(selectArea);
		}
		reset();
	}

	@Override
	protected void reset() {
		selectedObj = null;
		start = null;
		selectArea = null;
		multiSelect = false;
	}
}
