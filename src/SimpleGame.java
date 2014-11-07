import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class SimpleGame extends Game implements ActionListener, KeyListener {
	private Ball ball;
	private Paddle1 paddle1;
	private Paddle2 paddle2;
	private Scoreboard score;
	Timer time;
	private int screenWidth;
	private int screenHeight;
	private static boolean keepGoing;
	
	// Left = false, Right = true
	private static boolean ballLeftOrRight;
	
	public SimpleGame(){
		this.screenWidth = 1280;
		this.screenHeight = 720;
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
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
	
	public void initializeGame(){
		ballLeftOrRight = true;
		keepGoing = true;
		ball = new Ball();
		paddle1 = new Paddle1();
		paddle2 = new Paddle2();
		score = new Scoreboard();
		
		
		time = new Timer(4, this);
		time.start();
	}
	
	public void keyPressed(KeyEvent e){
	    int keyCode = e.getKeyCode();
	    if(keepGoing){
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            paddle1.incYPos(10);
		            break;
		        case KeyEvent.VK_DOWN:
		            paddle1.decYPos(10);
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
	 * Error if all three are not overrided
	 */
	public void keyReleased(KeyEvent e){}

	/**
	 * Error if all three are not overrided
	 */
	public void keyTyped(KeyEvent e){}
	
	public void paintComponent(final Graphics g){
		super.paintComponent(g);

		setLayout(null);
		
		ball.paint(g);
		paddle1.paint(g);
		paddle2.paint(g);
		score.paint(g);
	}
	
	public boolean getKeepGoing(){
		return keepGoing;
	}
	
	public void stopGame(){
		keepGoing = false;
		ball.setHorizontalSpeed(0);
	}
	
	public void update(){
		paddle2.setBallPos(ball.getBallYPos(), ball.getBallDiameter());
		
		if(!getBallLeftOrRight() && ball.getBallXPos() == 50){
			System.out.println("1");
			if(paddle1.isAHit(ball.getBallYPos(), ball.getBallDiameter())){
				System.out.println("2");
				if(ball.topHalf(paddle1.getYPos(), paddle1.getYHeight())){
					System.out.println("3");
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
	
	public void actionPerformed(ActionEvent e){
		update();
		repaint();
	}
	
}
