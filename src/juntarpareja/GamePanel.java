/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MeraliCastillo
 */
public class GamePanel extends JPanel implements MouseListener{
     private JPanel p2;
    private JLabel l[]= new JLabel[8];
    private JLabel Reiniciar[]= new JLabel[8];
    private int ArreNumerico[]=new int[8];
    private int controlRepeticiones[]=new int[4];
    private JButton Rei;

    public GamePanel() {
        setLayout(new BorderLayout(100,1));
            JLabel Esta= new JLabel("Prueba");
            add(Esta,BorderLayout.EAST);
            Rei=new JButton();
            Rei.setText("ONAN");
            Rei.addMouseListener(this);
            add(Rei,BorderLayout.EAST);
            //Panel del tablero
            p2= new JPanel();
            p2.setLayout(new GridLayout(2,2));            
            add(p2,BorderLayout.CENTER);
             LlenadoLabel();
             InicializarComponentes();
    }
        
    private void InicializarComponentes() {
         //Panel de las estadisticas
        
            ArregloImagenes();
            RandonNumeros();
            InicializarArreglo(ArreNumerico);
            InicializarArreglo(controlRepeticiones);
           
            
    }
    //Metodo para armar el Panel del tablero 
    private void LlenadoLabel(){          
        for (int i = 0; i < l.length; i++) {
            l[i]=new JLabel();
            l[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));
            
            p2.add(l[i]);
        }       
    }
    // Metodo pare reiniciar las imagines del juego
     private void ArregloImagenes(){
        for (int i = 0; i <Reiniciar.length; i++) {
            Reiniciar[i]=l[i];
        }
        for (int i = 0; i < Reiniciar.length; i++) {
            Reiniciar[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));             
            Reiniciar[i].addMouseListener(this);
        }
   }
    //Metodo para generar los numeros aleatorios para cargar las imagenes en los JLeabel
    private void RandonNumeros(){
        int PosicionImagen;
        Random r= new Random();
        for (int i = 0; i < ArreNumerico.length; i++) {
            PosicionImagen=r.nextInt(4);
            if (controlRepeticiones[PosicionImagen]<2) {
                ArreNumerico[i]=PosicionImagen+1;   
                controlRepeticiones[PosicionImagen]++;
                System.out.print(ArreNumerico[i]+",");
            }else{
                i--;
            }
            
        }
        for (int i = 0; i <controlRepeticiones.length; i++) {
            System.out.print(controlRepeticiones[i]+"");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource()==Rei) {  
                
              InicializarComponentes();
            }
        for (int i = 0; i < Reiniciar.length; i++) {
            if (e.getSource()==Reiniciar[i]) {  
                l[i].setIcon(this.AjustarImagen("/Imagen/"+Reiniciar[i]+".jpg")); 
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {  }

    @Override
    public void mouseEntered(MouseEvent e) throws UnsupportedOperationException{}

    @Override
    public void mouseExited(MouseEvent e) {}
    //Se Nicializan en O
    private void InicializarArreglo(int[] Arreglo) {
        for (int i = 0; i < Arreglo.length; i++) {
          Arreglo[i]=0;  
        }
    }
    //Metodo para ajutas las imagenes Automaticamente
   private Icon AjustarImagen(String ruta){
           ImageIcon fot = new ImageIcon(getClass().getResource(ruta));
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(l[0].getWidth(),l[0].getHeight(), Image.SCALE_DEFAULT));
            //jLabel1.setIcon(icono);
             this.repaint();
           return icono; 
   }
   
   
}
 