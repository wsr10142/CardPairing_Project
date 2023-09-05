package myfinal;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;

public class ImagePanel extends JPanel {
	private Image image;
	 
	  // �غc�l
	  public ImagePanel() {
	      ;
	  }
	 
	  // �غc�l
	  public ImagePanel(Image image) {
	      this.image = image;
	  }
	 
	  public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.drawImage(image, 5, 5, 600, 450, this);
	  }
	 
	  public Image getImage() {
	      return image;
	  }
	 
	  public void setImage(Image image) {
	      this.image = image;
	  }
}
