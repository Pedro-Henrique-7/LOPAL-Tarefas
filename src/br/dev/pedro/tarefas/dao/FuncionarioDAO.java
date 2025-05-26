package br.dev.pedro.tarefas.dao;

import java.io.IOException;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Funcionario;

//classe que persiste funcionario em um banco de dados
public class FuncionarioDAO {

	private Funcionario funcionario;
	
	public FuncionarioDAO() {}
	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
