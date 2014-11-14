import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Piece;
import model.Territory;

public class GameScreenPresenter implements GamePresenterOutputPort
{
	Territory selectedTerritory;
	int numberOfPieces;
	private GameStateInputPort gameState;
	private TroopsRedeployInputPort troopsRedeployInputPort;
	private TroopsDistributionBoundary troopsDistributionInputPort;
	private AttackInputPort attackInputPort;
	JFrame frame;
	static GameScreen gameScreenPanel;
    MenuScreen menuScreenPanel;
    JPanel panel;
    private PiecesController piecesController;
	private PlanetarySystemController planetarySystemController;
	List<Piece> pieceLabels;
	List<Territory> territoryLabels;
	List<JLabel> armyCountLabels;
	private GameCreationInputPort gameCreation;
	private JLabel selectedTerritoryLabel;
	
	
	
	private JPanel playerMenuPanel1 = new JPanel();
	private JPanel playerMenuPanel2 = new JPanel();
	BufferedImage[] currentPlayerTerritoryCardsImages = null;
	private JLabel planetasGalaxiasLabel;
	private JLabel turnoJogadorLabel;
	JButton objectiveButton = new JButton("");
	JButton territoryCardsButton = new JButton("");
	ImageIcon verseIcon = new ImageIcon();
	ImageIcon verseTerritoryIcon = new ImageIcon();
	int territoryCardCounter = 0;
	private final JLabel diceLabel = new JLabel(
			"<html>\r\n<br>\r\nDADOS<br><br>\r\n\r\nAtaque: 6, 6, 6<br>\r\nDefesa: 6, 6, 6<br>\r\n</html>");
	
	
	
	public GameScreenPresenter() 
	{
		frame = new JFrame();
		panel = new JPanel();
		pieceLabels = new ArrayList<Piece>();
		territoryLabels = new ArrayList<Territory>();
		armyCountLabels = new ArrayList<JLabel>();
	}
	
	public GameScreenPresenter(GameCreationInputPort gameCreation) 
	{
		this();
		this.setGameCreation(gameCreation);		
	}
	
	public void show() 
	{
		planetarySystemController = new PlanetarySystemController(gameState, troopsRedeployInputPort, attackInputPort);
		piecesController = new PiecesController(gameState, troopsRedeployInputPort);
		gameScreenPanel = new GameScreen("image/outerspace.jpg", this.gameState, attackInputPort, troopsRedeployInputPort);
		menuScreenPanel = new MenuScreen(this.gameState);
		gameState.initializePlayers();
		
		EventQueue.invokeLater(new Runnable(){
	    	public void run(){
				
    		   
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        panel.setLayout(new BorderLayout());
		        
		        menuScreenPanel.setLayout(new BoxLayout(menuScreenPanel, BoxLayout.Y_AXIS));
		        
		        panel.add(gameScreenPanel);
		        panel.add(menuScreenPanel, BorderLayout.SOUTH);
		        
		        showArmyCount();
		        showPieces();
			    showTerritories();
			    
			    Image verseCardImage = gameState.getCardVerseImage();
				verseCardImage = verseCardImage.getScaledInstance(356, 320,
						java.awt.Image.SCALE_SMOOTH);

				
				Image verseTerritoryCardImage = gameState.getTerritoryCardVerseImage();
				if(verseTerritoryCardImage!=null){
					verseTerritoryCardImage = verseTerritoryCardImage.getScaledInstance(
						356, 320, java.awt.Image.SCALE_SMOOTH);
					playerMenuPanel1.add(territoryCardsButton);
					verseTerritoryIcon = new ImageIcon(verseTerritoryCardImage);
				}
				JPanel panel2 = new JPanel();
				panel2.setBounds(0, 0, 1350, 730);
				frame.add(panel2);
				panel2.setLayout(null);
				panel2.setVisible(true);
				panel2.setOpaque(false);
				
				JButton menuButton = new JButton("MENU");
				menuButton.setBounds(320, 696, 91, 23);
				panel2.add(menuButton);
				menuButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				menuButton.setBackground(new Color(160, 82, 45));
				menuButton.setForeground(new Color(255, 255, 255));
				playerMenuPanel1.setBorder(null);
				playerMenuPanel1.setBounds(0, 410, 1350, 320);
				panel2.add(playerMenuPanel1);
				playerMenuPanel1.setLayout(null);
				playerMenuPanel1.setVisible(false);
				playerMenuPanel1.setOpaque(false);

				objectiveButton.setBounds(0, 0, 356, 320);
				playerMenuPanel1.add(objectiveButton);
				verseIcon = new ImageIcon(verseCardImage);
				objectiveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Image currentPlayerObjectiveCardImage = gameState
								.getCurrentPlayerObjectiveCardImage();
						currentPlayerObjectiveCardImage = currentPlayerObjectiveCardImage
								.getScaledInstance(356, 320,
										java.awt.Image.SCALE_SMOOTH);
						ImageIcon currentPlayerObjectiveIcon = new ImageIcon(
								currentPlayerObjectiveCardImage);
						if (objectiveButton.getIcon().equals(verseIcon))
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
				playerMenuPanel1.add(turnoJogadorLabel);
				;

				menuButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (playerMenuPanel1.isVisible()) {
							playerMenuPanel1.setVisible(false);
							playerMenuPanel2.setVisible(false);
						} else {
							currentPlayerTerritoryCardsImages = gameState
									.getCurrentPlayerTerritoryCardsImages();
							playerMenuPanel1.setVisible(true);
							playerMenuPanel2.setVisible(true);
						}
						turnoJogadorLabel.setText("<html>Turno: "
								+ gameState.getCurrentRound() + "<br>Jogador: "
								+ gameState.getCurrentPlayerName() + "("
								+ gameState.getCurrentPlayerRace() + ")</html>");
						planetasGalaxiasLabel.setText("Planetas: "
								+ gameState.currentPlayerNumberOfOwnedPlanets());
					}
				});

				territoryCardsButton.setBounds(353, 0, 356, 320);
				

				territoryCardsButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Image territoryCardImage = currentPlayerTerritoryCardsImages[territoryCardCounter];
						if (territoryCardImage == null) {

						} else {
							territoryCardImage = territoryCardImage.getScaledInstance(
									356, 320, java.awt.Image.SCALE_SMOOTH);
							ImageIcon territoryIcon = new ImageIcon(territoryCardImage);
							territoryCardsButton.setIcon(territoryIcon);
							if (territoryCardCounter >= currentPlayerTerritoryCardsImages.length - 1) {
								territoryCardsButton.setIcon(verseTerritoryIcon);
								territoryCardCounter = 0;
							} else
								territoryCardCounter++;

						}
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
				
				JLabel qntCartasTerritorioLabel = new JLabel();
				qntCartasTerritorioLabel.setForeground(new Color(255, 255, 255));
				qntCartasTerritorioLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
				if(gameState.getCurrentPlayerTerritoryCardsImages()!= null)
					qntCartasTerritorioLabel.setText(""+gameState.getCurrentPlayerTerritoryCardsImages().length);
				
				qntCartasTerritorioLabel.setBounds(595, 281, 46, 14);
				playerMenuPanel1.add(qntCartasTerritorioLabel);

				playerMenuPanel2.setBounds(951, 0, 399, 412);
				panel2.add(playerMenuPanel2);
				playerMenuPanel2.setLayout(null);
				playerMenuPanel2.setBorder(null);
				playerMenuPanel2.setVisible(false);
				playerMenuPanel2.setOpaque(false);

				JButton ajudaButton = new JButton("Ajuda");
				ajudaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				ajudaButton.setForeground(new Color(255, 255, 255));
				ajudaButton.setBackground(new Color(165, 42, 42));
				ajudaButton.setBounds(255, 334, 134, 67);
				playerMenuPanel2.add(ajudaButton);
			    
			    
			    frame.add(panel);
			   
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		        
		        //MainScreen window = new MainScreen(gameState, gameCreation);// Estou fazendo os menus em outra janela para teste depois vou passar para essa tela (Daniel)
				//window.getFrame().setVisible(true);
		        
		        
		        frame.setComponentZOrder(panel2, 0);
		        frame.repaint();
		        frame.revalidate();
		        
	    	}
		    
   
    	
	     	});
    	 
    	
    	
	}

	protected void showTerritories() 
	{
		for (Territory territory : planetarySystemController.getAllTerritories())
        {
        	ImageIcon territoryIcon = new ImageIcon(getClass().getResource(territory.getImagePath()).getPath().toString());
        	Territory territoryLabel = new Territory(territoryIcon);
        	territoryLabel.setImagePath(territory.getImagePath());
        	territoryLabel.setOwnerName(territory.getOwnerName());
        	territoryLabel.setxAxisCoordinate(territory.getxAxisCoordinate());
        	territoryLabel.setyAxisCoordinate(territory.getyAxisCoordinate());
        	territoryLabel.setName(territory.getName());
        	territoryLabel.setId(territory.getId());
        	territoryLabel.setBounds(territory.getxAxisCoordinate(), territory.getyAxisCoordinate(), territoryIcon.getIconWidth(), territoryIcon.getIconHeight());
			MouseListener listener = new TerritoryMouseAdapter();
			territoryLabel.addMouseListener(listener);
			territoryLabels.add(territoryLabel);			

			selectedTerritoryLabel = new JLabel("*");
			selectedTerritoryLabel.setForeground(new Color(255, 215, 0));
			selectedTerritoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			selectedTerritoryLabel.setVisible(false);
			frame.add(selectedTerritoryLabel);
			frame.add(territoryLabel);
	    }
		frame.repaint();
	}

	protected void showPieces() 
	{
		for (Piece label : pieceLabels)
		{
			frame.remove(label);
		}
		
		for (Territory label : territoryLabels)
		{
			frame.remove(label);
		}
		
		pieceLabels = new ArrayList<Piece>();
		for (Piece piece : piecesController.getAllPieces())
        {
        	ImageIcon pieceIcon = new ImageIcon(getClass().getResource(piece.getImagePath()).getPath().toString());
        	Piece pieceLabel = new Piece(pieceIcon);
        	pieceLabel.setBounds(piece.getxAxisCoordinate(), piece.getyAxisCoordinate(), pieceIcon.getIconWidth(), pieceIcon.getIconHeight());
			pieceLabels.add(pieceLabel);
			frame.add(pieceLabel);					
        }	
		
		frame.repaint();
	}	

	@Override
	public void showReason(String reason) 
	{

	}

	public void setGameStateInputPort(GameStateInputPort gameState)
	{
		this.gameState = gameState;
	}
	
	public void setTroopsRedeployInputPort(TroopsRedeployInputPort troopsRedeployInputPort)
	{
		this.troopsRedeployInputPort = troopsRedeployInputPort;
	}
	
	public void setTroopsDistribution(TroopsDistributionBoundary troopsDistributionInputPort)
	{
		this.troopsDistributionInputPort = troopsDistributionInputPort;
	}
	
	public void setAttackInputPort(AttackInputPort attackInputPort)
	{
		this.attackInputPort = attackInputPort;
	}

	public GameCreationInputPort getGameCreation() {
		return gameCreation;
	}

	public void setGameCreation(GameCreationInputPort gameCreation) {
		this.gameCreation = gameCreation;
	}

	
	class TerritoryMouseAdapter extends MouseAdapter 
	{
		
        @Override
    	public void mouseEntered(MouseEvent e) 
        {
        	if (selectedTerritory == null)
        	{
        		Territory enteredTerritory = null;
            	for (Territory t : territoryLabels)
            	{
            		if(t.hashCode() == e.getComponent().hashCode())
            		{
            			enteredTerritory = t;
            			break;
            		}
            	}        		
        		if (enteredTerritory != null && gameState.currentPlayerName().equalsIgnoreCase(enteredTerritory.getOwnerName()))
        				frame.setCursor(new Cursor(12));
        	}
        	else
        	{
        		if (gameState.currentPlayerName().equalsIgnoreCase(selectedTerritory.getOwnerName()) && (gameState.isRedeployPhase() || gameState.isAttackPhase()))
				{      		
        			Territory targetTerritory = null;
                	for (Territory t : territoryLabels)
                	{
                		if(t.hashCode() == e.getComponent().hashCode())
                		{
                			targetTerritory = t;
                			break;
                		}
                	}        		
		        	List<Territory> neighbors = planetarySystemController.getTerritoriesToRedeploy(selectedTerritory.getName(), 0);
		        	
		        	for (Territory territory : neighbors)
		        	{
		        		if(territory.getName().equals(targetTerritory.getName()))
		        		{
		        			frame.setCursor(new Cursor(12));
		        			return;
		        		}
		        	} 
				}
        	}
        	
    	}
        
        @Override
    	public void mouseExited(MouseEvent e) 
        {
        	frame.setCursor(new Cursor(0));    		
    	}
        
        @Override
    	public void mouseClicked(MouseEvent e) 
    	{
        	Territory candidateTerritory = null;
        	for (Territory t : territoryLabels)
        	{
        		if(t.hashCode() == e.getComponent().hashCode())
        		{
        			candidateTerritory = t;
        			break;
        		}
        	}   
        	
        	if (selectedTerritory == null)
        	{
        		candidateTerritory.setOwnerName(gameState.currentPlayerName());
        		if (candidateTerritory.getOwnerName().equals(gameState.currentPlayerName()))
        		{
        			selectedTerritory = candidateTerritory;
        			selectedTerritoryLabel.setBounds(selectedTerritory.getX() + selectedTerritory.getWidth()/2, selectedTerritory.getY(), 20, 20);
        			selectedTerritoryLabel.setVisible(true);
        		}
        		return;
        	}
        	else
        	{
        		if (gameState.isDistributionPhase())
        		{
        			int numberOfPiecesToDistribute = gameState.getUnitsToDistribute();
        			if(numberOfPiecesToDistribute > 0)
        			{
        				troopsDistributionInputPort.distributeTroops(1, selectedTerritory.getOwnerName(), selectedTerritory.getName());
        			}		
        		}
        		
	        	if (selectedTerritory.getName().equals(candidateTerritory.getName()))
	        	{
	        		selectedTerritory = null;
	        		selectedTerritoryLabel.setVisible(false);
	        		return;
	        	}
				if (selectedTerritory.getOwnerName().equals(gameState.currentPlayerName()))
				{
					Territory targetTerritory = null;
		        	for (Territory t : territoryLabels)
		        	{
		        		if(t.hashCode() == e.getComponent().hashCode())
		        		{
		        			targetTerritory = t;
		        			break;
		        		}
		        	} 
					if (targetTerritory != null)
					{
						if (gameState.isRedeployPhase() && targetTerritory.getOwnerName().equals(gameState.currentPlayerName()))
						{
							troopsRedeployInputPort.redeployUnits(selectedTerritory.getName(), targetTerritory.getName());
							selectedTerritory = null;
							selectedTerritoryLabel.setVisible(false);
							return;
						}
						if (gameState.isAttackPhase() && !targetTerritory.getOwnerName().equals(gameState.currentPlayerName()))
						{
							attackInputPort.attack(selectedTerritory.getName(), targetTerritory.getName());
							selectedTerritory = null;
							selectedTerritoryLabel.setVisible(false);
							return;
						}
					}
				}				
        	}
    	}    	   	
	}
	private void showArmyCount()
	{
		for (JLabel label : armyCountLabels)
		{
			frame.remove(label);
		}
		
		for (Piece label : pieceLabels)
		{
			frame.remove(label);
		}
		
		for (Territory label : territoryLabels)
		{
			frame.remove(label);
		}
		for (Territory territory : planetarySystemController.getAllTerritories())
        {
			int armyCount = 0;
			for (PieceDTO piece : gameState.getAllPieces())
			{
				if (piece.getTerritoryName().equals(territory.getName()))
				{
					armyCount++;
				}
			}
			JLabel armyCountLabel = new JLabel("" + armyCount);
			armyCountLabel.setBounds(territory.getxAxisCoordinate() + territory.getWidth()/2, territory.getyAxisCoordinate() + territory.getHeight()/2, 20, 20);
			armyCountLabel.setForeground(new Color(255, 215, 0));
			armyCountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			armyCountLabels = new ArrayList<JLabel>();
			armyCountLabels.add(armyCountLabel);
			frame.add(armyCountLabel);
	    }
	    frame.repaint();
	}
	

}

