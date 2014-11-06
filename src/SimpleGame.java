import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class SimpleGame extends JPanel {
	private int ballDiameter;
	private int ballXPos;
	private int ballYPos;
	private int speed;
	private int startSpeed;
	private Timer time;
	
	public SimpleGame(){
		speed = 2;
		startSpeed = 2;
		ballDiameter = 40;
		ballXPos = 50;
		ballYPos = 200;
	}
	
	public void animate(){
        final int animationTime = 1000;
        int framesPerSecond = 120;
        int delay = 1000 / framesPerSecond;
        final long start = System.currentTimeMillis();
        final Timer timer = new Timer(delay, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		ballXPos = ballXPos + speed;

        		if(ballXPos > 750){
        			speed = -(startSpeed);
        		}

        		if(ballXPos < 50){
        			speed = startSpeed;
        		}

                repaint();
            }
        });
        timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(ballXPos, ballYPos, ballDiameter, ballDiameter);
	}
}
