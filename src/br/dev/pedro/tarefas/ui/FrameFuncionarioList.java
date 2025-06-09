package br.dev.pedro.tarefas.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameFuncionarioList {
	private JLabel labelTitulo;
	private JButton btnCadastro;
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
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		
		tela.setVisible(true);
	}
	;
}
