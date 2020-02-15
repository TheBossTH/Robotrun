/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotrun;

import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author Pond
 */
public class enemy2 extends enemy {
    enemy2() {
        String imageLocation = "enemy2.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x -= 1;
                if (x <= -166) {
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(2);
                } catch (InterruptedException e) {
                }
            }
        }
    });
}
