package br.dev.pedro.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameFuncionario {
	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSalario;
	
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;
	
	private JButton btnSave;
	private JButton btnSair;
	
	public FrameFuncionario(){
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		
		
		Container painel = tela.getContentPane();
		
		labelMatricula = new JLabel("Matrícula");
		labelMatricula.setBounds(10, 10, 200, 30);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 40, 150, 30);
		txtMatricula.setEnabled(false);
		
		//nome
		labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 75, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(10, 105, 365, 30);
		
		//----------------------------------------
		
		
		//cargo
		labelCargo= new JLabel("Cargo");
		labelCargo.setBounds(10, 140, 200, 30);
		txtCargo = new JTextField();
		txtCargo.setBounds(10, 170, 300, 30);
		
		//------------------------------------
		
		//salario
		labelSalario= new JLabel("Salario");
		labelSalario.setBounds(10, 205, 150, 30);
		txtSalario = new JTextField();
		txtSalario.setBounds(10, 235, 150, 30);
		
		//---------------------------------------
		
		//botão salvar
		btnSave = new JButton("Salvar");
		btnSave.setBounds(10, 300, 120, 50);
		
		//---------------------------------
		
		//botão sair
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(140, 300, 80, 50);
		
		//-----------------------------------
		
		painel.add(labelMatricula);
		painel.add(txtMatricula);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelCargo);
		painel.add(txtCargo);
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(btnSave);
		painel.add(btnSair);
		
		
		tela.setVisible(true);
	}
}
