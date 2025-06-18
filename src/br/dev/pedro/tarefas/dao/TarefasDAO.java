package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.factory.FileFactory;

import br.dev.pedro.tarefas.model.Tarefa;

public class TarefasDAO {

	private Tarefa tarefa;

	public TarefasDAO() {
	}

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
				linha = br.readLine();

				if (linha != null) {
					String tarefaStr[] = linha.split(",");

					// criando tarefas

					Tarefa tarefa = new Tarefa();
					tarefa.setTituloTarefa(tarefaStr[0]);
					tarefa.setDescricaoTarefa(tarefaStr[1]);
					tarefa.setDataTarefa(tarefaStr[2]);
					int prazo = Integer.parseInt(tarefaStr[3]);
					tarefa.setPrazo(prazo);
					tarefa.setDataConclusao(tarefaStr[4]);
					tarefa.setResponsavel(tarefaStr[6]);
					tarefa.setCodigo(tarefaStr[7]);

					// adicionando tarefa á lista tarefas
					tarefas.add(tarefa);

				}
			}

			return tarefas;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
