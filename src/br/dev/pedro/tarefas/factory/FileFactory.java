package br.dev.pedro.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private String arquivoFuncinario = "C:\\Users\\25132766\\ProjetoTarefas\\funcionarios.csv";
	private String arquivoTarefas = "C:\\Users\\25132766\\ProjetoTarefas\\tarefas.csv";
	//Funcionario
	private FileWriter fwf;
	private BufferedWriter bwf;
	private FileReader frf;
	private BufferedReader brf;
	
	//tarefas
	private FileWriter fwt;
	private BufferedWriter bwt;
	private FileReader frt;
	private BufferedReader brt;
	
	
	public FileFactory() throws IOException {
		//funcionario
		fwf = new FileWriter(arquivoFuncinario, true); //true indica que o arquivo vai ser aberto em modo de edição
		bwf = new BufferedWriter(fwf);
		
		frf = new FileReader(arquivoFuncinario);
		brf = new BufferedReader(frf);
		
		//tarefas
		
		fwt = new FileWriter(arquivoTarefas, true);
		bwt = new BufferedWriter(fwt);
		
		frt = new FileReader(arquivoTarefas);
		brt = new BufferedReader(frt);
		
		
	}
	
	public BufferedWriter getBufferedWriterFuncionario() {
		return bwf ;

	}
	
	public BufferedWriter getBufferedWriterTarefas() {
		return bwt;
		
	}

	public BufferedReader getBufferedReaderFuncionario() {
		
		return brf;
	}
	
	public BufferedReader getBufferedReaderTarefas() {
		
		return brt;
	}
	
}
