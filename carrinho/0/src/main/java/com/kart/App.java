package com.kart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CarrinhoCompras c = new CarrinhoCompras();
        System.out.println( "Hello World!" );
        MockObservadorKart mock = new MockObservadorKart();
        MockObservadorKart mock2 = new MockObservadorKart();

        /* c.adicionarObservador(mock);
        c.adicionarObservador(mock2);
 */
        c.adicionaProduto(new Produto("mouse", 15));
        c.adicionaProduto(new Produto("teclado", 40));
/* 
        System.out.println(mock.verificaRecebimento("mouse", 15));
        
        System.out.println(mock2.verificaRecebimento("teclado", 40)); */

        System.out.println(c.total());
    }
}
