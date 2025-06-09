package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.model.Funcionario;

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

	public FrameFuncionario() {
		criarTela();
	}

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setLayout(null);	
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		
		//Funcionalidades dos Botões
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//salvar conteudo dos txt em variaveis
				String nome = txtNome.getText();
				String cargo = txtCargo.getText();
				
				//salvar salario como double e transformar salario em string
				double salario = Double.parseDouble(txtSalario.getText());
				
				//criando novo funcionario e definindo oque ele vai receber
				Funcionario f = new Funcionario(nome, cargo, salario);
				
				//gravar funcionario no arquivo
				FuncionarioDAO dao = new FuncionarioDAO(f);
				dao.gravar();
				
				//mensagem para indicar que o cadastro foi finalizado
				
				JOptionPane.showMessageDialog(tela,nome + "\ncadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				limparFormulario();
				
				
			}
		});
		
		
		//Sair da tela caso o usuario queira
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//armazenando resposta do JOptionPane que retorna 0 para sim e outro valor para qualquer outra resposta
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Você tem certeza que deseja sair do cadastro? ");
				
				if (resposta == 0) {
					//fechar tela caso resposta for 0
					tela.dispose();	
				}
				
			}
			
		});
		
		tela.setVisible(true);	
	
		}

	// limpar formulario após o preenchimento
	public void limparFormulario() {
		txtNome.setText(null);

		// retomar o foco para o campo nome
		txtNome.requestFocus();

		txtCargo.setText(null);
		txtSalario.setText(null);
	}

}
