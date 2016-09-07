/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author MeraliCastillo
 */
public class Juego extends JFrame{
        int n=12;
    public Juego(int aux) {
        n=aux;
        Pantalla(aux);   
        
    }   
    
    
    //pantalla
    public void Pantalla(int n){        
        
        
       setTitle("Juntar Pareja");       
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
     //setSize(width, height);		
      JLabel[]la = new JLabel[n];
      int[] arrNum=new int[n]; 
      int num=8;
       GamePanel e= new GamePanel(n);
      // Panel e=new Panel();
       add(e);
        pack();
         setLocationRelativeTo(null);
    }
    
    
}
