package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Funcionario;
import model.Produto;

public class GravarRegistros {

	public void GravarProdutos (JTextField codbarras, JTextField descricao, JTextField marca, JTextField fornecedor, JTextField categoria, JTextField precovenda, JTextField precocompra, JTextField qtde) {
		
		boolean erro = false;

		Produto objProduto = new Produto();
		
		PrintWriter gravar;
		
			objProduto.setCod_barra(codbarras.getText());
			
			if(objProduto.getCod_barra() == null) {
				erro = true;
			}
						
			objProduto.setDescricao(descricao.getText());
				if (objProduto.getDescricao() == null) {
					erro = true;
				}
				
			objProduto.setMarca(marca.getText());
			
			objProduto.setFornecedor(fornecedor.getText());
			
			objProduto.setCategoria(categoria.getText());
			
			try {
				objProduto.setPreco_compra(Double.parseDouble(precocompra.getText()));
			} catch (Exception e1) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Preço de compra inválido!\nVerifique o campo");
			}
			
			try {
				objProduto.setPrecoVenda(Double.parseDouble(precovenda.getText()));
			} catch (Exception e) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Preço de venda inválido!\nVerifique o campo");
			}
			
			try {
				objProduto.setQtde(Integer.parseInt(qtde.getText()));
			} catch (Exception e) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Quantidade inválida!\nVerifique o campo");
			}
			
			if (erro == false) {
				File arquivo = new File("produtos", codbarras.getText() + ".txt");
				try {
					gravar = new PrintWriter(arquivo);
					gravar.println(objProduto.getCod_barra());
					gravar.println(objProduto.getDescricao());
					gravar.println(objProduto.getMarca());
					gravar.println(objProduto.getFornecedor());
					gravar.println(objProduto.getCategoria());					
					gravar.println(Double.toString(objProduto.getPreco_compra()));
					gravar.println(Double.toString(objProduto.getPrecoVenda()));
					gravar.println(Integer.toString(objProduto.getQtde()));
				
					gravar.close();
				} catch (FileNotFoundException e) {
					System.out.println("Erro com banco de dados!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor incorreto para Preço Compra!");
				}
	
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

				codbarras.setText("");
				descricao.setText("");
				marca.setText("");
				fornecedor.setText("");
				categoria.setText("");
				precocompra.setText("");
				precovenda.setText("");
				qtde.setText("");
			} else {
		}
	}
	
	public void AlterarProduto(JTextField codbarras, JTextField descricao, JTextField marca, JTextField fornecedor, JTextField categoria, JTextField precovenda, JTextField precocompra, JTextField qtde) {
		boolean erro = false;

		
		Produto objProduto = new Produto();
		
		PrintWriter gravar;
		
			objProduto.setCod_barra(codbarras.getText());
						
			objProduto.setDescricao(descricao.getText());
				if (objProduto.getDescricao().equals("")) {
					erro = true;
				} else {
					
				}

			objProduto.setMarca(marca.getText());
						
			objProduto.setFornecedor(fornecedor.getText());
			
			objProduto.setCategoria(categoria.getText());
						
			try {
				double teste = Double.parseDouble(precocompra.getText());
				objProduto.setPreco_compra(teste);
				
			} catch (Exception e1) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Preço de compra inválido!\nVerifique o campo");
			}
			
			try {
				objProduto.setPrecoVenda(Double.parseDouble(precovenda.getText()));

			} catch (Exception e) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Preço de venda inválido!\nVerifique o campo");
			}
			
			try {
				objProduto.setQtde(Integer.parseInt(qtde.getText()));

			} catch (Exception e) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Quantidade inválida!\nVerifique o campo");
			}
			
			if (erro == false) {
				
				int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
				
				if (opcao == 0) {
					File arquivo = new File("produtos", codbarras.getText() + ".txt");
					try {
						gravar = new PrintWriter(arquivo);
						gravar.println(objProduto.getCod_barra());
						gravar.println(objProduto.getDescricao());
						gravar.println(objProduto.getMarca());
						gravar.println(objProduto.getFornecedor());
						gravar.println(objProduto.getCategoria());
						gravar.println(Double.toString(objProduto.getPreco_compra()));
						gravar.println(Double.toString(objProduto.getPrecoVenda()));
						gravar.println(Integer.toString(objProduto.getQtde()));
				
						gravar.close();
					} catch (FileNotFoundException e) {
						System.out.println("Erro com banco de dados!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor incorreto para Preço Compra!");
				}
	
				JOptionPane.showMessageDialog(null, "Produto alterado sucesso!");

			}
		}
	}
	
	public int removerProduto(String codigo) {
		
		File remover = new File("produtos", codigo + ".txt");
		int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este produto?\nTodos os dados ser�o apagados!", "Confirma��o", JOptionPane.YES_NO_OPTION);
		if (opcao == 0) {
			remover.delete();
			JOptionPane.showMessageDialog(null, "Produto removido do sistema!");
		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
		}
		return opcao;
	}

	
	
	public void gravarFuncionario(JTextField codfunc, JTextField nome, JTextField endereco, JTextField telefone, JTextField celular, JComboBox funcao, JPasswordField senha, JPasswordField senhaconfirma) {

		boolean erro = false;

		Funcionario objFuncionario = new Funcionario();
		
		PrintWriter gravar;
		
			objFuncionario.setCod_Funcionario(codfunc.getText());
				if (objFuncionario.getCod_Funcionario().equals("")) {
					erro = true;
					JOptionPane.showMessageDialog(null, "Insira um código para o funcionário");
				}
						
			objFuncionario.setNome(nome.getText());
				if (objFuncionario.getNome().equals("")) {
					erro = true;
					JOptionPane.showMessageDialog(null, "O nome do funcionario e de\npreenchemento obrigatório");
				}

				objFuncionario.setEndereco(endereco.getText());

				objFuncionario.setTelefone(telefone.getText());

				objFuncionario.setCelular(celular.getText());

			if (funcao.getSelectedItem().equals("Selecione uma função")) {
				JOptionPane.showMessageDialog(null, "Selecione uma função!");
				erro = true;
			} else {
				objFuncionario.setFuncao((String)funcao.getSelectedItem());
			}
			
			if (senha.getText().equals(senhaconfirma.getText())) {
			objFuncionario.setSenha(senha.getText());
			} else {
				JOptionPane.showMessageDialog(null, "As senhas não conferem!");
				erro = true;
			}
			
			if (erro == false) {
				File arquivo = new File("funcionarios", codfunc.getText() + ".txt");
				try {
					gravar = new PrintWriter(arquivo);
					gravar.println(objFuncionario.getCod_Funcionario());
					gravar.println(objFuncionario.getNome());
					gravar.println(objFuncionario.getEndereco());
					gravar.println(objFuncionario.getTelefone());
					gravar.println(objFuncionario.getCelular());
					gravar.println(objFuncionario.getFuncao());
					gravar.println(objFuncionario.getSenha());
				
					gravar.close();
				} catch (FileNotFoundException e) {
					System.out.println("Erro com banco de dados!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Valor incorreto para Preço Compra!");
				}
	
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");

				codfunc.setText("");
				nome.setText("");
				endereco.setText("");
				telefone.setText("");
				celular.setText("");
				senha.setText("");
				senhaconfirma.setText("");
			} else {
		}
	}	
}
	


	

