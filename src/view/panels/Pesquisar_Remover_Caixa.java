package view.panels;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import controller.EntradaSaidaDados;
import controller.ExibirRegistros;

@SuppressWarnings("serial")
public class Pesquisar_Remover_Caixa extends JPanel {

	static String codigo;

	String[] coluna = { "Cod Func", "Nome", "Endereço", "Telefone", "Celular", "Função" };

	JLabel lbRotulo;
	static JPanel PainelTabela;
	JTextArea area;
	static JScrollPane scroll;
	JButton btPesquisar, btExibir, btRemover;
	EntradaSaidaDados esd;

	ExibirRegistros objExibir = new ExibirRegistros();

	@SuppressWarnings("deprecation")
	static void apresentarTabela(String[][] dados, String[] coluna) {

		PainelTabela.removeAll();
		PainelTabela.repaint();
		scroll.removeAll();
		scroll.repaint();
		JTable tabela = new JTable(dados, coluna);
		tabela.disable();
		scroll = new JScrollPane(tabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		PainelTabela.add(scroll);
		scroll.setBounds(0, 0, 620, 320);

	}

	public Pesquisar_Remover_Caixa() {

		esd = new EntradaSaidaDados();

		PainelTabela = new JPanel();
		lbRotulo = new JLabel("PESQUISAR / REMOVER FUNCIONÁRIOS");
		scroll = new JScrollPane();

		btPesquisar = new JButton("<html><p align=center>Pesquisar<br />Funcionário</p></html>");
		btExibir = new JButton("<html><p align=center>Todos<br />Funcionários</p></html>");
		btRemover = new JButton("<html><p align=center>Remover<br />Funcionário</p></html>");

		this.setLayout(null);
		PainelTabela.setLayout(new GridLayout(1, 1));

		this.add(lbRotulo);
		lbRotulo.setBounds(180, 30, 300, 30);

		this.add(PainelTabela);
		PainelTabela.setBounds(20, 80, 620, 320);
		PainelTabela.setBorder(BorderFactory.createEtchedBorder());

		this.add(btPesquisar);
		btPesquisar.setBounds(20, 420, 100, 40);

		this.add(btExibir);
		btExibir.setBounds(140, 420, 100, 40);

		this.add(btRemover);
		btRemover.setBounds(260, 420, 100, 40);

		btPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				codigo = esd.entradaDados("Digite o Codigo do funcionário");

				if (codigo != null) {
					if (objExibir.exibirRegistroFuncionarios(codigo)[0][0] != null) {
						PainelTabela.removeAll();
						apresentarTabela(objExibir.exibirRegistroFuncionarios(codigo), coluna);
					}

				}
			}
		});

		btExibir.addActionListener(new ActionListener() {
			private BufferedReader lerArquivo;

			public void actionPerformed(ActionEvent e) {

				try {

					File arquivos[];
					File diretorio = new File("funcionarios");
					arquivos = diretorio.listFiles();
					String[][] dados = new String[arquivos.length][8];
					for (int i = 0; i < arquivos.length; i++) {
						FileReader arquivo = new FileReader(arquivos[i].toString());
						lerArquivo = new BufferedReader(arquivo);
						for (int t = 0; t < 8; t++) {
							dados[i][t] = lerArquivo.readLine();
						}

					}

					PainelTabela.removeAll();

					apresentarTabela(dados, coluna);

				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Banco de dados não encontrado!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		btRemover.addActionListener(new ActionListener() {
			private BufferedReader lerArquivologin;

			public void actionPerformed(ActionEvent e) {

				codigo = esd.entradaDados("Digite o código do Funcionário");

				if (codigo != null) {
					try {
						FileReader arquivologin = new FileReader("login.txt");
						lerArquivologin = new BufferedReader(arquivologin);
						if (lerArquivologin.readLine().equals(codigo)) {
							JOptionPane.showMessageDialog(null,
									"Funcionário logado no sistema não pode ser removido!\nAcesse o sistema com uma nova conta de administrador para poder remove-lo.");
						} else {

							int opcao = JOptionPane.showConfirmDialog(null,
									"Deseja realmente excluir este funcionário?\nTodos os registros serão apagados do sistemas!",
									"Confirmação", JOptionPane.YES_NO_OPTION);

							if (opcao == 0) {

								File arquivo = new File("funcionarios/" + codigo + ".txt");
								arquivo.delete();
								JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso.");

							}
						}
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
					} catch (IOException e1) {

					}

				}
			}

		});
	}
}
