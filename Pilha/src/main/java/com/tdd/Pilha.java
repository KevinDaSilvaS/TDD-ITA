package com.tdd;

import java.util.ArrayList;

public class Pilha {

    private int curSize = -1;
    private ArrayList<String> pilha = new ArrayList<String>();
    private int maxSize;

    public Pilha(int size){
        this.maxSize = size;
    }

	public int size() {
		return this.curSize + 1;
	}

	public boolean isEmpty() {
        
        if (this.curSize != -1) {
            return false;
        }
		return true;
	}

	public void empilha(String elemento) {

        if ((curSize+1) >= maxSize) {
            return;
        }
        
        this.pilha.add(elemento);
        this.curSize++;
	}

	public String topo() {

        if (curSize <= -1) {
            return "the stack is empty";
        }
        return this.pilha.get(curSize);
	}

	public void desempilha() {

        if (curSize > -1) {
            this.pilha.remove(curSize);
            curSize--;
            return;
        }  
	}
    
}