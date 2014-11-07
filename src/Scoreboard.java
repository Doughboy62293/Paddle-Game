import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Scoreboard extends SimpleGame {
	private int score;
	
	public Scoreboard(){
		score = 0;
	}
	
	public void incScore(int value){
		score+=value;
	}
	
	public void paint(Graphics g){
		/*
		 * Text starts here
		 */
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		    RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Impact", Font.PLAIN, 16);
		g2.setFont(font);
	 
		g2.setColor(Color.BLUE);
		g2.drawString("SCORE", 1150, 75);
		
		Font font2 = new Font("Impact", Font.PLAIN, 60);
		g2.setFont(font2);
		g2.setColor(Color.WHITE);
		
		// Position the score itself
		if (score < 10)
			g2.drawString(Integer.toString(score), 1160, 155);
		else if (score < 100)
			g2.drawString(Integer.toString(score), 1142, 155);
		else if (score < 1000)
			g2.drawString(Integer.toString(score), 1128, 155);
		/*
		 * Text ends here
		 */
	}
}
