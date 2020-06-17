package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import listener.CanvasListener;
import model.CanvasModel;
import object.UML_Object;

public class Canvas extends JPanel {
	public static final int objectColor = 0xDDDDDD;
	private CanvasModel model;
	private CanvasListener listener;

	Canvas() throws AWTException {
		model = CanvasModel.getInstance();
		listener = new CanvasListener(this);
		initialize();
	}

	private void initialize() {
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void draw(UML_Object obj) {
		Graphics g = getGraphics();
		obj.draw(g);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		UML_Object[] objects = model.getSortedObject();
		for (UML_Object i : objects) {
			i.draw(g);
		}
	}

}
