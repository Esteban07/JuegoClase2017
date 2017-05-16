/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;                   /* Importaciones para que los métodos y acciones sean ejecutadas*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;
import java.awt.Graphics;
/**
 *
 * @author Estudiante
 */
public class Juegos extends JFrame{    //Habilita la salida de la ventana
     
    public Juegos(){                //Constructor, añadir el panel predeterminado                   
        add(new Panel());
    }
    
    public static void main(String[] args) {           
        Juegos frame = new Juegos();                 //Crea objeto y libera memoria
        
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000, 500);                                      //Configuración de la ventana
        frame.setLocationRelativeTo(null);                             //Nombre, tamaño, localización,pa que se cierre, visicle
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Panel extends JPanel implements ActionListener,MouseListener{     //Clase interna, Panel dentro de juegos, extends: hereda atributos o métodos, implements: métodos abstractos.
    
    private int x;
    private int x1;
    private int y = 330;
    private int y1;                           //Atributos necesarios
    private int secuencia;
    private Timer Timer;
    private Color color;
    private URL url = null;
    
    
    
    public Panel(){                                //Constructor clase panel, predeterminado
        this.color = Color.CYAN;
        Timer = new Timer(25, this);
        Timer.start();
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){    //Método para crear escenario
        super.paintComponent(g);                     //predeterminado 
        Image fondo = loadImage("fondo.png");        //Cargar imagen.
        g.drawImage(fondo, 0, 0, null);              //Colocarla, nombre,x,y,null
        
        Image gato = loadImage("cats.gif");       //Cargar imagen
        g.drawImage(gato, x, y, x+132, y+80,this.secuencia*132,0, (this.secuencia*132)+132,80, this); //nombre,x:inicio,y:inicio,x+ancho/num img,y+alto img,secuencia*ancho,0,secuencia*ancho+ancho,alto img, this.
        
        Image moneda = loadImage("FullCoins.png");
        g.drawImage(moneda, 0, 0, null);  
        g.drawRect(x,0,20,20);
    }
        
        public void DetectarCollision() {    //Detecta intersecciones
        Rectangle tanque = getBounds();
        Rectangle object = new Rectangle(100,0,20,20);
        
        if(tanque.intersects(object)){
            Timer.stop();
        }
}
        
    @Override
    public Rectangle getBounds(){     //algo para delimitar una figura 
        return new Rectangle(x, 0, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   //actualizacion creo... de novimientos
        x += 5;
        x1 += 7;
        y += 0;
        y1 += 0;
        if(this.secuencia == 5){
        this.secuencia = 0;
        }else
            this.secuencia++;
    
        
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { //
        Point mp = e.getPoint();
        
        if(getBounds().contains(mp)){
         
        }
        
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    public Image loadImage(String ImageName) {
        ImageIcon ii = new ImageIcon(ImageName);
        Image image = ii.getImage();
        return image;
    }
    
  }
