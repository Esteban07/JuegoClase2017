/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosclase2017;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author Estudiante
 */
public class Juegos extends JFrame{
    
    public Juegos(){
        add(new Panel());
    }
    
    public static void main(String[] args) {
        Juegos frame = new Juegos();
        
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Panel extends JPanel implements ActionListener,MouseListener{
    
    private int x;
    private int x1;
    private int y =250;
    private int y1 =250;
    private int secuencia;
    private Timer Timer;
    private Color color;
    private URL url = null;
    
    
    
    public Panel(){
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        this.color = Color.CYAN;
        Timer = new Timer(25, this);
        Timer.start();
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillOval(x+170, y-80, 50, 50);
        
        g.setColor(Color.green);
        g.fillOval(x1+250, y1-80, 70, 70);
        
        
        /*Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        
        Image gato = loadImage("cats.gif");
        g.drawImage(gato, x, y, x+132, y+80,this.secuencia*132,0, (this.secuencia*132)+132,80, this);
        
        Image moneda = loadImage("FullCoins.png");
        g.drawImage(moneda, 0, 0, null);*/
      
    }
        
        public void DetectarCollision() {
        Rectangle tanque = getBounds();
        Rectangle object = new Rectangle(260,y,20,40);
        if(tanque.intersects(object)){
            Timer.stop();
        }
}
        
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x-5+400, 345, 110, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*x += 5;
        x1 += 7;
        y += 0;
        y1 += 0;
        if(this.secuencia == 5){
        this.secuencia = 0;
        }else
            this.secuencia++;
    */
        
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(getBounds().contains(mp)){
            this.Timer.stop();
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
    
    private class TAdapter extends KeyAdapter {
        
        @Override
        public void keyReleased(KeyEvent e){
            System.out.println("Presione");
    }
    
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println("Listo");
            int Key = e.getKeyCode();
           
            if(Key == KeyEvent.VK_LEFT){
                x = x-10;
            }
            if(Key == KeyEvent.VK_RIGHT){
                x = x+10;
            }
            if(Key == KeyEvent.VK_DOWN){
                y = y+10;
            }
            if(Key == KeyEvent.VK_UP){
                y = y-10;
                  }
             
            if(Key == KeyEvent.VK_A){
                x1= x1-10;
                  }
             
            if(Key == KeyEvent.VK_D){
                x1 = x1+10;
                  }
             
            if(Key == KeyEvent.VK_S){
                y1 = y1+10;
                  }
 
            if(Key == KeyEvent.VK_W){
                y1 = y1-10;
                  }
            
    
  }
  }
}
            
      