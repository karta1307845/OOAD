package listener;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import event.DrawLineEvent;
import event.DrawRectangleEvent;
import event.Event;
import event.MoveEvent;
import event.SelectEvent;
import model.ClassObject;
import model.Location;
import model.ShapeObject;
import model.UML_Editor;
import model.UseCaseObject;
import view.Canvas;

public class CanvasListener implements MouseListener, MouseMotionListener {
	private Robot robot;
	private UML_Editor editor;
	private Canvas canvas;

	private Event select;
	private Event multiSelect;
	private Event action;

	public CanvasListener(UML_Editor editor, Canvas canvas) throws AWTException {
		this.canvas = canvas;
		this.editor = editor;
		robot = new Robot();
		select = new SelectEvent(editor, robot);
		multiSelect = new DrawRectangleEvent(editor, robot);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();

		switch (mode) {
		case 0:
			select.press(e);
			break;
		case 4:
			ShapeObject obj;
			obj = new ClassObject(new Location(x, y));
			editor.addObject(obj);
			break;
		case 5:
			obj = new UseCaseObject(new Location(x, y));
			editor.addObject(obj);
			break;
		}
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mode = editor.getMode();

		switch (mode) {
		case 0:
			action = new MoveEvent(editor, robot);
			action.press(e);
			multiSelect.press(e);
			break;
		case 1:
		case 2:
		case 3:
			action = new DrawLineEvent(editor, robot, mode);
			action.press(e);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (action != null) {
			action.release(e);
			action = null;
		}
		multiSelect.release(e);

		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (action != null) {
			action.drag(e);
		}
		multiSelect.drag(e);

		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}
}
