package robotrun;
import java.applet.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.ImageIcon;
public class EXThread extends Applet implements Runnable,KeyListener {
        Thread thread;
        int x=10,y=10,x2=5,y2=300,score=0;
        int distanceP;
        URL imageURL; 
        Image image;
        Image image2;
        
	public void init( ) {
            imageURL = this.getClass().getResource("enemy1.png");
            image = new ImageIcon(imageURL).getImage();
            imageURL = this.getClass().getResource("player1.png");
            image2 = new ImageIcon(imageURL).getImage();
            thread = new Thread(this);
            addKeyListener(this);
            setFocusable(true);
	}
	public void start( ) {
            
            thread.start( );						
        }
	public void paint(Graphics g) {
            g.drawImage(image, x, y, this);	
            g.drawImage(image2, x2, y2, this);
            g.setFont(new Font("Courier New", Font.ITALIC, 20));
            g.drawString("Score : "+score, 10, 20);
	}
	public void run( ) {
            while (thread != null) {
		repaint( );  								
                try{
                    if(x>getWidth()) x=0;
                    else x=x+10;
                    
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(x-x2),2))+(Math.pow(Math.abs(y-y2),2)));
                    if(distanceP<100){
                          score+=10;
                    }

                    thread.sleep(100);					
                } catch(InterruptedException e) {		
                    showStatus(" "+e);						
                }
            }
	}
	/*public void update(Graphics g) {
           // paint(g);
	}*/
	public void stop( )	{
            thread = null;						
	}

    @Override
    public void keyTyped(KeyEvent e) {   }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_UP){ y2-=10;  }
        if (e.getKeyCode()== KeyEvent.VK_DOWN){ y2+=10; }
        if (e.getKeyCode()== KeyEvent.VK_LEFT){ x2 -=10; }
        if (e.getKeyCode()== KeyEvent.VK_RIGHT) { x2 +=10; }
    }
    @Override
    public void keyReleased(KeyEvent e) {  }
}


