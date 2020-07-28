package com.points;

public class Likes implements TipoPonto{

    public String tipoPonto = "likes";

    @Override
    public String getTipoPonto() {
        return tipoPonto;
    }
}