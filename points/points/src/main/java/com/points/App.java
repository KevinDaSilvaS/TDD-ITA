package com.points;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Estrela estrela = new Estrela();
        System.out.println( "Hello World!" );
        Placar pcl = new Placar();
        //System.out.println(pcl.listaPontosTotaisUsuario("guerra"));
        System.out.println(pcl.listaRanking(estrela));
    }
}
