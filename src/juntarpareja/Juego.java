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

    public Juego() {
        Pantalla();   
        
    }   
    
    
    //pantalla
    public void Pantalla(){        
       setTitle("Juntar Pareja");       
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
     //setSize(width, height);		
      JLabel[]la = new JLabel[8];
       GamePanel e= new GamePanel(la);
      // Panel e=new Panel();
       add(e);
        pack();
         setLocationRelativeTo(null);
    }
    
    
}
////Paneles del Juego
//class Panel extends JPanel implements MouseListener{
//    private JPanel p2;
//    private JLabel l[]= new JLabel[4];
//    private int ArreNumerico[]=new int[4];
//    private int controlRepeticiones[]=new int[2];
//    public Panel() {
//            //Panel de las estadisticas
//            setLayout(new BorderLayout());
//            JLabel Esta= new JLabel("Prueba");
//            add(Esta,BorderLayout.EAST);
//            //Panel del tablero
//            p2= new JPanel();
//            p2.setLayout(new GridLayout(2,2));
//            
//            add(p2,BorderLayout.CENTER);
//            PonerLabel();
//    }
//    //Panel del tablero
//    private void PonerLabel(){
//     
//        for (int i = 0; i < l.length; i++) {
//            l[i]=new JLabel(); 
//            l[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg"))); 
//            l[i].addMouseListener(this);
//            p2.add(l[i]);
//        }
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) throws UnsupportedOperationException{
//        
//        for (int i = 0; i < l.length; i++) {
//            if (e.getSource()==l[i]) {  
//                
//            }
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) { }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {  }
//
//    @Override
//    public void mouseEntered(MouseEvent e) throws UnsupportedOperationException{}
//
//    @Override
//    public void mouseExited(MouseEvent e) {}
//    
//}