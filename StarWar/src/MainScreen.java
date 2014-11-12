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

import javax.swing.border.EtchedBorder;


public class MainScreen {

	private JFrame frame;
	private GameStateInputPort gameState;
	private GameCreationInputPort gameCreation;
	private JPanel playerMenuPanel1 = new JPanel();
	private JLabel planetasGalaxiasLabel;
	private JLabel turnoJogadorLabel;
	JButton objectiveButton = new JButton("");
	JButton territoryCardsButton = new JButton("");
	ImageIcon verseIcon = new ImageIcon();
	ImageIcon verseTerritoryIcon = new ImageIcon();
	int territoryCardCounter = 0;
	private final JLabel diceLabel = new JLabel("<html>\r\n<br>\r\nDADOS<br><br>\r\n\r\nAtaque: 6, 6, 6<br>\r\nDefesa: 6, 6, 6<br>\r\n</html>");

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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verseCardImage = verseCardImage.getScaledInstance(356, 320, java.awt.Image.SCALE_SMOOTH);
		
		Image verseTerritoryCardImage = gameState.getTerritoryCardVerseImage();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verseTerritoryCardImage = verseTerritoryCardImage.getScaledInstance(356, 320, java.awt.Image.SCALE_SMOOTH);
		
		
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
		
		JButton menuButton = new JButton("MENU");
		menuButton.setBounds(246, 696, 91, 23);
		panel.add(menuButton);
		menuButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuButton.setBackground(new Color(160, 82, 45));
		menuButton.setForeground(new Color(255, 255, 255));
		playerMenuPanel1.setBorder(null);
		playerMenuPanel1.setBounds(0, 410, 1350, 320);
		panel.add(playerMenuPanel1);
		playerMenuPanel1.setLayout(null);
		playerMenuPanel1.setVisible(false);
		playerMenuPanel1.setOpaque(false);
		
		
		
		objectiveButton.setBounds(0, 0, 356, 320);
		playerMenuPanel1.add(objectiveButton);
		verseIcon = new ImageIcon(verseCardImage);
		objectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Image currentPlayerObjectiveCardImage = gameState.getCurrentPlayerObjectiveCardImage();
				currentPlayerObjectiveCardImage = currentPlayerObjectiveCardImage.getScaledInstance(356, 320, java.awt.Image.SCALE_SMOOTH);
				ImageIcon currentPlayerObjectiveIcon = new ImageIcon(currentPlayerObjectiveCardImage);
				if(objectiveButton.getIcon().equals(verseIcon))
					objectiveButton.setIcon(currentPlayerObjectiveIcon);
				else
					objectiveButton.setIcon(verseIcon);
			}
		});
		
		objectiveButton.setIcon(verseIcon);
		objectiveButton.setContentAreaFilled(false);
		objectiveButton.setBorder(null);
		
		turnoJogadorLabel = new JLabel("");
		turnoJogadorLabel.setForeground(new Color(255, 255, 0));
		turnoJogadorLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		turnoJogadorLabel.setBounds(719, 220, 507, 68);
		playerMenuPanel1.add(turnoJogadorLabel);;
		
		
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(playerMenuPanel1.isVisible())
					playerMenuPanel1.setVisible(false);
				else
					playerMenuPanel1.setVisible(true);
				turnoJogadorLabel.setText("<html>Turno: "+gameState.getCurrentRound()+ "<br>Jogador: "+gameState.getCurrentPlayerName()+"("+gameState.getCurrentPlayerRace()+")</html>");
				planetasGalaxiasLabel.setText("Planetas: "+gameState.currentPlayerNumberOfOwnedPlanets());
			}
		});
		
		
		
		territoryCardsButton.setBounds(353, 0, 356, 320);
		playerMenuPanel1.add(territoryCardsButton);
		verseTerritoryIcon = new ImageIcon(verseTerritoryCardImage);
		territoryCardsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				BufferedImage[] currentPlayerTerritoryCardsImages = gameState.getCurrentPlayerTerritoryCardsImages();
				Image territoryCardImage = currentPlayerTerritoryCardsImages[territoryCardCounter];
				territoryCardImage = territoryCardImage.getScaledInstance(356, 320, java.awt.Image.SCALE_SMOOTH);
				ImageIcon territoryIcon = new ImageIcon(territoryCardImage);
				territoryCardsButton.setIcon(territoryIcon);
				if(territoryCardCounter>=currentPlayerTerritoryCardsImages.length-1){
					territoryCardsButton.setIcon(verseTerritoryIcon);
					territoryCardCounter = 0;
				}else
					territoryCardCounter++;
				
			}
		});
		territoryCardsButton.setIcon(verseTerritoryIcon);
		territoryCardsButton.setContentAreaFilled(false);
		territoryCardsButton.setBorder(null);
		
		planetasGalaxiasLabel = new JLabel("");
		planetasGalaxiasLabel.setForeground(Color.YELLOW);
		planetasGalaxiasLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		planetasGalaxiasLabel.setBounds(719, 281, 507, 39);
		playerMenuPanel1.add(planetasGalaxiasLabel);
		diceLabel.setForeground(Color.RED);
		diceLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		diceLabel.setBounds(1090, 175, 250, 145);
		
		playerMenuPanel1.add(diceLabel);
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
