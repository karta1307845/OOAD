import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	private List<JButton> buttonList;

	Toolbar() {
		buttonList = new ArrayList<JButton>();
		setLayout(new GridLayout(6, 1,5,5));
		
		for(int i=1; i<=6; i++) {
			Icon icon = new ImageIcon("images/tool"+i+".png");
			JButton btn = new JButton(icon);
			btn.setPreferredSize(new Dimension(40,40));
			btn.setFocusPainted(false);
			btn.setContentAreaFilled(false);
			buttonList.add(btn);
		}

		initialize();
	}

	private void initialize() {
		setBackground(new Color(0xB0C4DE));
		for(JButton i:buttonList) {
			add(i);
		}
	}
}
