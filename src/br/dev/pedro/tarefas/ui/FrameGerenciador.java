package br.dev.pedro.tarefas.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameGerenciador {

	private JFrame gerenciadorJFrame;
	private JButton btnFuncinarios;
	private JButton btnTarefas;
	
	public FrameGerenciador(){
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Gerenciador de Tarefas");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}
}
