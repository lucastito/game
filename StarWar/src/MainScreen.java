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
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;
import java.util.List;


public class MainScreen {

	private JFrame frame;
	private GameStateInputPort gameState;
	private GameCreationInputPort gameCreation;
	private JLabel currentPlayerLabel = new JLabel();
	private JPanel panel_1 = new JPanel();
	private JLabel lblNewLabel = null;

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
		
		
		
		Image verseCardImage = gameState.getCardVerseImage();
		verseCardImage = verseCardImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		
//		Image verseTerritoryCardImage = gameState.getTerritoryCardVerseImage();
//		verseTerritoryCardImage = verseTerritoryCardImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		
		
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
		objectiveButton.setBounds(0, 530, 200, 200);
		objectiveButton.setIcon(new ImageIcon(verseCardImage));
		objectiveButton.setContentAreaFilled(false);
		objectiveButton.setBorder(null);
		
		panel.add(objectiveButton);
		
		JButton endTurnButton = new JButton("Passar turno");
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameState.finishTurn();
				initialize();
				currentPlayerLabel.validate();
				JOptionPane.showMessageDialog(null, "Turno: "+gameState.getCurrentRound()+"  Jogador: "+gameState.getCurrentPlayerName());
			
			}
		});
		endTurnButton.setBounds(730, 140, 89, 23);
		panel.add(endTurnButton);
		
		//JPanel panel_1 = new JPanel();
		panel_1.setBounds(129, 140, 550, 167);
		panel_1.setVisible(false);
		panel.add(panel_1);
		
		lblNewLabel = new JLabel("Muda por favor");
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel_1.isVisible())
					panel_1.setVisible(false);
				else
					panel_1.setVisible(true);
				lblNewLabel.setText("Mudei"+Math.random());
			}
		});
		btnNewButton.setBounds(310, 399, 89, 23);
		panel.add(btnNewButton);
		currentPlayerLabel.setBounds(233, 11, 609, 66);
		panel.add(currentPlayerLabel);
		
		
		currentPlayerLabel.setText(gameState.getCurrentPlayerName()+" ("+gameState.getCurrentPlayerRace()+")");
		currentPlayerLabel.setForeground(Color.YELLOW);
		currentPlayerLabel.setFont(new Font("Tahoma", Font.PLAIN, 54));
		
//		JButton territoryCardsButton = new JButton("");
//		territoryCardsButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				
//				
//				List<BufferedImage> currentPlayerTerritoryCardsImages = gameState.getCurrentPlayerTerritoryCardsImages();
//				while(currentPlayerTerritoryCardsImages.iterator().hasNext()){
//					Image territoryCardImage = currentPlayerTerritoryCardsImages.iterator().next();
//					territoryCardImage = territoryCardImage.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
//			        JLabel territoryCardImageLabel = new JLabel(new ImageIcon(territoryCardImage));
//					JOptionPane.showMessageDialog(null, territoryCardImageLabel," ",JOptionPane.PLAIN_MESSAGE, null);
//				}
//				
//				
//			}
//		});
//		territoryCardsButton.setContentAreaFilled(false);
//		territoryCardsButton.setBorder(null);
//		objectiveButton.setIcon(new ImageIcon(verseTerritoryCardImage));
//		territoryCardsButton.setBounds(210, 530, 200, 200);
//		panel.add(territoryCardsButton);
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
