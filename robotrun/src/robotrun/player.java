package robotrun;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class player {

    public ImageIcon[] im = new ImageIcon[3];
    public int x;
    public int y;
    public int count = 0;

    player() {
        for (int i = 0; i < im.length; i++) {
            im[i] = new ImageIcon(this.getClass().getResource("player" + (i+1) + ".png"));
        }
    }
    public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
    
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,174,203));
    }
    
}
