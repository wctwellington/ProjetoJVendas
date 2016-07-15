package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.GravarRegistros;

@SuppressWarnings("serial")
public class Alterar_Produto extends Panel_CadastroProduto {
		
	JPanel PainelAlterar;
	JLabel lbRotulo;
	JButton btAlterar, btRemover;

	Panel_CadastroProduto objCadastrar = new Panel_CadastroProduto();
	GravarRegistros objGravar = new GravarRegistros();
	
	public Alterar_Produto() {

		lbRotulo = new JLabel("ALTERAR / REMOVER PRODUTOS");
		btAlterar = new JButton("Alterar");
		btRemover = new JButton("Remover");
		
		PainelAlterar.remove(objCadastrar.btCadastrar);
		PainelAlterar.remove(objCadastrar.lbRotulo);
		PainelAlterar.remove(objCadastrar.btLimpar);
		
		PainelAlterar.setLayout(null);
		
		PainelAlterar.add(lbRotulo);
		lbRotulo.setBounds(200, 30, 250, 30);
		
		PainelAlterar.add(btAlterar);
		btAlterar.setBounds(515, 310, 120, 40);
		
		PainelAlterar.add(btRemover);
		btRemover.setBounds(515, 360, 120, 40);

		String [][] dados = new String[1][8];
		
		try {
			FileReader arquivo = new FileReader("temp.txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);

			while(lerArquivo.ready()) {
					for(int i=0; i<8; i++) {
						dados[0][i] = lerArquivo.readLine();
					}
				}	
			
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		} catch (IOException e1) {
			System.out.println("Erro codigo");
		}

		objCadastrar.txCodBarras.setText(dados[0][0]);
		objCadastrar.txCodBarras.setEditable(false);
		objCadastrar.txDescricao.setText(dados[0][1]);
		objCadastrar.txMarca.setText(dados[0][2]);
		objCadastrar.txFornecedor.setText(dados[0][3]);
		objCadastrar.txCategoria.setText(dados[0][4]);
		objCadastrar.txPrecoCompra.setText(dados[0][5]);
		objCadastrar.txPrecoVenda.setText(dados[0][6]);
		objCadastrar.txqtde.setText(dados[0][7]);

		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objGravar.AlterarProduto(objCadastrar.txCodBarras, objCadastrar.txDescricao, objCadastrar.txMarca, objCadastrar.txFornecedor, objCadastrar.txCategoria, objCadastrar.txPrecoVenda, objCadastrar.txPrecoCompra, objCadastrar.txqtde);

			}
		
			
		});
		
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao_rv = objGravar.removerProduto((String)dados[0][0]);

				if(opcao_rv == 0) {
				
				}
				
			}
			
		});
		
	}	
}
