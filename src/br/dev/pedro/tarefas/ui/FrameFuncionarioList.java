package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.model.Funcionario;

public class FrameFuncionarioList {
	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JButton btnSair;
	private JTable tabelaFuncionarios;
	private JScrollPane scrollFuncionarios;
	private DefaultTableModel modelFuncionarios;
	
	//criando vetor para identificar colunas
	private String[] colunas = {"CODIGO", "NOME", "CARGO"};
	
	public FrameFuncionarioList() {
		criarTela();
	}
	
	private void criarTela() {
		
		//criando objeto de tela
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Funcionarios");
		tela.setSize(500, 500);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLocationRelativeTo(null);

		labelTitulo = new JLabel("Lista de Funcionarios: ");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		

		
		// criando modelo de tabela
		
		//colunas é o vetor que criei na linha 20, e o parametro 20 é o tamanho de linhas que ele vai suportar
		modelFuncionarios = new DefaultTableModel(colunas , 20) {
			
			//definir se a celula pode ser editada
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //celula não pode ser editada
			}
			
		};
		
		//criando tabela
		tabelaFuncionarios = new JTable(modelFuncionarios);
		
		//Pegar o cabeçalho da tabela e não permitir reorganização das colunas
		tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
		
		//Criando scroll e adicionando a tabela nele 
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 50, 460, 343);
		
		carregarDados();
		
		// Ajustando o Botão
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 410, 200, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(240, 410, 200, 40);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameFuncionario();
				carregarDados();
				
			}
		});
		
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			int resposta = JOptionPane.showConfirmDialog(tela, "Você tem certeza que deseja sair do cadastro? ");
							
							if (resposta == 0) {
								//fechar tela caso resposta for 0
								tela.dispose();	
							}
			}
		});
		
		
		
		
		
		// Criando variável do container da tela
		Container painel = tela.getContentPane();
		// Adicionando componentes no container
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnCadastro);
		painel.add(btnSair);

		
		tela.setVisible(true);
	}
	
	public void carregarDados() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		//Define o tamanho do objeto da  tabela de funcionarios
		Object[][] dados =new Object[funcionarios.size()][3];
		int i = 0;
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		modelFuncionarios.setDataVector(dados, colunas);
	}
}
