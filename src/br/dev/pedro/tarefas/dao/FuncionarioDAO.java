package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			ff.getBufferedWriterFuncionario().write(funcionario.toString());
			ff.getBufferedWriterFuncionario().flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderFuncionario();
			
			String linha = "";
			
			br.readLine();
			
			while (linha != null) {
				
			linha = br.readLine();
			
			if (linha != null) {
				String funcionarioStr[] = linha.split(",");
				
				//criando funcionario
				
				Funcionario funcionario = new Funcionario();
				funcionario.setMatricula(funcionarioStr[0]);
				funcionario.setNome(funcionarioStr[1]);
				funcionario.setCargo(funcionarioStr[2]);
				double salario = Double.parseDouble(funcionarioStr[3]);
				funcionario.setSalario(salario);

				// Adicionando funcionários na lista
				funcionarios.add(funcionario);
				}
			}
			
			
			
			return funcionarios;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
