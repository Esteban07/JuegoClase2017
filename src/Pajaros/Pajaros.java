/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pajaros;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pajaros extends JFrame {
    public Pajaros(){
    add(new NewPanel());
}
/**
 *
 * @author Diego
 */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Pajaros frame= new Pajaros();
      frame.setTitle("TestPaintComponent");
      frame.setSize(1024,512);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);    
    }  
}
class NewPanel extends JPanel implements ActionListener, MouseListener{
    private Timer time;
    private int x;
    private int y;
    private int secuencia =0;
    int aux=0;
     Rectangle Carro=this.getBounds();
     Rectangle obstaculo=new Rectangle(200,200,10,10);
    public NewPanel(){
        
        this.time=new Timer(500, this);
        this.time.start();
        this.x = 20;
    
        this.addMouseListener(this);
       
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
       Image fondo = loadImage("fondii.png");
       g.drawImage(fondo,0,0,null);
       
       
       
       Image pajaro = loadImage("pajaros.gif");
       g.drawImage(pajaro,100+x,100,100+148+x,100+129,secuencia*148, 0, secuencia*148+148, 129, this);
     
       
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x+6,100,100,70);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        x+=20;
    
        
        if(aux==0){
            this.secuencia++;
            if(secuencia==9){
                aux=1;
            }
        }
        if(aux==1){
            this.secuencia--;
             if(secuencia==0){
                aux=0;
            }
        }
        
        
      
        
        
        repaint();
       
       
    }
    
    
 public void checkCollisions(){
     Rectangle rCicle= Carro.getBounds();
     Rectangle rRect= obstaculo.getBounds();
     if(rCicle.intersects(rRect)){
         System.out.println("Colision");
         time.stop();
     }
 }
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp= e.getPoint();
        if(getBounds().contains(mp)){         
                time.stop(); 
                try {
             Thread.sleep(500);
              time.start();
         } catch (InterruptedException ex) {
             Logger.getLogger(NewPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        System.out.println("click");
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
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
}