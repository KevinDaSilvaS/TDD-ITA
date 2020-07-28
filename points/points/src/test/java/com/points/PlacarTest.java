package com.points;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PlacarTest {
    Placar placar = new Placar();

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void registerPoint() {
        Estrela estrela = new Estrela();
        assertEquals("o usuario guerra recebeu 25 pontos do tipo estrela",
        placar.adicionaPontos("guerra", 25, estrela));
    }

    @Test
    public void registerTwoDifferentPointTypes() {
        Estrela estrela = new Estrela();
        Likes likes = new Likes();
        assertEquals("o usuario guerra recebeu 25 pontos do tipo estrela",
        placar.adicionaPontos("guerra", 25, estrela));

        assertEquals("o usuario guerra recebeu 10 pontos do tipo likes", 
        placar.adicionaPontos("guerra", 10, likes));
    }

    @Test
    public void registerPointForDifferentUsers() {
        Estrela estrela = new Estrela();

        assertEquals("o usuario orlando recebeu 3 pontos do tipo estrela",
        placar.adicionaPontos("orlando", 3, estrela));

        assertEquals("o usuario fonseca recebeu 5 pontos do tipo estrela",
        placar.adicionaPontos("fonseca", 5, estrela));
    }

    @Test
    public void retornaTodosPontosPorUsuario() {
        List<String> lista = placar.listaPontosUsuario("guerra");
        assertEquals("guerra 25 estrela", lista.get(0));
    }

    @Test
    public void pontosTotaisUsuario(){
        Map<String, String> map = new HashMap<>();
        map.put("likes", "5");
        Map<String, String> map2 = placar.listaPontosTotaisUsuario("guerra");
        assertEquals(map.get("Likes"),map2.get("Likes"));

        /* Map<String, String> map = new HashMap<>();
        map.put("estrela", "50");
        Map<String, String> map2 = placar.listaPontosTotaisUsuario("guerra");
        assertEquals(map.get("estrela"),map2.get("estrela")); */
    }

    @Test
    public void retornaUsuariosPorPonto(){
        Estrela estrela = new Estrela();
        List lista = placar.listaUsuariosPorTipoPonto(estrela);
        assertEquals("guerra", lista.get(0));
    }

    @Test
    public void returnRanking(){
        Estrela estrela = new Estrela();
        List<String> lista = placar.listaRanking(estrela);
        assertEquals("guerra 25", lista.get(0));
    }
}
