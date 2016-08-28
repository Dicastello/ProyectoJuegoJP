/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MeraliCastillo
 */
public class GamePanel extends JPanel implements MouseListener{
     private JPanel p2;
    private JLabel l[]= new JLabel[30];
    private int ArreNumerico[]=new int[30];
    private int controlRepeticiones[]=new int[15];

    public GamePanel() {
        InicializarComponentes();
    }

    private void InicializarComponentes() {
         //Panel de las estadisticas
            setLayout(new BorderLayout());
            JLabel Esta= new JLabel("Prueba");
            add(Esta,BorderLayout.EAST);
            //Panel del tablero
            p2= new JPanel();
            p2.setLayout(new GridLayout(5,6));            
            add(p2,BorderLayout.CENTER);
            LlenadoLabel();
            InicializarArreglo(ArreNumerico);
            InicializarArreglo(controlRepeticiones);
            RandonNumeros();
    }
    //Panel del tablero
    private void LlenadoLabel(){
     
        for (int i = 0; i < l.length; i++) {
            l[i]=new JLabel(); 
            l[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg"))); 
            l[i].addMouseListener(this);
            p2.add(l[i]);
        }
    }
    //Metodo para generar los numeros aleatorios para cargar las imagenes en los JLeabel
    private void RandonNumeros(){
        int PosicionImagen;
        Random r= new Random();
        for (int i = 0; i < ArreNumerico.length; i++) {
            PosicionImagen=r.nextInt(15);
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
    public void mouseClicked(MouseEvent e) throws UnsupportedOperationException{
        
        for (int i = 0; i < l.length; i++) {
            if (e.getSource()==l[i]) {  
                
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
    
}
