import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class MainScreen {

	private JFrame frame;
	private GameStateInputPort gameState;
	private GameCreationInputPort gameCreation;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	
	public MainScreen(GameStateInputPort gameState, GameCreationInputPort gameCreation) {
		this.gameState = gameState;
		this.gameCreation = gameCreation;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel currentPlayerLabel = new JLabel();
		
		Image verseCardImage = gameState.getCardVerseImage();
		verseCardImage = verseCardImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                          MainScreen.class.getResource("image/outerspace.jpg"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }
		};
		panel.setBounds(0, 0, 1350, 730);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton objectiveButton = new JButton("");
		objectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image currentPlayerObjectiveCardImage = gameState.getCurrentPlayerObjectiveCardImage();
				currentPlayerObjectiveCardImage = currentPlayerObjectiveCardImage.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
		        JLabel objectiveImageLabel = new JLabel(new ImageIcon(currentPlayerObjectiveCardImage));
				JOptionPane.showMessageDialog(null, objectiveImageLabel," ",JOptionPane.PLAIN_MESSAGE, null);
			}
		});
		objectiveButton.setBounds(571, 292, 200, 200);
		objectiveButton.setIcon(new ImageIcon(verseCardImage));
		objectiveButton.setContentAreaFilled(false);
		objectiveButton.setBorder(null);
		
		panel.add(objectiveButton);
		
		JButton endTurnButton = new JButton("Passar turno");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameState.finishTurn();
				initialize();
				JOptionPane.showMessageDialog(null, "Turno: "+gameState.getCurrentRound()+"  Jogador: "+gameState.getCurrentPlayerName());
			
			}
		});
		endTurnButton.setBounds(730, 140, 89, 23);
		panel.add(endTurnButton);
		
		
		currentPlayerLabel.setText(gameState.getCurrentPlayerName()+" ("+gameState.getCurrentPlayerRace()+")");
		currentPlayerLabel.setForeground(Color.YELLOW);
		currentPlayerLabel.setFont(new Font("Tahoma", Font.PLAIN, 54));
		currentPlayerLabel.setBounds(497, 11, 635, 105);
		panel.add(currentPlayerLabel);
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
