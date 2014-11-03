import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
	private GameCreationInputPort gameCreation;
	
    
	
	public GameScreenPresenter() 
	{
		frame = new JFrame();
		panel = new JPanel();
		pieceLabels = new ArrayList<Piece>();
		territoryLabels = new ArrayList<Territory>();
	}
	
	public GameScreenPresenter(GameCreationInputPort gameCreation) 
	{
		this.setGameCreation(gameCreation);
		frame = new JFrame();
		panel = new JPanel();
		pieceLabels = new ArrayList<Piece>();
		territoryLabels = new ArrayList<Territory>();
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
		        
		        showPieces();
			    showTerritories();
			    
			    frame.add(panel);
			    
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
    	gameCreation.printInfo();
	}

	protected void showTerritories() 
	{
		for (Territory territory : planetarySystemController.getAllTerritories())
        {
        	ImageIcon territoryIcon = new ImageIcon(getClass().getResource(territory.getImagePath()).getPath().toString());
        	Territory territoryLabel = new Territory(territoryIcon);
        	territoryLabel.setBounds(territory.getxAxisCoordinate(), territory.getyAxisCoordinate(), territoryIcon.getIconWidth(), territoryIcon.getIconHeight());
			MouseListener listener = new TerritoryMouseAdapter();
			territoryLabel.addMouseListener(listener);
			territoryLabels.add(territoryLabel);
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
        	System.out.println(piece.getxAxisCoordinate() +" "+ piece.getxAxisCoordinate());
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
        		return;
        	if (gameState.isPieceFromCurrentPlayer(selectedTerritory.getId()) && (gameState.isRedeployPhase() || gameState.isAttackPhase()))
			{
	        	Territory targetTerritory = findTerritoryOnClick(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y); 
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
        
        @Override
    	public void mouseExited(MouseEvent e) 
        {
        	frame.setCursor(new Cursor(0));    		
    	}
        
        @Override
    	public void mouseClicked(MouseEvent e) 
    	{
        	Territory targetTerritory;
			if (selectedTerritory != null)
			{
				if (selectedTerritory.getOwnerName().equals(gameState.currentPlayerName()))
				{
					targetTerritory = findTerritoryOnClick(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);  
				
					if (targetTerritory != null && gameState.isRedeployPhase())
					{
						troopsRedeployInputPort.redeployUnits(selectedTerritory.getName(), targetTerritory.getName(), numberOfPieces);
						selectedTerritory = null;
						return;
					}
					if (targetTerritory != null && gameState.isAttackPhase())
					{
						attackInputPort.attack(selectedTerritory.getName(), targetTerritory.getName(), numberOfPieces);
						selectedTerritory = null;
						return;
					}
				}
			}        		   	
    	}
    	private Territory findTerritoryOnClick(int x, int y) 
    	{
    		for(Territory territory : planetarySystemController.getAllTerritories())
    		{
    			if(x <= territory.getxAxisCoordinate() + 100 && x >= territory.getxAxisCoordinate()
    					&& y <= territory.getyAxisCoordinate() + 100 && y >= territory.getyAxisCoordinate())
    			{
    				return territory;
    			}
    			System.out.println(territory.getName()+" " + territory.getxAxisCoordinate() + " " + x + " " + territory.getyAxisCoordinate() + " " + y );	
    		}		
    		return null;
    	}    	
	}
}