package com.caixaEletronico;

public class ContaCorrente implements ServicoRemoto{
	double saldo = 0;
	int numConta = 0;

	@Override
	public String recuperarConta(int numConta) {
		if (numConta == 353535) {
			this.numConta = numConta;
			this.saldo = 350.54;
		}
		return numConta + "";
	}

	@Override
	public void persistirConta(String tipo) {
		System.out.println(tipo + " efetuado com sucesso.");

	}

	public int getNumConta(){
		return this.numConta;
	}

	public double getSaldo(){
		return this.saldo;
	}

	public void setSaldo(double novoSaldo){
		this.saldo = novoSaldo;
	}

}
