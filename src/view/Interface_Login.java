package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Splash;

public class Interface_Login extends JFrame{

	    JLabel lbUsuario = new JLabel("Usuario");
	    JTextField txtUsuario = new JTextField();
	    JLabel lbSenha = new JLabel("Senha");
	    JPasswordField pwSenha = new JPasswordField();
	    JButton btEntrar = new JButton("Logar");
	    JButton btSair = new JButton("Sair");
	    JLabel lbImagem =  new JLabel(new javax.swing.ImageIcon("images/senha.png"));
	    
	   
	    
	    public static String usuario;
	    String senha;
	    
	    public Interface_Login() {
	   
	    	super("Login");
	    	
	    	Container pane = getContentPane();
	    	pane.setLayout(null);
	    	setSize(600, 400);
	    	setVisible(true);
	 	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	   
	 	    setResizable(false);
	 	    setLocationRelativeTo(null);
	 	   
	    
	    
	    pane.add(lbUsuario);
	    lbUsuario.setBounds(300, 120, 60, 30);
	    
	    pane.add(txtUsuario);
	    txtUsuario.setBounds(370, 120, 200, 30);
	    
	    pane.add(lbSenha);
	    lbSenha.setBounds(300, 160, 60, 30);
	    
	    pane.add(pwSenha);
	    pwSenha.setBounds(370, 160, 200, 30);
	    
	    pane.add(btEntrar);
	    btEntrar.setBounds(450, 230, 120, 40);
	    
	    pane.add(btSair);
	    btSair.setBounds(450, 280, 120, 40);
	    
	    pane.add(lbImagem);
	    lbImagem.setBounds(20, 40, 300, 300);

	    
	    btEntrar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    			    		
	    		usuario = txtUsuario.getText();
	    		senha = pwSenha.getText();
	    		
	    		
	    		
				FileReader arquivo;
				try {
					arquivo = new FileReader("bancoDados/funcionarios/" + usuario + ".txt");
					BufferedReader lerArquivo = new BufferedReader(arquivo);
					String [][] dados = new String[1][7];
					while(lerArquivo.ready()) {
						for(int i=0; i<7; i++) {
							dados[0][i] = lerArquivo.readLine();
						}
					}
					
					if (senha.equals(dados[0][6])) {
						if (dados[0][5].equals("Administrador")) {
							
							File arquivologin = new File("login.txt");
							arquivologin.delete();
							PrintWriter gravar = new PrintWriter(arquivologin);
							gravar.println(usuario);
							gravar.close();
							
							Interface_Principal objInterfacePrincipal = new Interface_Principal(); 
							dispose();

						} else if (dados[0][5].equals("Caixa")) {
							
							view.Interface_Principal_Vendas objVendas = new view.Interface_Principal_Vendas();	
							dispose();
						
						}
					} else {
						JOptionPane.showMessageDialog(null, "Senha Incorreta!");
					}
					

				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Usuário Incorreto!");
				} catch (IOException e1) {
					System.out.println("Erro ao ler dados");
				}
	    	}

	    });
	    
	    btSair.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION);
	    		
	    		if (sair == 0) {
	    				    			
	    			System.exit(0);
	    		}
	    		
	    	}
	    });
	    
	    }
	       
	    public static void main(String[] args) throws InterruptedException {
	    	new Splash();
	        new Interface_Login();
	        
	    } 
	}

