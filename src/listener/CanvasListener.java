package listener;

import java.awt.AWTException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mode.Mode;
import model.ToolBarModel;
import view.Canvas;

public class CanvasListener implements MouseListener, MouseMotionListener {
	private ToolBarModel model;
	private Canvas canvas;

	public CanvasListener(Canvas canvas) throws AWTException {
		this.canvas = canvas;
		this.model = ToolBarModel.getInstance();
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
		Mode mode = model.getMode();
		if (mode == null) {
			return;
		}
		mode.mousePressed(e);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Mode mode = model.getMode();
		if (mode == null) {
			return;
		}
		mode.mouseReleased(e);
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Mode mode = model.getMode();
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
