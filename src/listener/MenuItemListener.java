package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.CanvasModel;
import view.ToolBar;

public class MenuItemListener implements ActionListener{
	protected CanvasModel model;
	protected JPanel canvas;
	protected ToolBar toolbar;
	
	public MenuItemListener(JPanel canvas, ToolBar toolbar) {
		this.canvas = canvas;
		this.toolbar = toolbar;
		model = CanvasModel.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
