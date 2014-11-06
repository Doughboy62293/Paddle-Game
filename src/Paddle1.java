import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class Paddle1 extends SimpleGame implements ActionListener{
	private Timer time;
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	public Paddle1(){
		xPos = 30;
		yPos = 20;
		width = 20;
		height = 100;
		
		time = new Timer(5, this);
		time.start();

	}
	
	public boolean isAHit(int topYValue, int lengthOfObject){
		if(topYValue > yPos && topYValue < yPos+height)
			return true;
		else
			return false;
	}
		
	public void decYPos(int value){
		System.out.println("down" + yPos + " " + (getHeight() - height));
		if(yPos - ((height) / 2) < (getHeight() - (2 * height)))
			yPos+=value;
	}
	
	public void incYPos(int value){
		if(yPos > 0)
			yPos-=value;
	}
	
	public void paint(Graphics g){
		//ball_full_resizable.createGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}	
}