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
	
	public Game() {
		super(new BorderLayout());

		
		gameDrawing = new SimpleGame();
		 // Set screen ratio 800 x 600
		setPreferredSize(new Dimension(800,600));
		gameDrawing.repaint();
		add(gameDrawing, BorderLayout.CENTER);
		gameDrawing.animate();
	}


	
	private static void createAndShowGUI(){
		// create and show game of life window
		JFrame frame = new JFrame("Paddle Fun");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add content to window
		frame.add(new Game());
		
		// display window
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				createAndShowGUI();
			}
			
		});
	}

}
