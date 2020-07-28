package com.refatoracao;

@SuppressWarnings("serial")
public class DevolveLivroDisponivelParaEmprestimoException extends Exception {
	public DevolveLivroDisponivelParaEmprestimoException(String message)
    {
       super(message);
    }
}
