package com.caixaEletronico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CaixaEletronico ce = new CaixaEletronico();
        ce.logar();
        System.out.println(ce.sacar(30));
    }
}
