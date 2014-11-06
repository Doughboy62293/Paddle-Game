import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class SimpleGame extends Game implements ActionListener, KeyListener {
	private Ball ball;
	private Paddle1 paddle1;
	private Timer time;
	private final int screenWidth;
	private final int screenHeight;
	
	// Left = false, Right = true
	private boolean ballLeftOrRight;
	
	public SimpleGame(){
		this.screenWidth = 1280;
		this.screenHeight = 720;
	}
	
	public SimpleGame(int screenWidth, int screenHeight){
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		addKeyListener(this);
		this.setFocusable(true);
	}
	
	public void setBallLeftOrRight(boolean value){
		ballLeftOrRight = value;
	}
	
	public int getWidth(){
		return screenWidth;
	}
	
	public int getHeight(){
		return screenHeight;
	}
	
	public void initializeGame(){
		paddle1 = new Paddle1();
		ball = new Ball();
		time = new Timer(5, this);
		time.start();		
	}
	
	public void keyPressed(KeyEvent e){
		System.out.println("Pressed");
	    int keyCode = e.getKeyCode();
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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		setLayout(null);
		
		ball.paint(g);
		paddle1.paint(g);
	}
	
	public void actionPerformed(ActionEvent e){
		if(!ballLeftOrRight && ball.getBallXPos() < 51)
			if(paddle1.isAHit(ball.getBallYPos(), ball.getBallDiameter()))
				ball.setYPos();
		
		repaint();
	}
}
