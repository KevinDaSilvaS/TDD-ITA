package com.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PilhaTest 
{
    Pilha p;

    @Before
    public void inicializaPilha(){
        p = new Pilha(30);
    }

    @Test
    public void pilhaVazia(){
        //Pilha p = new Pilha();
        assertTrue(p.isEmpty());
        assertEquals(0, p.size());
    }

    @Test
    public void empilharElemento(){
        //Pilha p = new Pilha();
        p.empilha("elem");
        assertFalse(p.isEmpty());
        assertEquals(1, p.size());
        assertEquals("elem", p.topo());
    }

    @Test
    public void desempilha(){
        //Pilha p = new Pilha();
        p.empilha("elem0");
        p.empilha("elem");
        p.desempilha();
        assertNotEquals("elem", p.topo());
        assertEquals("elem0", p.topo());
    }

    @Test
    public void adicionarMaxPilha(){
        p.empilha("elem0");
        p.empilha("elem1");
        p.empilha("elem2");
        //p.empilha("elem3");
        assertEquals(3, p.size());
    }

}
