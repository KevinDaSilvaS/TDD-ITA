package com.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CamelCaseStrTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnList()
    {
        assertTrue(CamelCaseStr.converterCamelCase("olaMundo") instanceof List<?>);
    }

    @Test
    public void shouldHaveTwoValues(){
       
        assertEquals(2, CamelCaseStr.converterCamelCase("olaMundo").size());
    }

    @Test
    public void checkAllUpercaseWord(){
        assertEquals("CPF", CamelCaseStr.converterCamelCase("olaCPF").get(1));
        assertEquals("ola", CamelCaseStr.converterCamelCase("olaCPF").get(0));
        assertEquals(2, CamelCaseStr.converterCamelCase("olaCPF").size());
    }
    
    @Test
    public void shouldNotHaveWordsUppercase(){
        assertEquals("ola", CamelCaseStr.converterCamelCase("olaMundo").get(0));
        assertEquals("mundo", CamelCaseStr.converterCamelCase("olaMundo").get(1));
    }

    @Test
    public void shouldHaveStartWithNumber(){
        assertEquals("invalidFormat", CamelCaseStr.converterCamelCase("10olaMundo").get(0));
    }

    @Test
    public void ShouldNotHaveSpecialChars(){
        assertEquals("invalidFormatSpecialChar", 
        CamelCaseStr.converterCamelCase("ola#Mundo").get(0));
    }
}
