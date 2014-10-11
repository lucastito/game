

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

public class GameScreenPresenter implements TroopsRedeployOutputPort
{
	private GameStateInputPort gameState;
	
	public GameScreenPresenter(GameStateInputPort gameState)
	{
		this.gameState = gameState;
	}
	
	public void show() {
    	EventQueue.invokeLater(new Runnable(){
	    	public void run(){ 
		    	JFrame frame = new JFrame();
//		        frame.setLayout(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setTitle("StarWar");
//		        frame.setSize(800, 600);
		        frame.setSize(1366, 768);
		        
		        JPanel panel = new JPanel();
		        panel.setLayout(new BorderLayout());
		        GameScreen gameScreenPanel = new GameScreen("image/outerspace.jpg", gameState);
		        MenuScreen menuScreenPanel = new MenuScreen(gameState);
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

	@Override
	public void showPossibleTerritoriesToRedeploy(List<TerritoryDTO> territories) 
	{
		
	}

	@Override
	public void showReason(String reason) {

	}

	@Override
	public void showRedeployedUnits() 
	{
		
	}

	@Override
	public void showNumberOfUnitsToRedeploy(int numberOfUnits) 
	{
		
	}
}
