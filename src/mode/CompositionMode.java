package mode;

import java.awt.Robot;

import model.CanvasModel;
import object.CompositionLine;
import object.ConnectionLine;
import object.Port;

public class CompositionMode extends DrawLineMode{

	public CompositionMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	protected ConnectionLine createLine(Port start, Port end) {
		return new CompositionLine(start, end);
	}

}
