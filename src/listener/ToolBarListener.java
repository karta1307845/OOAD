package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.UML_Editor;
import view.ToolBar;

public class ToolBarListener implements ActionListener {
	private UML_Editor editor;
	private ToolBar toolbar;

	public ToolBarListener(UML_Editor editor, ToolBar toolbar) {
		this.toolbar = toolbar;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mode = editor.getMode();
		int index = toolbar.getButtonIndex(e.getSource());

		if (index != -1) {
			if (mode != -1) {
				toolbar.releaseButton(mode);
			}
			editor.setMode(index);
			toolbar.pressButton(index);
		}
	}

}
