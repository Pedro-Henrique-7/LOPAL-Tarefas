package br.dev.pedro.tarefas.utils;

import java.util.UUID;

public class Utils {
	
	public static String gerarUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		String uuid8 = uuidStr.substring(0, 8);
		return uuid8;
	}

}
	