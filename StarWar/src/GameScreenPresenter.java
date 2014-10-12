import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreenPresenter implements TroopsRedeployOutputPort, GameStateOutputPort
{
	private GameStateInputPort gameState;
	private TroopsRedeployInputPort troopsRedeployInputPort;
	private AttackInputPort attackInputPort;
	JFrame frame;
	static GameScreen gameScreenPanel;
    MenuScreen menuScreenPanel;
    JPanel panel;
    
	public GameScreenPresenter() 
	{
		frame = new JFrame();
		panel = new JPanel();
	}
	
	public void show() {
		
		gameScreenPanel = new GameScreen("image/outerspace.jpg", this.gameState, attackInputPort, troopsRedeployInputPort);
		menuScreenPanel = new MenuScreen(this.gameState);
		
    	EventQueue.invokeLater(new Runnable(){
	    	public void run(){ 		    	
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        panel.setLayout(new BorderLayout());
		        
		        menuScreenPanel.setLayout(new BoxLayout(menuScreenPanel, BoxLayout.Y_AXIS));
		        
		        panel.add(gameScreenPanel, BorderLayout.CENTER);
		        panel.add(menuScreenPanel, BorderLayout.SOUTH);
				
				frame.add(panel);
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
	}

	public void clearGameScreen() 
	{
    	gameScreenPanel.removeAll();
		gameScreenPanel.repaint();
	}
	
	
	
	@Override
	public void showPossibleTerritoriesToRedeploy(List<TerritoryDTO> territories) 
	{
		for(TerritoryDTO planet : territories)
		{
			try 
			{
				JLabel neighbor = new JLabel(new ImageIcon(ImageIO.read(new File(getClass().getResource("image/greenhighlight.png").getPath().toString()))));
				neighbor.setBounds(planet.getxAxisCoordinate(), planet.getyAxisCoordinate(), neighbor.getIcon().getIconWidth(), neighbor.getIcon().getIconHeight());
			    gameScreenPanel.add(neighbor);
			    frame.repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void showReason(String reason) {

	}

	@Override
	public void showRedeployedUnits() 
	{
		clearGameScreen();
	}

	@Override
	public void showNumberOfUnitsToRedeploy(int numberOfUnits) 
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

	@Override
	public void showAllTerritories(List<TerritoryDTO> planets) 
	{
		for(TerritoryDTO planet : planets)
		{
			try 
			{
				String path = getClass().getResource(planet.getImagePath()).getPath().toString(); 
				JLabel planetLabel = new JLabel(new ImageIcon(ImageIO.read(new File(path))));
				planetLabel.setBounds(planet.getxAxisCoordinate(), planet.getyAxisCoordinate(), planetLabel.getIcon().getIconWidth(), planetLabel.getIcon().getIconHeight());
			    gameScreenPanel.add(planetLabel);
			    frame.repaint();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void showAllPieces(List<PieceDTO> pieces) 
	{
		for(PieceDTO piece : pieces)
		{
			try 
			{
				String path = getClass().getResource(piece.getImagePath()).getPath().toString(); 
				JLabel pieceLabel = new JLabel(new ImageIcon(ImageIO.read(new File(path))));
				pieceLabel.setBounds(piece.getxAxisCoordinate(), piece.getxAxisCoordinate(), pieceLabel.getIcon().getIconWidth(), pieceLabel.getIcon().getIconHeight());
			    gameScreenPanel.add(pieceLabel);
			    frame.repaint();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}	
}
