package com.tradutor;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class Tradutor {
	Map<String, String> dicionario = new HashMap<>();

    public boolean estaVazia() {
		if (!this.dicionario.isEmpty()) {
			return false;
		}
		return true;
	}

	public void AddTranslation(String word, String translation) {
		if (dicionario.containsKey(word)){
			translation = translate(word) + ", " + translation;
		}

		dicionario.put(word, translation);
	}

	public String translate(String word) {
		return dicionario.get(word);
	}

	public Object translatePhrase(String frase) {

		String palavrasFrase[] = frase.split(" ");
		String fraseFinal = "";
		
		for (String palavra : palavrasFrase) {

			String traducao = this.translate(palavra);

			if (traducao.contains(",")) {
				traducao = traducao.substring(0, traducao.indexOf(","));
			}
			fraseFinal += " " + traducao;
		}

		return fraseFinal.trim();
	}

}
