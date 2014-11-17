import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
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
	}
	
	public boolean isAHit(int topYValue, int lengthOfObject){
		if(topYValue > yPos-lengthOfObject && topYValue < yPos+height)
			return true;
		else
			return false;
	}
	
	public void reset(){
		xPos = 30;
		yPos = 20;
		width = 20;
		height = 100;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public int getYHeight(){
		return height;
	}
		
	public void decYPos(int value){
		if(yPos - ((height) / 2) < (getHeight() - (2 * height)))
			yPos+=value;
	}
	
	public void incYPos(int value){
		if(yPos > 0)
			yPos-=value;
	}
	
	public void paint(Graphics g){
		//ball_full_resizable.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
	}	
}