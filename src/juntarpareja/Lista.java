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
public class Lista {
    private Nodo cabeza = null;
   
    
    //Clase nodo
    public class Nodo{
    public jugador jugador;
    public Nodo siguiente = null;
 
    public Nodo(jugador jugador){
     this.jugador= jugador;
        }
    
    }
    //Insetar al principio
    public void InsertarPrincipio(jugador Jugador){
        Nodo nodo= new Nodo(Jugador);
        nodo.siguiente= cabeza;
        cabeza=nodo;
    }
     public void InsertarFinal(jugador Jugador){
         Nodo nodo = new Nodo(Jugador);
         Nodo puntero=cabeza;
         while(puntero.siguiente!=null){
             puntero=puntero.siguiente;
         } 
         puntero.siguiente=nodo;
     }
     public void InsertarDespues(int n,jugador Jugador){
         Nodo nodo= new Nodo(Jugador);
         if (cabeza== null) {
             cabeza=nodo;
         }else{
             Nodo puntero=cabeza;
             int cont=0;
             while(cont<n && puntero.siguiente!=null){
             puntero=puntero.siguiente;
             cont++;
             } 
             nodo.siguiente=puntero.siguiente;
             puntero.siguiente=nodo;
         }
     }
     public jugador Obtener(int n){
         if (cabeza==null) {
             return null;
         }else{
             Nodo puntero=cabeza;
             int cont=0;
             while(cont<n && puntero.siguiente!=null){
             puntero=puntero.siguiente;
             cont++;
         }
             if (cont!=n) {
                 return null;
             }else{
                 return puntero.jugador;
             }
        }
    }
     
    
            
}

