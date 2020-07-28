package com.caixaEletronico;

public interface ServicoRemoto {
    public String recuperarConta(int numConta);
    
    public void persistirConta(String tipo);
}
