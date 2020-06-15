package mode;

import java.awt.AWTException;
import java.awt.Robot;

import model.CanvasModel;

public class ModeFactory {
	private CanvasModel canvas;
	private Robot robot;
	
	public ModeFactory() throws AWTException {
		canvas = CanvasModel.getInstance();
		robot = new Robot();
	}
	
	public Mode createMode(int index) {
		switch (index) {
		case 0:
			return new SelectMode(canvas, robot);
		case 1:
			return new AssociationMode(canvas, robot);
		case 2:
			return new GeneralizationMode(canvas, robot);
		case 3:
			return new CompositionMode(canvas, robot);
		case 4:
			return new ClassMode(canvas, robot);
		case 5:
			return new UseCaseMode(canvas, robot);
		default:
			return null;
		}
	}
}
