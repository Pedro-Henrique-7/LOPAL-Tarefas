package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		tela.setSize(400, 200);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
				
				
		//botão
		
		btnFuncinarios = new JButton("Funcionários");
		btnFuncinarios.setBounds(60, 60, 120, 40);
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(210, 60, 120, 40);
		
		
		// clicar no botão funcionarios e ir para tela funcionarios
		
		btnFuncinarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameFuncionarioList();
			}
		});
		 
		
		painel.add(btnFuncinarios);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
	}
}
