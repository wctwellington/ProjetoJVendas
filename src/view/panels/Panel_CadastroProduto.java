package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.GravarRegistros;
import model.Produto;
import persist.IGenericDAO;
import persist.TxtProdutoDAO;

@SuppressWarnings("serial")
public class Panel_CadastroProduto extends JPanel {
	
	JLabel lbRotulo, lbImagemCarrinho, lbCodBarras, lbMarca, lbDescricao, lbCategoria, lbPrecoCompra, lbPrecoVenda, lbFornecedor, lbqtde, lberro;
	JButton btCadastrar, btLimpar;
	JTextField txCodBarras, txMarca, txDescricao, txCategoria, txPrecoCompra, txPrecoVenda, txFornecedor, txqtde;
	
	public Panel_CadastroProduto() {

		lbRotulo = new JLabel("CADASTRO DE PRODUTOS");
		lbImagemCarrinho = new JLabel(new ImageIcon("images/carrinhocompra.png"));
		lbCodBarras = new JLabel("* Código de Barras");
		lbMarca = new JLabel("Marca");
		lbDescricao = new JLabel("* Descrição");
		lbCategoria = new JLabel("Categoria");
		lbPrecoCompra = new JLabel("* Preço de Compra");
		lbPrecoVenda = new JLabel("* Preço de Venda");
		lbFornecedor = new JLabel("Fornecedor");
		lbqtde = new JLabel("* Quantidade");
		lberro = new JLabel("");
		
		txCodBarras = new JTextField();
		txMarca = new JTextField();
		txDescricao = new JTextField();
		txCategoria = new JTextField();
		txPrecoCompra = new JTextField();
		txPrecoVenda = new JTextField();
		txFornecedor = new JTextField();
		txqtde = new JTextField();
		
		btCadastrar = new JButton("Cadastrar");
		btLimpar = new JButton("Limpar");

		this.setLayout(null);
		
		this.add(lbRotulo);
		lbRotulo.setBounds(220, 30, 200, 30);
		
		this.add(lbCodBarras);
		lbCodBarras.setBounds(25, 115, 150, 25);

		this.add(txCodBarras);
		txCodBarras.setBounds(160, 115, 200, 25);
		
		this.add(lbDescricao);
		lbDescricao.setBounds(25, 150, 150, 25);
		this.add(txDescricao);
		txDescricao.setBounds(160, 150, 200, 25);
		
		
		this.add(lbMarca);
		lbMarca.setBounds(25, 185, 150, 25);
		this.add(txMarca);
		txMarca.setBounds(160, 185, 200, 25);
		
		this.add(lbFornecedor);
		lbFornecedor.setBounds(25, 220, 150, 25);
		this.add(txFornecedor);
		txFornecedor.setBounds(160, 220, 200, 25);
		
		this.add(lbCategoria);
		lbCategoria.setBounds(25, 255, 150, 25);
		this.add(txCategoria);
		txCategoria.setBounds(160, 255, 200, 25);
		
		this.add(lbPrecoCompra);
		lbPrecoCompra.setBounds(25, 290, 150, 25);
		this.add(txPrecoCompra);
		txPrecoCompra.setBounds(160, 290, 200, 25);
		
		this.add(lbPrecoVenda);
		lbPrecoVenda.setBounds(25, 325, 150, 25);
		this.add(txPrecoVenda);
		txPrecoVenda.setBounds(160, 325, 200, 25);
		
		this.add(lbqtde);
		lbqtde.setBounds(25, 360, 150, 25);
		this.add(txqtde);
		txqtde.setBounds(160, 360, 80, 25);
		
		this.add(btCadastrar);
		btCadastrar.setBounds(515, 310, 120, 40);
		
		this.add(btLimpar);
		btLimpar.setBounds(515, 360, 120, 40);
		
		this.add(lbImagemCarrinho);
		lbImagemCarrinho.setBounds(390, 80, 220, 223);

		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e0) {
				
				Produto produto = new Produto();
				produto.setCod_barra(txCodBarras.getText());
				produto.setCategoria(txCategoria.getText());
				produto.setDescricao(txDescricao.getText());
				produto.setFornecedor(txFornecedor.getText());
				produto.setMarca(txMarca.getText());
				produto.setPreco_compra(Double.parseDouble(txPrecoCompra.getText()));
				produto.setPrecoVenda(Double.parseDouble(txPrecoVenda.getText()));
				produto.setQtde(Integer.parseInt(txqtde.getText()));
				
				IGenericDAO produtoDAO = new TxtProdutoDAO();
				
				if (produtoDAO.create(produto) == true) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso aqui");
				} else {
					JOptionPane.showMessageDialog(null, "Produto não pode ser cadastrado");
				}
			}
		});
		
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txCodBarras.setText("");
				txDescricao.setText("");
				txMarca.setText("");
				txFornecedor.setText("");
				txCategoria.setText("");
				txPrecoCompra.setText("");
				txPrecoVenda.setText("");
				txqtde.setText("");
				
			}
		});
	}
}
