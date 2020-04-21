package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import listener.CanvasListener;
import model.UML_Editor;
import model.UML_Object;

public class Canvas extends JPanel {
	public static final int objectColor = 0xDDDDDD;
	private UML_Editor editor;
	private CanvasListener listener;

	Canvas(UML_Editor editor) throws AWTException {
		this.editor = editor;
		listener = new CanvasListener(editor, this);
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
		UML_Object[] objects = editor.getSortedObject();
		for (UML_Object i : objects) {
			i.draw(g);
		}
	}

}
