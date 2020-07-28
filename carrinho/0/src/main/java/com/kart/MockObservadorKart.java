package com.kart;

public class MockObservadorKart implements ObservadorKart {

    private String nomeRecebido;
    private int valorRecebido;

	public Boolean verificaRecebimento(String nomeEsperado, int valorEsperado) {
        if (nomeEsperado == nomeRecebido && valorEsperado == valorRecebido) {
            return true;
        }
        return false;
	}

    @Override
    public void produtoAdicionado(String nome, int valor) {
        
        nomeRecebido = nome;
        valorRecebido = valor;
    }

}
