package com.tradutor; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TradutorTest 
{
    /**
     * Rigorous Test :-)
     */
    Tradutor t;

    @Before
    public void criarTradutor(){
        t = new Tradutor();
    }

    @Test
    public void tradutorTesteSemPalavras()
    {
        assertTrue(t.estaVazia());
    }

    @Test
    public void traduzirUmaPalavra(){
        t.AddTranslation("bom", "good");
        assertFalse(t.estaVazia());
        assertEquals("good", t.translate("bom"));
    }

    @Test
    public void traduzirDuasPalavras(){
        t.AddTranslation("bom", "good");
        t.AddTranslation("amor", "love");
        assertFalse(t.estaVazia());
        assertEquals("good", t.translate("bom"));
        assertEquals("love", t.translate("amor"));
    }

    @Test
    public void doisSignificadosMesmaPalavra(){
        t.AddTranslation("carta", "letter");
        t.AddTranslation("carta", "card");
        assertEquals("letter, card", t.translate("carta"));
    }

    @Test
    public void traduzirFrase(){
        t.AddTranslation("ola", "hello");
        t.AddTranslation("mundo", "world");
        assertEquals("hello world", t.translatePhrase("ola mundo"));
    }

    @Test
    public void traduzirFrasePalavraDoisSignificados(){
        t.AddTranslation("ola", "hello");
        t.AddTranslation("mundo", "world");
        t.AddTranslation("carta", "letter");
        t.AddTranslation("carta", "card");
        assertEquals("hello world letter", t.translatePhrase("ola mundo carta"));
    }

}
