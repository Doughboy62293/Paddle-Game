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
	private int ballDiameter;
	private int ballXPos;
	private int ballYPos;
	private int speed;
	private int ySpeed;
	private int startSpeed;
	private Timer time;
	public Thread animate;
	private BufferedImage ball_full;
	private BufferedImage ball_full_resizable;

	public Ball(){
		speed = 2;
		ySpeed = 0;
		startSpeed = 2;
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
	
	public void setYPos(){
		ySpeed = 1;
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
		ballXPos = ballXPos + speed;
		ballYPos = ballYPos + ySpeed;
		
		System.out.println(ballYPos - ballDiameter);
		System.out.println(getHeight());
		
		if(ballYPos + ballDiameter > getHeight())
			ySpeed = -1;

		if(ballYPos < 1)
			ySpeed = 1;
		
		if(ballXPos > 750){
			speed = -(startSpeed);
			super.setBallLeftOrRight(false);
		}

		if(ballXPos < 50){
			speed = startSpeed;
			super.setBallLeftOrRight(true);
		}

        repaint();
	}
	
	public void paint(Graphics g){
		//ball_full_resizable.createGraphics();
		g.drawImage(ball_full, ballXPos, ballYPos, ballDiameter, ballDiameter, null);
	}
}
