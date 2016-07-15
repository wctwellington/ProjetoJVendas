package model;

public class Funcionario {

	String Cod_Funcionario, Nome, Endereco, Telefone, Celular, Funcao, Data_Admissao, Senha;

	public String getCod_Funcionario() {
		return Cod_Funcionario;
	}

	public void setCod_Funcionario(String cod_Funcionario) {
		
		if(cod_Funcionario != null) {
			Cod_Funcionario = cod_Funcionario;
		}
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public String getFuncao() {
		return Funcao;
	}

	public void setFuncao(String cargo) {
		Funcao = cargo;
	}

	public String getData_Admissao() {
		return Data_Admissao;
	}

	public void setData_Admissao(String data_Admissao) {
		Data_Admissao = data_Admissao;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
}
