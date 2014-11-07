
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuScreen extends Game{

private SimpleGame gameDrawing;
	private JFrame frame;

	public MainMenuScreen(JFrame frame){
		gameDrawing = new SimpleGame();
		gameDrawing.initializeGame();
		this.frame = frame;
	}
	
	/**
	 * Clear the screen before painting new image
	 */
	public void ClearScreenContents(){
		frame.getContentPane().removeAll();
	}
	
	public void NewPane(JPanel panel){
		frame.getContentPane().add(panel);
		frame.getContentPane().repaint();
		frame.setVisible(true);
		panel.requestFocusInWindow();
	}

	public void paintComponent(final Graphics g){
		setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearScreenContents();
				gameDrawing.setKeepGoing(true);
				NewPane(gameDrawing);
			}
		});
		btnStartGame.setBounds(36, 138, 102, 25);
		add(btnStartGame);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.setBounds(150, 138, 138, 25);
		add(btnOptions);
		
		JButton btnHelp = new JButton("Help");
			btnHelp.setBounds(300, 138, 138, 25);
			add(btnHelp);
		}
}


