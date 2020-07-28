package com.caixaEletronico;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CaixaEletronicoTest 
{
    CaixaEletronico ce = new CaixaEletronico();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testLogin(){
        
        assertEquals("Usuário Autenticado" , ce.logar());
    }

    @Test
    public void testSaqueBemSucedido(){
        ce.logar();
        assertEquals("Retire seu dinheiro" , ce.sacar(10));
    }

    @Test
    public void testSaqueMalSucedido(){
        ce.logar();
        assertEquals("Saldo insuficiente" , ce.sacar(150000));
    }

    @Test
    public void testDeposito(){
        ce.logar();
        assertEquals("Depósito recebido com sucesso" , ce.depositar(10054, 50));
    }

    @Test
    public void testDepositoFail(){
        ce.logar();
        assertEquals("" , ce.depositar(10054, 50000000));
    }

    @Test
    public void testSaldo(){
        ce.logar();
        assertEquals("O saldo é R$350.54" , ce.saldo());
    }
}
