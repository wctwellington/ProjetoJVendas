package model;

import javax.swing.JOptionPane;

public class Produto {
	
	private int qtde; 
	private String descricao, marca, categoria, Fornecedor, cod_barra;
	private double preco_compra, PrecoVenda;
	
	
	public int getQtde() {
		return qtde;
	}
	
	public void setQtde(int qtde) {
		this.qtde = qtde;;
	}
	
	public String getCod_barra() {
		return cod_barra;
	}
	
	public void setCod_barra(String cod_barra) {
		if (cod_barra.length() == 13) {
			this.cod_barra = cod_barra;
		} else {
			JOptionPane.showMessageDialog(null, "Código de barras inválido!");
		}
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		if (descricao.equals("")) {	
			JOptionPane.showMessageDialog(null, "Campo descrição é de preencimento obrigatório!");
		} else {
			this.descricao = descricao;
		}
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getFornecedor() {
		return Fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}
	
	public double getPreco_compra() {
		return preco_compra;
	}
	
	public void setPreco_compra(double preco_compra) {
		this.preco_compra = preco_compra;
	}
	
	public double getPrecoVenda() {
		return PrecoVenda;
	}
	
	public void setPrecoVenda(double precoVenda) {
		PrecoVenda = precoVenda;
	}

}
