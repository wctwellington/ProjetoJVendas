package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.EntradaSaidaDados;
import controller.ExibirRegistros;
import view.panels.Alterar_Produto;
import view.panels.Alterar_Senha;
import view.panels.Cadastro_Funcionario;
import view.panels.Panel_CadastroProduto;
import view.panels.Painel_Entrada;
import view.panels.Pesquisar_Alterar_Produto;
import view.panels.Pesquisar_Remover_Caixa;

@SuppressWarnings("serial")
public class Interface_Principal extends JFrame {

	JButton btCadastrarProduto, btCadastrarFuncionario, btPesquisarFuncionario, btExibirRelatorio, btAlterarSenha, btPesquisarProdutos, btAlterarProdutos, btSair, btSairPainel; 
	JPanel Painel, PainelBotoes; 
	JLabel lbImagemSup, lbLogo, lbLogo2;
	
	Container pane = getContentPane();
	
	public void trocarJPanel(JPanel painel) {
		
		pane.remove(Painel);
		Painel = painel;
		pane.repaint();
		pane.add(Painel);
		
		Painel.setBounds(220, 120, 660, 480);
		Painel.setBorder(BorderFactory.createEtchedBorder());
		Painel.add(btSairPainel);
		btSairPainel.setBounds(515, 420, 120, 40);
	}
	
	public Interface_Principal() {
		
		super("área Administrativa");
		
		Painel = new JPanel();
		PainelBotoes = new JPanel();
		
		lbLogo = new JLabel(new ImageIcon("images/logo.png"));
		lbImagemSup = new JLabel(new ImageIcon("images/supermercado.png"));
		lbLogo = new JLabel(new ImageIcon("images/logo_mini.png"));
		lbLogo2 = new JLabel(new ImageIcon("images/comtitulo.png"));
		
		btCadastrarProduto = new JButton("<html><p align=center>Adicionar<br />Produto</p></html>");
		btCadastrarFuncionario = new JButton("<html><p align=center>Cadastrar<br />Funcionario</p></html>");
		btPesquisarFuncionario = new JButton("<html><p align=center>Pesquisar/Remover<br />Funcionario</p></html>");
		btExibirRelatorio = new JButton("<html><p align=center>Exibir Relatório<br />Vendas</p></html>");
		btAlterarSenha = new JButton("<html><p align=center>Alterar Senha<br />Acesso</p></html>");
		btPesquisarProdutos = new JButton("<html><p align=center>Pesquisar<br />Produto</p></html>");
		btAlterarProdutos = new JButton("<html><p align=center>Alterar/Remover<br />Produtos</p></html>");
		
		btSair = new JButton("Encerrar Sessão");
		btSairPainel = new JButton("Sair");
		
		
		setSize(900, 670);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
				
		pane.add(Painel);
		Painel.setBounds(220, 120, 660, 480);
		Painel.setBorder(BorderFactory.createEtchedBorder());
		Painel.setBackground(Color.WHITE);
		
		pane.add(lbLogo);
		lbLogo.setBounds(780, 600, 100, 44);
		pane.add(lbLogo2);
		lbLogo2.setBounds(250, 10, 400, 100);
		
		
		Painel.add(lbImagemSup);
		lbImagemSup.setBounds(50, 60, 492, 470);
		
		pane.add(PainelBotoes);
		PainelBotoes.setBounds(15, 120, 200, 480);
		PainelBotoes.setBorder(BorderFactory.createEtchedBorder());
		PainelBotoes.setLayout(null);

		PainelBotoes.add(btCadastrarProduto);
		btCadastrarProduto.setBounds(25, 25, 150, 45);
		
		PainelBotoes.add(btCadastrarFuncionario);
		btCadastrarFuncionario.setBounds(25, 80, 150, 45);
		
		PainelBotoes.add(btPesquisarProdutos);
		btPesquisarProdutos.setBounds(25, 135, 150, 45);

		PainelBotoes.add(btPesquisarFuncionario);
		btPesquisarFuncionario.setBounds(25, 190, 150, 45);
				
		PainelBotoes.add(btAlterarProdutos);
		btAlterarProdutos.setBounds(25, 245, 150, 45);
		
		PainelBotoes.add(btAlterarSenha);
		btAlterarSenha.setBounds(25, 300, 150, 45);
				
		PainelBotoes.add(btSair);
		btSair.setBounds(25, 410, 150, 45);
		
		
		btCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trocarJPanel(new Panel_CadastroProduto());
	
			}
		});
		
		btPesquisarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trocarJPanel(new Pesquisar_Remover_Caixa());
				
			}
		});
		
		btPesquisarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trocarJPanel(new Pesquisar_Alterar_Produto());
				
			}
		});
	
		
		btCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trocarJPanel(new Cadastro_Funcionario());

			}
		});
		
		btAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trocarJPanel(new Alterar_Senha());
				
			}
		});
		
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sair;
				
				sair = JOptionPane.showConfirmDialog(null, "Deseja encerrar a sessão?", "Encerrar Sessão", JOptionPane.YES_NO_OPTION);
				
				if (sair == 0) {
					new Interface_Login();
					dispose();
				}
				
			}
			
		});
		
		btAlterarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String codigo;
				
				EntradaSaidaDados esd = new EntradaSaidaDados();
				codigo = esd.entradaDados("Digite o Código de Barras");

				boolean teste = codigo==null;
				
				System.out.println(teste);

				if (teste != true) {
					
					ExibirRegistros objExibir = new ExibirRegistros();
					
					String[][] registro = objExibir.exibirRegistroProduto(codigo);
					
					if(registro[0][0] != null) {
					
					try {
						File arquivotemp = new File("temp.txt");
						arquivotemp.delete();
						PrintWriter gravar = new PrintWriter(arquivotemp);
						for (int i=0; i<8; i++) {
							gravar.println((String)registro[0][i]);
						}
						gravar.close();
						trocarJPanel(new Alterar_Produto());
						
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao encontrar banco de dados");
					}
					
					}
				}				
			}
		});
		
		btSairPainel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pane.remove(Painel);
				Painel = new Painel_Entrada();
				pane.repaint();
				pane.add(Painel);
				Painel.setBounds(220, 120, 660, 480);
				Painel.setBorder(BorderFactory.createEtchedBorder());
				Painel.setBackground(Color.WHITE);

			}
		});
	}
}
