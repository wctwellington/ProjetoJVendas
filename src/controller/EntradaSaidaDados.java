package controller;

import javax.swing.JOptionPane;

public class EntradaSaidaDados {

	public String entradaDados(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}
	
	public void saidaDados(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
}
