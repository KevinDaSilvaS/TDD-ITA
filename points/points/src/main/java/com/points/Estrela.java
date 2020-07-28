package com.points;

public class Estrela implements TipoPonto{

    public String tipoPonto = "estrela";

    @Override
    public String getTipoPonto() {
        return tipoPonto;
    }
}