package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExibirRegistros {
	
	private static String [][] produtos = null;

	public String[][] exibirRegistroProduto(String codigo) {
		
		String [][] dados = new String[1][8];
		
		try {
			FileReader arquivo = new FileReader("produtos/" + codigo + ".txt");
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
		
		return dados;
		
	}
	
	public String[][] exibirTodosRegistrosProduto() {
			
		String [][] dados = null;
		
		try {

			File arquivos[]; 
			File diretorio = new File("produtos"); 
			arquivos = diretorio.listFiles(); 
			dados = new String[arquivos.length][8];
			for ( int i = 0; i < arquivos.length ; i++) {
				FileReader arquivo = new FileReader(arquivos[i].toString());
				BufferedReader lerArquivo = new BufferedReader(arquivo);
				for (int t = 0; t < 8; t++) {
					dados[i][t] = lerArquivo.readLine();
				}

			} 
			
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Banco de dados não encontrado!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return dados;		
		
	}
	
	public String[][] exibirRegistroFuncionarios(String codigo) {
		
		String [][] dados = new String[1][8];
		try {
			FileReader arquivo = new FileReader("funcionarios/" + codigo + ".txt");
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			while(lerArquivo.ready()) {
					for(int i=0; i<8; i++) {
						dados[0][i] = lerArquivo.readLine();
					}
				}	
						
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return dados;
	}
	
public String[][] LerTodosProdutos() {
		
		try {

			File arquivos[]; 
			File diretorio = new File("produtos"); 
			arquivos = diretorio.listFiles(); 
			produtos = new String[arquivos.length][8];
			for ( int i = 0; i < arquivos.length ; i++) {
				FileReader arquivo = new FileReader(arquivos[i].toString());
				BufferedReader lerArquivo = new BufferedReader(arquivo);
				for (int t = 0; t < 8; t++) {
					produtos[i][t] = lerArquivo.readLine();
				}

			} 
			
		} catch (FileNotFoundException e1) {
			//JOptionPane.showMessageDialog(null, "Banco de dados n�o encontrado!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return produtos;		
		
	}
	
	public static String LerUltPedido(String UltP,int Npedido){
		File Ultimo; 
		Ultimo= new File("UltPedido.txt");
		
		FileReader UltPedido = null;
		try {
			UltPedido = new FileReader(UltPedido.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader lerArquivo = new BufferedReader(UltPedido);
		try {
			UltP = lerArquivo.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Npedido = Integer.parseInt(UltP) + 1;
		return  UltP;
	}
	
	
		
}
	
