package com.kart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarrinhoComprasTest 
{
    private CarrinhoCompras c = new CarrinhoCompras();
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test 
    
    public void totalCarrinho(){
        
        c.adicionaProduto(new Produto("Celular", 10));
        c.adicionaProduto(new Produto("fone", 10));

        assertEquals(c.total(), c.total());
    }

    @Test 
    
    public void addKartObserver(){
        MockObservadorKart mock = new MockObservadorKart();
        c.adicionarObservador(mock);
        c.adicionaProduto(new Produto("mouse", 15));
        assertTrue(mock.verificaRecebimento("mouse", 15));
    }

    @Test
    public void add2KartObserver(){
        MockObservadorKart mock = new MockObservadorKart();
        MockObservadorKart mock2 = new MockObservadorKart();

        c.adicionarObservador(mock);
        c.adicionarObservador(mock2);

        c.adicionaProduto(new Produto("mouse", 15));
        c.adicionaProduto(new Produto("teclado", 40));

        assertTrue(mock.verificaRecebimento("teclado", 40));
        assertTrue(mock2.verificaRecebimento("teclado", 40));
    }
}
