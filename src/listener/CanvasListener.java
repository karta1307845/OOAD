package listener;

import java.awt.AWTException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mode.Mode;
import model.CanvasModel;
import model.ToolBarModel;
import view.Canvas;

public class CanvasListener implements MouseListener, MouseMotionListener {
	private CanvasModel model;
	private Canvas canvas;
	private ToolBarModel toolbarModel;

	public CanvasListener(CanvasModel model, Canvas canvas, ToolBarModel toolbarModel) throws AWTException {
		this.canvas = canvas;
		this.model = model;
		this.toolbarModel = toolbarModel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
		Mode mode = toolbarModel.getMode();
		if (mode == null) {
			return;
		}
		mode.mousePressed(e);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Mode mode = toolbarModel.getMode();
		if (mode == null) {
			return;
		}
		mode.mouseReleased(e);
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Mode mode = toolbarModel.getMode();
		if (mode == null) {
			return;
		}
		mode.mouseDragged(e);
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}
}
