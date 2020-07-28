package com.caixaEletronico;

public class CaixaEletronico {
    private ContaCorrente cc = new ContaCorrente();
    private Hardware ch = new ConcreteHardware();

	public String logar() {
        
        cc.recuperarConta(Integer.parseInt(ch.pegarNumeroDaContaCartao(353535, 123456)));
        int numConta = cc.getNumConta();
        if (numConta == 353535) {
            return  "Usuário Autenticado";
        }
        return "Não foi possível autenticar o usuário";
    }

    public String sacar(int valor) {
        if (cc.getSaldo() >= valor && valor > 0) {
            cc.setSaldo(cc.getSaldo() - valor);
            cc.persistirConta("saque");
            ch.entregarDinheiro();
            return "Retire seu dinheiro";
        }
        return "Saldo insuficiente";
    }

    public String depositar(int numConta, double deposito){
        ch.lerEnvelope();
        if (cc.getNumConta() != numConta &&
        cc.getSaldo() >= deposito){
            cc.setSaldo(cc.getSaldo() - deposito);
            cc.persistirConta("deposito");
            return "Depósito recebido com sucesso";
        }
        return "";
    }

    public String saldo(){
        return "O saldo é R$"+ cc.getSaldo();
    }
 
}