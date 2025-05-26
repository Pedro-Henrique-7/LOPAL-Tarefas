package br.dev.pedro.tarefas.model;

import br.dev.pedro.tarefas.utils.Utils;

public class Funcionario {

	private String nome;
	private String matricula;
	private String cargo;
	private double salario;

	// constructor method

	// default constructor
	public Funcionario() {
		this.matricula = Utils.gerarUUID();
	}

	public Funcionario(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID();
	}

	public Funcionario(String nome, String cargo) {
		this.cargo = cargo;
		this.nome = nome;
		this.matricula = Utils.gerarUUID();
	}

	public Funcionario(String nome, String cargo, double salario) {
		this.cargo = cargo;
		this.nome = nome;
		this.matricula = Utils.gerarUUID();
		this.salario = salario;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula ;
}

	public void setMatricula( String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	// sobrescrita do toString herdado da classe Objects

	@Override
	public String toString() {
		String funcionario = matricula + "," + nome + "," + cargo + "," + salario + "\n";
		return funcionario;
	}

}
