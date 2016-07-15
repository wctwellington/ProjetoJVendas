package persist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Produto;

public class TxtProdutoDAO implements IGenericDAO {

	@Override
	public Boolean create(Object object) {

		Produto produto = (Produto) object;
		PrintWriter gravar;

		File arquivo = new File("bancoDados/produtos/", produto.getCod_barra() + ".txt");
		try {
			gravar = new PrintWriter(arquivo);
			gravar.println(produto.getCod_barra());
			gravar.println(produto.getDescricao());
			gravar.println(produto.getMarca());
			gravar.println(produto.getFornecedor());
			gravar.println(produto.getCategoria());
			gravar.println(Double.toString(produto.getPreco_compra()));
			gravar.println(Double.toString(produto.getPrecoVenda()));
			gravar.println(Integer.toString(produto.getQtde()));
			gravar.close();
			
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Object read(Object pk) {
				
		try {
			FileReader arquivo = new FileReader("bancoDados/produtos/" + pk + ".txt");
			
			if (arquivo.ready()) {
				BufferedReader lerArquivo = new BufferedReader(arquivo);
				Produto produto = new Produto();
				produto.setCod_barra(lerArquivo.readLine());
				produto.setDescricao(lerArquivo.readLine());
				produto.setMarca(lerArquivo.readLine());
				produto.setFornecedor(lerArquivo.readLine());
				produto.setCategoria(lerArquivo.readLine());
				produto.setPreco_compra(Double.parseDouble(lerArquivo.readLine()));
				produto.setPrecoVenda(Double.parseDouble(lerArquivo.readLine()));
				produto.setQtde(Integer.parseInt(lerArquivo.readLine()));
				
				lerArquivo.close();
				return produto;
			}
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Boolean update(Object object) {
		
		Produto produto = (Produto) object;
		PrintWriter gravar;

		File arquivo = new File("bancoDados/produtos/", produto.getCod_barra() + ".txt");
		try {
			gravar = new PrintWriter(arquivo);
			gravar.println(produto.getCod_barra());
			gravar.println(produto.getDescricao());
			gravar.println(produto.getMarca());
			gravar.println(produto.getFornecedor());
			gravar.println(produto.getCategoria());
			gravar.println(Double.toString(produto.getPreco_compra()));
			gravar.println(Double.toString(produto.getPrecoVenda()));
			gravar.println(Integer.toString(produto.getQtde()));
			gravar.close();
			
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Boolean delete(Object pk) {
		File arquivo = new File("bancoDados/produtos/", pk + ".txt");
		arquivo.delete();
		return true;
	}

	@Override
	public ArrayList<Object> readAll() {
		
		try {
			
			ArrayList<Object> listaProdutos = new ArrayList<Object>();
			File diretorio = new File("bancoDados/produtos"); 
			File[] arquivos = diretorio.listFiles();
			
			for ( int i = 0; i < arquivos.length ; i++) {
				FileReader arquivo = new FileReader(arquivos[i].toString());
				BufferedReader lerArquivo = new BufferedReader(arquivo);
				
				Produto produto = new Produto();
				produto.setCod_barra(lerArquivo.readLine());
				produto.setDescricao(lerArquivo.readLine());
				produto.setMarca(lerArquivo.readLine());
				produto.setFornecedor(lerArquivo.readLine());
				produto.setCategoria(lerArquivo.readLine());
				produto.setPreco_compra(Double.parseDouble(lerArquivo.readLine()));
				produto.setPrecoVenda(Double.parseDouble(lerArquivo.readLine()));
				produto.setQtde(Integer.parseInt(lerArquivo.readLine()));
				
				listaProdutos.add(produto);
			} 
			
			if (listaProdutos.isEmpty()) {
				return listaProdutos;
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
}
