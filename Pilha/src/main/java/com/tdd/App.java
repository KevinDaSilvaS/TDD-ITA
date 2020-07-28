package com.tdd;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /* System.out.println( "Hello World!" );
        Pilha p = new Pilha(3);
        p.empilha("elem");
        p.empilha("elem");
        p.empilha("elem");
        System.out.println(p.size()); */
        //System.out.println(p.isEmpty());
        //System.out.println(p.size());
        //System.out.println(p.topo());
        //p.desempilha();
        //System.out.println(p.topo());

        List<String> l = CamelCaseStr.converterCamelCase("numeroCPFContribuinte10");
        for (String string : l) {
            System.out.println(string);
        }
    }
}
