/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author MeraliCastillo
 */
public class Juego extends JFrame{

    public Juego() {
        Pantalla();
        
        
    }
    
    
    
    
    //pantalla
    public void Pantalla(){        
       setTitle("Juntar Pareja");       
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width, height);		
       setLocationRelativeTo(null);
       Panel e=new Panel();
       add(e);
        
    }
    
    
}
//Paneles del Juego
class Panel extends JPanel{
    JPanel p2;
    public Panel() {
            //Panel de las estadisticas
            setLayout(new BorderLayout());
            JLabel Esta= new JLabel("Prueba");
            add(Esta,BorderLayout.EAST);
            //Panel del tablero
            p2= new JPanel();
            p2.setLayout(new GridLayout(2,2));
            
            add(p2,BorderLayout.CENTER);
            PonerLabel();
    }
    //Panel del tablero
    private void PonerLabel(){
     JLabel l[]= new JLabel[4];
        for (int i = 0; i < l.length; i++) {
            l[i]=new JLabel(); 
            l[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));            
            p2.add(l[i]);
        }
    }
    
}