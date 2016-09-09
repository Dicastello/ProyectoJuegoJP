/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.io.Serializable;

/**
 *
 * @author MeraliCastillo
 */
public class jugador implements Serializable{
    private String  nombre;
    private int puntosT=0;
    private  int recor=0;

    public jugador() {
    }
    public jugador(String nombre){
        this.nombre=nombre;
    }

    public jugador(String nombre, int recor,int puntosT) {
        this.nombre = nombre;
        this.recor = recor;
        this.puntosT=puntosT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
