package com.points;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Placar {

    Armazenamento data = new Armazenamento();

	public String adicionaPontos(String user, int amount, TipoPonto tipoPonto) {
        return data.add(user, amount, tipoPonto.getTipoPonto());
	}

	public List<String> listaPontosUsuario(String user) {

        return data.searchUser(user);
    }
    
    public Map<String, String> listaPontosTotaisUsuario(String user) {
        
        List<String> rawList = data.searchUser(user);
        Map<String, String> dados = new HashMap<>();

        for (int i = 0; i < rawList.size(); i++) {

            String[] parts = rawList.get(i).split(" ");

            if (dados.containsKey(parts[2])) {

                int value =  Integer.parseInt(dados.get(parts[2])) + 
                Integer.parseInt(parts[1]);

                dados.put(parts[2], value + "");
            }else{
                dados.put(parts[2], parts[1]);
            }

        }
        return dados;
	}

	public List<String> listaUsuariosPorTipoPonto(TipoPonto tipoPonto) {
        return data.searchPoint(tipoPonto.getTipoPonto());
    }

    public List<String> listaRanking(TipoPonto tipoPonto){
        List<String> users = data.searchPoint(tipoPonto.getTipoPonto());
        String[] userNames = new String[users.size()];
        int[] userPoints = new int[users.size()];

        for (int i = 0; i < users.size(); i++) {
            Map<String, String> points = listaPontosTotaisUsuario(users.get(i));
            userNames[i] = users.get(i);
            userPoints[i] = Integer.parseInt(points.get(tipoPonto.getTipoPonto()));
        }

        List<String> rankingFinal = sortRanking(userNames, userPoints);
        return rankingFinal;
    }

    private List<String> sortRanking(String[] userNames, int[] userPoints) {
        List<String> rankingFinal = new ArrayList<String>();

        for (int i = 0; i < userPoints.length; i++) {
            int posMaior = i;
            for (int j = i+1; j < userPoints.length; j++) {

                if (userPoints[j] > userPoints[posMaior]) {
                    posMaior = j;
                }
            }

            if (posMaior != i) {
                String nome = userNames[i];
                int pontos = userPoints[i];

                userPoints[i] = userPoints[posMaior];
                userNames[i] = userNames[posMaior];
                userPoints[posMaior] = pontos;
                userNames[posMaior] = nome;
            }
            rankingFinal.add(userNames[i] + " " + userPoints[i]);
        }
        return rankingFinal;
    }
    
}