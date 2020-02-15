package robotrun;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class stage extends JPanel implements ActionListener {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("bg1.jpg"));
    private ImageIcon feild1 = new ImageIcon(this.getClass().getResource("bg1.jpg"));
    private ImageIcon feild2 = new ImageIcon(this.getClass().getResource("bg2.jpg"));
    private ImageIcon feild3 = new ImageIcon(this.getClass().getResource("bg2.jpg"));
    private ImageIcon feild4 = new ImageIcon(this.getClass().getResource("bg3.jpg"));
    private ImageIcon feild5 = new ImageIcon(this.getClass().getResource("bg3.jpg"));
    private ImageIcon gover = new ImageIcon(this.getClass().getResource("gameover.jpg"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
    private ImageIcon player1 = new ImageIcon(this.getClass().getResource("player1.png"));
    private ImageIcon te = new ImageIcon(this.getClass().getResource("Thruster Effects.gif"));
    private ImageIcon ammolef = new ImageIcon(this.getClass().getResource("ammolef.png"));
    private ImageIcon ammoleftext = new ImageIcon(this.getClass().getResource("ammoleftext.png"));
    private ImageIcon hp3 = new ImageIcon(this.getClass().getResource("hp3.png"));
    private ImageIcon hp2 = new ImageIcon(this.getClass().getResource("hp2.png"));
    private ImageIcon hp1 = new ImageIcon(this.getClass().getResource("hp1.png"));
    public ArrayList<Beam> beam = new ArrayList<Beam>();
    public ArrayList<enemy> enemy1 = new ArrayList<enemy>();
    public ArrayList<enemy> enemy2 = new ArrayList<enemy>();
    public ArrayList<enemy> enemy3 = new ArrayList<enemy>();
    public ArrayList<rocket> rocket1 = new ArrayList<rocket>();
    public ArrayList<box> box1 = new ArrayList<box>();
    public ArrayList<ammo> ammobox = new ArrayList<ammo>();
    public JButton BExit1 = new JButton(exit);
    boolean scorestart = true;
    boolean startenemy = false;
    public int score;
    public int ammoleft;
    public int hp;
    public int x1;

    player p1 = new player();

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (scorestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread tenemy1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 1700);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false && score < 50) {
                    enemy1.add(new enemy());
                }
            }
        }
    });
    
    Thread tenemy2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 1700);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false && score >= 50 && score < 100) {
                    enemy2.add(new enemy2());
                }
            }
        }
    });
    
    Thread tenemy3 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 1700);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false && score >= 100) {
                    enemy3.add(new enemy3());
                }
            }
        }
    });
    
    Thread trocket1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 2300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false) {
                    rocket1.add(new rocket());
                }
            }
        }
    });
    
    Thread tbox = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 1000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false) {
                    box1.add(new box());
                }
            }
        }
    });
    
    Thread tammo = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startenemy == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startenemy == false) {
                    ammobox.add(new ammo());
                }
            }
        }
    });

    Thread s = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (scorestart == false) {
                    score = (score + 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    
    Thread bgrun = new Thread(new Runnable() {
            public void run() {
            while (true) {
                if (scorestart == false) {
                    x1 += 2;
                    if(x1 == 1280){
                        x1 = 0;
                    }
                }
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
	});
    
    

    stage() {
        this.setLayout(null);
        this.setFocusable(true);
        BExit1.setOpaque(false);
        BExit1.setBorderPainted(false);
        BExit1.setContentAreaFilled(false);
        BExit1.setRolloverIcon(new ImageIcon(this.getClass().getResource("exitred.png")));
        
        BExit1.setBounds(1055, 62, 225, 62);
        add(BExit1);
        
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (a == KeyEvent.VK_UP) {
                    p1.count = 2;
                    p1.y = 100;
                }
                if (p1.count > 2) {
                    p1.count = 0;
                } else if (a == KeyEvent.VK_A && ammoleft > 0 ) {
                    p1.count = 1;
                    beam.add(new Beam(p1.x + 150, p1.y+90));
                    ammoleft -= 1;
                }
            }

            public void keyReleased(KeyEvent e) {
                p1.count = 0;
                p1.y = 275;
            }

        });
        p1.x = 95;
        p1.y = 275;
        
        
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(feild.getImage(), 0-x1, 0, 1280, 640, this);
        g.drawImage(feild1.getImage(), 1280-x1, 0, 1280, 640, this);
        
        if(score >= 50){
            g.drawImage(feild2.getImage(),0-x1,0,1280,640,this);
            g.drawImage(feild3.getImage(),1280-x1,0,1280,640,this);
        }
        if(score >= 100){
            g.drawImage(feild4.getImage(),0-x1,0,1280,640,this);
            g.drawImage(feild5.getImage(),1280-x1,0,1280,640,this);
        }
        
        if(p1.count == 2){
            g.drawImage(te.getImage(),p1.x-140, p1.y,256,256,this);
        }
        g.drawImage(p1.im[p1.count].getImage(), p1.x, p1.y, 174, 203, this);
        g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
        g.setColor(Color.WHITE);
        g.drawString("SCORE : " + score, 600, 100);
        if (p1.x < 0) {
            p1.x = this.getWidth() - 10;
        }
        if (p1.x > this.getWidth()) {
            p1.x = 20;
        }
        
        for (int i = 0; i < beam.size(); i++) {
            Beam ba = beam.get(i);
            g.drawImage(ba.b.getImage(), ba.x, ba.y, 200, 21, null);
            ba.move();
            if (ba.x > 1280) {
                beam.remove(i);
            }
        }
        
        for (int i = 0; i < rocket1.size(); i++) {
            g.drawImage(rocket1.get(i).getImage(), rocket1.get(i).getX(), rocket1.get(i).getY(), 133, 70, this);
        }
        for (int i = 0; i < beam.size(); i++) {
            for (int j = 0; j < rocket1.size(); j++) {
                if (Intersect(beam.get(i).getbound(), rocket1.get(j).getbound())) {
                    rocket1.remove(j);
                    beam.remove(i);
                    score += 15;
                }
            }
        }
        for (int i = 0; i < rocket1.size(); i++) {
            if (Intersect(p1.getbound(), rocket1.get(i).getbound())) {
                rocket1.remove(i);
                hp -= 1;
            }
        }
        
        for (int i = 0; i < ammobox.size(); i++) {
            g.drawImage(ammobox.get(i).getImage(), ammobox.get(i).getX(), ammobox.get(i).getY(), 105, 105, this);
        }
        for (int i = 0; i < ammobox.size(); i++) {
            if (Intersect(p1.getbound(), ammobox.get(i).getbound())) {
                ammobox.remove(i);
                ammoleft += 3;
                if(ammoleft > 5){
                    ammoleft = 5;
                }
            }
        }
        
        for (int i = 0; i < box1.size(); i++) {
            g.drawImage(box1.get(i).getImage(), box1.get(i).getX(), box1.get(i).getY(), 140, 140, this);
        }
        for (int i = 0; i < beam.size(); i++) {
            for (int j = 0; j < box1.size(); j++) {
                if (Intersect(beam.get(i).getbound(), box1.get(j).getbound())) {
                    beam.remove(i);
                }
            }
        }
        for (int i = 0; i < box1.size(); i++) {
            if (Intersect(p1.getbound(), box1.get(i).getbound())) {
                box1.remove(i);
                hp -= 1;
            }
        }
        
        for (int i = 0; i < enemy1.size(); i++) {
            g.drawImage(enemy1.get(i).getImage(), enemy1.get(i).getX(), enemy1.get(i).getY(), 166, 181, this);
        }
        for (int i = 0; i < beam.size(); i++) {
            for (int j = 0; j < enemy1.size(); j++) {
                if (Intersect(beam.get(i).getbound(), enemy1.get(j).getbound())) {
                    enemy1.remove(j);
                    beam.remove(i);
                    score += 10;
                }
            }
        }
        for (int i = 0; i < enemy1.size(); i++) {
            if (Intersect(p1.getbound(), enemy1.get(i).getbound())) {
                enemy1.remove(i);
                hp -= 1;
            }
        }
        
        for (int i = 0; i < enemy2.size(); i++) {
            g.drawImage(enemy2.get(i).getImage(), enemy2.get(i).getX(), enemy2.get(i).getY(), 166, 181, this);
        }
        for (int i = 0; i < beam.size(); i++) {
            for (int j = 0; j < enemy2.size(); j++) {
                if (Intersect(beam.get(i).getbound(), enemy2.get(j).getbound())) {
                    enemy2.remove(j);
                    beam.remove(i);
                    score += 15;
                }
            }
        }
        for (int i = 0; i < enemy2.size(); i++) {
            if (Intersect(p1.getbound(), enemy2.get(i).getbound())) {
                enemy2.remove(i);
                hp -= 1;
            }
        }
        
        for (int i = 0; i < enemy3.size(); i++) {
            g.drawImage(enemy3.get(i).getImage(), enemy3.get(i).getX(), enemy3.get(i).getY(), 166, 181, this);
        }
        for (int i = 0; i < beam.size(); i++) {
            for (int j = 0; j < enemy3.size(); j++) {
                if (Intersect(beam.get(i).getbound(), enemy3.get(j).getbound())) {
                    enemy3.remove(j);
                    beam.remove(i);
                    score += 20;
                }
            }
        }
        for (int i = 0; i < enemy3.size(); i++) {
            if (Intersect(p1.getbound(), enemy3.get(i).getbound())) {
                enemy3.remove(i);
                hp -= 1;
            }
        }
        
        if(hp == 3){
            g.drawImage(hp3.getImage(),10,10,413,31,this);
        }else if(hp == 2){
            g.drawImage(hp2.getImage(),10,10,413,31,this);
        }else if(hp == 1){
            g.drawImage(hp1.getImage(),10,10,413,31,this);
        }
        
        g.drawImage(ammoleftext.getImage(),20,65,210,35,this);
        if(ammoleft >= 1){
            g.drawImage(ammolef.getImage(),250,50,36,55,this);
        }if(ammoleft >= 2){
            g.drawImage(ammolef.getImage(),300,50,36,55,this);
        }if(ammoleft >= 3){
            g.drawImage(ammolef.getImage(),350,50,36,55,this);
        }if(ammoleft >= 4){
            g.drawImage(ammolef.getImage(),400,50,36,55,this);
        }if(ammoleft == 5){
            g.drawImage(ammolef.getImage(),450,50,36,55,this);
        }
        
        
        
        
        if(hp<=0){
                this.setLayout(null);
                scorestart = true;
                startenemy = true;
                g.drawImage(gover.getImage(),0,0,1280,640,this);
                BExit1.setBounds(550, 320, 225, 62);
		g.setColor(Color.WHITE);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE  :  "+score,500,270);
        }
        
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }
    

}
