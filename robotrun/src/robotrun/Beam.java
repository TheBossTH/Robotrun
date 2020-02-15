package robotrun;

import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Beam extends JPanel{
    public int y;
    public int x;
    public int count=0;
    public ImageIcon b = new ImageIcon(this.getClass().getResource("beam.png"));
    Beam(int x,int y){
        this.x=x;
        this.y=y;
    }
	
    public void move(){
	this.x+=5;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,200,21));
    }
}
