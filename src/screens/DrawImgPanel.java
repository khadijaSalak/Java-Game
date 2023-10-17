package screens;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawImgPanel extends JPanel{
	Image img;
      DrawImgPanel(ImageIcon m1){
    	img=m1.getImage();  
    	  
      }
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(img, 40, 100, null, this);
    }
}
