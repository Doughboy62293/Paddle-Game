import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class Ball extends SimpleGame implements ActionListener{
	private static int ballDiameter;
	private static int ballXPos;
	private int ballYPos;
	private int speed;
	private int ySpeed;
	private int startSpeed;
	private Timer time;
	public Thread animate;
	private BufferedImage ball_full;
	private BufferedImage ball_full_resizable;
	
	public Ball(int speed){
		this.speed = speed;
		startSpeed = speed;
		ySpeed = 0;
		ballDiameter = 40;
		ballXPos = 50;
		ballYPos = 200;
		
		try {
			
			ball_full = ImageIO.read(getClass().getResource("Ball_full.png"));
		} catch (IOException e) {
		}
		time = new Timer(5, this);
		time.start();
	}

	public Ball(){
		speed = 4;
		ySpeed = 0;
		startSpeed = 4;
		ballDiameter = 40;
		ballXPos = 50;
		ballYPos = 200;
		
		try {
			ball_full = ImageIO.read(new File("Ball_full.png"));
		} catch (IOException e) {
		}
		time = new Timer(5, this);
		time.start();
	}
	
	public void downSpeed(){
		ySpeed = 1;
	}
	
	public void upSpeed(){
		ySpeed = -1;
	}
	
	public void setHorizontalSpeed(int speed){
		this.speed = speed;
	}
	
	public boolean topHalf(int yPos, int height){
		if(ballYPos < (yPos + height) - (height/2))
			return true;
		else
			return false;
	}
	
	public int getBallXPos(){
		return ballXPos;
	}
	
	public int getBallYPos(){
		return ballYPos;
	}
	
	public int getBallDiameter(){
		return ballDiameter;
	}
	
		
	public void actionPerformed(ActionEvent e){
		if(getKeepGoing()){
			if(ballYPos + (2*ballDiameter) > getHeight())
				ySpeed = -1;
	
			if(ballYPos < 1)
				ySpeed = 1;
			
			if(ballXPos > 1160){
				speed = -(startSpeed);
				setBallLeftOrRight(false);
			}
			
			if(ballXPos < 50){
				speed = startSpeed;
				setBallLeftOrRight(true);
			}
			
			ballYPos = ballYPos + ySpeed;
			ballXPos = ballXPos + speed;
		}
	}
	
	public void paint(Graphics g){
		//ball_full_resizable.createGraphics();
		g.drawImage(ball_full, ballXPos, ballYPos, ballDiameter, ballDiameter, null);
	}
}
