import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar{
	private JMenu fileMenu;
	private JMenu editMenu;
	
	Menu(){
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		
		initialize();
	}
	
	private void initialize() {
		setBackground(new Color(0x00BFFF));
		add(fileMenu);
		add(editMenu);
	}
}
