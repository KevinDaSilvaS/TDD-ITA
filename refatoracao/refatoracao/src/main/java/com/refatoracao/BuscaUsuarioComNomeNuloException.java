package com.refatoracao;

@SuppressWarnings("serial")
public class BuscaUsuarioComNomeNuloException extends Exception {
	public BuscaUsuarioComNomeNuloException(String message)
    {
       super(message);
    }
}