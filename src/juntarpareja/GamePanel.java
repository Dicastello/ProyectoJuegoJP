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
import javax.swing.BoxLayout;
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
     private JPanel Tablero,HistorialJ,JugaadorTop;
    private JLabel l[]= new JLabel[8];
    private JLabel Reiniciar[]= new JLabel[8];
    private int ArreNumerico[]=new int[8];
    private int controlRepeticiones[]=new int[4];
    private JButton Rei;
    private int Click=0;
    private int Vista1=0;
    private int vista2=0;
    
    
    public GamePanel() {
                     
          //  Panel del tablero
            Tablero= new JPanel();
            Tablero.setLayout(new GridLayout(2,2));            
            add(Tablero,BorderLayout.CENTER);
            HistorialDeJugdor();
            TopJugdores();
             LlenadoLabel();
             InicializarComponentes();
    }
        
    private void InicializarComponentes() {
         //Panel de las estadisticas        
            ArregloImagenes();
            InicializarArreglo(ArreNumerico);
            InicializarArreglo(controlRepeticiones);
            RandonNumeros();
     
            
    }
    //Metodo para armar el Panel del tablero 
    private void LlenadoLabel(){          
        for (int i = 0; i < l.length; i++) {
            l[i]=new JLabel();
            l[i].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));          
            Tablero.add(l[i]);
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
                Click++;
                System.out.println(""+Click);
                Reiniciar[i].setIcon(AjustarImagen("/Imagen/"+ArreNumerico[i]+".jpg")); 
                if(Click==1){
                    Vista1=i;   
                           System.out.println("Vista 1"+Vista1);
                           System.out.println("posicion"+i);
                }else{
                    vista2=i;
                           System.out.println("Vista 1"+vista2);
                           System.out.println("posicion"+i);
                }
         
                System.out.println(""+i);
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {  }

    @Override
    public void mouseEntered(MouseEvent e) throws UnsupportedOperationException{}
    //metodo para validar en cotro las parejas
    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < Reiniciar.length; i++) {
            if (e.getSource()==Reiniciar[i]) {
                if (Click==2) {
                    ValidarPareja(Vista1,vista2);
                    Click=0;
                }
            }
        }
    }
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
            // this.repaint();
           return icono; 
   }

    private void TopJugdores() {
      JLabel prueba= new JLabel("Prueba");   
    }
    //Llenado el historial del jugador
    private void HistorialDeJugdor() {
            JLabel Esta= new JLabel("Prueba");   
            HistorialJ= new JPanel();
            HistorialJ.add(Esta);
            Rei=new JButton();
            Rei.setText("ONAN");
            Rei.addMouseListener(this);
            HistorialJ.add(Rei);
            HistorialJ.setLayout(new BoxLayout(HistorialJ,BoxLayout.Y_AXIS));            
            add(HistorialJ,BorderLayout.EAST);
    }

    private void ValidarPareja(int Vist, int vist2) {
        if (Reiniciar[Vist]==Reiniciar[vist2]) {
            
        }else{
            Reiniciar[Vist].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));
            Reiniciar[vist2].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));
            
        }
    }
   
   
}
 