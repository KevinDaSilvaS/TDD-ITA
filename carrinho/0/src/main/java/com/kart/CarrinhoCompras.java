package com.kart;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Produto> itens = new ArrayList<Produto>(); 
    private List<ObservadorKart> obs = new ArrayList<ObservadorKart>();

    public void adicionaProduto(Produto item){
        this.itens.add(item);
        for (ObservadorKart observer : obs) {
            
            observer.produtoAdicionado(item.getNome(), item.getValor());
        }
    }

    public int total(){
        int total = 0;
        for (Produto produto : itens) {
            total += produto.getValor();
        } 

        return total;
    }

	public void adicionarObservador(ObservadorKart observador) {
        obs.add(observador);
	}
}