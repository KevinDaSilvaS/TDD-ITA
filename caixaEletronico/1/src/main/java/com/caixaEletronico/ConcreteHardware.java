package com.caixaEletronico;

public class ConcreteHardware implements Hardware{

    @Override
    public String pegarNumeroDaContaCartao(int numConta, int senha) {
        return "" + numConta;
    }

    @Override
    public void entregarDinheiro() {
        // TODO Auto-generated method stub

    }

    @Override
    public void lerEnvelope() {
        // TODO Auto-generated method stub

    }
    
}