/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giff;

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
/**
 *
 * @author Estudiante
 */
public class GIF extends JFrame{
    
    public GIF(){
        add(new Panel());
    }
    
    public static void main(String[] args) {
        GIF frame = new GIF();
        
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Panel extends JPanel implements ActionListener,MouseListener{
    
    private int x=200;
    private int x1;
    private int y=0;
    private int y1;
    private int secuencia;
    private Timer Timer;
    private Color color;
    private URL url = null;
    
    
    
    public Panel(){
        this.color = Color.CYAN;
        Timer = new Timer(100, this);
        Timer.start();
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo = loadImage("Fondii.png");
        g.drawImage(fondo, 0, 0, null);
        
        Image Ninja = loadImage("Ninja.png");
        g.drawImage(Ninja, x-50, 238, x+210, 238+221,secuencia*210,0,(secuencia*210)+210,221, this);
        
        Image caballo = loadImage("Caballo.png");
        g.drawImage(caballo, x+200, 330, x+200+227, 330+220,secuencia*227,0,(secuencia*227)+227,220, this);
        
        Image moneda = loadImage("FullCoins.png");
        g.drawImage(moneda, 0, 0, null);
      
    }
        
        public void DetectarCollision() {
        Rectangle tanque = getBounds();
        Rectangle object = new Rectangle(260,y,80,80);
        if(tanque.intersects(object)){
            Timer.stop();
        }
}
        
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x-5+400, 20, 15, 23);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 8;
        x1 += 0;
        y = 0;
        y1 += 0;
        if(this.secuencia == 2){
        this.secuencia = 0;
        }else
            this.secuencia++;
    
        
        
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
    
  }
