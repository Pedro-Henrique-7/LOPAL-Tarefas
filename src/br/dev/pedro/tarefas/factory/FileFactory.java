package br.dev.pedro.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private String arquivo = "C:\\Users\\25132766\\ProjetoTarefas\\funcionarios.csv";
	private FileWriter fw;
	private BufferedWriter bw;
	
	public FileFactory() throws IOException {
		fw = new FileWriter(arquivo, true); //true indica que o arquivo vai ser aberto em modo de edição
		bw = new BufferedWriter(fw);
	}
	
	public BufferedWriter getBufferedWriter() {
		return bw;
	}
	
}
