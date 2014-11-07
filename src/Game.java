import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class Game extends JPanel{
	private SimpleGame gameDrawing;
	private int screenWidth;
	private int screenHeight;
    boolean keepPlaying;
	
	private JFrame frame = new JFrame("dunk-a-prof");
	
	public Game(){
		keepPlaying = true;
	}
	
	public void setKeepPlaying(){
		keepPlaying = false;
	}
	
	public boolean getKeepPlaying(){
		return keepPlaying;
	}
	
	public void createAndShowGUI(){
		Game game = new Game();
		keepPlaying = true;
		screenWidth = 1280;
		screenHeight = 720;
		
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(screenWidth, screenHeight));  //default is supposed to be 1280 x 720
		frame.setVisible(true);
		
		gameDrawing = new SimpleGame();
		gameDrawing.initializeGame();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameDrawing);
		frame.getContentPane().repaint();
		gameDrawing.requestFocusInWindow();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	
		frame.setTitle("Dunk-A-Prof");
		frame.setVisible(true);	
	}
	
	public static void main(String[] args){
		final Game game = new Game();
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				game.createAndShowGUI();
			}
			
		});
	}

}
