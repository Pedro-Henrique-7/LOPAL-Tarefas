package br.dev.pedro.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.ui.FrameFuncionario;
import br.dev.pedro.tarefas.ui.FrameFuncionarioList;
import br.dev.pedro.tarefas.ui.FrameGerenciador;
import br.dev.pedro.tarefas.ui.FrameTarefas;
import br.dev.pedro.tarefas.utils.Utils;	

public class Main {

	private static String path = "C:\\Users\\25132766\\ProjetoTarefas\\tarefas.txt";

	public static void main(String[] args) {
				
		new FrameGerenciador();


	}
}

