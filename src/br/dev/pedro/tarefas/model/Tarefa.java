package br.dev.pedro.tarefas.model;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.utils.Utils;

public class Tarefa {

	private String tituloTarefa;
	private String descricaoTarefa;
	private String dataTarefa;
	private int prazo;
	private String dataConclusao;
	private String status;
	private String responsavel;
	private String codigo;
	
	
	public Tarefa(String tituloTarefa, String descricaoTarefa, String dataTarefa, int prazo, String dataConclusao,
			String status, String responsavel, String codigo) {
		
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataTarefa = dataTarefa;
		this.prazo = prazo;
		this.dataConclusao = dataConclusao;
		this.status = status;
		this.responsavel = responsavel;
		this.codigo = Utils.gerarUUID();
	}
	public Tarefa(String tituloTarefa, String descricaoTarefa, String dataTarefa, int prazo, String dataConclusao) {
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataTarefa = dataTarefa;
		this.prazo = prazo;
		this.dataConclusao = dataConclusao;
		this.codigo = Utils.gerarUUID();
	}
	public Tarefa() {
		this.codigo = Utils.gerarUUID();	
	}
	public String getTituloTarefa() {
		return tituloTarefa;
	}
	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}
	public String getDataTarefa() {
		return dataTarefa;
	}
	public void setDataTarefa(String dataTarefa) {
		this.dataTarefa = dataTarefa;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	public String getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		String tarefa = tituloTarefa + "," + descricaoTarefa + "," + dataTarefa + "," + prazo + "," + dataConclusao + "," + status + "," + responsavel + "," + codigo +"\n";
		return tarefa;
	}
	

	
}
