
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ebinePaint {
    
    JButton tyhjennaNp, mustaNp, sininenNp, vihreaNp, punainenNp, magentaNp;
    piirtoAlue piirto;
    ActionListener jou;
    
    public static void main(String[] args){
        new ebinePaint().show();
    }

    public ebinePaint() {
        this.jou = new ActionListener(){
            
            //nappien toiminnot painettaessa
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tyhjennaNp) {
                    piirto.tyhjenna();
                } else if (e.getSource() == mustaNp) {
                    piirto.musta();
                } else if (e.getSource() == sininenNp) {
                    piirto.sininen();
                } else if (e.getSource() == vihreaNp) {
                    piirto.vihrea();
                } else if (e.getSource() == punainenNp) {
                    piirto.punainen();
                } else if (e.getSource() == magentaNp) {
                    piirto.magenta();
                }
            }
        };
    }
    
    public void show() {
        
        JFrame frame = new JFrame("Ebine Paint");
        Container content = frame.getContentPane();
        
        content.setLayout(new BorderLayout());
        
        piirto = new piirtoAlue();
        
        content.add(piirto, BorderLayout.CENTER);
        
        JPanel controls = new JPanel();
        
        //luodaan napit
        tyhjennaNp = new JButton("Tyhjennä");
        tyhjennaNp.addActionListener(jou);
        mustaNp = new JButton("Musta");
        mustaNp.addActionListener(jou);
        sininenNp = new JButton("Sininen");
        sininenNp.addActionListener(jou);
        vihreaNp = new JButton("Vihreä");
        vihreaNp.addActionListener(jou);
        punainenNp = new JButton("Punainen");
        punainenNp.addActionListener(jou);
        magentaNp = new JButton("Magenta");
        magentaNp.addActionListener(jou);
        
        //lisää paneeliin
        
        controls.add(vihreaNp);
        controls.add(sininenNp);
        controls.add(mustaNp);
        controls.add(punainenNp);
        controls.add(magentaNp);
        controls.add(tyhjennaNp);
        
        
        content.add(controls, BorderLayout.NORTH);
        
        frame.setSize(800,800);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        
    }
}
