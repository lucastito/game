import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Piece;
import model.Territory;

public class GameScreenPresenter implements TroopsRedeployOutputPort
{
	Territory selectedTerritory;
	int numberOfPieces;
	private GameStateInputPort gameState;
	private TroopsRedeployInputPort troopsRedeployInputPort;
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
			    
			    frame.add(panel);
			    
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
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
        		//if (isDistributionTurn())
        		//{
        		//	getnumberofpiecestodistribute()
        		//	while(numberofpiecestodistribute > 0)
        		//	addplayerpiece
        		//}
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
							troopsRedeployInputPort.redeployUnits(selectedTerritory.getName(), targetTerritory.getName(), numberOfPieces);
							selectedTerritory = null;
							selectedTerritoryLabel.setVisible(false);
							return;
						}
						if (gameState.isAttackPhase() && !targetTerritory.getOwnerName().equals(gameState.currentPlayerName()))
						{
							attackInputPort.attack(selectedTerritory.getName(), targetTerritory.getName(), numberOfPieces);
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

