package br.dev.pedro.tarefas.dao;

import java.io.IOException;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Tarefa;

public class TarefasDAO {

	private Tarefa tarefa;
	
	public TarefasDAO() {}
	
	public TarefasDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void gravar() {
			
			try {
				FileFactory ff = new FileFactory();
				ff.getBufferedWriterTarefas().write(tarefa.toString());
				ff.getBufferedWriterTarefas().flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}	
}
