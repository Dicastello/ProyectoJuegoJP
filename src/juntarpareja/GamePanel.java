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
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author MeraliCastillo
 */
public class GamePanel extends JPanel implements MouseListener{
     private JPanel Tablero,HistorialJ,JugadorTop,PanelScor,PanelJugador,titulo;
     private JLabel Scor,dIntentos,faIntentos,DatoMatriz,Lnombre,Lrecor,LpuntosTotal;
     private JList Top10;
    private int Fila=0,Columna=0;
    private JLabel l[];
    private JLabel Reiniciar[];
    private int ArreNumerico[];
    private int controlRepeticiones[];
    private int ControlPareja[];
    private int CantidadDeClic[];
    private JButton Rei,NuevoJuego;
    private int Click=0;
    private int Vista1=0;
    private int vista2=0;
    private int Puntos=0;
    private int intentos=0;
    private int intentoF=0;
    private int cant=0,c=0;
    private int inicio;
    
    
    public GamePanel(int i) {   
        inicio=i; 
        l=new JLabel[inicio];
        Reiniciar=new JLabel[inicio];        
        ArreNumerico=new int[inicio];
        ControlPareja=new int[inicio];
        CantidadDeClic=new int[inicio];
        controlRepeticiones=new int[inicio/2];
       
            setLayout(new BorderLayout());
          //  Panel del tablero
            Tablero= new JPanel();
             MostrarPuntajes();
            TamañoMatriz();
            Tablero.setLayout(new GridLayout(Fila,Columna,10,10));            
            add(Tablero,BorderLayout.CENTER);                  
             LlenadoLabel();
             MostrarDatosJugardo();
             InicializarComponentes();
            TopJugdores();
            
    }
    // tamaño de la matriz estos parametros van en el gridLayout
    private void TamañoMatriz(){
        switch (inicio) {
            case 30:
                Fila=5;
                Columna=6;    
                DatoMatriz.setText("    6 X 5    ");
                break;
            case 24:
                Fila=4;
                Columna=6;
                DatoMatriz.setText("    6 X 4    ");
                break;
            case 20:
                Fila=4;
                Columna=5;
                DatoMatriz.setText("    5 X 4    ");
                break;
            case 16:
                Fila=4;
                Columna=4;
                DatoMatriz.setText("    4 X 4    ");
                break;    
             case 12:
                Fila=3;
                Columna=4;
                DatoMatriz.setText("    4 X 3    ");
                break; 
             case 6:
                Fila=2;
                Columna=3;
                DatoMatriz.setText("    2 X 3    ");
             break;
                
            default:
                throw new AssertionError();
        }
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
            PosicionImagen=r.nextInt(inicio/2);
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
                    for (int j = 0; j < ArreNumerico.length; j++) {
                        System.out.println(j+"       "+this.ArreNumerico[j]);
                    }
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
    private void Guardar(){
        
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
            // Validar que se hago el juego
           if (c==3) {
            System.out.println("gano el suego");
                }          
                    System.out.println("vistas 1 y 2      "+Vista1+vista2);                        
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
        JugadorTop=  new JPanel();
        JugadorTop.setBorder(BorderFactory.createTitledBorder("TOP 10"));
         JugadorTop.setLayout(new BoxLayout(JugadorTop,BoxLayout.Y_AXIS));
        add(JugadorTop,BorderLayout.WEST);
        Top10=new JList();
        Top10.setFont(new Font("",Font.BOLD,18));
        Top10.setAlignmentY(Component.RIGHT_ALIGNMENT);       
        JugadorTop.add(Top10);
                
        titulo= new JPanel();
        JLabel ti= new JLabel("JUEGO DE MEMORIA");
        ti.setFont(new Font("",Font.BOLD,18));
        titulo.setBorder(BorderFactory.createTitledBorder(""));        
        titulo.add(ti);
        add(titulo,BorderLayout.NORTH);
        
    }
    //Llenado el historial del jugador en el lado derrecho de la pantalla
    private void HistorialDeJugdor() {
//            JLabel Esta= new JLabel("Prueba");   
//            HistorialJ= new JPanel();
//            HistorialJ.add(Esta);
////            Rei=new JButton();
////            Rei.setText("ONAN");
////            Rei.addMouseListener(this);
////            HistorialJ.add(Rei);
//            HistorialJ.setLayout(new BoxLayout(HistorialJ,BoxLayout.Y_AXIS));            
//            add(HistorialJ,BorderLayout.EAST);
    }
    // muestra los puntajes en el lado izquierdo de la pantalla 
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
        DatoMatriz= new JLabel("");
        DatoMatriz.setFont(new Font("",Font.BOLD,20));
        DatoMatriz.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(DatoMatriz);
        PanelScor.add(p1);
        
         
         
        //LABEL NUMERO DE INTENTOS           
        dIntentos=new JLabel("             0           ");
        dIntentos.setFont(new Font("Helvetica",Font.BOLD,20));
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
        Scor.setFont(new Font("",Font.BOLD,20));
        Scor.setAlignmentX(Component.LEFT_ALIGNMENT);
        p4.add(Scor);
        PanelScor.add(p4);
        
        //Botones  
        JPanel p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("BOTONES"));
        
        Rei=new JButton("REINICIAR");
         Rei.addMouseListener(this);
        Rei.setFont(new Font("",Font.BOLD,16));
        Rei.setAlignmentX(Component.LEFT_ALIGNMENT);
        p5.add(Rei);
        PanelScor.add(p5);
        
        NuevoJuego=new JButton("NUEVO JUEGO");
        NuevoJuego.addMouseListener(this);
        NuevoJuego.setFont(new Font("",Font.BOLD,16));
        NuevoJuego.setAlignmentX(Component.LEFT_ALIGNMENT);
        p5.add(NuevoJuego);
        PanelScor.add(p5);        
        BoxLayout layout5 = new BoxLayout(p1, BoxLayout.Y_AXIS);
         p1.setLayout(layout5);
         
         
         BoxLayout layout2 = new BoxLayout(p2, BoxLayout.Y_AXIS);
         p2.setLayout(layout2);
         BoxLayout layout3 = new BoxLayout(p3, BoxLayout.Y_AXIS);
         p3.setLayout(layout3);
         BoxLayout layout4 = new BoxLayout(p4, BoxLayout.Y_AXIS);
         p4.setLayout(layout4);   
        PanelScor.setLayout(new BoxLayout(PanelScor,BoxLayout.X_AXIS));
        add(PanelScor,BorderLayout.SOUTH);
    }
    //Muestra Todo los datos del jugador actual
    private void MostrarDatosJugardo(){
        //Lnombre,Lrecor,LpuntosTotal
        PanelJugador = new JPanel();
        PanelJugador.setBorder(BorderFactory.createTitledBorder("JUGADOR ACTUAL"));
        
        //PANELES SEGUNDARIOS
        JPanel p1 = new JPanel();  
        p1.setBorder(BorderFactory.createTitledBorder("  NOMBRE"));
        JPanel p2 = new JPanel();  
        p2.setBorder(BorderFactory.createTitledBorder("  RECOR"));
        JPanel p3 = new JPanel();  
        p3.setBorder(BorderFactory.createTitledBorder("  TOTAL PUNTOS"));
        
        //datos del nombre
        Lnombre= new JLabel("     ANONIMO     ");
        Lnombre.setFont(new Font("",Font.BOLD,18));
        Lnombre.setAlignmentY(Component.RIGHT_ALIGNMENT);
        p1.add(Lnombre);
        PanelJugador.add(p1);
        //Recor
        Lrecor= new JLabel("            0             ");
        Lrecor.setFont(new Font("",Font.BOLD,18));
        Lrecor.setAlignmentY(Component.RIGHT_ALIGNMENT);
        p2.add(Lrecor);
        PanelJugador.add(p2);
        //total de puntos
        LpuntosTotal= new JLabel("            0             ");
        LpuntosTotal.setFont(new Font("",Font.BOLD,18));
        LpuntosTotal.setAlignmentY(Component.RIGHT_ALIGNMENT);
        p3.add(LpuntosTotal);
        PanelJugador.add(p3);
        
               
        BoxLayout layout1 = new BoxLayout(p1, BoxLayout.Y_AXIS);
         p1.setLayout(layout1);
         BoxLayout layout2 = new BoxLayout(p2, BoxLayout.Y_AXIS);
         p2.setLayout(layout2);
         BoxLayout layout3 = new BoxLayout(p3, BoxLayout.Y_AXIS);
        p3.setLayout(layout3);
        PanelJugador.setLayout(new BoxLayout(PanelJugador,BoxLayout.Y_AXIS));
        add(PanelJugador,BorderLayout.EAST);
        
    }
        //Validar si al 2 al dar dos click busque la pareja, si no la encuentra que la oculte    
    private void ValidarPareja(int Vist, int vist2) {
        if (ArreNumerico[Vist]==ArreNumerico[vist2]) {
            Puntos+=10;
            Scor.setText("     "+Puntos+"     ");
            c++;
                    System.out.println("Cantidad de parejas encontradas"+c);
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
    // verifica si ya se presiono una ves un label 
    private boolean VerificarParejas(int i) {
        if (ControlPareja[i]!=1) {
          return true;      
        }else{
            System.out.println("gano");
             return false;
             
        }       
         }
    
    private void AgregarTopo(){
        
    }
    
   
   
}
 