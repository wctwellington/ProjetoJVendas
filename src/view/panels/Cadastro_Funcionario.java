package view.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.GravarRegistros;

@SuppressWarnings("serial")
public class Cadastro_Funcionario extends JPanel {
	
	JLabel lbRotulo, lbCod_Funcionario, lbNome, lbEndereco, lbTelefone, lbCelular, lbFuncao, lbSenha, lbConfirmarSenha, lbObservacao, lbImagemFuncionario;
	JTextField txtCod_Funcionario, txtNome, txtEndereco, txtTelefone, txtCelular, txtSalario;
	@SuppressWarnings("rawtypes")
	JComboBox bxFuncao;
	JPasswordField pwSenha, pwConfirmarSenha;
	JButton btCadastrar, btLimpar;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Cadastro_Funcionario() {
				
		lbRotulo = new JLabel("CADASTRAR FUNCIONÁRIO");
		lbCod_Funcionario = new JLabel("*Cod. Funcionario");
		lbNome = new JLabel("*Nome");
		lbEndereco = new JLabel("Endereco");
		lbTelefone = new JLabel("Telefone");
		lbCelular = new JLabel("Celular");
		lbFuncao = new JLabel("Função");
		lbSenha = new JLabel("Senha");
		lbConfirmarSenha = new JLabel("Confirme a Senha");
		lbObservacao = new JLabel("<html>Observação: O login do funcionário será o seu Codigo.</html>");
		lbImagemFuncionario = new JLabel(new ImageIcon("images/funcionario.png"));
		
		txtCod_Funcionario = new JTextField();
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtTelefone = new JTextField();
		txtCelular = new JTextField();
		txtSalario = new JTextField();
		
		bxFuncao = new JComboBox();
		bxFuncao.setBackground(Color.WHITE);
		bxFuncao.addItem("Selecione uma função");
		bxFuncao.addItem("Caixa");
		bxFuncao.addItem("Administrador");
		
		pwSenha = new JPasswordField();
		pwConfirmarSenha = new JPasswordField();
		
		btCadastrar = new JButton("Cadastrar");
		btLimpar = new JButton("Limpar");
		
		this.setLayout(null);
		
		this.add(lbRotulo);
		lbRotulo.setBounds(220, 30, 200, 30);
		
		this.add(lbCod_Funcionario);
		lbCod_Funcionario.setBounds(25, 115, 150, 25);
		this.add(txtCod_Funcionario);
		txtCod_Funcionario.setBounds(165, 115, 200, 25);
		
		this.add(lbNome);
		lbNome.setBounds(25, 150, 150, 25);
		this.add(txtNome);
		txtNome.setBounds(165, 150, 200, 25);
		
		
		this.add(lbEndereco);
		lbEndereco.setBounds(25, 185, 150, 25);
		this.add(txtEndereco);
		txtEndereco.setBounds(165, 185, 200, 25);
		
		this.add(lbTelefone);
		lbTelefone.setBounds(25, 220, 150, 25);
		
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no codigo de barras");
		}
		
		this.add(txtTelefone);
		txtTelefone.setBounds(165, 220, 200, 25);
		
		this.add(lbCelular);
		lbCelular.setBounds(25, 255, 150, 25);
		
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no codigo de barras");
		}
		
		this.add(txtCelular);
		txtCelular.setBounds(165, 255, 200, 25);
		
		this.add(lbFuncao);
		lbFuncao.setBounds(25, 290, 150, 25);
				
		this.add(bxFuncao);
		bxFuncao.setBounds(165, 290, 200, 25);
				
		this.add(lbSenha);
		lbSenha.setBounds(25, 325, 150, 25);
		this.add(pwSenha);
		pwSenha.setBounds(165, 325, 150, 25);
		
		this.add(lbConfirmarSenha);
		lbConfirmarSenha.setBounds(25, 360, 150, 25);
		this.add(pwConfirmarSenha);
		pwConfirmarSenha.setBounds(165, 360, 150, 25);
		
		this.add(lbObservacao);
		lbObservacao.setBounds(25, 410, 320, 30);
						
		this.add(btCadastrar);
		btCadastrar.setBounds(515, 310, 120, 40);
		
		this.add(btLimpar);
		btLimpar.setBounds(515, 360, 120, 40);
		
		this.add(lbImagemFuncionario);
		lbImagemFuncionario.setBounds(430, 120, 128, 128);
		
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GravarRegistros objGravar = new GravarRegistros();
				
				objGravar.gravarFuncionario(txtCod_Funcionario, txtNome, txtEndereco, txtTelefone, txtCelular, bxFuncao, pwSenha, pwConfirmarSenha);
				
			}
		});
		
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCod_Funcionario.setText("");
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
				bxFuncao.setSelectedItem("Selecione uma função");
				pwSenha.setText("");
				pwConfirmarSenha.setText("");
				
			}
		});
	}
}
