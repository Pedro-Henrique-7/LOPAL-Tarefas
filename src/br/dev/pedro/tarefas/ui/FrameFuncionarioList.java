package br.dev.pedro.tarefas.ui;

import javax.swing.JFrame;

public class FrameFuncionarioList {
	
	public FrameFuncionarioList() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(500, 500);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		
		tela.setVisible(true);
	}
	;
}
