package mode;

import java.awt.Robot;

import model.CanvasModel;
import object.AssociationLine;
import object.ConnectionLine;
import object.Port;

public class AssociationMode extends DrawLineMode {

	public AssociationMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	protected ConnectionLine createLine(Port start, Port end) {
		return new AssociationLine(start, end);
	}
}
