

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

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
		        frame.setLayout(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setTitle("StarWar");
		        frame.setSize(1366, 768);
		        
		        GameScreen panel = new GameScreen("image/img.png", gameState);
		
		        frame.add(panel);
		        frame.repaint();
		        frame.validate();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		    }
    	});
	}

	public void showPossibleTerritoriesToRedeploy(List<TerritoryDTO> territories) 
	{
		
	}
}
