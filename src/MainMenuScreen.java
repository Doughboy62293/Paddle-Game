
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainMenuScreen extends Game implements ActionListener{

private SimpleGame gameDrawing;
	private JFrame frame;
	private int ballSpeed;
	private int computerPaddleSpeed;

	/*
	 * Initialize our game in background
	 * for faster loading time
	 */
	public MainMenuScreen(JFrame frame, int screenWidth, int screenHeight){
		gameDrawing = new SimpleGame(screenWidth, screenHeight);
		this.frame = frame;
		ballSpeed = 2;
		computerPaddleSpeed = 2;
	}
	
	/**
	 * Clear the screen for the next panel
	 */
	public void ClearScreenContents(){
		frame.getContentPane().removeAll();
	}
	
	/**
	 * Set up frame for the next panel
	 * @param panel
	 */
	public void NewPane(JPanel panel){
		frame.getContentPane().add(panel);
		frame.getContentPane().repaint();
		frame.setVisible(true);
		panel.requestFocusInWindow();
	}

	/**
	 * Paint our menu screen that includes:
	 *     Button: New Game
	 *     Button: Instructions
	 *     Button: Help
	 *     
	 *     Radio Buttons for game difficulty:
	 *     Easy, Medium, Hard
	 */
	public void paintComponent(final Graphics g){
		setLayout(null);
		
		/*
		 * New game button
		 */
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameDrawing.initializeGame(ballSpeed, computerPaddleSpeed, frame);
				ClearScreenContents();
				gameDrawing.setKeepGoing(true);
				NewPane(gameDrawing);
			}
		});
		btnStartGame.setBounds(36, 138, 102, 25);
		add(btnStartGame);
		
		
		/*
		 * Options button
		 */
		JButton btnOptions = new JButton("Options");
		btnOptions.setBounds(150, 138, 138, 25);
		add(btnOptions);
		
		/*
		 * Help button
		 */
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(300, 138, 138, 25);
		add(btnHelp);
			
		/*
		 * Easy radio button
		 */
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setBounds(31, 211, 149, 23);
		rdbtnEasy.setSelected(true);
		add(rdbtnEasy);
		rdbtnEasy.setActionCommand("easy");
	    rdbtnEasy.addActionListener(this);
		
		/*
		 * Medium radio button
		 */
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setBounds(61, 245, 149, 23);
		add(rdbtnMedium);
		rdbtnMedium.setMnemonic(KeyEvent.VK_M);
		rdbtnMedium.setActionCommand("medium");
		rdbtnMedium.addActionListener(this);
		
		/*
		 * Hard radio button
		 */
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setBounds(88, 272, 149, 23);
		add(rdbtnHard);	
		rdbtnHard.setMnemonic(KeyEvent.VK_H);
		rdbtnHard.setActionCommand("hard");
		rdbtnHard.addActionListener(this);
		
		/*
		 * Group the radio buttons for ease of use
		 */
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnEasy);
	    group.add(rdbtnMedium);
	    group.add(rdbtnHard);    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String keyCode = e.getActionCommand();
	    if (keyCode == "easy"){
        	ballSpeed = 2;
        	computerPaddleSpeed = 1;
	    }else if (keyCode == "medium"){
        	ballSpeed = 3;
        	computerPaddleSpeed = 2;
	    }else if (keyCode == "hard"){
        	ballSpeed = 6;
        	computerPaddleSpeed = 4;
	    }
	}
}


