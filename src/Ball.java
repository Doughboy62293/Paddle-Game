import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class Ball extends SimpleGame implements ActionListener{
	private static int ballDiameter;
	private int ballXPos;
	private int ballYPos;
	private int speed;
	private int ySpeed;
	private int startSpeed;
	private Timer time;
	public Thread animate;
	private BufferedImage ball_full;
	
	/**
	 * Constructor sets the default speed,
	 * ball position, ball size, loads the 
	 * ball image, and starts the timer
	 * @param speed
	 */
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
	
	public void reset(){
		speed = startSpeed;
		ySpeed = 0;
		ballDiameter = 40;
		ballXPos = 50;
		ballYPos = 200;
	}
	
	/*
	 * Change the direction of the ball to go down
	 */
	public void downSpeed(){
		ySpeed = 1;
	}

	/*
	 * Change the direction of the ball to go up
	 */
	public void upSpeed(){
		ySpeed = -1;
	}
	
	/*
	 * Change the horizontal direction of the ball
	 */
	public void setHorizontalSpeed(int speed){
		this.speed = speed;
	}
	
	/**
	 * Check to see if the ball hit the top half
	 * of the stick or the bottom half.  If it hits
	 * the top half, direct the ball upward, if it
	 * hits the bottom half, direct the ball downward
	 * @param yPos
	 * @param height
	 * @return
	 */
	public boolean topHalf(int yPos, int height){
		if(ballYPos + (ballDiameter/2) < (yPos + height) - (height/2))
			return true;
		else
			return false;
	}
	
	/*
	 * Accessor methods below
	 */
	public int getBallXPos(){
		return ballXPos;
	}
	
	public int getBallYPos(){
		return ballYPos;
	}
	
	public int getBallDiameter(){
		return ballDiameter;
	}
	
	/**
	 * Constant check the direction of the ball,
	 * if it hit a wall or a barrier, and change 
	 * appropriate values
	 */
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
	
	/**
	 * Paint the basketball
	 */
	public void paint(Graphics g){
		g.drawImage(ball_full, ballXPos, ballYPos, ballDiameter, ballDiameter, null);
	}
}
