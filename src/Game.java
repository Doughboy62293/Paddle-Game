import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Dimension;


public class Game extends JPanel implements Runnable{
	MainMenuScreen menu;
	private int screenWidth;
	private int screenHeight;
	
	private JFrame frame;
	
	public void run(){
		frame = new JFrame("Paddle Game");
		screenWidth = 1280;
		screenHeight = 720;
		
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(screenWidth, screenHeight));  //default is supposed to be 1280 x 720
		frame.setVisible(true);
		
		menu = new MainMenuScreen(frame);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(menu);
		frame.getContentPane().repaint();
		menu.requestFocusInWindow();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	
		frame.setTitle("Paddle Game");
	}
	
	public static void main(String[] args){
		(new Thread(new Game())).start();
	}
}
