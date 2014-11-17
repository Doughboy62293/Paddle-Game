import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Background extends SimpleGame{
	private BufferedImage background;
	
	public Background(String backgroundName){
		try {
			background = new BufferedImage(getWidth(), getHeight(),
		            BufferedImage.TYPE_INT_ARGB);
			background = ImageIO.read(getClass().getResource("background_images/" + backgroundName));
		} catch (IOException e) {
		}		
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g2d.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}	
}
