package com.refatoracao;

@SuppressWarnings("serial")
public class DevolveLivroNuloParaEmprestimoException extends Exception {
	public DevolveLivroNuloParaEmprestimoException(String message)
    {
       super(message);
    }
}
