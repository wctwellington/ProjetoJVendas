package view;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ExibirRegistros;
import controller.Gravartxt;

public class Interface_Principal_Vendas extends JFrame {

	JButton btSair,btnadicionar,btnFinalizar,btnRemoveItem,btnCancelPe; 
	JPanel Painel,PainelInserir,PainelTotal;
	JTextField txCodBarras, txtNome, txPreco,txQtde,txtCEF;
	JLabel lblCodBarras,lblUsuario,lblpainelCodBarras,lblpainelPreco,lblpainelNome,lblNome,lblPreco,lblQtde,lblpainelQtde,lblpainelTotalPreco,lblTotal,lblCEF,lblDadosU,lblUsuarioI,lblUsuarioII,lblValorTotal,lblBanner;
	JTable tabela;
	JScrollPane barraRolagem;
	String codigo,linha,CPF,UltPedido;
	double ValorTotal =0.00;
	double TempValorTotal =0.00;
	int tempcont,Npedido;
	Gravartxt Gravar;
	String [][] dados = new String[5][5];
	
	String [][] pedido = new String[100][5];
	
	
	
	String [] colunas = {"Cod.Barras", "Nome", "Pre�o","Qtde","SubTotal"};
	
	Container pane = getContentPane();
	
	
	public Interface_Principal_Vendas() {
		
		super("Estrela De Ouro");
				
		lblUsuario = new JLabel(new ImageIcon("usuarioF.png"));
		lblBanner = new JLabel(new ImageIcon("logo2.png"));
		
		txCodBarras = new JTextField();
				
		lblTotal = new JLabel("Valor Total:");
		lblValorTotal = new JLabel(Double.toString(ValorTotal));
		lblCEF = new JLabel("CPF");
	
		
		
		lblpainelQtde = new JLabel(" Qtde.");
		lblCodBarras = new JLabel("Código de Barras");
		lblNome = new JLabel("Nome");
		lblPreco = new JLabel("Preço");
		lblQtde = new JLabel("Quantidade");
		
		
		lblDadosU = new JLabel("Dados do Funcionario");
		lblUsuarioI = new JLabel("Nome: ");
		lblUsuarioII = new JLabel("Cód.Caixa: ");
	
		
		Painel = new JPanel();
		PainelInserir = new JPanel();		
		PainelTotal = new JPanel();
		
		
		btnadicionar = new JButton("<html><p align=center>Adicionar<br />Produto</p></html>");
		btnFinalizar = new JButton("Finalizar Compra" );
		btSair = new JButton("Sair");
		btnRemoveItem = new JButton("<html><p align=center>Remover<br />Item</p></html>");
		btnCancelPe = new JButton("<html><p align=center>Cancelar<br />Pedido</p></html>");
		
		Container pane = getContentPane();
		setSize(780, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		/* Inserir icone no sistema */
		//Toolkit � um kit de ferramentas
		
		java.net.URL url = this.getClass().getResource("imagem.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(imagemTitulo);
		
		ExibirRegistros objExibir = new ExibirRegistros();
		objExibir.LerTodosProdutos();
		String [][] produtos = objExibir.LerTodosProdutos();
		
		
		
		tabela = new JTable(pedido, colunas);
		barraRolagem = new JScrollPane(tabela);
		tabela.disable();
		
		
		// Inser��o dos componentes do Painel Lateral
		
		PainelInserir.setLayout(null);
		
		//Insers�o de Bot�es no PainelInserir
		 
		PainelInserir.add(btnFinalizar);
		btnFinalizar.setBounds(5,305,220,40);
		btnFinalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			//	objExibir.LerUltPedido(UltPedido,Npedido);

				int cont = 0;
				
				int Sair ;
				
				Sair = JOptionPane.showConfirmDialog(null,"Deseja Finalizar o pedido ? ","Fechar",JOptionPane.YES_NO_OPTION);
				
				if (Sair == 0){
					CPF = txtCEF.getText();
					try {
						Gravar.Gravar_txt(Npedido, UltPedido, CPF);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.out.println(CPF);

					for(int i=0;i<100;i++){
						
						pedido[cont][0] = "";
						pedido[cont][1] = "";
						pedido[cont][2] = "";
						pedido[cont][3] = "";
						pedido[cont][4] = "";
						ValorTotal = 0.0;
						lblValorTotal.setText(Double.toString(ValorTotal));
						cont++;
						Painel.repaint();
						PainelTotal.repaint();
						}
					System.exit(0);
					
				}
			}
		});
		
		PainelInserir.add(btnadicionar);
		btnadicionar.setBounds(10,118,118,30);
		/*btnadicionar.setMnemonic(KeyEvent.VK_ENTER);
		this.getRootPane().setDefaultButton(btnadicionar);*/
		btnadicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				codigo = txCodBarras.getText();
				int Qtd = Integer.parseInt(txQtde.getText());
				txQtde.setText("");
				txCodBarras.setText("");
				double Valor=0.0;
				int cont=1;
				do{		
					//Responsavel por localizar o C�digo de Barras nos registros		
					if(codigo.equals(produtos[cont][0])){
						
						dados[1][0] = produtos[cont][0];
						dados[1][1] = produtos[cont][1];
						dados[1][2] = produtos[cont][6];
						
						cont=101;
					}
					else{
						cont++;
					}
					
				}while(cont<100);
				int X =0;
				//Resonsavel por atualizar o painel caso o mesmo(painel) j� esteja com o C�digo de Barras
				for(int i=0;i<100;i++){
				if(codigo.equals(pedido[X][0])){
					Qtd = Qtd + (Integer.parseInt(pedido[X][3]));
					
					pedido[X][3] = Integer.toString(Qtd);
					Valor = Valor + Double.parseDouble(pedido[X][2]);
					
					ValorTotal = ValorTotal - (Double.parseDouble(pedido[X][4]));//Responsavel por atualizar o valor Total do pedido
					pedido[X][4] = Double.toString(Qtd * 1.0* Valor);
					
					//Responsavel por atualizar o valor Total do pedido
					
					TempValorTotal = (Double.parseDouble(pedido[X][4]));
					ValorTotal = ValorTotal + TempValorTotal;
					System.out.println(ValorTotal);
					
					lblValorTotal.setText(Double.toString(ValorTotal));	
					
					Painel.repaint();
					PainelTotal.repaint();
					i=101;
					}
				else{	//Resonsavel por atualizar o painel caso o mesmo(painel) n�o esteja com o C�digo de Barras

					if(pedido[X][0]==null||pedido[X][0]==""){
					pedido[X][0] = dados[1][0];
					pedido[X][1] = dados[1][1];
					pedido[X][2] = dados[1][2];
					Valor = Double.parseDouble(dados[1][2]);
					pedido[X][3] = Integer.toString(Qtd);
					pedido[X][4] = Double.toString(Qtd * 1.0* Valor);
					//Responsavel por atualizar o valor Total do pedido
					TempValorTotal = (Double.parseDouble(pedido[X][4]));
					
					ValorTotal = ValorTotal + TempValorTotal;
					System.out.println(ValorTotal);
					lblValorTotal.setText(Double.toString(ValorTotal));					
					Painel.repaint();
					PainelTotal.repaint();
				
					i=100;
				}
					else X++;
				}
				
					
			}		
		}
	});
		
		PainelInserir.add(btnRemoveItem);
		btnRemoveItem.setBounds(5,226,220,35);
		btnRemoveItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			codigo = JOptionPane.showInputDialog("Digite o C�d.Barras Que deseja Deletar");
			int cont=0;
				do{				
					if(codigo.equals(pedido[cont][0])){
						
					ValorTotal = ValorTotal - (Double.parseDouble(pedido[cont][4]));
					System.out.println(ValorTotal);
					
					lblValorTotal.setText(Double.toString(ValorTotal));	
					PainelTotal.repaint();
					
					pedido[cont][0] = "";
					pedido[cont][1] = "";
					pedido[cont][2] = "";
					pedido[cont][3] = "";
					pedido[cont][4] = "";
					tempcont = cont;
					Painel.repaint();
					
					cont=100;
				}
					else cont++;
		}while(cont<100);
				
				for(int i=0;i<100;i++){
					
					if(pedido[tempcont+1][0]!="" ||pedido[tempcont+1][0]!=null){
					pedido[tempcont][0] = pedido[tempcont+1][0];
					pedido[tempcont][1] = pedido[tempcont+1][1];
					pedido[tempcont][2] = pedido[tempcont+1][2];
					pedido[tempcont][3] = pedido[tempcont+1][3];
					pedido[tempcont][4] = pedido[tempcont+1][4];
									
				}
					else i = 101;
			}		
				pedido[tempcont+1][0] = "";
				pedido[tempcont+1][1] = "";
				pedido[tempcont+1][2] = "";
				pedido[tempcont+1][3] = "";
				pedido[tempcont+1][4] = "";	
				
				Painel.repaint();
			}
		
	});
		
		
		PainelInserir.add(btnCancelPe);
		btnCancelPe.setBounds(5,263,220,40);
		btnCancelPe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int cont = 0;
				
				int Sair ;
				
				Sair = JOptionPane.showConfirmDialog(null,"Deseja Cancelar o pedido ? ","Fechar",JOptionPane.YES_NO_OPTION);
				
				if (Sair == 0){
					for(int i=0;i<100;i++){
						
					pedido[cont][0] = "";
					pedido[cont][1] = "";
					pedido[cont][2] = "";
					pedido[cont][3] = "";
					pedido[cont][4] = "";
					System.out.println(pedido[cont][i]);
					ValorTotal = 0.0;
					lblValorTotal.setText(Double.toString(ValorTotal));
					cont++;
					Painel.repaint();
					PainelTotal.repaint();
					}
			
					
				}
			}
		});
		
		//Insers�o de Labels e TextFields no PainelInserir
		PainelInserir.add(lblCodBarras);
		lblCodBarras.setBounds(10, 1, 110, 40);
		
		/*try{
			txCodBarras = new JFormattedTextField(new MaskFormatter("#############"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "C�digo de Barras invalido");
		}*/
		
		PainelInserir.add(txCodBarras);
		txCodBarras.setBounds(10, 30, 150, 25);
		txCodBarras.addKeyListener(new KeyAdapter(){
			public void KeyTyped(KeyEvent ev){
				String caracteres = "0987654321";
					if(!caracteres.contains(ev.getKeyChar()+"")){
						ev.consume();
						
					}
			
		
			}
		});
		
		PainelInserir.add(lblQtde);
		lblQtde.setBounds(10, 60, 110, 40);
		
		try{
			txQtde = new JFormattedTextField(new MaskFormatter("#" ));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		PainelInserir.add(txQtde);
		txQtde.setBounds(10, 90, 60, 25);	
		
	
		//Inser��o dos componentes do Painel Principal
		
		Painel.setLayout(new GridLayout(1, 1));
		
		Painel.add(barraRolagem);
		
		
		//Insers�o dos componentes do PainelTotal
		PainelTotal.setLayout(null);
		
		PainelTotal.add(lblTotal);
		lblTotal.setBounds(300, 0, 120, 80);
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));  
		
		
		PainelTotal.add(lblValorTotal);
		lblValorTotal.setBounds(420, 25, 90, 27);
		lblValorTotal.setFont(new Font("Dialog", Font.BOLD, 20));  
		
		
		PainelTotal.add(lblCEF);
		lblCEF.setBounds(5, -28, 120, 80);
		lblCEF.setFont(new Font("Arial", Font.PLAIN, 18));
		
		try{
			txtCEF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		PainelTotal.add(txtCEF);
		txtCEF.setBounds(5, 26, 100, 25);
		
		
		pane.add(lblBanner);
		//lblBanner.setBorder(BorderFactory.createEtchedBorder());
		lblBanner.setBounds(260,0,400,120);	
		
		pane.add(lblUsuario);
		lblUsuario.setBorder(BorderFactory.createEtchedBorder());
		lblUsuario.setBounds(10,3,128,115);	
		
		pane.add(lblDadosU);
		lblDadosU.setBounds(10, 120, 230, 25);
		
		pane.add(lblUsuarioI);
		lblUsuarioI.setBounds(10, 145, 230, 25);
		
		pane.add(lblUsuarioII);
		lblUsuarioII.setBounds(10, 170, 230, 25);		
		
		pane.add(Painel);
		Painel.setBounds(250, 120, 512, 380);
		Painel.setBorder(BorderFactory.createEtchedBorder());
		Painel.setBackground(Color.WHITE);
		
		pane.add(PainelTotal);
		PainelTotal.setBounds(250, 500, 512, 55);
		PainelTotal.setBorder(BorderFactory.createEtchedBorder());
		PainelTotal.setBackground(new Color(238,238,238));
		
		pane.add(PainelInserir);
		PainelInserir.setBounds(10, 205, 230, 350);
		PainelInserir.setBorder(BorderFactory.createEtchedBorder());
		PainelInserir.setBackground(Color.WHITE);
		
		
		
	}
	
}
