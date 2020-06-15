package listener;

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
	private HashMap<Integer, Mode> map;

	public ToolBarListener(ToolBarModel model, ToolBar toolbar) {
		this.toolbar = toolbar;
		this.model = model;
		factory = new ModeFactory();
		createMap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mode mode = model.getMode();
		int index = toolbar.getButtonIndex(e.getSource());

		if (index != -1) {
			if (mode != null) {
				toolbar.releaseButton(getModeIndex(mode));
			}
			model.setMode(map.get(index));
			toolbar.pressButton(index);
		}
	}

	private void createMap() {
		map = new HashMap<Integer, Mode>();
		map.put(0, new SelectMode());
	}

	private int getModeIndex(Mode mode) {
		Set<Integer> keyset = map.keySet();
		for (int i : keyset) {
			if (map.get(i).equals(mode)) {
				return i;
			}
		}
		return -1;
	}

}
