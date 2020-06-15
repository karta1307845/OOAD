package mode;

import java.awt.Robot;

import model.CanvasModel;
import object.ConnectionLine;
import object.GeneralizationLine;
import object.Port;

public class GeneralizationMode extends DrawLineMode{

	public GeneralizationMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	protected ConnectionLine createLine(Port start, Port end) {
		return new GeneralizationLine(start, end);
	}

}
