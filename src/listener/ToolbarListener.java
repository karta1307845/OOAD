package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.UML_Editor;
import view.Toolbar;

public class ToolbarListener implements ActionListener {
	private UML_Editor editor;
	private Toolbar toolbar;

	public ToolbarListener(Toolbar toolbar) {
		this.toolbar = toolbar;
		editor = toolbar.getEditor();
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
