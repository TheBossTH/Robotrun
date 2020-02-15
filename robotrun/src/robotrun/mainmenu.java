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

public class mainmenu extends JPanel {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("mainmenu.jpg"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
    private ImageIcon howto = new ImageIcon(this.getClass().getResource("howtoplay.png"));
    public JButton BStart = new JButton(starts);
    public JButton BHowto = new JButton(howto);
    public JButton BExit1 = new JButton(exit);
    

    mainmenu() {
        setLayout(null);
        BStart.setOpaque(false);
        BStart.setBorderPainted(false);
        BStart.setContentAreaFilled(false);
        BStart.setRolloverIcon(new ImageIcon(this.getClass().getResource("startred.png")));
        
        BHowto.setOpaque(false);
        BHowto.setBorderPainted(false);
        BHowto.setContentAreaFilled(false);
        BHowto.setRolloverIcon(new ImageIcon(this.getClass().getResource("howtoplayred.png")));
        
        BExit1.setOpaque(false);
        BExit1.setBorderPainted(false);
        BExit1.setContentAreaFilled(false);
        BExit1.setRolloverIcon(new ImageIcon(this.getClass().getResource("exitred.png")));

        BExit1.setBounds(550, 465, 180, 62);
        add(BExit1);
        BStart.setBounds(516, 275, 248, 62);
        add(BStart);
        BHowto.setBounds(378, 370, 524, 62);
        add(BHowto);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(feild.getImage(), 0, 0, 1280, 640, this);
    }
}
