package listener;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import mode.Mode;
import mode.ModeFactory;
import mode.SelectMode;
import model.ToolBarModel;
import model.UML_Editor;
import view.ToolBar;

public class ToolBarListener implements ActionListener {
	private ToolBarModel model;
	private ToolBar toolbar;
	private ModeFactory factory;

	public ToolBarListener(ToolBarModel model, ToolBar toolbar) {
		this.toolbar = toolbar;
		this.model = model;
		try {
			factory = new ModeFactory();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = toolbar.getButtonIndex(e.getSource());
		Mode mode = factory.createMode(index);

		if (index != -1) {
			model.setMode(mode);
			toolbar.pressButton(index);
		}
	}

}
