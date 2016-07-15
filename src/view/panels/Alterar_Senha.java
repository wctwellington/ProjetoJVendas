package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import model.Usuario;

@SuppressWarnings("serial")
public class Alterar_Senha extends JPanel {
	
	JLabel lbSenha, lbNovaSenha, lbConfirmaSenha, lbRotulo, lbImagem;
	JPasswordField pwSenha, pwNovaSenha, pwConfirmaSenha;
	JButton btAlterar;

	Usuario objUsuario = new Usuario();
	
	public Alterar_Senha() {
				
		lbRotulo = new JLabel("ALTERAR SENHA DE ACESSO");
		lbSenha = new JLabel("Digite a senha");
		lbNovaSenha = new JLabel("Digite a nova senha");
		lbConfirmaSenha = new JLabel("Confirme a senha");
		lbImagem = new JLabel(new ImageIcon("images/senha.png"));

		pwSenha = new JPasswordField();
		pwNovaSenha = new JPasswordField();
		pwConfirmaSenha = new JPasswordField();
		
		btAlterar = new JButton("Alterar");
		
		
		this.setLayout(null);
		
		this.setBorder(BorderFactory.createEtchedBorder());
		
		this.add(lbRotulo);
		lbRotulo.setBounds(200, 50, 200, 25);
		
		this.add(lbSenha);
		lbSenha.setBounds(50, 150, 200, 25);
		this.add(pwSenha);
		pwSenha.setBounds(50, 175, 200, 25);
		
		this.add(lbNovaSenha);
		lbNovaSenha.setBounds(50, 250, 200, 25);
		this.add(pwNovaSenha);
		pwNovaSenha.setBounds(50, 275, 200, 25);
		
		this.add(lbConfirmaSenha);
		lbConfirmaSenha.setBounds(50, 310, 200, 25);
		this.add(pwConfirmaSenha);
		pwConfirmaSenha.setBounds(50, 335, 200, 25);
		
		this.add(lbImagem);
		lbImagem.setBounds(300, 130, 300, 300);
		
		this.add(btAlterar);
		btAlterar.setBounds(50, 390, 120, 40);
				
		btAlterar.addActionListener(new ActionListener() {
			private BufferedReader lerArquivologin;
			private BufferedReader lerArquivo;

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String dadoslogin = null;
				String [][] dados = new String[1][7];
				
				FileReader arquivologin;
				try {
					arquivologin = new FileReader("login.txt");
					lerArquivologin = new BufferedReader(arquivologin);
					while(lerArquivologin.ready()) {
						//for(int i=0; i<1; i++) {
							dadoslogin = lerArquivologin.readLine();
						//}
					}
				} catch (FileNotFoundException e2) {
					System.out.println("Usuário não encontrado!");
				} catch (IOException e1) {
					System.out.println("Erro While");
				}

				FileReader arquivo;
				try {
					arquivo = new FileReader("funcionarios/" + dadoslogin + ".txt");
					lerArquivo = new BufferedReader(arquivo);
					while(lerArquivo.ready()) {
						for(int i=0; i<7; i++) {
							dados[0][i] = lerArquivo.readLine();
						}
					}
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Usuário Incorreto!");
				} catch (IOException e1) {
					//System.out.println("Erro ao ler dados");
				}

					if (pwSenha.getText().equals(dados[0][6])) {
						if (pwNovaSenha.getText().equals(pwConfirmaSenha.getText())) {
							
							File arquivotemp = new File("funcionarios", dadoslogin + ".txt");
							arquivotemp.delete();
							PrintWriter gravar;
							try {
								gravar = new PrintWriter(arquivotemp);
								for (int i=0; i<6; i++) {					
									gravar.println(dados[0][i]);
								}
								gravar.println(pwNovaSenha.getText());
								gravar.close();
								
								JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
								
								pwSenha.setText("");
								pwNovaSenha.setText("");
								pwConfirmaSenha.setText("");
							} catch (FileNotFoundException e1) {
							System.out.println("Erro no código");
							}
							
							
							
						} else {
							JOptionPane.showMessageDialog(null, "As senhas não são iguais\nConfirme novamente a senha");
							pwConfirmaSenha.setText("");
							pwNovaSenha.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senha Incorreta!");
					}

	    	}		
			
		});
				
	}

}
