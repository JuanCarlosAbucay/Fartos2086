package com.example.fartos2086;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nom;
    private List<Carta> ma;
    private boolean patada = false;
    private boolean zancadilla = false;
    private int foto;
    private int fotoInicial;
    private int casilla = -1;
    private ImageView imagenCasilla;
    private ImageView casillaInicial;

    public String getNom() {
        return nom;
    }
    public List<Carta> getMa() {
        return ma;
    }
    public boolean isPatada() {
        return patada;
    }
    public boolean isZancadilla() {
        return zancadilla;
    }

    public void setMa(List<Carta> ma) {
        this.ma = new ArrayList<>();
        this.ma.addAll(ma);
    }
    public void setPatada(boolean patada) {
        this.patada = patada;
    }
    public void setZancadilla(boolean zancadilla) {
        this.zancadilla = zancadilla;
    }

    public Jugador (String nom) {
        this.nom = nom;
        this.ma = new ArrayList<>();
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public ImageView getImagenCasilla() {
        return imagenCasilla;
    }

    public void setImagenCasilla(ImageView imagenCasilla) {
        this.imagenCasilla = imagenCasilla;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ImageView getCasillaInicial() {
        return casillaInicial;
    }

    public void setCasillaInicial(ImageView casillaInicial) {
        this.casillaInicial = casillaInicial;
    }

    public int getFotoInicial() {
        return fotoInicial;
    }

    public void setFotoInicial(int fotoInicial) {
        this.fotoInicial = fotoInicial;
    }

    @Override
    public String toString() {
        return nom;
    }
}
