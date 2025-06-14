package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Status;
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
	
	public List<Tarefa> listar() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderTarefas();
			
			String linha = "";
			
			br.readLine();
			
			while (linha != null) {
				linha= br.readLine();
				
				if (linha != null) {
					String tarefasStr[] = linha.split(",");
					
					//criando tarefas
					
					Tarefa tarefa = new Tarefa();
					tarefa.setTituloTarefa(tarefasStr[0]);
					tarefa.setDescricaoTarefa(tarefasStr[1]);
					tarefa.setDataTarefa(tarefasStr[2]);
					int prazo = Integer.parseInt(tarefasStr[3]);
					tarefa.setPrazo(prazo);
					tarefa.setDataConclusao(tarefasStr[4]);
					

				}
			}
			
			return tarefas;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
