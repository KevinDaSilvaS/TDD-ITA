package com.caixaEletronico;

public interface Hardware {
    public String pegarNumeroDaContaCartao(int numConta, int senha);

    public void entregarDinheiro();

    public void lerEnvelope();
}
