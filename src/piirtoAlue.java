
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class piirtoAlue extends JComponent{
    
    // kuva mihin piirretään
    private Image kuva;
    
    // Graphics2D objecti ==> käytetään piirtämiseen
    private Graphics2D g2;
    
    //hiiri koordinaatit
    private int currentX, currentY, oldX, oldY;
    
    public piirtoAlue(){
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e) {
                
               // tallennetaan koordinaatit, ku painetaan hiirtä
               oldX = e.getX();
               oldY = e.getY();
            }
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
         
            public void mouseDragged(MouseEvent e) {
               currentX = e.getX();
               currentY = e.getY();
               
               if (g2 != null) {
                   
                   // piirrä viiva jos g2 sisältö ei oo null
                   g2.drawLine(oldX, oldY, currentX, currentY);
                   
                   // päivitetään piirrustusalue piirrustukseen
                   repaint();
                   
                   //tallennetaan nykyiset koordinaatit x, y vanhoihin
                   oldX = currentX;
                   oldY = currentY;
               }
            }
            
        });
    }
    
    protected void paintComponent(Graphics g) {
        if (kuva == null){
            
            kuva = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) kuva.getGraphics();
            
            // antialiasing päälle
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
            // putsaa piirrustusalue
            tyhjenna();
        }
        
        g.drawImage(kuva, 0, 0, null);
        
    }
    
    public void tyhjenna() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
        
    public void punainen() {
        g2.setPaint(Color.red);
    }
    
    public void musta(){
        g2.setPaint(Color.black);
    }
    
    public void magenta() {
        g2.setPaint(Color.magenta);
    }
    
    public void vihrea() {
        g2.setPaint(Color.green);
    }
    
    public void sininen() {
        g2.setPaint(Color.blue);
    }
    
    
}
    
