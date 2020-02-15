package robotrun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Robotrun extends JFrame implements ActionListener {

    mainmenu memu = new mainmenu();
    stage state1 = new stage();
    howto howto1 = new howto();

    public Robotrun(){
        this.setSize(1280, 640);
        this.add(memu);
        memu.BExit1.addActionListener(this);
        memu.BHowto.addActionListener(this);
        memu.BStart.addActionListener(this);
        howto1.BBack.addActionListener(this);
        state1.BExit1.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == memu.BStart) {
            this.setLocationRelativeTo(null);
            this.remove(memu);
            this.setSize(1280, 640);
            this.add(state1);
            state1.requestFocusInWindow();
            state1.scorestart = false;
            state1.startenemy = false;
            state1.score = 0;
            state1.ammoleft = 5;
            state1.hp = 3;
            state1.actor.start();
            state1.s.start();
            state1.time.start();
            state1.tenemy1.start();
            state1.tenemy2.start();
            state1.tenemy3.start();
            state1.trocket1.start();
            state1.tammo.start();
            state1.tbox.start();
            state1.bgrun.start();
            
        } else if (e.getSource() == memu.BHowto) {
            this.setLocationRelativeTo(null);
            this.setSize(1280, 640);
            this.remove(memu);
            this.add(howto1);
        } else if (e.getSource() == howto1.BBack) {
            this.setLocationRelativeTo(null);
            this.remove(howto1);
            this.setSize(1280, 640);
            this.add(memu);
        } else if (e.getSource() == state1.BExit1) {
            System.exit(0);
        } else if (e.getSource() == memu.BExit1) {
            System.exit(0);
        }
        
        this.validate();
        this.repaint();
    }

    public static void main(String[] args){
        JFrame jf = new Robotrun();
        jf.setSize(1280, 640);
        jf.setTitle("Robot Run");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        
        
    }
    
    
}

