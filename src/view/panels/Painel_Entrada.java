package view.panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painel_Entrada extends JPanel {

	JLabel lbImagemSup;
	
	public Painel_Entrada() {
		
		lbImagemSup = new JLabel(new ImageIcon("images/supermercado.png"));
		
		this.setLayout(null);
		
		this.add(lbImagemSup);
		lbImagemSup.setBounds(80, 10, 492, 470);
		
	}
	
}
