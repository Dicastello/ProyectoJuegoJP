/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juntarpareja;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.BorderFactory;
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
     private JPanel Tablero,HistorialJ,JugaadorTop,PanelScor;
     private JLabel Scor,dIntentos,faIntentos;
    private JLabel l[];
    private JLabel Reiniciar[];
    private int ArreNumerico[]=new int[8];
    private int controlRepeticiones[]=new int[4];
    private int ControlPareja[]=new int[8];
    private int CantidadDeClic[]=new int[8];
    private JButton Rei;
    private int Click=0;
    private int Vista1=0;
    private int vista2=0;
    private int Puntos=0;
    private int intentos=0;
    private int intentoF=0;
    private int cant=0;

    
    
    public GamePanel(JLabel[] la) {   
        l=la;
        Reiniciar=la;
            setLayout(new BorderLayout());
          //  Panel del tablero
            Tablero= new JPanel();
            Tablero.setLayout(new GridLayout(2,2,10,10));            
            add(Tablero,BorderLayout.CENTER);
            HistorialDeJugdor();            
             LlenadoLabel();
             InicializarComponentes();
            // TopJugdores();
            MostrarPuntajes();
    }
        
    private void InicializarComponentes() {
         //Panel de las estadisticas        
            ArregloImagenes(); 
            InicializarArreglo(ArreNumerico);
            InicializarArreglo(controlRepeticiones);
            InicializarArreglo(ControlPareja);
            InicializarArreglo(CantidadDeClic);            
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
    private void RenicializarVariables(){
                Puntos=0;                
                Click=0;
                System.out.println(" puntoo   "+Puntos);
                Vista1=0;
                vista2=0;
                Scor.setText("       0      ");
                 intentos=0;
                dIntentos.setText("             0           ");   
                 intentoF=0;
                 faIntentos.setText("            0            ");
        
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource()==Rei) { 
            InicializarComponentes();
            RenicializarVariables();                
                
            }
        for (int i = 0; i < Reiniciar.length; i++) {
            if (e.getSource()==Reiniciar[i]&& VerificarParejas(i)) { 
                CantidadDeClic[i]++;                
                if (CantidadDeClic[i]<2) {
                  Click++;             
                System.out.println(" click sair "+Click);
                Reiniciar[i].setIcon(AjustarImagen("/Imagen/"+ArreNumerico[i]+".jpg")); 
                if(Click==1){
                    Vista1 = i;   
                           System.out.println("Vista 1   "+Vista1);
                    }else{
                    vista2=i;
                           System.out.println("Vista 2  "+vista2);
                   intentos++;
                this.dIntentos.setText("            "+intentos+"            ");
                    }
               
                }
                                
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
                    System.out.println("vistas 1 y 2"+Vista1+vista2);                        
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
    // Listado en el lado izquiedo de la pantalla de en tiempo real del top 10 de los mejores jugadores
    private void TopJugdores() {
      JLabel prueba= new JLabel("Prueba");   
    }
    //Llenado el historial del jugador en el lado derrecho de la pantalla
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
    // muestra los puntajes en el lado isquierdo de la pantalla 
    private void MostrarPuntajes(){
        PanelScor= new JPanel();
        PanelScor.setBorder(BorderFactory.createTitledBorder("SCORS"));
        JPanel p1 = new JPanel();  
        p1.setBorder(BorderFactory.createTitledBorder("  MATRIZ"));
        
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder(" TOTAL INTENTOS"));
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("  INTENTOS FALLIDOS"));
        JPanel p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("  PUNTOS"));
        
         BoxLayout layout1 = new BoxLayout(p1, BoxLayout.Y_AXIS);
         p1.setLayout(layout1);
//         //Label MUSTRAR MAATRIZ
        JLabel DatoMatriz= new JLabel("   oxo   ");
        DatoMatriz.setFont(new Font("",Font.BOLD,18));
        DatoMatriz.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(DatoMatriz);
        PanelScor.add(p1);
         
         
        //LABEL NUMERO DE INTENTOS           
        dIntentos=new JLabel("             0           ");
        dIntentos.setFont(new Font("Helvetica",Font.BOLD,18));
        dIntentos.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(dIntentos);
        PanelScor.add(p2);
        
              //LABEL NUMERO DE INTENTOS FALLIDOS            
        faIntentos=new JLabel("          0           ");
        faIntentos.setFont(new Font("  ",Font.BOLD,20));
        faIntentos.setAlignmentX(Component.LEFT_ALIGNMENT);
        p3.add(faIntentos);
        PanelScor.add(p3);
        
          //LABEL PUTAJE          
        Scor=new JLabel("       0       ");
        Scor.setFont(new Font("",Font.BOLD,18));
        Scor.setAlignmentX(Component.LEFT_ALIGNMENT);
        p4.add(Scor);
        PanelScor.add(p4);
         
         BoxLayout layout2 = new BoxLayout(p2, BoxLayout.Y_AXIS);
         p2.setLayout(layout2);
         BoxLayout layout3 = new BoxLayout(p3, BoxLayout.Y_AXIS);
         p3.setLayout(layout3);
         BoxLayout layout4 = new BoxLayout(p4, BoxLayout.Y_AXIS);
         p4.setLayout(layout4);   
        PanelScor.setLayout(new BoxLayout(PanelScor,BoxLayout.X_AXIS));
        add(PanelScor,BorderLayout.SOUTH);
    }
            
    private void ValidarPareja(int Vist, int vist2) {
        if (ArreNumerico[Vist]==ArreNumerico[vist2]) {
            Puntos+=10;
            Scor.setText("     "+Puntos+"     ");
            ControlPareja[Vist]=1;
            ControlPareja[vist2]=1;
            
        }else{
            Reiniciar[Vist].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));
            Reiniciar[vist2].setIcon(new ImageIcon(getClass().getResource("/Imagen/Buscar.jpg")));
            CantidadDeClic[Vist]=0;
            CantidadDeClic[vist2]=0;      
            intentoF++;
            this.faIntentos.setText("            "+intentoF+"            ");
            if (Puntos>=5) {
                Puntos-=5;
                 Scor.setText("     "+Puntos+"     ");
            }
          
        }
    }

    private boolean VerificarParejas(int i) {
        if (ControlPareja[i]!=1) {
          return true;      
        }else{
             return false;
        }       
         }
    
   
   
}
 