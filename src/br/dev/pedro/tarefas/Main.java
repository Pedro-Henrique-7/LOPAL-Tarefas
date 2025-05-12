package br.dev.pedro.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	private static String path = "C:\\Users\\25132766\\ProjetoTarefas\\tarefas.txt";

	public static void main(String[] args) {

		
//		gravarArquivo();
	lerArquivo();
		
	}

	
	private static void gravarArquivo() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);
			String newLine = "Isso é uma linha nova coco \n";
			
			bw.write(newLine);
			bw.flush();
		
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
		
	}
	private static void lerArquivo() { 
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while (line != null) {
				
				String registro[] = line.split(";");
				System.out.println("Nome: " + registro[0]);
				line = br.readLine();
			}

		} catch (FileNotFoundException erro) {
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
