/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

/**
 *
 * @author MeraliCastillo
 */
public class jugador{
    private String  noombre;
    private int puntosT=0;
    private  int recor=0;

    public jugador(String nombre, int recors,int puntos) {
        nombre = noombre;
        recors = recor;
        puntos=puntosT;
    }

    public String getNoombre() {
        return noombre;
    }

    public void setNoombre(String noombre) {
        this.noombre = noombre;
    }

    public int getPuntosT() {
        return puntosT;
    }

    public void setPuntosT(int puntosT) {
        this.puntosT = puntosT;
    }

    public int getRecor() {
        return recor;
    }

    public void setRecor(int recor) {
        this.recor = recor;
    }
    
    
    
}
