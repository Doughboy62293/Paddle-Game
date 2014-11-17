import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Options extends JPanel{
	private String background;
	private JFrame frame;
	private MainMenuScreen mainMenu;
	private int screenWidth;
	private int screenHeight;

	public Options(JFrame frame, int screenWidth, int screenHeight) {
		background = "green-soccer-field.jpg";
		this.frame = frame;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	


	public void paintComponent(final Graphics g){
		super.paintComponent(g);
		setLayout(null);
		
		JButton btnChooseBackground = new JButton("Choose Background");
		btnChooseBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChooseBackground.setBounds(30, 45, 117, 25);
		add(btnChooseBackground);
		
		JButton btnAboutGame = new JButton("About Game");
		btnAboutGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAboutGame.setBounds(12, 117, 117, 25);
		add(btnAboutGame);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainMenu = new MainMenuScreen(frame, screenWidth, screenHeight, background);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(mainMenu);
				frame.getContentPane().repaint();
				frame.setVisible(true);
				mainMenu.requestFocusInWindow();
			}
		});
		btnNewButton.setBounds(30, 206, 117, 25);
		add(btnNewButton);
	}
}
