package com.refatoracao;

@SuppressWarnings("serial")
public class LivroOuUsuarioNulosException extends Exception {
	public LivroOuUsuarioNulosException(String message)
    {
       super(message);
    }
}