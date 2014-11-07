import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class SimpleGame extends JPanel implements ActionListener, KeyListener {
	private Ball ball;
	private Paddle1 paddle1;
	private Paddle2 paddle2;
	private Scoreboard score;
	private Timer time;
	private int screenWidth;
	private int screenHeight;
	private static boolean keepGoing;
	// Left = false, Right = true
	private static boolean ballLeftOrRight;
	
	public SimpleGame(){
		this.screenWidth = 1280;
		this.screenHeight = 720;
	}
	
	public void initializeGame(int difficultySpeed, int computerSpeed){	
		this.setFocusable(true);
		this.addKeyListener(this);
				
		ballLeftOrRight = true;
		keepGoing = false;
		ball = new Ball(difficultySpeed);
		paddle1 = new Paddle1();
		paddle2 = new Paddle2(computerSpeed);
		score = new Scoreboard();
		
		time = new Timer(5, this);
		time.start();
	}
	
	
	/*
	 * Accessor methods below
	 */
	public void setBallLeftOrRight(boolean value){
		ballLeftOrRight = value;
	}
	
	public boolean getBallLeftOrRight(){
		return ballLeftOrRight;
	}
	
	public int getWidth(){
		return screenWidth;
	}
	
	public int getHeight(){
		return screenHeight;
	}
	
	public boolean getKeepGoing(){
		return keepGoing;
	}
	
	public void setKeepGoing(boolean value){
		keepGoing = value;
	}
	
	public void stopGame(){
		keepGoing = false;
		ball.setHorizontalSpeed(0);
	}
	
	/*
	 * Key Listeners below
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e){
	    int keyCode = e.getKeyCode();
	    if(keepGoing){
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            paddle1.incYPos(20);
		            break;
		        case KeyEvent.VK_DOWN:
		            paddle1.decYPos(20);
		            break;
		        case KeyEvent.VK_LEFT:
		            // handle left
		            break;
		        case KeyEvent.VK_RIGHT :
		            // handle right
		            break;
		    }
	    }
	    
	    repaint();
	}
	
	public void keyReleased(KeyEvent e){
	    int keyCode = e.getKeyCode();
	    if(keepGoing){
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            paddle1.incYPos(20);
		            break;
		        case KeyEvent.VK_DOWN:
		            paddle1.decYPos(20);
		            break;
		        case KeyEvent.VK_LEFT:
		            // handle left
		            break;
		        case KeyEvent.VK_RIGHT :
		            // handle right
		            break;
		    }
	    }
	    
	    repaint();
	}

	/**
	 * Error if all three are not overwritten
	 */
	public void keyTyped(KeyEvent e){}
	
	/**
	 * Call the paint methods of all our objects here
	 */
	public void paintComponent(final Graphics g){
		super.paintComponent(g);
		
		ball.paint(g);
		paddle1.paint(g);
		paddle2.paint(g);
		score.paint(g);
	}
	
	/**
	 * Check here to see status of game
	 */
	public void update(){
		paddle2.setBallPos(ball.getBallYPos(), ball.getBallDiameter());
		
		if(!getBallLeftOrRight() && ball.getBallXPos() == 50){
			if(paddle1.isAHit(ball.getBallYPos(), ball.getBallDiameter())){
				if(ball.topHalf(paddle1.getYPos(), paddle1.getYHeight())){;
					ball.upSpeed();
				}else{
					ball.downSpeed();
				}
				score.incScore(10);
			}else{
				stopGame();
			}
		}
	}
	
	/**
	 * Constantly check status and repaint
	 */
	public void actionPerformed(ActionEvent e){		
		update();
		repaint();
	}
	
}
