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


public class Paddle2 extends SimpleGame implements ActionListener{
	private Timer time;
	private int xPos;
	private int yPos;
	private int currentBallYPos;
	private int currentBallDiameter;
	private int width;
	private int height;
	
	public Paddle2(){
		xPos = 1200;
		yPos = 20;
		width = 20;
		height = 100;
		
		time = new Timer(4, this);
		time.start();
	}
	
	public void setBallPos(int currentBallYPos, int currentBallDiameter){
		this.currentBallYPos = currentBallYPos;
		this.currentBallDiameter = currentBallDiameter;
	}
	
	public void decYPos(int value){
		if(yPos - ((height) / 2) < (getHeight() - (2 * height)))
			yPos+=value;
	}
	
	public void incYPos(int value){
		if(yPos > 0)
			yPos-=value;
	}
	
	public void actionPerformed(ActionEvent e){
		if(getBallLeftOrRight() && getKeepGoing()){
			if(currentBallYPos < yPos){
				if(yPos > 0)
					yPos-=2;
			}
			else if(currentBallYPos + (2*currentBallDiameter) > yPos + height){
				if(yPos - ((height) / 2) < (getHeight() - (2 * height)))
					yPos+=2;
			}
				
		}

	}
	
	public void paint(Graphics g){
		//ball_full_resizable.createGraphics();
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}	
}