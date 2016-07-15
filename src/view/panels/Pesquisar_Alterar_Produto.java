package view.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.EntradaSaidaDados;
import controller.ExibirRegistros;

@SuppressWarnings("serial")
public class Pesquisar_Alterar_Produto extends JPanel {
	
	String codigo;
	
	String[] coluna = {"Cod Barras", "Descrição", "Marca", "Fornecedor", "Categora", "Preço Compra", "Preço Venda", "Qtde"};
	
	JLabel lbRotulo;
	static JPanel PainelTabela;
	static JScrollPane scroll;
	JButton btPesquisar, btExibir;
	EntradaSaidaDados esd;
	static JTable tabela;
	
	ExibirRegistros objExibir = new ExibirRegistros();
		
	@SuppressWarnings("deprecation")
	static void apresentarTabela(String[][] dados, String[] coluna) {
		//scroll.removeAll();
		tabela = new JTable(dados, coluna);
		tabela.disable();
		scroll = new JScrollPane(tabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	
		PainelTabela.add(scroll);
		scroll.setBounds(0, 0, 620, 320);
	}
	
	public Pesquisar_Alterar_Produto() {
		
		esd = new EntradaSaidaDados();

		PainelTabela = new JPanel();
		lbRotulo = new JLabel("PESQUISAR PRODUTOS");
		scroll = new JScrollPane();
		
		btPesquisar = new JButton("<html><p align=center>Pesquisar<br />Produto</p></html>");
		btExibir = new JButton("<html><p align=center>Todos<br />Produtos</p></html>");
		
		this.setLayout(null);
		PainelTabela.setLayout(new GridLayout(1, 1));
		
		this.add(lbRotulo);
		lbRotulo.setBounds(230, 30, 300, 30);
				
		this.add(PainelTabela);
		PainelTabela.setBounds(20, 80, 620, 320);
		PainelTabela.setBorder(BorderFactory.createEtchedBorder());
				
		this.add(btPesquisar);
		btPesquisar.setBounds(20, 420, 100, 40);
		
		this.add(btExibir);
		btExibir.setBounds(140, 420, 100, 40);

		
		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigo = esd.entradaDados("Digite o Código de Barras");
				
				if (codigo != null) {
					if (objExibir.exibirRegistroProduto(codigo)[0][0]!= null) {
						PainelTabela.removeAll();
						apresentarTabela(objExibir.exibirRegistroProduto(codigo), coluna);
					}
				}

			}

		});
				
		btExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				PainelTabela.removeAll();
				
				apresentarTabela(objExibir.exibirTodosRegistrosProduto(), coluna);
				
			}
		});	
	}
}


			
		
	

								
			
		

