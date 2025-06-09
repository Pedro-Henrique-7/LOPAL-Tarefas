package br.dev.pedro.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private String arquivo = "C:\\Users\\25132766\\ProjetoTarefas\\funcionarios.csv";
	
	//Funcionario
	private FileWriter fwf;
	private BufferedWriter bwf;
	private FileReader frf;
	private BufferedReader brf;
	
	public FileFactory() throws IOException {
		fwf = new FileWriter(arquivo, true); //true indica que o arquivo vai ser aberto em modo de edição
		bwf = new BufferedWriter(fwf);
		
		frf = new FileReader(arquivo);
		brf = new BufferedReader(frf);
	}
	
	public BufferedWriter getBufferedWriter() {
		return bwf;
	}

	public BufferedReader getBufferedReaderFuncionario() {
		
		return brf;
	}
	
}
