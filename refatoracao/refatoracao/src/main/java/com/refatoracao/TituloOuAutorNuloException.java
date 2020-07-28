package com.refatoracao;

@SuppressWarnings("serial")
public class TituloOuAutorNuloException extends Exception {
	public TituloOuAutorNuloException(String message)
    {
       super(message);
    }
}