package robotrun;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class howto extends JPanel {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("howto.jpg"));
    private ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    public JButton BBack = new JButton(back);
    

    howto() {
        setLayout(null);
        
        BBack.setOpaque(false);
        BBack.setBorderPainted(false);
        BBack.setContentAreaFilled(false);
        BBack.setRolloverIcon(new ImageIcon(this.getClass().getResource("backred.png")));

        BBack.setBounds(527, 465, 225, 62);
        add(BBack);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(feild.getImage(), 0, 0, 1280, 640, this);
    }
}
