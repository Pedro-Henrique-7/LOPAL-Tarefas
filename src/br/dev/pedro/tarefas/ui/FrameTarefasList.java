package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.dao.TarefasDAO;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.model.Tarefa;

public class FrameTarefasList {
	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JButton btnSair;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;

	// criando vetor para identificar colunas
	private String[] colunas = { "CODIGO", "TAREFA", "RESPONSAVEL" };

	public FrameTarefasList() {
		criarTela();
	}

	private void criarTela() {

		// criando objeto de tela
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(500, 500);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLocationRelativeTo(null);

		labelTitulo = new JLabel("Lista de Funcionarios: ");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		labelTitulo.setBounds(10, 10, 400, 40);

		// criando modelo de tabela

		// colunas é o vetor que criei na linha 20, e o parametro 20 é o tamanho de
		// linhas que ele vai suportar
		modelTarefas = new DefaultTableModel(colunas, 20) {

			// definir se a celula pode ser editada
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // celula não pode ser editada
			}

		};

		// criando tabela
		tabelaTarefas = new JTable(modelTarefas);

		// Pegar o cabeçalho da tabela e não permitir reorganização das colunas
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);

		// Criando scroll e adicionando a tabela nele
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 50, 460, 343);

		carregarDados();

		// Ajustando o Botão
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 410, 200, 40);

		btnSair = new JButton("Sair");
		btnSair.setBounds(240, 410, 200, 40);

		btnCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FrameTarefas();
				carregarDados();

			}
		});

//		carregarDados();

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(tela, "Você tem certeza que deseja sair do cadastro? ");

				if (resposta == 0) {
					// fechar tela caso resposta for 0
					tela.dispose();
				}
			}
		});

		// Criando variável do container da tela
		Container painel = tela.getContentPane();
		// Adicionando componentes no container
		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnCadastro);
		painel.add(btnSair);

		tela.setVisible(true);
	}

	public void carregarDados() {
		TarefasDAO dao = new TarefasDAO();
		List<Tarefa> tarefas = dao.listar();

		// Define o tamanho do objeto da tabela de funcionarios
		Object[][] dados = new Object[tarefas.size()][3];
		int i = 0;
		for (Tarefa t : tarefas) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getTituloTarefa();
			dados[i][2] = t.getResponsavel();
			modelTarefas.setDataVector(dados, colunas);
			i++;
		}

	}
}
